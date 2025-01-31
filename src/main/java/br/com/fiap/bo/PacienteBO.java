package br.com.fiap.bo;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.exceptions.PacienteInvalidoException;

import java.util.Calendar;
import java.util.List;

public class PacienteBO {
    private PacienteDAO pacienteDAO;

    public PacienteBO() {
        this.pacienteDAO = new PacienteDAO();
    }

    public void cadastrarPaciente(Paciente paciente) throws PacienteInvalidoException {
        if (paciente != null && isValidPaciente(paciente)) {
            pacienteDAO.inserirPaciente(paciente);
        } else {
            throw new PacienteInvalidoException("Erro: Paciente inválido");
        }
    }

    public void deletarPaciente(String pacienteId) {
        if (pacienteId != null && !pacienteId.isEmpty()) {
            pacienteDAO.deletarPaciente(pacienteId);
        } else {
            // Lógica de tratamento para ID de paciente inválido
            System.out.println("Erro: ID de Paciente inválido");
        }
    }

    public void atualizarPaciente(Paciente paciente) throws PacienteInvalidoException {
        if (paciente != null && isValidPaciente(paciente)) {
            pacienteDAO.atualizarPaciente(paciente);
        } else {
            throw new PacienteInvalidoException("Erro: Paciente inválido");
        }
    }

    public List<Paciente> listarTodosPacientes() {
        
        return pacienteDAO.selecionarTodosPacientes();
    }

    
    private boolean isValidPaciente(Paciente paciente) {
        //regras de validação
        //Garantir que o paciente seja maior de idade
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(paciente.getDataNasc());

        Calendar dataAtual = Calendar.getInstance();
        dataAtual.add(Calendar.YEAR, -18); // Subtrai 18 anos da data atual

        return dataNasc.before(dataAtual) &&
               paciente.getTelefone() != null && paciente.getTelefone().matches("\\d{11}") &&
               paciente.getPacienteId() != null && !paciente.getPacienteId().isEmpty();
    }
        
        public Paciente autenticarPaciente(String email, String senha) throws PacienteInvalidoException {
            if (email != null && senha != null) {
                return pacienteDAO.autenticarPaciente(email, senha);
            } else {
                throw new PacienteInvalidoException("Erro: Credenciais inválidas");
            }
        }
    }

