package br.com.tech4me.escola.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.escola.Model.Aluno;

public interface AlunoRepository extends MongoRepository<Aluno, String> {
    
}
