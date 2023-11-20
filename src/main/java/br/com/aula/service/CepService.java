package br.com.aula.service;
import br.com.aula.dto.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( url = "https://viacep.com.br/ws/",name = "cep")

public interface CepService {
    @GetMapping("{cep}/json")
    CepDto getCep(@PathVariable String cep);
}
