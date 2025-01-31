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

import br.com.fiap.beans.Agendamento;
import br.com.fiap.bo.AgendamentoBO;
import br.com.fiap.exceptions.AgendamentoInvalidoException;

@Path("/agendamento")
public class AgendamentoResource {

    private AgendamentoBO agendamentoBO;

    public AgendamentoResource() {
        this.agendamentoBO = new AgendamentoBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarAgendamento(Agendamento agendamento) {
        try {
            agendamentoBO.cadastrarAgendamento(agendamento);
            return Response.status(Response.Status.CREATED).build();
        } catch (AgendamentoInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{agendamentoId}")
    public Response deletarAgendamento(@PathParam("agendamentoId") String agendamentoId) {
        agendamentoBO.deletarAgendamento(agendamentoId);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarAgendamento(Agendamento agendamento) {
        try {
            agendamentoBO.atualizarAgendamento(agendamento);
            return Response.ok().build();
        } catch (AgendamentoInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Agendamento> listarTodosAgendamentos() {
        return agendamentoBO.listarTodosAgendamentos();
    }
}
