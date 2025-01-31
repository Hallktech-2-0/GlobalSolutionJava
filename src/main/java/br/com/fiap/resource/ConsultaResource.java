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

import br.com.fiap.beans.Consulta;
import br.com.fiap.bo.ConsultaBO;
import br.com.fiap.exceptions.ConsultaInvalidaException;

@Path("/consulta")
public class ConsultaResource {

    private ConsultaBO consultaBO;

    public ConsultaResource() {
        this.consultaBO = new ConsultaBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarConsulta(Consulta consulta) {
        try {
            consultaBO.cadastrarConsulta(consulta);
            return Response.status(Response.Status.CREATED).build();
        } catch (ConsultaInvalidaException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{consultaId}")
    public Response deletarConsulta(@PathParam("consultaId") String consultaId) {
        consultaBO.deletarConsulta(consultaId);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarConsulta(Consulta consulta) {
        try {
            consultaBO.atualizarConsulta(consulta);
            return Response.ok().build();
        } catch (ConsultaInvalidaException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consulta> listarTodasConsultas() {
        return consultaBO.listarTodasConsultas();
    }
}
