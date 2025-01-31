package br.com.fiap.beans;

public class Medico {
    private String crm;
    private String nome;
    private String especialidade;
    
    
    

	public Medico() {
		super();
	}



	public Medico(String crm, String nome, String especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}
    
    
    
	public String getCrm() {
		return crm;
	}



	public void setCrm(String crm) {
		this.crm = crm;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEspecialidade() {
		return especialidade;
	}



	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	@Override
	public String toString() {
		return "Medico [crm=" + crm + ", nome=" + nome + ", especialidade=" + especialidade + "]";
	}

	
	

}

    
