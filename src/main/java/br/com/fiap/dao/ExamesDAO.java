package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Exames;
import br.com.fiap.connection.ConnectionFactory;

public class ExamesDAO {

    private Connection connection;

    public ExamesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirExames(Exames exames) {
        String sql = "INSERT INTO exames (exame_id, agend_id, consulta_id, tipo_exame, data_hora, resultado) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, exames.getExameId());
            stmt.setString(2, exames.getAgendId());
            stmt.setString(3, exames.getConsultaId());
            stmt.setString(4, exames.getTipoExame());
            stmt.setDate(5, new java.sql.Date(exames.getDataHora().getTime()));
            stmt.setString(6, exames.getResultado());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarExames(String exameId) {
        String sql = "DELETE FROM exames WHERE exame_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, exameId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarExames(Exames exames) {
        String sql = "UPDATE exames SET agend_id = ?, consulta_id = ?, tipo_exame = ?, data_hora = ?, resultado = ? WHERE exame_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, exames.getAgendId());
            stmt.setString(2, exames.getConsultaId());
            stmt.setString(3, exames.getTipoExame());
            stmt.setDate(4, new java.sql.Date(exames.getDataHora().getTime()));
            stmt.setString(5, exames.getResultado());
            stmt.setString(6, exames.getExameId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Exames> listarTodosExames() {
        List<Exames> examesList = new ArrayList<>();
        String sql = "SELECT * FROM exames";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Exames exames = new Exames();
                exames.setExameId(rs.getString("exame_id"));
                exames.setAgendId(rs.getString("agend_id"));
                exames.setConsultaId(rs.getString("consulta_id"));
                exames.setTipoExame(rs.getString("tipo_exame"));
                exames.setDataHora(rs.getDate("data_hora"));
                exames.setResultado(rs.getString("resultado"));

                examesList.add(exames);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return examesList;
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
