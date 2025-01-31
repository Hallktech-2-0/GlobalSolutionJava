package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.ResultadoTriagem;
import br.com.fiap.connection.ConnectionFactory;

public class ResultadoTriagemDAO {

    private Connection connection;

    public ResultadoTriagemDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirResultadoTriagem(ResultadoTriagem resultadoTriagem) {
        String sql = "INSERT INTO resultado_triagem (resultado_triagem_id, triagem_id, urgencia, recomendacao) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, resultadoTriagem.getResultadoTriagemId());
            stmt.setString(2, resultadoTriagem.getTriagemId());
            stmt.setString(3, resultadoTriagem.getUrgencia());
            stmt.setString(4, resultadoTriagem.getRecomendacao());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarResultadoTriagem(String resultadoTriagemId) {
        String sql = "DELETE FROM resultado_triagem WHERE resultado_triagem_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, resultadoTriagemId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarResultadoTriagem(ResultadoTriagem resultadoTriagem) {
        String sql = "UPDATE resultado_triagem SET triagem_id = ?, urgencia = ?, recomendacao = ? WHERE resultado_triagem_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, resultadoTriagem.getTriagemId());
            stmt.setString(2, resultadoTriagem.getUrgencia());
            stmt.setString(3, resultadoTriagem.getRecomendacao());
            stmt.setString(4, resultadoTriagem.getResultadoTriagemId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<ResultadoTriagem> listarTodosResultadosTriagem() {
        List<ResultadoTriagem> resultadosTriagem = new ArrayList<>();
        String sql = "SELECT * FROM resultado_triagem";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                ResultadoTriagem resultadoTriagem = new ResultadoTriagem();
                resultadoTriagem.setResultadoTriagemId(rs.getString("resultado_triagem_id"));
                resultadoTriagem.setTriagemId(rs.getString("triagem_id"));
                resultadoTriagem.setUrgencia(rs.getString("urgencia"));
                resultadoTriagem.setRecomendacao(rs.getString("recomendacao"));

                resultadosTriagem.add(resultadoTriagem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return resultadosTriagem;
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
