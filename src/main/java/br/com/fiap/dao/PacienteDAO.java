package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Paciente;
import br.com.fiap.connection.ConnectionFactory;

public class PacienteDAO {

    private Connection connection;

    public PacienteDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void inserirPaciente(Paciente paciente) {
        String sql = "INSERT INTO paciente (paciente_id, nome, data_nasc, genero, endereco, telefone, convenio, email, senha, consulta_consulta_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getPacienteId());
            stmt.setString(2, paciente.getNome());
            stmt.setDate(3, new java.sql.Date(paciente.getDataNasc().getTime()));
            stmt.setString(4, String.valueOf(paciente.getGenero()));
            stmt.setString(5, paciente.getEndereco());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getConvenio());
            stmt.setString(8, paciente.getEmail());
            stmt.setString(9, paciente.getSenha());
            stmt.setString(10, paciente.getConsultaConsultaId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void deletarPaciente(String pacienteId) {
        String sql = "DELETE FROM paciente WHERE paciente_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pacienteId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void atualizarPaciente(Paciente paciente) {
        String sql = "UPDATE paciente SET nome = ?, data_nasc = ?, genero = ?, endereco = ?, telefone = ?, convenio = ?, email = ?, senha = ?, consulta_consulta_id = ? WHERE paciente_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, paciente.getNome());
            stmt.setDate(2, new java.sql.Date(paciente.getDataNasc().getTime()));
            stmt.setString(3, String.valueOf(paciente.getGenero()));
            stmt.setString(4, paciente.getEndereco());
            stmt.setString(5, paciente.getTelefone());
            stmt.setString(6, paciente.getConvenio());
            stmt.setString(7, paciente.getEmail());
            stmt.setString(8, paciente.getSenha());
            stmt.setString(9, paciente.getConsultaConsultaId());
            stmt.setString(10, paciente.getPacienteId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public List<Paciente> selecionarTodosPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = "SELECT * FROM paciente";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setPacienteId(rs.getString("paciente_id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setDataNasc(rs.getDate("data_nasc"));
                paciente.setGenero(rs.getString("genero").charAt(0));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setConvenio(rs.getString("convenio"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setConsultaConsultaId(rs.getString("consulta_consulta_id"));

                pacientes.add(paciente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return pacientes;
    }

    public Paciente autenticarPaciente(String email, String senha) {
        Paciente paciente = null;
        String sql = "SELECT * FROM paciente WHERE email = ? AND senha = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setPacienteId(rs.getString("paciente_id"));
                    paciente.setNome(rs.getString("nome"));
                    // Adicione outros campos se necessário
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }

        return paciente;
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
