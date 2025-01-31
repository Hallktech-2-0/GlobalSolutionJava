package br.com.fiap.bo;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.dao.AgendamentoDAO;
import br.com.fiap.exceptions.AgendamentoInvalidoException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class AgendamentoBO {
    private AgendamentoDAO agendamentoDAO;

    public AgendamentoBO() {
        this.agendamentoDAO = new AgendamentoDAO();
    }

    public void cadastrarAgendamento(Agendamento agendamento) throws AgendamentoInvalidoException {
        try {
            if (agendamento != null && isValidAgendamento(agendamento)) {
                agendamentoDAO.inserirAgendamento(agendamento);
            } else {
                throw new AgendamentoInvalidoException("Erro: Agendamento inválido. Verifique os dados fornecidos.", null);
            }
        } catch (Exception e) {
            throw new AgendamentoInvalidoException("Erro ao cadastrar agendamento.", e);
        }
    }

    public void deletarAgendamento(String agendamentoId) {
        try {
            if (agendamentoId != null && !agendamentoId.trim().isEmpty()) {
                agendamentoDAO.deletarAgendamento(agendamentoId);
            } else {
                System.out.println("Erro: ID de Agendamento inválido");
            }
        } catch (Exception e) {
            // Adicione tratamento específico para a exceção, se necessário
            System.out.println("Erro ao deletar agendamento.");
        }
    }

    public void atualizarAgendamento(Agendamento agendamento) throws AgendamentoInvalidoException {
        try {
            if (agendamento != null && isValidAgendamento(agendamento)) {
                agendamentoDAO.atualizarAgendamento(agendamento);
            } else {
                throw new AgendamentoInvalidoException("Erro: Agendamento inválido. Verifique os dados fornecidos.", null);
            }
        } catch (Exception e) {
            // Adicione tratamento específico para a exceção, se necessário
            throw new AgendamentoInvalidoException("Erro ao atualizar agendamento.", e);
        }
    }

    public List<Agendamento> listarTodosAgendamentos() {
        try {
            return agendamentoDAO.listarTodosAgendamentos();
        } catch (Exception e) {
            System.out.println("Erro ao listar agendamentos.");
            return null;
        }
    }

    private boolean isValidAgendamento(Agendamento agendamento) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dataHoraAgendamento = LocalDateTime.ofInstant(agendamento.getDataHoraAgend().toInstant(), ZoneId.systemDefault());

        return dataHoraAgendamento.isAfter(now) &&
               agendamento.getPacienteId() != null && !agendamento.getPacienteId().isBlank() &&
               agendamento.getCrmPs() != null && !agendamento.getCrmPs().isBlank();
    }
}
