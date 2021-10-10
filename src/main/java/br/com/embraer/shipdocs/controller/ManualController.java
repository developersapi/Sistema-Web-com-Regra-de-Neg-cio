package br.com.embraer.shipdocs.controller;

import br.com.embraer.shipdocs.model.manual.Arquivo;
import br.com.embraer.shipdocs.model.manual.Manual;
import br.com.embraer.shipdocs.model.manual.TipoArquivo;
import br.com.embraer.shipdocs.repository.ManualRepository;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/manual", produces = "application/json;charset=UTF-8")
public class ManualController {

    @Autowired
    ManualRepository manualRepository;

    @PostMapping(value = "/upload")
    public Manual upload(@RequestBody Manual manual, MultipartFile arquivo) throws IOException {
        String nome = arquivo.getOriginalFilename();
        String tipoArquivo = (nome != null) ? FilenameUtils.getExtension(nome) : null;
        Arquivo arq = new Arquivo(arquivo.getOriginalFilename(), arquivo.getBytes(), TipoArquivo.toEnum(tipoArquivo));

        manual.setArquivo(arq);
        return manualRepository.save(manual);
    }

    @GetMapping(value = "/importar/{id}")
    public Manual importar(@RequestBody Long manualId){
        return manualRepository.findById(manualId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Não foi possível encontrar o manual com o identificador especificado"));
    }

    @GetMapping(value = "/buscarTodos")
    public List<Manual> buscarTodos(){
        return manualRepository.findAll();
    }
}
