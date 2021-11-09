package com.example.provabackend.repository;

import com.example.provabackend.model.Contato;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long> {

    List<Contato> findByTelefone(String telefone);

    List<Contato> findByEmail(String email);
}
