package inclui_mais_api.data.model.type;

public enum EducativoTipo {
    JOGO("JOGO"),
    CURSO("CURSO");

    EducativoTipo(String content){

    }

    public static String toString(EducativoTipo perfil) {
        return String.valueOf(perfil);
    }
}
