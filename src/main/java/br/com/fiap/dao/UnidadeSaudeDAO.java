package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.UnidadeSaude;
import br.com.fiap.connection.ConnectionFactory;

public class UnidadeSaudeDAO {

    private Connection connection;

    public UnidadeSaudeDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirUnidadeSaude(UnidadeSaude unidadeSaude) {
        String sql = "INSERT INTO unidade_saude (unidade_id, nome_unid, endereco_unid, telefone_unid, email, site) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, unidadeSaude.getUnidadeId());
            stmt.setString(2, unidadeSaude.getNomeUnid());
            stmt.setString(3, unidadeSaude.getEnderecoUnid());
            stmt.setString(4, unidadeSaude.getTelefoneUnid());
            stmt.setString(5, unidadeSaude.getEmail());
            stmt.setString(6, unidadeSaude.getSite());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarUnidadeSaude(String unidadeId) {
        String sql = "DELETE FROM unidade_saude WHERE unidade_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, unidadeId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarUnidadeSaude(UnidadeSaude unidadeSaude) {
        String sql = "UPDATE unidade_saude SET nome_unid = ?, endereco_unid = ?, telefone_unid = ?, email = ?, site = ? WHERE unidade_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, unidadeSaude.getNomeUnid());
            stmt.setString(2, unidadeSaude.getEnderecoUnid());
            stmt.setString(3, unidadeSaude.getTelefoneUnid());
            stmt.setString(4, unidadeSaude.getEmail());
            stmt.setString(5, unidadeSaude.getSite());
            stmt.setString(6, unidadeSaude.getUnidadeId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<UnidadeSaude> listarTodasUnidadesSaude() {
        List<UnidadeSaude> unidadesSaude = new ArrayList<>();
        String sql = "SELECT * FROM unidade_saude";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                UnidadeSaude unidadeSaude = new UnidadeSaude();
                unidadeSaude.setUnidadeId(rs.getString("unidade_id"));
                unidadeSaude.setNomeUnid(rs.getString("nome_unid"));
                unidadeSaude.setEnderecoUnid(rs.getString("endereco_unid"));
                unidadeSaude.setTelefoneUnid(rs.getString("telefone_unid"));
                unidadeSaude.setEmail(rs.getString("email"));
                unidadeSaude.setSite(rs.getString("site"));

                unidadesSaude.add(unidadeSaude);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return unidadesSaude;
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
