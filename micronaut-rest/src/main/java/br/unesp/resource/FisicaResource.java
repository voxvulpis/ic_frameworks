package br.unesp.resource;

import br.unesp.entity.Fisica;
import br.unesp.repository.FisicaRepository;
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

@Controller("/fisica")
public class FisicaResource {
    @Inject
    FisicaRepository fisicaRepository;

    @Get
    public HttpResponse<?> getAll(){
        return HttpResponse.status(HttpStatus.OK).body(fisicaRepository.findAll());
    }

    @Post
    public HttpResponse<?> create(@Body Fisica item){
        item.setIdPessoa();
        System.out.println("------------------------------------------------------------------");
        System.out.println(item);
        System.out.println("------------------------------------------------------------------");
        fisicaRepository.save(item);
        return HttpResponse.status(HttpStatus.CREATED).body(item);
    }

    @Patch("/{id}")
    public HttpResponse<?> update(@Body Fisica item, @PathVariable("id") Long id){
        Fisica entity = fisicaRepository.findById(id).get();
        entity.setIdPessoa(item.getIdPessoa());

        entity.setCpf(item.getCpf());
        entity.setDataNascimento(item.getDataNascimento());

        entity.setNome(item.getNome());
        entity.setAcesso(item.getAcesso());

        fisicaRepository.update(entity);

        return HttpResponse.status(HttpStatus.OK).body(item);
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteOne(@PathVariable("id") Long id){
        Fisica entity = fisicaRepository.findById(id).get();
        if(entity == null) return HttpResponse.status(HttpStatus.NOT_FOUND);

        fisicaRepository.deleteById(id);

        return HttpResponse.status(HttpStatus.OK);
    }

}
