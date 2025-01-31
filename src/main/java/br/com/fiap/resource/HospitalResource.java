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

import br.com.fiap.beans.Hospital;
import br.com.fiap.bo.HospitalBO;
import br.com.fiap.exceptions.HospitalInvalidoException;

@Path("/hospital")
public class HospitalResource {

    private HospitalBO hospitalBO;

    public HospitalResource() {
        this.hospitalBO = new HospitalBO();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarHospital(Hospital hospital) {
        try {
            hospitalBO.cadastrarHospital(hospital);
            return Response.status(Response.Status.CREATED).build();
        } catch (HospitalInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{unidadeId}")
    public Response deletarHospital(@PathParam("unidadeId") String unidadeId) {
        hospitalBO.deletarHospital(unidadeId);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarHospital(Hospital hospital) {
        try {
            hospitalBO.atualizarHospital(hospital);
            return Response.ok().build();
        } catch (HospitalInvalidoException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hospital> listarTodosHospitais() {
        return hospitalBO.listarTodosHospitais();
    }
}
