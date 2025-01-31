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

import br.com.fiap.beans.Triagem;
import br.com.fiap.bo.TriagemBO;
import br.com.fiap.exceptions.TriagemException;

@Path("/triagem")
public class TriagemResource {

    private TriagemBO triagemBO;

    public TriagemResource() {
        this.triagemBO = new TriagemBO();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarTriagem(Triagem triagem) {
        try {
            triagemBO.cadastrarTriagem(triagem);
            return Response.status(Response.Status.CREATED).build();
        } catch (TriagemException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/excluir/{triagemId}")
    public Response excluirTriagem(@PathParam("triagemId") String triagemId) {
        try {
            triagemBO.excluirTriagem(triagemId);
            return Response.status(Response.Status.OK).build();
        } catch (TriagemException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarTriagem(Triagem triagem) {
        try {
            triagemBO.atualizarTriagem(triagem);
            return Response.status(Response.Status.OK).build();
        } catch (TriagemException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodasTriagens() {
        try {
            List<Triagem> triagens = triagemBO.listarTodasTriagens();
            return Response.status(Response.Status.OK).entity(triagens).build();
        } catch (TriagemException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
