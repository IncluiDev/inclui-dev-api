package incluidevapi.data.model.type;

public enum PerfilTipo {
    ADMINISTRADOR("ADMINISTRADOR"),
    SUPORTE("SUPORTE"),
    USUARIO("USUARIO"),
    PROFESSOR("PROFESSOR"),
    RESPONSAVEL("RESPONSAVEL");

    private final String content;

    PerfilTipo (String content){
        this.content = content;
    }

    public static String toString(PerfilTipo perfil) {
        return perfil.content;
    }
}
