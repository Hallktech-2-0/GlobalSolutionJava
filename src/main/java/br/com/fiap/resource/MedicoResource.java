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

import br.com.fiap.beans.Medico;
import br.com.fiap.bo.MedicoBO;
import br.com.fiap.exceptions.MedicoException;

@Path("/medico")
public class MedicoResource {

    private MedicoBO medicoBO;

    public MedicoResource() {
        this.medicoBO = new MedicoBO();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarMedico(Medico medico) {
        try {
            medicoBO.cadastrarMedico(medico);
            return Response.status(Response.Status.CREATED).build();
        } catch (MedicoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/excluir/{crm}")
    public Response excluirMedico(@PathParam("crm") String crm) {
        try {
            medicoBO.excluirMedico(crm);
            return Response.status(Response.Status.OK).build();
        } catch (MedicoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarMedico(Medico medico) {
        try {
            medicoBO.atualizarMedico(medico);
            return Response.status(Response.Status.OK).build();
        } catch (MedicoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosMedicos() {
        try {
            List<Medico> medicos = medicoBO.listarTodosMedicos();
            return Response.status(Response.Status.OK).entity(medicos).build();
        } catch (MedicoException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
