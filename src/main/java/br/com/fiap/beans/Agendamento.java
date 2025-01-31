package br.com.fiap.beans;

import java.util.Date;

public class Agendamento {
    private String agendId;
    private String pacienteId;
    private String crmPs;
    private Date dataHoraAgend;
    private String examesExameId;
    
	public Agendamento() {
		super();
	}
	
	public Agendamento(String agendId, String pacienteId, String crmPs, Date dataHoraAgend, String examesExameId) {
		super();
		this.agendId = agendId;
		this.pacienteId = pacienteId;
		this.crmPs = crmPs;
		this.dataHoraAgend = dataHoraAgend;
		this.examesExameId = examesExameId;
	}
	
	public String getAgendId() {
		return agendId;
	}
	public void setAgendId(String agendId) {
		this.agendId = agendId;
	}
	public String getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}
	public String getCrmPs() {
		return crmPs;
	}
	public void setCrmPs(String crmPs) {
		this.crmPs = crmPs;
	}
	public Date getDataHoraAgend() {
		return dataHoraAgend;
	}
	public void setDataHoraAgend(Date dataHoraAgend) {
		this.dataHoraAgend = dataHoraAgend;
	}
	public String getExamesExameId() {
		return examesExameId;
	}
	public void setExamesExameId(String examesExameId) {
		this.examesExameId = examesExameId;
	}

	@Override
	public String toString() {
		return "Agendamento [agendId=" + agendId + ", pacienteId=" + pacienteId + ", crmPs=" + crmPs
				+ ", dataHoraAgend=" + dataHoraAgend + ", examesExameId=" + examesExameId + "]";
	}
	

    
}
