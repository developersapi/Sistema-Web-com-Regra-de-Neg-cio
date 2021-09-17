package br.com.embraer.shipdocs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
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
				.findById(usuarioId.toString())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usu·rio n√£o encontrado"));
}
