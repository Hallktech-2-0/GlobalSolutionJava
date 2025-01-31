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

import br.com.fiap.beans.MedicoAtendimento;
import br.com.fiap.bo.MedicoAtendimentoBO;
import br.com.fiap.exceptions.MedicoAtendimentoException;

@Path("/medicoAtendimento")
public class MedicoAtendimentoResource {

    private MedicoAtendimentoBO medicoAtendimentoBO;

    public MedicoAtendimentoResource() {
        this.medicoAtendimentoBO = new MedicoAtendimentoBO();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarMedicoAtendimento(MedicoAtendimento medicoAtendimento) {
        try {
            medicoAtendimentoBO.cadastrarMedicoAtendimento(medicoAtendimento);
            return Response.status(Response.Status.CREATED).build();
        } catch (MedicoAtendimentoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/excluir/{crm}/{unidadeId}")
    public Response excluirMedicoAtendimento(
            @PathParam("crm") String crm,
            @PathParam("unidadeId") String unidadeId) {
        try {
            medicoAtendimentoBO.excluirMedicoAtendimento(crm, unidadeId);
            return Response.status(Response.Status.OK).build();
        } catch (MedicoAtendimentoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarMedicoAtendimento(MedicoAtendimento medicoAtendimento) {
        try {
            medicoAtendimentoBO.atualizarMedicoAtendimento(medicoAtendimento);
            return Response.status(Response.Status.OK).build();
        } catch (MedicoAtendimentoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosMedicosAtendimento() {
        try {
            List<MedicoAtendimento> medicosAtendimento = medicoAtendimentoBO.listarTodosMedicosAtendimento();
            return Response.status(Response.Status.OK).entity(medicosAtendimento).build();
        } catch (MedicoAtendimentoException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
