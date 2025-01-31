package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Medico;
import br.com.fiap.connection.ConnectionFactory;

public class MedicoDAO {

    private Connection connection;

    public MedicoDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirMedico(Medico medico) {
        String sql = "INSERT INTO medico (crm, nome, especialidade) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getCrm());
            stmt.setString(2, medico.getNome());
            stmt.setString(3, medico.getEspecialidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarMedico(String crm) {
        String sql = "DELETE FROM medico WHERE crm = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, crm);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarMedico(Medico medico) {
        String sql = "UPDATE medico SET nome = ?, especialidade = ? WHERE crm = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getEspecialidade());
            stmt.setString(3, medico.getCrm());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Medico> listarTodosMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medico";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setCrm(rs.getString("crm"));
                medico.setNome(rs.getString("nome"));
                medico.setEspecialidade(rs.getString("especialidade"));

                medicos.add(medico);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return medicos;
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
