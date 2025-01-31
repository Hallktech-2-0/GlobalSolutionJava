package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Consulta;
import br.com.fiap.connection.ConnectionFactory;

public class ConsultaDAO {

    private Connection connection;

    public ConsultaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirConsulta(Consulta consulta) {
        String sql = "INSERT INTO consulta (consulta_id, paciente_id, crm_ps, data_hora, cid_pac, agendamento_agend_id, unidade_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consulta.getConsultaId());
            stmt.setString(2, consulta.getPacienteId());
            stmt.setString(3, consulta.getCrmPs());
            stmt.setDate(4, new java.sql.Date(consulta.getDataHora().getTime()));
            stmt.setString(5, consulta.getCidPac());
            stmt.setString(6, consulta.getAgendamentoAgendId());
            stmt.setString(7, consulta.getUnidadeId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarConsulta(String consultaId) {
        String sql = "DELETE FROM consulta WHERE consulta_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consultaId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarConsulta(Consulta consulta) {
        String sql = "UPDATE consulta SET paciente_id = ?, crm_ps = ?, data_hora = ?, cid_pac = ?, agendamento_agend_id = ?, unidade_id = ? WHERE consulta_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, consulta.getPacienteId());
            stmt.setString(2, consulta.getCrmPs());
            stmt.setDate(3, new java.sql.Date(consulta.getDataHora().getTime()));
            stmt.setString(4, consulta.getCidPac());
            stmt.setString(5, consulta.getAgendamentoAgendId());
            stmt.setString(6, consulta.getUnidadeId());
            stmt.setString(7, consulta.getConsultaId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Consulta> listarTodasConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setConsultaId(rs.getString("consulta_id"));
                consulta.setPacienteId(rs.getString("paciente_id"));
                consulta.setCrmPs(rs.getString("crm_ps"));
                consulta.setDataHora(rs.getDate("data_hora"));
                consulta.setCidPac(rs.getString("cid_pac"));
                consulta.setAgendamentoAgendId(rs.getString("agendamento_agend_id"));
                consulta.setUnidadeId(rs.getString("unidade_id"));

                consultas.add(consulta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return consultas;
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
