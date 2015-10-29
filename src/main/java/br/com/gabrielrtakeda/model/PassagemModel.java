package br.com.gabrielrtakeda.model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

import org.joda.time.Interval;
import org.joda.time.Hours;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;

import br.com.gabrielrtakeda.dao.PassagemDAOInterface;
import br.com.gabrielrtakeda.dao.PassageiroDAOInterface;
import br.com.gabrielrtakeda.dao.VooDAOInterface;
import br.com.gabrielrtakeda.dao.AeronaveDAOInterface;
import br.com.gabrielrtakeda.dao.AeroportoDAOInterface;
import br.com.gabrielrtakeda.dao.ReembolsoDAOInterface;

import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.strategy.DAOStrategy;
import br.com.gabrielrtakeda.api.beans.ComprarPassagemBean;

import br.com.gabrielrtakeda.to.PassagemTO;
import br.com.gabrielrtakeda.to.PassageiroTO;
import br.com.gabrielrtakeda.to.VooTO;

public class PassagemModel {

    PassagemDAOInterface dao;
    PassageiroDAOInterface passageiroDAO;
    VooDAOInterface vooDAO;
    AeronaveDAOInterface aeronaveDAO;
    AeroportoDAOInterface aeroportoDAO;

    public PassagemModel() {
        AbstractDAOFactory factory = DAOStrategy.get();
        dao = factory.getPassagemDAO();
        passageiroDAO = factory.getPassageiroDAO();
        vooDAO = factory.getVooDAO();
        aeronaveDAO = factory.getAeronaveDAO();
        aeroportoDAO = factory.getAeroportoDAO();
    }

    public List<PassageiroTO> insert(ComprarPassagemBean comprarPassagemBean) {

        List<PassageiroTO>
            insertedPassageiroTOList =
                new ArrayList<PassageiroTO>();
        List<PassagemTO>
            insertedPassagemTOList =
                new ArrayList<PassagemTO>();

        try {
            // Passageiros
            insertedPassageiroTOList = passageiroDAO.insertMultiple(
                comprarPassagemBean.getPassageiros()
            );
            comprarPassagemBean.setPassageiros(
                insertedPassageiroTOList
            );

            // Passagens
            insertedPassagemTOList = dao.insertMultiple(
                this.buildPassagemTOList(
                    comprarPassagemBean,
                    insertedPassageiroTOList
                )
            );
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return insertedPassageiroTOList;
    }

    private List<PassagemTO> buildPassagemTOList(
        ComprarPassagemBean comprarPassagemBean,
        List<PassageiroTO> passageiroTOList
    ) {
        PassageiroTO passageiroResponsavelTO =
            this.getPassageiroResponsavel(passageiroTOList);

        List<PassagemTO> passagemTOList = new ArrayList<PassagemTO>();
        for (PassageiroTO passageiroTO : passageiroTOList) {
            passagemTOList.add(
                new PassagemTO()
                    .setVoo(passageiroTO.getVoo())
                    .setPassageiroResponsavel(passageiroResponsavelTO)
                    .setPassageiro(passageiroTO)
                    .setBilhete(this.getMD5Bilhete(passageiroTO))
                    .setValor(passageiroTO.getValorPassagem())
            );
        }

        return passagemTOList;
    }

    public PassagemTO getByBilhete(String bilhete) {
        PassagemTO to = new PassagemTO();

        try {
            to = dao.getByBilhete(bilhete);
            if (to.getStatusOperation()) {
                to.setVoo(
                    vooDAO.get(
                        to.getVoo().getId()
                    )
                ).setPassageiroResponsavel(
                    passageiroDAO.get(
                        to.getPassageiroResponsavel().getId()
                    )
                ).setPassageiro(
                    passageiroDAO.get(
                        to.getPassageiro().getId()
                    )
                );
                to.getVoo().setAeronave(
                    aeronaveDAO.get(
                        to.getVoo().getAeronave().getId()
                    )
                ).setOrigemAeroporto(
                    aeroportoDAO.get(
                        to.getVoo().getOrigemAeroporto().getId()
                    )
                ).setDestinoAeroporto(
                    aeroportoDAO.get(
                        to.getVoo().getDestinoAeroporto().getId()
                    )
                );
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return to;
    }

    public double calculateValorPassagem(
        String tipoPassageiro,
        double valor
    ) {
        if (tipoPassageiro.equals("Bebê"))
            return 0;

        else if (tipoPassageiro.equals("Criança")) {
            /**
             * Valor da passagem de Criança =
             *   70% do valor total da passagem
             * + 10% da Taxa de Embarque
             */
            return this.round((valor * 0.7) * 1.1);

        }
        return this.round(valor * 1.1);
    }

    public PassagemTO updateVoo(int id, int vooId) {
        PassagemTO to = new PassagemTO()
            .setId(id)
            .setVoo(new VooTO().setId(vooId));

        if (!this.validateTransferencia(to)) {
            to.setStatusOperation(false)
                .setErrorMessage(
                      "Não será possível efetuar a transferência da passagem"
                    + " pois restam menos de 2 horas para o vôo."
                );
            return to;
        }

        try {
            to = dao.updateVoo(to);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return to;
    }

    public PassagemTO delete(int id) {
        PassagemTO to = new PassagemTO().setId(id);
        try { to = dao.delete(to); }
        catch (Exception e) { e.printStackTrace(); }

        return to;
    }

    private PassageiroTO getPassageiroResponsavel(
        List<PassageiroTO> passageiroTOList
    ) {
        for (PassageiroTO passageiroTO : passageiroTOList) {
            if (passageiroTO.getResponsavel() == true) return passageiroTO;
        }
        return null;
    }

    private double round(double valor) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(valor));
    }

    private String getMD5Bilhete(PassageiroTO passageiroTO) {
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(
            Calendar.getInstance().getTime()
        );
        String md5hashFormat = String.format(
            timestamp + "%d%s%s%s%s%s",
            passageiroTO.getId(),
            passageiroTO.getTipoPassageiro(),
            passageiroTO.getFormaTratamento(),
            passageiroTO.getNome(),
            passageiroTO.getSobrenome(),
            passageiroTO.getDataNascimento()
        );
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5hashFormat.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
              sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
           }
            return sb.toString().substring(0, 9);
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean validateTransferencia(PassagemTO to) {
        try {
            to = dao.get(to.getId());
            to.setVoo(
                vooDAO.get(
                    to.getVoo().getId()
                )
            );

            DateTimeFormatter formatter = DateTimeFormat.forPattern(
                "yyyy-MM-dd HH:mm:ss.S"
            );
            DateTime vooDataHora = formatter.parseDateTime(
                to.getVoo().getDataHora()
            );
            DateTime now = new DateTime();
            Hours hours = Hours.hoursBetween(now, vooDataHora);
            int differenceHours = hours.getHours();

            if (differenceHours < 2) return false;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
