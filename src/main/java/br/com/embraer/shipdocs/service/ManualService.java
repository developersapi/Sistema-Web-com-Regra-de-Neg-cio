package br.com.embraer.shipdocs.service;

import br.com.embraer.shipdocs.model.codelist.Codelist;
import br.com.embraer.shipdocs.model.manual.*;
import br.com.embraer.shipdocs.repository.CodelistRepository;
import br.com.embraer.shipdocs.repository.ManualRepository;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ManualService {

    public static final String DIRETORIO_MANUAIS_PATH = "src/main/documents";

    @Autowired
    EntityManager entityManager;

    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    private CodelistRepository codelistRepository;

    @Autowired
    private IdentificacaoService identificacaoService;

    public List<Manual> importarLocal(@Nullable String opcao) throws IOException {
        return importarManuaisLocais((DIRETORIO_MANUAIS_PATH + opcao));
    }

    public List<Manual> importarManuaisLocais(String diretorioPath) throws IOException {
        File diretorio = new File(diretorioPath);
        String[] extensoes = {"pdf"};

        Collection<File> arquivos = FileUtils.listFiles(diretorio, extensoes, true);

        List<Manual> manuais = Lists.newArrayList();
        for (File manual : arquivos) {
            Identificacao identificacao = this.identificacaoService.identificarManual(manual);
            Arquivo arquivo = new Arquivo(manual.getName(), Files.readAllBytes(manual.toPath()), TipoArquivo.PDF);

            manuais.add(new Manual(identificacao, arquivo));
        }

        return manuais;
    }

    public File gerarManualViaCodelist() throws IOException {
        List<Codelist> codelists = codelistRepository.findAll();
        List<Manual> manuais = Lists.newArrayList();
        List<Arquivo> arquivos = Lists.newArrayList();


        for (Codelist codelist : codelists) {
            Manual manual = findManual(codelist.getSecao(), codelist.getBloco(), codelist.getTraco());

            manuais.add(manual);
        }

        for (Manual manual : manuais) {
            arquivos.add(manual.getArquivo());
        }

        PDFMergerUtility ut = new PDFMergerUtility();
        for (Arquivo arquivo : arquivos) {
            ut.addSource(new File("");
        }

        return new File(DIRETORIO_MANUAIS_PATH);
    }

    public Manual findManual(Secao secao, Bloco bloco, Traco traco) {
        String queryString = "select m from Manual m where m.identificacao.secao.codigoSecao = :secao" +
                " and m.identificacao.secao.subSecao.codigoSubSecao = :subSecao and m.identificacao.bloco.numeroBloco = :numeroBloco " +
                "and m.identificacao.bloco.codigoBloco = :codigoBloco and m.identificacao.traco.codigoTraco = :codigoTraco";

        Query query = entityManager.createQuery(queryString);
        query.setParameter("secao", secao.getCodigoSecao());
        query.setParameter("subSecao", secao.getSubSecao().getCodigoSubSecao());
        query.setParameter("numeroBloco", bloco.getNumeroBloco());
        query.setParameter("codigoBloco", bloco.getCodigoBloco());
        query.setParameter("codigoTraco", traco.getCodigoTraco());


        return (Manual) query.getSingleResult();
    }
}
