package br.com.embraer.shipdocs.service;

import br.com.embraer.shipdocs.model.manual.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional()
public class IdentificacaoService {

    public Identificacao identificarManual(File manual){
        Identificacao identificacao = new Identificacao();

        identificacao.setNome(identificarNome(manual));
        identificacao.setTraco(identificarTraco(manual));
        identificacao.setBloco(identificarBloco(manual));
        try {
            identificacao.setSecao(identificarSecao(manual));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return identificacao;
    }

    private String identificarNome(File manual){
        String nomeArquivo = manual.getName();

        return nomeArquivo.substring(0, nomeArquivo.indexOf("-"));
    }

    private Traco identificarTraco(File manual){
        String nomeArquivo = FilenameUtils.removeExtension(manual.getName());

        String codTraco = "50";

        String codPN = StringUtils.substringBetween(nomeArquivo, "-", "-");

        Pattern regexTraco = Pattern.compile("-(50|55|60)");
        Matcher matcher = regexTraco.matcher(nomeArquivo);
        if(matcher.find()) {
            codTraco = StringUtils.substringAfter(matcher.group(), "-");
        }

        return new Traco(codTraco, codPN);
    }

    private Bloco identificarBloco(File manual) {
        String nomeArquivo = FilenameUtils.removeExtension(manual.getName());

        String numeroBloco = StringUtils.substringAfterLast(nomeArquivo, "-");
        numeroBloco = StringUtils.substringBefore(numeroBloco, "c");

        String codigoBloco = StringUtils.substringAfter(nomeArquivo, "c");

        return new Bloco(numeroBloco, codigoBloco);
    }

    private Secao identificarSecao(File manual) throws IOException{
        PDDocument documento = Loader.loadPDF(manual);
        String texto = new PDFTextStripper().getText(documento);

        String secao = StringUtils.substringBetween(texto, "-", "-");
        String subsecao = StringUtils.substringBetween(texto, "0", "-");

        return new Secao(secao, new SubSecao(subsecao));
    }
}
