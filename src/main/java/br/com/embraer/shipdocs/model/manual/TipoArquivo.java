package br.com.embraer.shipdocs.model.manual;

import org.springframework.util.StringUtils;

import java.util.Locale;

public enum TipoArquivo {

    PDF,

    PNG,

    JPG;

    public static TipoArquivo toEnum(String string) {
        return TipoArquivo.valueOf(string.toUpperCase(Locale.ROOT));
    }

}
