package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Hospital;
import br.com.fiap.connection.ConnectionFactory;

public class HospitalDAO {

    private Connection connection;

    public HospitalDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirHospital(Hospital hospital) {
        String sql = "INSERT INTO hospital (unidade_id, nome_unid, endereco_unid, telefone_unid, email, site) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospital.getUnidadeId());
            stmt.setString(2, hospital.getNomeUnid());
            stmt.setString(3, hospital.getEnderecoUnid());
            stmt.setString(4, hospital.getTelefoneUnid());
            stmt.setString(5, hospital.getEmail());
            stmt.setString(6, hospital.getSite());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarHospital(String unidadeId) {
        String sql = "DELETE FROM hospital WHERE unidade_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, unidadeId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarHospital(Hospital hospital) {
        String sql = "UPDATE hospital SET nome_unid = ?, endereco_unid = ?, telefone_unid = ?, email = ?, site = ? WHERE unidade_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, hospital.getNomeUnid());
            stmt.setString(2, hospital.getEnderecoUnid());
            stmt.setString(3, hospital.getTelefoneUnid());
            stmt.setString(4, hospital.getEmail());
            stmt.setString(5, hospital.getSite());
            stmt.setString(6, hospital.getUnidadeId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Hospital> listarTodosHospitais() {
        List<Hospital> hospitais = new ArrayList<>();
        String sql = "SELECT * FROM hospital";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setUnidadeId(rs.getString("unidade_id"));
                hospital.setNomeUnid(rs.getString("nome_unid"));
                hospital.setEnderecoUnid(rs.getString("endereco_unid"));
                hospital.setTelefoneUnid(rs.getString("telefone_unid"));
                hospital.setEmail(rs.getString("email"));
                hospital.setSite(rs.getString("site"));

                hospitais.add(hospital);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return hospitais;
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
