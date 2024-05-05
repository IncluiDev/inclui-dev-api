package incluidevapi.data.model.type;

public enum EducativoTipo {
    JOGO("JOGO"),
    CURSO("CURSO");

    private final String content;

    EducativoTipo(String content){
        this.content = content;
    }

    public static String toString(EducativoTipo perfil) {
        return perfil.content;
    }
}
