package br.com.fiap.bo;

import br.com.fiap.beans.Exames;
import br.com.fiap.dao.ExamesDAO;
import br.com.fiap.exceptions.ExamesInvalidosException;

import java.util.List;

public class ExamesBO {
    private ExamesDAO examesDAO;

    public ExamesBO() {
        this.examesDAO = new ExamesDAO();
    }

    public void cadastrarExames(Exames exames) throws ExamesInvalidosException {
        if (exames != null && isValidExames(exames)) {
            examesDAO.inserirExames(exames);
        } else {
            throw new ExamesInvalidosException("Erro: Exames inválidos");
        }
    }

    public void deletarExames(String examesId) {
        if (examesId != null && !examesId.isEmpty()) {
            examesDAO.deletarExames(examesId);
        } else {
            // Lógica de tratamento para ID de exames inválido
            System.out.println("Erro: ID de Exames inválido");
        }
    }

    public void atualizarExames(Exames exames) throws ExamesInvalidosException {
        if (exames != null && isValidExames(exames)) {
            examesDAO.atualizarExames(exames);
        } else {
            throw new ExamesInvalidosException("Erro: Exames inválidos");
        }
    }

    public List<Exames> listarTodosExames() {
        // Implemente a lógica de validação, se necessário
        return examesDAO.listarTodosExames();
    }

    // Método de validação mais complexa para exames
    private boolean isValidExames(Exames exames) {
        // Adicionar regras de validação mais complexas aqui
        // Exemplo: Garantir que o tipo de exame seja válido
        return exames.getTipoExame() != null && !exames.getTipoExame().isEmpty() &&
               exames.getAgendId() != null && !exames.getAgendId().isEmpty();
    }
}
