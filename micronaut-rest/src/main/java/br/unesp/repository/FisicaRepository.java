package br.unesp.repository;

import br.unesp.entity.Fisica;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface FisicaRepository extends CrudRepository<Fisica, Long> {
}
