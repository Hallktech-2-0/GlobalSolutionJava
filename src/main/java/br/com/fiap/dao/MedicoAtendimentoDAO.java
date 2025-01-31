package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.MedicoAtendimento;
import br.com.fiap.connection.ConnectionFactory;

public class MedicoAtendimentoDAO {

    private Connection connection;

    public MedicoAtendimentoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirMedicoAtendimento(MedicoAtendimento medicoAtendimento) {
        String sql = "INSERT INTO medico_atendimento (crm, unidade_id) VALUES (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medicoAtendimento.getCrm());
            stmt.setString(2, medicoAtendimento.getUnidadeId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarMedicoAtendimento(String crm, String unidadeId) {
        String sql = "DELETE FROM medico_atendimento WHERE crm = ? AND unidade_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, crm);
            stmt.setString(2, unidadeId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarMedicoAtendimento(MedicoAtendimento medicoAtendimento) {
        String sql = "UPDATE medico_atendimento SET unidade_id = ? WHERE crm = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medicoAtendimento.getUnidadeId());
            stmt.setString(2, medicoAtendimento.getCrm());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<MedicoAtendimento> listarTodosMedicosAtendimento() {
        List<MedicoAtendimento> medicosAtendimento = new ArrayList<>();
        String sql = "SELECT * FROM medico_atendimento";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MedicoAtendimento medicoAtendimento = new MedicoAtendimento();
                medicoAtendimento.setCrm(rs.getString("crm"));
                medicoAtendimento.setUnidadeId(rs.getString("unidade_id"));

                medicosAtendimento.add(medicoAtendimento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return medicosAtendimento;
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
