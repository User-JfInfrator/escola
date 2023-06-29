package br.com.tech4me.escola.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aluno {
    @Id
    private String matricula;
    private String nome;
    private int idade;
    private double mediaEscola;

    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getMediaEscola() {
        return mediaEscola;
    }
    public void setMediaEscola(double mediaEscola) {
        this.mediaEscola = mediaEscola;
    } 
}
