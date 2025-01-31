package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Agendamento;
import br.com.fiap.connection.ConnectionFactory;

public class AgendamentoDAO {

    private Connection connection;

    public AgendamentoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirAgendamento(Agendamento agendamento) {
        String sql = "INSERT INTO agendamento (agend_id, paciente_id, crm_ps, data_hora_agend, exames_exame_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, agendamento.getAgendId());
            stmt.setString(2, agendamento.getPacienteId());
            stmt.setString(3, agendamento.getCrmPs());
            stmt.setDate(4, new java.sql.Date(agendamento.getDataHoraAgend().getTime()));
            stmt.setString(5, agendamento.getExamesExameId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarAgendamento(String agendamentoId) {
        String sql = "DELETE FROM agendamento WHERE agend_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, agendamentoId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarAgendamento(Agendamento agendamento) {
        String sql = "UPDATE agendamento SET paciente_id = ?, crm_ps = ?, data_hora_agend = ?, exames_exame_id = ? WHERE agend_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, agendamento.getPacienteId());
            stmt.setString(2, agendamento.getCrmPs());
            stmt.setDate(3, new java.sql.Date(agendamento.getDataHoraAgend().getTime()));
            stmt.setString(4, agendamento.getExamesExameId());
            stmt.setString(5, agendamento.getAgendId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Agendamento> listarTodosAgendamentos() {
        List<Agendamento> agendamentos = new ArrayList<>();
        String sql = "SELECT * FROM agendamento";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setAgendId(rs.getString("agend_id"));
                agendamento.setPacienteId(rs.getString("paciente_id"));
                agendamento.setCrmPs(rs.getString("crm_ps"));
                agendamento.setDataHoraAgend(rs.getDate("data_hora_agend"));
                agendamento.setExamesExameId(rs.getString("exames_exame_id"));

                agendamentos.add(agendamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return agendamentos;
    }

    // Método para fechar a conexão
    private void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
