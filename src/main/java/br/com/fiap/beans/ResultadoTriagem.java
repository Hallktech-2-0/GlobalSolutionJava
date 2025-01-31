package br.com.fiap.beans;

public class ResultadoTriagem {
    private String resultadoTriagemId;
    private String triagemId;
    private String urgencia;
    private String recomendacao;
    
    
    
	public ResultadoTriagem() {
		super();
	}
	public ResultadoTriagem(String resultadoTriagemId, String triagemId, String urgencia, String recomendacao) {
		super();
		this.resultadoTriagemId = resultadoTriagemId;
		this.triagemId = triagemId;
		this.urgencia = urgencia;
		this.recomendacao = recomendacao;
	}
	public String getResultadoTriagemId() {
		return resultadoTriagemId;
	}
	public void setResultadoTriagemId(String resultadoTriagemId) {
		this.resultadoTriagemId = resultadoTriagemId;
	}
	public String getTriagemId() {
		return triagemId;
	}
	public void setTriagemId(String triagemId) {
		this.triagemId = triagemId;
	}
	public String getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}
	public String getRecomendacao() {
		return recomendacao;
	}
	public void setRecomendacao(String recomendacao) {
		this.recomendacao = recomendacao;
	}
	@Override
	public String toString() {
		return "ResultadoTriagem [resultadoTriagemId=" + resultadoTriagemId + ", triagemId=" + triagemId + ", urgencia="
				+ urgencia + ", recomendacao=" + recomendacao + "]";
	}

	
	
    
}
