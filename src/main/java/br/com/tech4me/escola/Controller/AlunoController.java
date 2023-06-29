package br.com.tech4me.escola.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.escola.Model.Aluno;
import br.com.tech4me.escola.Repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    
    @Autowired
    private AlunoRepository repositorioAluno;
    
    
    @GetMapping
    public List<Aluno> listarAlunos(){
        return repositorioAluno.findAll();
    }

    @GetMapping("/{matricula}")
    public Aluno listarPorMatricula(@PathVariable String matricula){
        Aluno aln = repositorioAluno.findById(matricula).orElse(null);

        return aln;
    }

    @PostMapping
    public ResponseEntity<Aluno> matricularAluno(@RequestBody Aluno aln){
        repositorioAluno.save(aln);

        return new ResponseEntity<>(aln, HttpStatus.CREATED);
    }

    @DeleteMapping("/{matricula}")
    public String removerAluno(@PathVariable String matricula){
        repositorioAluno.deleteById(matricula);

        return "Aluno removido com sucesso!";
    }
    
    @PutMapping("/{matricula}")
    public Aluno atualizarAlunos(@PathVariable String matricula, @RequestBody Aluno alunoNovo){
        Aluno aln = repositorioAluno.findById(matricula).orElse(null);

        if(aln!= null){
            aln.setNome(alunoNovo.getNome());
            aln.setIdade(alunoNovo.getIdade());
            aln.setMediaEscola(alunoNovo.getMediaEscola());
            repositorioAluno.save(aln);
        };

        return aln;
    }
}
