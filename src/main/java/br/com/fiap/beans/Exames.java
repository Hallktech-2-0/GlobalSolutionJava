package br.com.fiap.beans;

	import java.util.Date;

	public class Exames {
	    private String exameId;
	    private String agendId;
	    private String consultaId;
	    private String tipoExame;
	    private Date dataHora;
	    private String resultado;
	    
		public Exames() {
			super();
		}
		
		public Exames(String exameId, String agendId, String consultaId, String tipoExame, Date dataHora,
				String resultado) {
			super();
			this.exameId = exameId;
			this.agendId = agendId;
			this.consultaId = consultaId;
			this.tipoExame = tipoExame;
			this.dataHora = dataHora;
			this.resultado = resultado;
		}
		
		public String getExameId() {
			return exameId;
		}
		public void setExameId(String exameId) {
			this.exameId = exameId;
		}
		public String getAgendId() {
			return agendId;
		}
		public void setAgendId(String agendId) {
			this.agendId = agendId;
		}
		public String getConsultaId() {
			return consultaId;
		}
		public void setConsultaId(String consultaId) {
			this.consultaId = consultaId;
		}
		public String getTipoExame() {
			return tipoExame;
		}
		public void setTipoExame(String tipoExame) {
			this.tipoExame = tipoExame;
		}
		public Date getDataHora() {
			return dataHora;
		}
		public void setDataHora(Date dataHora) {
			this.dataHora = dataHora;
		}
		public String getResultado() {
			return resultado;
		}
		public void setResultado(String resultado) {
			this.resultado = resultado;
		}

		@Override
		public String toString() {
			return "Exames [exameId=" + exameId + ", agendId=" + agendId + ", consultaId=" + consultaId + ", tipoExame="
					+ tipoExame + ", dataHora=" + dataHora + ", resultado=" + resultado + "]";
		}
		
		

	    
	}



