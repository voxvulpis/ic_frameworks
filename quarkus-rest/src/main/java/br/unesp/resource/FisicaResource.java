package br.unesp.resource;

import java.util.List;

import br.unesp.entity.Fisica;
import br.unesp.repository.FisicaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/fisica")
public class FisicaResource {
    @Inject
    FisicaRepository fisicaRepository;

    @GET
    @Transactional
    public List<Fisica> getAll(){
        return Fisica.listAll();
    }

    @POST
    @Transactional()
    public Response create(Fisica item){
        item.setIdPessoa();
        System.out.println("------------------------------------------------------------------");
        System.out.println(item);
        System.out.println("------------------------------------------------------------------");
        item.persist();
        return Response.status(Status.CREATED).entity(item).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response update(Fisica item, @PathParam("id") Long id){
        Fisica entity = Fisica.findById(id);
        entity.setIdPessoa(item.getIdPessoa());

        entity.setCpf(item.getCpf());
        entity.setDataNascimento(item.getDataNascimento());

        entity.setNome(item.getNome());
        entity.setAcesso(item.getAcesso());

        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteOne(@PathParam("id") Long id){
        Fisica entity = Fisica.findById(id);
        if(entity == null) throw new WebApplicationException("Pessoa Fisica nao existe", Status.NOT_FOUND);

        entity.delete();

        return Response.noContent().build();
    }

}
