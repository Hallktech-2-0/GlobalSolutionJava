package br.com.fiap.bo;

import br.com.fiap.beans.Triagem;
import br.com.fiap.dao.TriagemDAO;
import br.com.fiap.exceptions.TriagemException;

import java.util.List;

public class TriagemBO {

    private TriagemDAO triagemDAO;

    public TriagemBO() {
        this.triagemDAO = new TriagemDAO();
    }

    public void cadastrarTriagem(Triagem triagem) throws TriagemException {
        validarTriagem(triagem);
        triagemDAO.inserirTriagem(triagem);
    }

    public void excluirTriagem(String triagemId) throws TriagemException {
        if (triagemId == null || triagemId.isEmpty()) {
            throw new TriagemException("ID da triagem inválido");
        }
        triagemDAO.deletarTriagem(triagemId);
    }

    public void atualizarTriagem(Triagem triagem) throws TriagemException {
        validarTriagem(triagem);
        triagemDAO.atualizarTriagem(triagem);
    }

    public List<Triagem> listarTodasTriagens() throws TriagemException {
        return triagemDAO.listarTodasTriagens();
    }

    private void validarTriagem(Triagem triagem) throws TriagemException {
        if (triagem == null) {
            throw new TriagemException("Triagem não pode ser nula");
        }
    }
}
