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

import br.com.fiap.beans.Exames;
import br.com.fiap.bo.ExamesBO;
import br.com.fiap.exceptions.ExamesInvalidosException;

@Path("/exames")
public class ExamesResource {

    private ExamesBO examesBO;

    public ExamesResource() {
        this.examesBO = new ExamesBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarExames(Exames exames) {
        try {
            examesBO.cadastrarExames(exames);
            return Response.status(Response.Status.CREATED).build();
        } catch (ExamesInvalidosException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{examesId}")
    public Response deletarExames(@PathParam("examesId") String examesId) {
        examesBO.deletarExames(examesId);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarExames(Exames exames) {
        try {
            examesBO.atualizarExames(exames);
            return Response.ok().build();
        } catch (ExamesInvalidosException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Exames> listarTodosExames() {
        return examesBO.listarTodosExames();
    }
}
