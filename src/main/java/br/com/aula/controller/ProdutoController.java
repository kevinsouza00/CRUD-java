package br.com.aula.controller;

import br.com.aula.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//
////@RestController
////@RequestMapping("/produto")
////public class ProdutoController {
////
////    private final List<Produto> listaProduto = new ArrayList<>();
////    private Produto p;
////    private int id = 1;
////
////    @PostMapping()
////    public ResponseEntity<Object> addProduto(@RequestBody Produto prod) {
////        p = new Produto();
////        p.setCodigo(Long.valueOf(id++));
////        p.setDescricao(prod.getDescricao());
////        p.setValor(prod.getValor());
////
////        listaProduto.add(p);
////
////        return ResponseEntity.status(HttpStatus.OK).body(p);
////    }
////
////    @GetMapping()
////    public ResponseEntity<List<Produto>> listaProduto() {
////        return ResponseEntity.status(HttpStatus.OK).body(listaProduto);
////    }
////
////    @GetMapping("/{id}")
////    public ResponseEntity<Object> prodCodigo(@PathVariable(value = "id") Long id) {
////        if (!listaProduto.isEmpty()) {
////            for (Produto p : listaProduto) {
////                if (p.getCodigo() == id) {
////                    return ResponseEntity.status(HttpStatus.OK).body(p);
////                }
////            }
////        }
////        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
////    }
////
////    @PutMapping("/{id}")
////    public ResponseEntity<Object> altProd(@PathVariable(value = "id") Long id, @RequestBody Produto prod) {
////        if (!listaProduto.isEmpty()) {
////            for (Produto p : listaProduto) {
////                if (p.getCodigo() == id) {
////                    p.setDescricao(prod.getDescricao());
////                    p.setValor(prod.getValor());
////
////                    return ResponseEntity.status(HttpStatus.OK).body(p);
////                }
////            }
////        }
////        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
////    }
////
////    @DeleteMapping("/{id}")
////    public ResponseEntity<Object> delProd(@PathVariable(value = "id") Long id) {
////        if (!listaProduto.isEmpty()) {
////            for (Produto p : listaProduto) {
////                if (p.getCodigo() == id) {
////                    listaProduto.remove(p);
////                    return ResponseEntity.status(HttpStatus.OK).body(p);
////                }
////            }
////        }
////        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
////    }
////}


import br.com.aula.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    List<Produto> listaProduto = new ArrayList<>();
    Produto p;
    int id = 1;

    @PostMapping()
    public Produto addProduto(@RequestBody Produto prod) {
        p = new Produto();
        p.setCodigo(Long.valueOf(id++));
        p.setDescricao(prod.getDescricao());
        p.setValor(prod.getValor());

        listaProduto.add(p);

        return p;
    }

    @GetMapping()
    public List<Produto> ListaProduto() {
        return listaProduto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> prodCodigo(@PathVariable(value = "id") Long id) {
        if (!listaProduto.isEmpty()) {
            for (Produto p : listaProduto) {
                if (p.getCodigo() == id) {
                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> altProd(@PathVariable(value = "id") Long id, @RequestBody Produto prod) {
        if (!listaProduto.isEmpty()) {
            for (Produto p : listaProduto) {
                if (p.getCodigo() == id) {
                    p.setDescricao(prod.getDescricao());
                    p.setValor(prod.getValor());

                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delProd(@PathVariable(value = "id")Long id) {
        if (!listaProduto.isEmpty()) {
            for (Produto p : listaProduto) {
                if (p.getCodigo() == id) {
                    listaProduto.remove(p);

                    return ResponseEntity.status(HttpStatus.OK).body(p);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizado !");
    }
}


