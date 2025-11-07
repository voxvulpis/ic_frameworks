package br.unesp.repository;

import br.unesp.entity.Fisica;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FisicaRepository implements PanacheRepository<Fisica>{
    Fisica findByCpf(String cpf){
        return find("cpf", cpf).firstResult();
    }
}
