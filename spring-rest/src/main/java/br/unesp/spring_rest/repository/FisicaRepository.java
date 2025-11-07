package br.unesp.spring_rest.repository;

import br.unesp.spring_rest.entity.Fisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FisicaRepository extends JpaRepository<Fisica, Long> {
    
    Fisica findByCpf(String cpf);

}
