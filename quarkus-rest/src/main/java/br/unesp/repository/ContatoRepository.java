package br.unesp.repository;

import br.unesp.entity.Contato;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ContatoRepository implements PanacheRepository<Contato>{

}
