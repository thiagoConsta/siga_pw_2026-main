package br.com.fatecfv.siga.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecfv.siga.model.Aluno;
import br.com.fatecfv.siga.service.AlunoService;
import jakarta.validation.Valid;


@RestController 
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    //MÉTODOS HTTP: GET, PUT, POST, DELETE, PATCH
    // Cabeçalho e Corpo
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) 
    public Aluno cadastrar(@Valid @RequestBody Aluno aluno){
        return alunoService.cadastrar(aluno);
    }

    @GetMapping
    public List<Aluno> listar(){
        return alunoService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> consultarPorId(@PathVariable Long id) {
        return alunoService.consultarPorId(id);
    }
    
}
