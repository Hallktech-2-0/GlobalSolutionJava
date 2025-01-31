package br.com.fiap.beans;

import java.util.Date;

public class Consulta {
    private String consultaId;
    private String pacienteId;
    private String crmPs;
    private Date dataHora;
    private String cidPac;
    private String agendamentoAgendId;
    private String unidadeId;
    
	public Consulta() {
		super();
	}
	
	public Consulta(String consultaId, String pacienteId, String crmPs, Date dataHora, String cidPac,
			String agendamentoAgendId, String unidadeId) {
		super();
		this.consultaId = consultaId;
		this.pacienteId = pacienteId;
		this.crmPs = crmPs;
		this.dataHora = dataHora;
		this.cidPac = cidPac;
		this.agendamentoAgendId = agendamentoAgendId;
		this.unidadeId = unidadeId;
	}
	public String getConsultaId() {
		return consultaId;
	}
	public void setConsultaId(String consultaId) {
		this.consultaId = consultaId;
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
	public Date getDataHora() {
		return dataHora;
	}
	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}
	public String getCidPac() {
		return cidPac;
	}
	public void setCidPac(String cidPac) {
		this.cidPac = cidPac;
	}
	public String getAgendamentoAgendId() {
		return agendamentoAgendId;
	}
	public void setAgendamentoAgendId(String agendamentoAgendId) {
		this.agendamentoAgendId = agendamentoAgendId;
	}
	public String getUnidadeId() {
		return unidadeId;
	}
	public void setUnidadeId(String unidadeId) {
		this.unidadeId = unidadeId;
	}

	@Override
	public String toString() {
		return "Consulta [consultaId=" + consultaId + ", pacienteId=" + pacienteId + ", crmPs=" + crmPs + ", dataHora="
				+ dataHora + ", cidPac=" + cidPac + ", agendamentoAgendId=" + agendamentoAgendId + ", unidadeId="
				+ unidadeId + "]";
	}
	
	

    
}
