package br.com.embraer.shipdocs.controller;

import br.com.embraer.shipdocs.model.codelist.Codelist;
import br.com.embraer.shipdocs.repository.CodelistRepository;
import br.com.embraer.shipdocs.service.CodelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/codelist")
public class CodelistController {

    @Autowired
    CodelistRepository codelistRepository;

    @Autowired
    CodelistService codelistService;

    @GetMapping(value = "/importarCodelist")
    public List<Codelist> importarCodelist() throws IOException {
        return codelistRepository.saveAllAndFlush(codelistService.importarCodelist());
    }
}
