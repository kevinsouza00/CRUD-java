package br.com.aula.controller;
import br.com.aula.model.Pessoa;
import br.com.aula.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    List<Pessoa> listaPessoa = new ArrayList<>();
    Pessoa pe;

    int id = 1;

    @PostMapping()
    public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
        pe = new Pessoa();
        pe.setId(Long.valueOf(id++));
        pe.setNome(pessoa.getNome());
        pe.setCpf(pessoa.getCpf());
        pe.setSexo(pessoa.getSexo());
        pe.setDataNascimento(pessoa.getDataNascimento());


        listaPessoa.add(pe);

        return pe;
    }

    @GetMapping()
    public List<Pessoa> ListaPessoa() {
        return listaPessoa;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> pessoaId(@PathVariable(value = "id") Long id) {
        if (!listaPessoa.isEmpty()) {
            for (Pessoa pe : listaPessoa) {
                if (pe.getId() == id) {
                    return ResponseEntity.status(HttpStatus.OK).body(pe);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa nao localizada!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> altPessoa(@PathVariable(value = "id") Long id, @RequestBody Pessoa pessoa) {
        if (!listaPessoa.isEmpty()) {
            for (Pessoa pe : listaPessoa) {
                if (pe.getId() == id) {
                    pe.setNome(pessoa.getNome());
                    pe.setCpf(pessoa.getCpf());
                    pe.setDataNascimento(pessoa.getDataNascimento());
                    pe.setSexo(pessoa.getSexo());

                    return ResponseEntity.status(HttpStatus.OK).body(pe);

                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delPessoa(@PathVariable(value = "id") Long id) {
        if (!listaPessoa.isEmpty()) {
            for (Pessoa pe : listaPessoa) {
                if (pe.getId() == id) {
                    listaPessoa.remove(pe);

                    return ResponseEntity.status(HttpStatus.OK).body(pe);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao localizado!");
    }
}
