package br.com.fiap.bo;

import br.com.fiap.beans.Medico;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.exceptions.MedicoException;

import java.util.List;

public class MedicoBO {

    private MedicoDAO medicoDAO;

    public MedicoBO() {
        this.medicoDAO = new MedicoDAO();
    }

    public void cadastrarMedico(Medico medico) throws MedicoException {
        validarMedico(medico);
        medicoDAO.inserirMedico(medico);
    }

    public void excluirMedico(String crm) throws MedicoException {
        if (crm == null || crm.isEmpty()) {
            throw new MedicoException("CRM do médico inválido");
        }
        medicoDAO.deletarMedico(crm);
    }

    public void atualizarMedico(Medico medico) throws MedicoException {
        validarMedico(medico);
        medicoDAO.atualizarMedico(medico);
    }

    public List<Medico> listarTodosMedicos() throws MedicoException {
        return medicoDAO.listarTodosMedicos();
    }

    private void validarMedico(Medico medico) throws MedicoException {
        if (medico == null) {
            throw new MedicoException("Médico não pode ser nulo");
        }
        // Adicionar lógica de validação adicional, se necessário
    }
}
