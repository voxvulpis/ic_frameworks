package br.unesp.spring_rest.resource;

import br.unesp.spring_rest.entity.Fisica;
import br.unesp.spring_rest.service.FisicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Prof. Dr. Frank J. Affonso
 */
@RestController
@RequestMapping("/entidade/v1")
public class FisicaResource {

    @Autowired
    private FisicaService fisicaService;

    @GetMapping("/")
    public List<Fisica> getAllFisica() {
        return fisicaService.findAll();
    }
}