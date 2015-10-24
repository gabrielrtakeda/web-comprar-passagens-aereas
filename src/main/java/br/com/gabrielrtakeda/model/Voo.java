package br.com.gabrielrtakeda.model;

public class Voo {
		private int id ;
		private String codigo;
		private String origem;
		private String destino;
	    private int escalas;
	    private String data;
	    private String aeronave;
	    private String situacao;



		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		public String getOrigem() {
			return origem;
		}
		public void setOrigem(String origem) {
			this.origem = origem;
		}
		public String getDestino() {
			return destino;
		}
		public void setDestino(String destino) {
			this.destino = destino;
		}
		public int getEscalas() {
			return escalas;
		}
		public void setEscalas(int escalas) {
			this.escalas = escalas;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getAeronave() {
			return aeronave;
		}
		public void setAeronave(String aeronave) {
			this.aeronave = aeronave;
		}
		public String getSituacao() {
			return situacao;
		}
		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}

		public Voo(int i , String c , String o, String d , int esc, String dt, String aero, String situ){
	     id = i ;
	     codigo = c;
	     origem = o ;
	     destino = d;
	     escalas = esc;
	     data = dt ;
	     aeronave = aero;
	     situacao = situ;
		}
		public Voo(){

		}


	}

