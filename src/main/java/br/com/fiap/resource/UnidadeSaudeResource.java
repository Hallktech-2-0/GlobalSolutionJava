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

import br.com.fiap.beans.UnidadeSaude;
import br.com.fiap.bo.UnidadeSaudeBO;
import br.com.fiap.exceptions.UnidadeSaudeException;

@Path("/unidadeSaude")
public class UnidadeSaudeResource {

    private UnidadeSaudeBO unidadeSaudeBO;

    public UnidadeSaudeResource() {
        this.unidadeSaudeBO = new UnidadeSaudeBO();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarUnidadeSaude(UnidadeSaude unidadeSaude) {
        try {
            unidadeSaudeBO.cadastrarUnidadeSaude(unidadeSaude);
            return Response.status(Response.Status.CREATED).build();
        } catch (UnidadeSaudeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/excluir/{unidadeId}")
    public Response excluirUnidadeSaude(@PathParam("unidadeId") String unidadeId) {
        try {
            unidadeSaudeBO.excluirUnidadeSaude(unidadeId);
            return Response.status(Response.Status.OK).build();
        } catch (UnidadeSaudeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarUnidadeSaude(UnidadeSaude unidadeSaude) {
        try {
            unidadeSaudeBO.atualizarUnidadeSaude(unidadeSaude);
            return Response.status(Response.Status.OK).build();
        } catch (UnidadeSaudeException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodasUnidadesSaude() {
        try {
            List<UnidadeSaude> unidadesSaude = unidadeSaudeBO.listarTodasUnidadesSaude();
            return Response.status(Response.Status.OK).entity(unidadesSaude).build();
        } catch (UnidadeSaudeException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
