package br.unesp.repository;

import br.unesp.entity.Endereco;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

}
