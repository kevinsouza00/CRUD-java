package br.com.aula.controller;

import br.com.aula.dto.CepDto;
import br.com.aula.facede.CepFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {
    @Autowired
    private CepFacade cepFacade;

    @GetMapping("/{cep}")
    public CepDto buscaCep(@PathVariable String cep){
        return cepFacade.buscaCep(cep);
    }

}
