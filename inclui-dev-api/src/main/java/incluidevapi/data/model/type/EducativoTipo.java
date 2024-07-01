package incluidevapi.data.model.type;

import incluidevapi.component.exception.ExceptionGeneric;

public enum EducativoTipo {
    JOGO("JOGO"),
    CURSO("CURSO");

    private final String content;

    EducativoTipo(String content){
        this.content = content;
    }

    public static EducativoTipo toString(String perfil) {
        if(perfil.equalsIgnoreCase("JOGO"))
            return JOGO;
        else if(perfil.equalsIgnoreCase("CURSO"))
            return CURSO;

        throw new ExceptionGeneric("MODALIDADE NOT EXISTS", "MODALIDADE NOT EXISTS", 400);
    }
}
