package br.com.fiap.beans;

import java.util.Date;

public class Paciente {
    private String pacienteId;
    private String nome;
    private Date dataNasc;
    private char genero;
    private String endereco;
    private String telefone;
    private String convenio;
    private String email;
    private String senha;
    private String consultaConsultaId;
    
	public Paciente() {
		super();
	}
	
	
	
	public Paciente(String pacienteId, String nome, Date dataNasc, char genero, String telefone, String convenio,
			String email, String senha, String consultaConsultaId) {
		super();
		this.pacienteId = pacienteId;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.genero = genero;
		this.telefone = telefone;
		this.convenio = convenio;
		this.email = email;
		this.senha = senha;
		this.consultaConsultaId = consultaConsultaId;
	}



	public Paciente(String pacienteId, String nome, Date dataNasc, char genero, String endereco, String telefone,
			String convenio, String email, String senha, String consultaConsultaId) {
		super();
		this.pacienteId = pacienteId;
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.genero = genero;
		this.endereco = endereco;
		this.telefone = telefone;
		this.convenio = convenio;
		this.email = email;
		this.senha = senha;
		this.consultaConsultaId = consultaConsultaId;
	}
	public String getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(String pacienteId) {
		this.pacienteId = pacienteId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConsultaConsultaId() {
		return consultaConsultaId;
	}
	public void setConsultaConsultaId(String consultaConsultaId) {
		this.consultaConsultaId = consultaConsultaId;
	}



	@Override
	public String toString() {
		return "Paciente [pacienteId=" + pacienteId + ", nome=" + nome + ", dataNasc=" + dataNasc + ", genero=" + genero
				+ ", endereco=" + endereco + ", telefone=" + telefone + ", convenio=" + convenio + ", email=" + email
				+ ", senha=" + senha + ", consultaConsultaId=" + consultaConsultaId + "]";
	}
    
	
}
