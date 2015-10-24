package br.com.gabrielrtakeda.model;

public class Aeronave {
    private int id ;
    private String codigo;
    private String nome;
    private int quantidadeAssentos;


    public Aeronave(int i , String c , String n, int qa){
        id = i ;
        codigo = c;
        nome = n ;
        quantidadeAssentos = qa;
    }


    public Aeronave(String n){
       nome = n ;
    }

    public Aeronave() {}

    public void setCodigo(String codigos){
        codigo = codigos;
    }

    public String getcodigo(){
        return codigo;
    }

    public String getnome(){
        return nome;
    }

    public void setNome(String n){
        nome = n;
    }

    public int getId(){
        return id;
    }

    public void setId(int i){
        id = i ;
    }

    public void setQuant_assentos(int quant){
        quantidadeAssentos = quant;
    }

    public int getQuant_assentos(){
        return quantidadeAssentos;
    }
}
