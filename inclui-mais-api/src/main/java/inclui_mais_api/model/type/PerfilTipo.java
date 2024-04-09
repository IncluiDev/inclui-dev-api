package inclui_mais_api.model.type;

public enum PerfilTipo {
    ADMINISTRADOR("ADMINISTRADOR"),
    SUPORTE("SUPORTE"),
    USUARIO("USUARIO");

    PerfilTipo (String content){

    }

    public static String toString(PerfilTipo perfil) {
        return String.valueOf(perfil);
    }
}
