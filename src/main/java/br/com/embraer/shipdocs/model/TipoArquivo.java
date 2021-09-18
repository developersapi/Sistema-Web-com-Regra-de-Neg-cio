package br.com.embraer.shipdocs.model;

import java.util.Locale;

public enum TipoArquivo {

    PDF,

    PNG,

    JPG;

    public static TipoArquivo toEnum(String string) {
        return TipoArquivo.valueOf(string.toUpperCase(Locale.ROOT));
    }

}
