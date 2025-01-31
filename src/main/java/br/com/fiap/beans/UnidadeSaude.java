package br.com.fiap.beans;

public class UnidadeSaude {
    private String unidadeId;
    private String nomeUnid;
    private String enderecoUnid;
    private String telefoneUnid;
    private String email;
    private String site;
    
    
    
    
	public UnidadeSaude() {
		super();
	}
	public UnidadeSaude(String unidadeId, String nomeUnid, String enderecoUnid, String telefoneUnid, String email,
			String site) {
		super();
		this.unidadeId = unidadeId;
		this.nomeUnid = nomeUnid;
		this.enderecoUnid = enderecoUnid;
		this.telefoneUnid = telefoneUnid;
		this.email = email;
		this.site = site;
	}
	public String getUnidadeId() {
		return unidadeId;
	}
	public void setUnidadeId(String unidadeId) {
		this.unidadeId = unidadeId;
	}
	public String getNomeUnid() {
		return nomeUnid;
	}
	public void setNomeUnid(String nomeUnid) {
		this.nomeUnid = nomeUnid;
	}
	public String getEnderecoUnid() {
		return enderecoUnid;
	}
	public void setEnderecoUnid(String enderecoUnid) {
		this.enderecoUnid = enderecoUnid;
	}
	public String getTelefoneUnid() {
		return telefoneUnid;
	}
	public void setTelefoneUnid(String telefoneUnid) {
		this.telefoneUnid = telefoneUnid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	@Override
	public String toString() {
		return "UnidadeSaude [unidadeId=" + unidadeId + ", nomeUnid=" + nomeUnid + ", enderecoUnid=" + enderecoUnid
				+ ", telefoneUnid=" + telefoneUnid + ", email=" + email + ", site=" + site + "]";
	}
	
	

    
}
