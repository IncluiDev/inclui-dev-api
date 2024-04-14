package inclui_mais_api.data.model.type;

public enum PerfilTipo {
    ADMINISTRADOR("ADMINISTRADOR"),
    SUPORTE("SUPORTE"),
    USUARIO("USUARIO"),
    PROFESSOR("PROFESSOR"),
    RESPONSAVEL("RESPONSAVEL");

    PerfilTipo (String content){

    }

    public static String toString(PerfilTipo perfil) {
        return String.valueOf(perfil);
    }
}
