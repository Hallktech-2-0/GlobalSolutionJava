package br.com.fiap.bo;

import br.com.fiap.beans.UnidadeSaude;
import br.com.fiap.dao.UnidadeSaudeDAO;
import br.com.fiap.exceptions.UnidadeSaudeException;

import java.util.List;

public class UnidadeSaudeBO {

    private UnidadeSaudeDAO unidadeSaudeDAO;

    public UnidadeSaudeBO() {
        this.unidadeSaudeDAO = new UnidadeSaudeDAO();
    }

    public void cadastrarUnidadeSaude(UnidadeSaude unidadeSaude) throws UnidadeSaudeException {
        validarUnidadeSaude(unidadeSaude);
        unidadeSaudeDAO.inserirUnidadeSaude(unidadeSaude);
    }

    public void excluirUnidadeSaude(String unidadeId) throws UnidadeSaudeException {
        if (unidadeId == null || unidadeId.isEmpty()) {
            throw new UnidadeSaudeException("ID da unidade de saúde inválido");
        }
        unidadeSaudeDAO.deletarUnidadeSaude(unidadeId);
    }

    public void atualizarUnidadeSaude(UnidadeSaude unidadeSaude) throws UnidadeSaudeException {
        validarUnidadeSaude(unidadeSaude);
        unidadeSaudeDAO.atualizarUnidadeSaude(unidadeSaude);
    }

    public List<UnidadeSaude> listarTodasUnidadesSaude() throws UnidadeSaudeException {
        return unidadeSaudeDAO.listarTodasUnidadesSaude();
    }

    private void validarUnidadeSaude(UnidadeSaude unidadeSaude) throws UnidadeSaudeException {
        if (unidadeSaude == null) {
            throw new UnidadeSaudeException("Unidade de saúde não pode ser nula");
        }
        // Adicionar lógica de validação adicional, se necessário
    }
}
