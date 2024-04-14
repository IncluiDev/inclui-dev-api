package inclui_mais_api.data.model.dynamic;

import java.time.LocalDateTime;

public record TokenValidModel(LocalDateTime time, String token, boolean valid) {

}
