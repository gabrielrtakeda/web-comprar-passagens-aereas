package br.com.gabrielrtakeda.model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;

import org.joda.time.Hours;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormat;

import br.com.gabrielrtakeda.api.beans.ReembolsoBean;
import br.com.gabrielrtakeda.dao.ReembolsoDAOInterface;
import br.com.gabrielrtakeda.dao.AbstractDAOFactory;
import br.com.gabrielrtakeda.dao.exception.NotFoundException;
import br.com.gabrielrtakeda.strategy.DAOStrategy;
import br.com.gabrielrtakeda.to.ReembolsoTO;

public class ReembolsoModel {

    ReembolsoDAOInterface dao;

    public ReembolsoModel() {
        AbstractDAOFactory factory = DAOStrategy.get();
        dao = factory.getReembolsoDAO();
    }

    public ReembolsoTO insert(ReembolsoBean bean) {
        ReembolsoTO to = new ReembolsoTO();

        try {
            to = this.buildTO(bean);

            String vooDataHora = to.getVoo().getDataHora();
            int difference = this.getDifferenceBetweenNow(vooDataHora);

            if (difference < 8) to = dao.insert(to, 0);
            else if (difference < 12) to = dao.insert(to, 0.2);
            else if (difference < 24) to = dao.insert(to, 0.4);
            else to = dao.insert(to, 1);
        }
        catch (NotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return to;
    }

    private int getDifferenceBetweenNow(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormat.forPattern(
            "yyyy-MM-dd HH:mm:ss.S"
        );
        DateTime vooDataHora = formatter.parseDateTime(dateTime);
        Hours hours = Hours.hoursBetween(new DateTime(), vooDataHora);

        return hours.getHours();
    }

    private ReembolsoTO buildTO(ReembolsoBean bean) {
        return new ReembolsoTO()
            .setVoo(bean.getVoo())
            .setBanco(bean.getBanco())
            .setAgencia(bean.getAgencia())
            .setContaCorrente(bean.getContaCorrente())
            .setNomeTitular(bean.getNomeTitular())
            .setCpf(bean.getCpf());
    }
}
