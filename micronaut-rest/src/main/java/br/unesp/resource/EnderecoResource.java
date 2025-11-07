package br.unesp.resource;


import br.unesp.entity.Endereco;
import br.unesp.repository.EnderecoRepository;
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

@Controller("/endereco")
public class EnderecoResource {
    @Inject
    EnderecoRepository enderecoRepository;

    @Get
    public HttpResponse<?> getAll(){
        return HttpResponse.status(HttpStatus.OK).body(this.enderecoRepository.findAll());
    }

    @Post
    public HttpResponse<?> create(@Body Endereco item){
        item.setIdEndereco();
        this.enderecoRepository.save(item);
        return HttpResponse.status(HttpStatus.CREATED).body(item);
    }

    public Long createInternal(Endereco item){
        item.setIdEndereco();
        enderecoRepository.save(item);
        return item.getIdEndereco();
    }

    @Patch("/{id}")
    public HttpResponse<?> update(@Body Endereco item, @PathVariable("id") Long id){
        Endereco entity = enderecoRepository.findById(id).get();

        entity.setIdEndereco(item.getIdEndereco());
        entity.setRua(item.getRua());
        entity.setNumero(item.getNumero());
        entity.setBairro(item.getBairro());
        entity.setCep(item.getCep());
        entity.setCidade(item.getCidade());
        entity.setEstado(item.getEstado());

        enderecoRepository.update(entity);

        return HttpResponse.status(HttpStatus.OK).body(entity);
    }

    public Long updateInternal(Endereco item, Long id){
        Endereco entity = enderecoRepository.findById(id).get();

        entity.setIdEndereco(item.getIdEndereco());
        entity.setRua(item.getRua());
        entity.setNumero(item.getNumero());
        entity.setBairro(item.getBairro());
        entity.setCep(item.getCep());
        entity.setCidade(item.getCidade());
        entity.setEstado(item.getEstado());

        return entity.getIdEndereco();
    }

    @Delete("/{id}")
    public HttpResponse<?> deleteOne(@PathVariable("id") Long id){
        Endereco entity = enderecoRepository.findById(id).get();
        if(entity == null) return HttpResponse.status(HttpStatus.NOT_FOUND);
        enderecoRepository.deleteById(id);
        return HttpResponse.status(HttpStatus.OK);
    }


}
