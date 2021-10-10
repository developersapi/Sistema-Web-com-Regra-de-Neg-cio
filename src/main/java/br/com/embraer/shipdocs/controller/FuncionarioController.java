package br.com.embraer.shipdocs.controller;

import br.com.embraer.shipdocs.model.usuario.Funcionario;
import br.com.embraer.shipdocs.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @ResponseBody
    @PostMapping(value = "/cadastrar")
    public Funcionario criar(@RequestBody Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    @ResponseBody
    @GetMapping(value = "/buscar")
    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/buscar/{funcionarioId}")
    public Funcionario buscarPorId(@PathVariable Long funcionarioId) {
        return funcionarioRepository
                .findById(funcionarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Funcionário não encontrado"));
    }
}
