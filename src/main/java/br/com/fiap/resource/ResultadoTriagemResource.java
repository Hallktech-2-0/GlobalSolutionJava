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

import br.com.fiap.beans.ResultadoTriagem;
import br.com.fiap.bo.ResultadoTriagemBO;
import br.com.fiap.exceptions.ResultadoTriagemException;

@Path("/resultadoTriagem")
public class ResultadoTriagemResource {

    private ResultadoTriagemBO resultadoTriagemBO;

    public ResultadoTriagemResource() {
        this.resultadoTriagemBO = new ResultadoTriagemBO();
    }

    @POST
    @Path("/cadastrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarResultadoTriagem(ResultadoTriagem resultadoTriagem) {
        try {
            resultadoTriagemBO.cadastrarResultadoTriagem(resultadoTriagem);
            return Response.status(Response.Status.CREATED).build();
        } catch (ResultadoTriagemException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/excluir/{resultadoTriagemId}")
    public Response excluirResultadoTriagem(@PathParam("resultadoTriagemId") String resultadoTriagemId) {
        try {
            resultadoTriagemBO.excluirResultadoTriagem(resultadoTriagemId);
            return Response.status(Response.Status.OK).build();
        } catch (ResultadoTriagemException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/atualizar")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarResultadoTriagem(ResultadoTriagem resultadoTriagem) {
        try {
            resultadoTriagemBO.atualizarResultadoTriagem(resultadoTriagem);
            return Response.status(Response.Status.OK).build();
        } catch (ResultadoTriagemException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarTodosResultadosTriagem() {
        try {
            List<ResultadoTriagem> resultadosTriagem = resultadoTriagemBO.listarTodosResultadosTriagem();
            return Response.status(Response.Status.OK).entity(resultadosTriagem).build();
        } catch (ResultadoTriagemException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
