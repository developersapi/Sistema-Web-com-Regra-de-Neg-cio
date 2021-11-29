package br.com.embraer.shipdocs.service;

import br.com.embraer.shipdocs.model.codelist.Codelist;
import br.com.embraer.shipdocs.model.manual.Bloco;
import br.com.embraer.shipdocs.model.manual.Secao;
import br.com.embraer.shipdocs.model.manual.SubSecao;
import br.com.embraer.shipdocs.model.manual.Traco;
import com.google.common.collect.Lists;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CodelistService {

    public static final String ARQUIIVO_CODELIST_PATH = "src/main/documents/Codelist.xlsx";

    public List<Codelist> importarCodelist() throws IOException {
        HashMap<Integer, List> map = new HashMap<>();

        List<Codelist> codelists = Lists.newArrayList();
        FileInputStream arquivo = new FileInputStream(new File(ARQUIIVO_CODELIST_PATH));

        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);
        XSSFSheet sheet = workbook.getSheetAt(0);

        int rowStart = 2;
        int rowEnd = sheet.getLastRowNum();


        for(int rowNum = rowStart; rowNum <= rowEnd; rowNum++) {
            List<String> valores = Lists.newArrayList();
            Row row = sheet.getRow(rowNum);

            for (int cn = 1; cn <= 6; cn++){
                DataFormatter df = new DataFormatter();

                Cell cell = row.getCell(cn, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

                valores.add((cell != null) ? df.formatCellValue(cell) : null);
            }
            map.put(rowNum, valores);
        }

        for(List valoresCampos : map.values()) {
                Codelist codelist = new Codelist(
                        new Secao(String.valueOf(valoresCampos.get(0)), new SubSecao(String.valueOf(valoresCampos.get(1)))),
                        new Bloco(String.valueOf(valoresCampos.get(2)), String.valueOf(valoresCampos.get(4))),
                        String.valueOf(valoresCampos.get(3)),
                        new Traco(String.valueOf(valoresCampos.get(5)), null)
                        );
                codelists.add(codelist);
        }

        return codelists;
    }
}
