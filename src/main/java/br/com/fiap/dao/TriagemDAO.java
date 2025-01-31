package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Triagem;
import br.com.fiap.connection.ConnectionFactory;

public class TriagemDAO {

    private Connection connection;

    public TriagemDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirTriagem(Triagem triagem) {
        String sql = "INSERT INTO triagem (triagem_id, paciente_id, sintomas, historico_medico) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, triagem.getTriagemId());
            stmt.setString(2, triagem.getPacienteId());
            stmt.setString(3, triagem.getSintomas());
            stmt.setString(4, triagem.getHistoricoMedico());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarTriagem(String triagemId) {
        String sql = "DELETE FROM triagem WHERE triagem_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, triagemId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarTriagem(Triagem triagem) {
        String sql = "UPDATE triagem SET paciente_id = ?, sintomas = ?, historico_medico = ? WHERE triagem_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, triagem.getPacienteId());
            stmt.setString(2, triagem.getSintomas());
            stmt.setString(3, triagem.getHistoricoMedico());
            stmt.setString(4, triagem.getTriagemId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Triagem> listarTodasTriagens() {
        List<Triagem> triagens = new ArrayList<>();
        String sql = "SELECT * FROM triagem";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Triagem triagem = new Triagem();
                triagem.setTriagemId(rs.getString("triagem_id"));
                triagem.setPacienteId(rs.getString("paciente_id"));
                triagem.setSintomas(rs.getString("sintomas"));
                triagem.setHistoricoMedico(rs.getString("historico_medico"));

                triagens.add(triagem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return triagens;
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
