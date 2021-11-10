package com.example.provabackend.controller;

import com.example.provabackend.model.Contato;
import com.example.provabackend.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Contato> listaContatos() {
        return (List<Contato>) repository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> achaContato(@PathVariable Long id) {
        Optional<Contato> contato = repository.findById(id);
        return new ResponseEntity<>(contato, null, 1);
    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> cadastraContato(@RequestBody Contato contato) {
        if( !repository.findByTelefone(contato.getTelefone()).isEmpty() ||
                        !repository.findByEmail(contato.getEmail()).isEmpty() ){
            return new ResponseEntity<>("CONTATOEXISTENTE", null, 1);
        } else {
            repository.save(contato);
            return new ResponseEntity<>(contato, null, 1);
        }
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<?> atualizaContato(@PathVariable Long id, @RequestBody Contato contato) {
        return repository.findById(id)
                .map(antigoContato -> {
                    antigoContato.setNome(contato.getNome());
                    antigoContato.setTelefone(contato.getTelefone());
                    antigoContato.setEmail(contato.getEmail());
                    repository.save(antigoContato);
                    return new ResponseEntity<>(antigoContato, null, 1);
                })
                .orElseGet( () -> { contato.setId(id); return new ResponseEntity<>(contato, null, 1); });
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    void DeletarContato(@PathVariable Long id) { repository.deleteById(id); }

    @DeleteMapping
    @CrossOrigin(origins = "http://localhost:8080")
    void DeletarTodosContatos() { repository.deleteAll(); }
}
