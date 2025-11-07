package br.unesp.repository;

import br.unesp.entity.Contato;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ContatoRepository extends CrudRepository<Contato, Long> {

}
