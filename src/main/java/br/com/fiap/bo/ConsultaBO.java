package br.com.fiap.bo;

import br.com.fiap.beans.Consulta;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.exceptions.ConsultaInvalidaException;

import java.util.List;

public class ConsultaBO {
    private ConsultaDAO consultaDAO;

    public ConsultaBO() {
        this.consultaDAO = new ConsultaDAO();
    }

    public void cadastrarConsulta(Consulta consulta) throws ConsultaInvalidaException {
        if (consulta != null && isValidConsulta(consulta)) {
            consultaDAO.inserirConsulta(consulta);
        } else {
            throw new ConsultaInvalidaException("Erro: Consulta inválida");
        }
    }

    public void deletarConsulta(String consultaId) {
        if (consultaId != null && !consultaId.isEmpty()) {
            consultaDAO.deletarConsulta(consultaId);
        } else {
            // Lógica de tratamento para ID de consulta inválido
            System.out.println("Erro: ID de Consulta inválido");
        }
    }

    public void atualizarConsulta(Consulta consulta) throws ConsultaInvalidaException {
        if (consulta != null && isValidConsulta(consulta)) {
            consultaDAO.atualizarConsulta(consulta);
        } else {
            throw new ConsultaInvalidaException("Erro: Consulta inválida");
        }
    }

    public List<Consulta> listarTodasConsultas() {
        // Implemente a lógica de validação, se necessário
        return consultaDAO.listarTodasConsultas();
    }

    // Método de validação mais complexa para consulta
    private boolean isValidConsulta(Consulta consulta) {
        // Adicionar regras de validação mais complexas aqui
        // Exemplo: Garantir que a CID do paciente seja válida
        return consulta.getCidPac() != null && !consulta.getCidPac().isEmpty() &&
               consulta.getPacienteId() != null && !consulta.getPacienteId().isEmpty();
    }
}
