package br.com.fiap.bo;

import br.com.fiap.beans.MedicoAtendimento;
import br.com.fiap.dao.MedicoAtendimentoDAO;
import br.com.fiap.exceptions.MedicoAtendimentoException;

import java.util.List;

public class MedicoAtendimentoBO {

    private MedicoAtendimentoDAO medicoAtendimentoDAO;

    public MedicoAtendimentoBO() {
        this.medicoAtendimentoDAO = new MedicoAtendimentoDAO();
    }

    public void cadastrarMedicoAtendimento(MedicoAtendimento medicoAtendimento) throws MedicoAtendimentoException {
        validarMedicoAtendimento(medicoAtendimento);
        medicoAtendimentoDAO.inserirMedicoAtendimento(medicoAtendimento);
    }

    public void excluirMedicoAtendimento(String crm, String unidadeId) throws MedicoAtendimentoException {
        if (crm == null || crm.isEmpty() || unidadeId == null || unidadeId.isEmpty()) {
            throw new MedicoAtendimentoException("CRM ou ID da unidade de saúde inválido");
        }
        medicoAtendimentoDAO.deletarMedicoAtendimento(crm, unidadeId);
    }

    public void atualizarMedicoAtendimento(MedicoAtendimento medicoAtendimento) throws MedicoAtendimentoException {
        validarMedicoAtendimento(medicoAtendimento);
        medicoAtendimentoDAO.atualizarMedicoAtendimento(medicoAtendimento);
    }

    public List<MedicoAtendimento> listarTodosMedicosAtendimento() throws MedicoAtendimentoException {
        return medicoAtendimentoDAO.listarTodosMedicosAtendimento();
    }

    private void validarMedicoAtendimento(MedicoAtendimento medicoAtendimento) throws MedicoAtendimentoException {
        if (medicoAtendimento == null) {
            throw new MedicoAtendimentoException("Relacionamento médico-atendimento não pode ser nulo");
        }
        // Adicionar lógica de validação adicional, se necessário
    }
}
