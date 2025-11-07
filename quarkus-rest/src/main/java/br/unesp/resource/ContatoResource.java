package br.unesp.resource;

import java.util.List;

import br.unesp.entity.Contato;
import br.unesp.repository.ContatoRepository;
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

@Path("/contato")
public class ContatoResource {
    @Inject
    ContatoRepository contatoRepository;

    @GET
    @Transactional
    public List<Contato> getAll(){
        return Contato.listAll();
    }

    @POST
    @Transactional
    public Response create(Contato item){
        item.setIdContato();
        item.persist();
        return Response.status(Status.CREATED).entity(item).build();
    }

    @PATCH
    @Path("/{id}")
    public Response update(Contato item, @PathParam("id") Long id){
        Contato entity = Contato.findById(id);
        entity.setIdContato(item.getIdContato());

        entity.setCelular(item.getCelular());
        entity.setEmail(item.getEmail());
        entity.setTelefoneComercial(item.getTelefoneComercial());
        entity.setTelefoneResidencial(item.getTelefoneResidencial());


        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        Contato entity = Contato.findById(id);
        if(entity == null) throw new WebApplicationException("Contato Id n~ao encontrado" + Status.NOT_FOUND);
        return Response.noContent().build();
    }

}
