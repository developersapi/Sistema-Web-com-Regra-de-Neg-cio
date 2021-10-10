package br.com.embraer.shipdocs.controller;

import br.com.embraer.shipdocs.model.manual.Arquivo;
import br.com.embraer.shipdocs.model.manual.TipoArquivo;
import br.com.embraer.shipdocs.repository.ArquivoRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/arquivo", produces = "application/json;charset=UTF-8")
public class ArquivoController {

    @Autowired
    ArquivoRepository arquivoRepository;

    @PostMapping(value = "/upload")
    public Arquivo upload(@RequestBody MultipartFile arquivo) throws IOException {
        String nome = arquivo.getOriginalFilename();
        String tipoArquivo = (nome != null) ? FilenameUtils.getExtension(nome) : null;
        Arquivo arq = new Arquivo(arquivo.getOriginalFilename(), arquivo.getBytes(), TipoArquivo.toEnum(tipoArquivo));
        return arquivoRepository.save(arq);
    }

    @ResponseBody
    @GetMapping(value = "/buscar")
    public List<Arquivo> buscarTodos() {
        return arquivoRepository.findAll();
    }

    @ResponseBody
    @GetMapping(value = "buscar/{arquivoId}")
    public Arquivo buscarPorId(@RequestParam Long arquivoId){
        return arquivoRepository.findById(arquivoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado"));
    }
}
