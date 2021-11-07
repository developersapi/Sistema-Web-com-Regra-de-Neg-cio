package br.com.embraer.shipdocs.service;

import br.com.embraer.shipdocs.model.manual.Arquivo;
import br.com.embraer.shipdocs.model.manual.Identificacao;
import br.com.embraer.shipdocs.model.manual.Manual;
import br.com.embraer.shipdocs.model.manual.TipoArquivo;
import br.com.embraer.shipdocs.repository.ManualRepository;
import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;

@Service
@Transactional()
public class ManualService {

    public static final String DIRETORIO_MANUAIS_PATH = "src/main/documents";

    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    private IdentificacaoService identificacaoService;

    public List<Manual> importarLocal() throws IOException {
        return importarManuaisLocais(DIRETORIO_MANUAIS_PATH);
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
}
