package incluidevapi.data.model.type;

import incluidevapi.component.exception.ExceptionGeneric;

public enum PerfilTipo {
    ADMINISTRADOR("ADMINISTRADOR"),
    SUPORTE("SUPORTE"),
    USUARIO("USUARIO"),
    PROFESSOR("PROFESSOR"),
    RESPONSAVEL("RESPONSAVEL");

    private final String content;

    PerfilTipo (final String content){
        this.content = content;
    }

    public static PerfilTipo toString(String perfil) {
        if(perfil.equalsIgnoreCase("ADMINISTRADOR"))
            return ADMINISTRADOR;
        else if(perfil.equalsIgnoreCase("SUPORTE"))
            return SUPORTE;
        else if(perfil.equalsIgnoreCase("USUARIO"))
            return USUARIO;
        else if(perfil.equalsIgnoreCase("PROFESSOR"))
            return PROFESSOR;
        else if(perfil.equalsIgnoreCase("RESPONSAVEL"))
            return RESPONSAVEL;

        throw new ExceptionGeneric("RULE NOT EXISTS", "RULE NOT EXISTS", 400);
    }
}
