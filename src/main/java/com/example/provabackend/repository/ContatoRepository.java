package com.example.provabackend.repository;

import com.example.provabackend.model.Contato;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long> {}
