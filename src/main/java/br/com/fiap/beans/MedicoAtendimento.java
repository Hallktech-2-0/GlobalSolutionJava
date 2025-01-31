package br.com.fiap.beans;

public class MedicoAtendimento {
    private String crm;
    private String unidadeId;
    
    
    
	public MedicoAtendimento() {
		super();
	}
	public MedicoAtendimento(String crm, String unidadeId) {
		super();
		this.crm = crm;
		this.unidadeId = unidadeId;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getUnidadeId() {
		return unidadeId;
	}
	public void setUnidadeId(String unidadeId) {
		this.unidadeId = unidadeId;
	}
	@Override
	public String toString() {
		return "MedicoAtendimento [crm=" + crm + ", unidadeId=" + unidadeId + "]";
	}
	
	

    
}
