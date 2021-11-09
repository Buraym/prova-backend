package com.example.provabackend.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public Contato() {}

    public Contato(String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "CONTATO -> NOME: " + nome + " TELEFONE: " + telefone + " EMAIL: " + email;
    }
}
