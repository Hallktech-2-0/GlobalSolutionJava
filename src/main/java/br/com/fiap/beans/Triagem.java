package br.com.fiap.beans;

public class Triagem {
    private String triagemId;
    private String pacienteId;
    private String sintomas;
    private String historicoMedico;
    
    
    
	public Triagem() {
		super();
	}
	public Triagem(String triagemId, String pacienteId, String sintomas, String historicoMedico) {
		super();
		this.triagemId = triagemId;
		this.pacienteId = pacienteId;
		this.sintomas = sintomas;
		this.historicoMedico = historicoMedico;
	}
	
	public String getTriagemId() {
		return triagemId;
	}
	public void setTriagemId(String triagemId) {
		this.triagemId = triagemId;
	}
	public String getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getHistoricoMedico() {
		return historicoMedico;
	}
	public void setHistoricoMedico(String historicoMedico) {
		this.historicoMedico = historicoMedico;
	}
	@Override
	public String toString() {
		return "Triagem [triagemId=" + triagemId + ", pacienteId=" + pacienteId + ", sintomas=" + sintomas
				+ ", historicoMedico=" + historicoMedico + "]";
	}
	
	

    
}
