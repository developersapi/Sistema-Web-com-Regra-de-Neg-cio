package br.com.embraer.shipdocs.controller;

import br.com.embraer.shipdocs.model.Administrador;
import br.com.embraer.shipdocs.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/administrador")
@RestController
public class AdministradorController {

    @Autowired
    AdministradorRepository administradorRepository;

    @ResponseBody
    @PostMapping(value = "/cadastrar")
    public Administrador criar(@RequestBody Administrador administrador){
        return administradorRepository.save(administrador);
    }

    @ResponseBody
    @GetMapping(value = "/buscar")
    public List<Administrador> buscarTodos() {
        return administradorRepository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "/buscar/{administradorId}")
    public Administrador buscarPorId(@PathVariable Long administradorId) {
        return administradorRepository
                .findById(administradorId.toString())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador não encontrado"));
    }
}
