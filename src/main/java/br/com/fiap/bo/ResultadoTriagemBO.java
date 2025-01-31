package br.com.fiap.bo;

import br.com.fiap.beans.ResultadoTriagem;
import br.com.fiap.dao.ResultadoTriagemDAO;
import br.com.fiap.exceptions.ResultadoTriagemException;

import java.util.List;

public class ResultadoTriagemBO {

    private ResultadoTriagemDAO resultadoTriagemDAO;

    public ResultadoTriagemBO() {
        this.resultadoTriagemDAO = new ResultadoTriagemDAO();
    }

    public void cadastrarResultadoTriagem(ResultadoTriagem resultadoTriagem) throws ResultadoTriagemException {
        validarResultadoTriagem(resultadoTriagem);
        resultadoTriagemDAO.inserirResultadoTriagem(resultadoTriagem);
    }

    public void excluirResultadoTriagem(String resultadoTriagemId) throws ResultadoTriagemException {
        if (resultadoTriagemId == null || resultadoTriagemId.isEmpty()) {
            throw new ResultadoTriagemException("ID do resultado da triagem inválido");
        }
        resultadoTriagemDAO.deletarResultadoTriagem(resultadoTriagemId);
    }

    public void atualizarResultadoTriagem(ResultadoTriagem resultadoTriagem) throws ResultadoTriagemException {
        validarResultadoTriagem(resultadoTriagem);
        resultadoTriagemDAO.atualizarResultadoTriagem(resultadoTriagem);
    }

    public List<ResultadoTriagem> listarTodosResultadosTriagem() throws ResultadoTriagemException {
        return resultadoTriagemDAO.listarTodosResultadosTriagem();
    }

    private void validarResultadoTriagem(ResultadoTriagem resultadoTriagem) throws ResultadoTriagemException {
        if (resultadoTriagem == null) {
            throw new ResultadoTriagemException("Resultado da triagem não pode ser nulo");
        }
        // Adicionar lógica de validação adicional, se necessário
    }
}
