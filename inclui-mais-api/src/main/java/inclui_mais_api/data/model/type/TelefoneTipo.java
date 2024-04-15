package inclui_mais_api.data.model.type;

public enum TelefoneTipo {
    COMERCIAL("COMERCIAL"),
    RESIDENCIAL("RESIDENCIAL"),
    CELULAR("CELULAR");

    TelefoneTipo(String content){

    }

    public static String toString(TelefoneTipo perfil) {
        return String.valueOf(perfil);
    }
}
