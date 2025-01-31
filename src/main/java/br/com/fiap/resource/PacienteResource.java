package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.beans.LoginRequest;
import br.com.fiap.beans.Paciente;
import br.com.fiap.bo.PacienteBO;
import br.com.fiap.exceptions.PacienteInvalidoException;

@Path("/paciente")
public class PacienteResource {

    private PacienteBO pacienteBO;

    public PacienteResource() {
        this.pacienteBO = new PacienteBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPaciente(Paciente paciente) {
        try {
            pacienteBO.cadastrarPaciente(paciente);
            return Response.status(Response.Status.CREATED).build();
        } catch (PacienteInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{pacienteId}")
    public Response deletarPaciente(@PathParam("pacienteId") String pacienteId) {
        pacienteBO.deletarPaciente(pacienteId);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarPaciente(Paciente paciente) {
        try {
            pacienteBO.atualizarPaciente(paciente);
            return Response.ok().build();
        } catch (PacienteInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Paciente> listarTodosPacientes() {
        return pacienteBO.listarTodosPacientes();
    }

    @POST
    @Path("/cadastro")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarPacienteCadastro(Paciente paciente) {
        try {
            pacienteBO.cadastrarPaciente(paciente);
            return Response.status(Response.Status.CREATED).build();
        } catch (PacienteInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response autenticarPaciente(LoginRequest loginRequest) {
        try {
            Paciente paciente = pacienteBO.autenticarPaciente(loginRequest.getEmail(), loginRequest.getSenha());
            if (paciente != null) {
                // Autenticação bem-sucedida
                return Response.ok(paciente).build();
            } else {
                // Credenciais inválidas
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
