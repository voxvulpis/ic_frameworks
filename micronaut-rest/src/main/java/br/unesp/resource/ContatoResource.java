package br.unesp.resource;

import br.unesp.entity.Contato;
import br.unesp.repository.ContatoRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/contato")
public class ContatoResource {
    @Inject
    ContatoRepository contatoRepository;

    @Get
    public HttpResponse<?> getAll(){
        return HttpResponse.status(HttpStatus.OK).body(this.contatoRepository.findAll());
    }

    @Post
    public HttpResponse<?> create(@Body Contato item){
        item.setIdContato();
        this.contatoRepository.save(item);
        // return Response.status(Status.CREATED).entity(item).build();
        return HttpResponse.status(HttpStatus.CREATED);
    }

    @Patch("/{id}")
    public HttpResponse<?> update(@Body Contato item, @PathVariable ("id") Long id){
        Contato entity = contatoRepository.findById(id).get();
        entity.setIdContato(item.getIdContato());

        entity.setCelular(item.getCelular());
        entity.setEmail(item.getEmail());
        entity.setTelefoneComercial(item.getTelefoneComercial());
        entity.setTelefoneResidencial(item.getTelefoneResidencial());

        contatoRepository.update(entity);

        return HttpResponse.status(HttpStatus.OK);
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteOne(@PathVariable("id") Long id){
        Contato entity = contatoRepository.findById(id).get();
        if (entity == null)
            return HttpResponse.status(HttpStatus.NOT_FOUND).body(entity);
        
        contatoRepository.deleteById(entity.getIdContato());
        // return Response.noContent().build();
        return HttpResponse.status(HttpStatus.OK).body(entity);
    }

}
