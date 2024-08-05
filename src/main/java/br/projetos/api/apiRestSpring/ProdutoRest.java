package br.projetos.api.apiRestSpring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProdutoRest {
	
	@Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/produto")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto){
        Produto retorno = produtoRepository.save(produto);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping("/produto")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto){
        if(produto.getId()==null){
            ResponseEntity.notFound().build();
        }
        produto = produtoRepository.save(produto);
        
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/produto")
    public ResponseEntity<List<Produto>> getProdutos(){
        List<Produto> lista = produtoRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id){
        Produto produto = produtoRepository.findById(id).get();
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity delete(@PathVariable("id")  Long id){
            produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
	
}
