package incluidevapi.component.util;

import java.util.Random;

public class GenerateCode {
    public static String getCode() {
        return Integer.toString(new Random().nextInt((999999 - 100000) + 1) + 100000);
    }
}