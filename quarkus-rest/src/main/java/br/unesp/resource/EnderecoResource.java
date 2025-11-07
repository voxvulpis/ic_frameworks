package br.unesp.resource;

import java.util.List;

import br.unesp.entity.Endereco;
import br.unesp.repository.EnderecoRepository;
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

@Path("/endereco")
public class EnderecoResource {
    @Inject
    EnderecoRepository enderecoRepository;

    @GET
    @Transactional
    public List<Endereco> getAll(){
        return Endereco.listAll();
    }

    @POST
    @Transactional
    public Response create(Endereco item){
        item.setIdEndereco();
        item.persist();
        return Response.status(Status.CREATED).entity(item).build();
    }

    public Long createInternal(Endereco item){
        item.setIdEndereco();
        item.persist();
        return item.getIdEndereco();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response update(Endereco item, @PathParam("id") Long id){
        Endereco entity = Endereco.findById(id);

        entity.setIdEndereco(item.getIdEndereco());
        entity.setRua(item.getRua());
        entity.setNumero(item.getNumero());
        entity.setBairro(item.getBairro());
        entity.setCep(item.getCep());
        entity.setCidade(item.getCidade());
        entity.setEstado(item.getEstado());

        return Response.ok(entity).build();
    }

    public Long updateInternal(Endereco item, @PathParam("id") Long id){
        Endereco entity = Endereco.findById(id);

        entity.setIdEndereco(item.getIdEndereco());
        entity.setRua(item.getRua());
        entity.setNumero(item.getNumero());
        entity.setBairro(item.getBairro());
        entity.setCep(item.getCep());
        entity.setCidade(item.getCidade());
        entity.setEstado(item.getEstado());

        return entity.getIdEndereco();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteOne(@PathParam("id") Long id){
        Endereco entity = Endereco.findById(id);
        if(entity == null) throw new WebApplicationException("Endereco nao existe. " + Status.NOT_FOUND);
        entity.delete();
        return Response.noContent().build();
    }


}
