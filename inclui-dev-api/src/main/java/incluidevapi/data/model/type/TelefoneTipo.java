package incluidevapi.data.model.type;

public enum TelefoneTipo {
    COMERCIAL("COMERCIAL"),
    RESIDENCIAL("RESIDENCIAL"),
    CELULAR("CELULAR");

    private final String content;

    TelefoneTipo(String content){
        this.content = content;
    }

    public static String toString(TelefoneTipo perfil) {
        return perfil.content;
    }
}
