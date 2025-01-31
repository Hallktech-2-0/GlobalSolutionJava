package br.com.fiap.bo;

import br.com.fiap.beans.Hospital;
import br.com.fiap.dao.HospitalDAO;
import br.com.fiap.exceptions.HospitalInvalidoException;

import java.util.List;

public class HospitalBO {
    private HospitalDAO hospitalDAO;

    public HospitalBO() {
        this.hospitalDAO = new HospitalDAO();
    }

    public void cadastrarHospital(Hospital hospital) throws HospitalInvalidoException {
        if (hospital != null && isValidHospital(hospital)) {
            hospitalDAO.inserirHospital(hospital);
        } else {
            throw new HospitalInvalidoException("Erro: Hospital inválido");
        }
    }

    public void deletarHospital(String unidadeId) {
        if (unidadeId != null && !unidadeId.isEmpty()) {
            hospitalDAO.deletarHospital(unidadeId);
        } else {
            // Lógica de tratamento para ID de hospital inválido
            System.out.println("Erro: ID de Hospital inválido");
        }
    }

    public void atualizarHospital(Hospital hospital) throws HospitalInvalidoException {
        if (hospital != null && isValidHospital(hospital)) {
            hospitalDAO.atualizarHospital(hospital);
        } else {
            throw new HospitalInvalidoException("Erro: Hospital inválido");
        }
    }

    public List<Hospital> listarTodosHospitais() {
        // Implemente a lógica de validação, se necessário
        return hospitalDAO.listarTodosHospitais();
    }

    // Método de validação mais complexa para hospital
    private boolean isValidHospital(Hospital hospital) {
        // Adicionar regras de validação mais complexas aqui
        // Exemplo: Garantir que o telefone do hospital seja válido
        return hospital.getTelefoneUnid() != null && hospital.getTelefoneUnid().matches("\\d{11}") &&
               hospital.getUnidadeId() != null && !hospital.getUnidadeId().isEmpty();
    }
}
