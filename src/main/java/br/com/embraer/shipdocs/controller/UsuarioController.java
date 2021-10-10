package br.com.embraer.shipdocs.controller;

import br.com.embraer.shipdocs.model.usuario.Usuario;
import br.com.embraer.shipdocs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@ResponseBody
	@GetMapping(value = "/buscar")
	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();

	}

	@ResponseBody
	@GetMapping(value = "/buscar/{usuarioId}")
	public Usuario buscarPorId(@PathVariable Long usuarioId) {
		return usuarioRepository
				.findById(usuarioId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
	}
}
