package br.com.embraer.shipdocs.service;

import br.com.embraer.shipdocs.model.manual.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;

@Service
@Transactional()
public class IdentificacaoService {

    public Identificacao identificarManual(File manual){
        Identificacao identificacao = new Identificacao();

        identificacao.setNome(identificarNome(manual));
        identificacao.setTraco(identificarTraco(manual));
        identificacao.setBloco(identificarBloco(manual));
        identificacao.setSecao(identificarSecao(manual));

        return identificacao;
    }

    private String identificarNome(File manual){
        String nomeArquivo = manual.getName();

        return nomeArquivo.substring(0, nomeArquivo.indexOf("-"));
    }

    private Traco identificarTraco(File manual){
        String nomeArquivo = manual.getName();

        String codPN = StringUtils.substringBetween(nomeArquivo, "-", "-");
        String codTraco = StringUtils.substringAfterLast(nomeArquivo, "-");

        return new Traco(codTraco, codPN);
    }

    // Provisório
    @Deprecated
    private Bloco identificarBloco(File manual){
        return new Bloco("03");
    }

    // Provisório
    @Deprecated
    private Secao identificarSecao(File manual){
        return new Secao("05", new SubSecao("06"));
    }
}
