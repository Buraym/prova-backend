package com.example.provabackend;



import com.example.provabackend.controller.ContatoController;
import com.example.provabackend.model.Contato;
import com.example.provabackend.repository.ContatoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ContatoController.class)
public class TesteRegraDeNegocio {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContatoRepository repository;

    @Test
    void ObtemUmaListaGeralEAplicaAsRegrasDeNegocio() throws Exception {

        List<Contato> todosContatos = (List<Contato>) repository.findAll();



        String url = "http://localhost:8080/contatos";
        List<Contato> adawdaw = (List<Contato>) mockMvc.perform(get(url)).andExpect(status().isOk()).andReturn();
    }
}
