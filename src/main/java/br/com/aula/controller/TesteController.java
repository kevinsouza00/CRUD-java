//package br.com.aula.controller;
//
//import br.com.aula.model.Produto;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@RestController
//@RequestMapping("/teste")
//public class TesteController {
//    private final List<Produto> listaProduto = new ArrayList<>();
//    private Produto prod;
//    private Long codigo = Long.valueOf(1);
//
//    @GetMapping("/teste")
//    public String teste() {
//
//        return "Java teste";
//    }
//
//    @PostMapping()
//    public ResponseEntity<Produto> addProd(@RequestBody Produto p1) {
//
//        prod = new Produto();
//        prod.setCodigo(Long.valueOf(codigo++));
//        prod.setDescricao(p1.getDescricao());
//        prod.setValor(p1.getValor());
//        listaProduto.add(prod);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
//    }
//
//    @GetMapping()
//    public ResponseEntity<List<Produto>> listProd() {
//        return ResponseEntity.status(HttpStatus.CREATED).body(listaProduto);
//    }
//
//    @GetMapping("/{codigo}")
//    public ResponseEntity<Object> codProd(@PathVariable(value = "codigo") Long cod) {
//
//        if (!listaProduto.isEmpty()) {
//            for (Produto p : listaProduto) {
//                if (p.getCodigo() == cod) {
//                    return ResponseEntity.status(HttpStatus.OK).body(p);
//                }
//            }
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
//    }
//
//    @PutMapping("/{codigo}")
//    public ResponseEntity<Object> updateProd(@PathVariable(value = "codigo") Long cod, @RequestBody Produto prod) {
//
//        if (!listaProduto.isEmpty()) {
//            for (Produto p : listaProduto) {
//                if (p.getCodigo() == cod) {
//                    p.setDescricao(prod.getDescricao());
//                    p.setValor(prod.getValor());
//                    return ResponseEntity.status(HttpStatus.OK).body(p);
//                }
//            }
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
//    }
//
//    @DeleteMapping("/{codigo}")
//    public ResponseEntity<Object> delProd(@PathVariable(value = "codigo") Long cod) {
//        if (!listaProduto.isEmpty()) {
//            for (Produto p : listaProduto) {
//                if (p.getCodigo() == cod) {
//                    listaProduto.remove(p);
//                    return ResponseEntity.status(HttpStatus.OK).body(p);
//                }
//            }
//        }
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao encontrado");
//    }
//}
