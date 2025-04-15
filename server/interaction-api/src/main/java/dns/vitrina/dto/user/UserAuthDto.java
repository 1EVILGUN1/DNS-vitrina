package dns.vitrina.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

//Dto приходит из авторизации
@Data
public class UserAuthDto {
    @NotBlank
    @Size(min = 5)
    private String lastName;
    @NotBlank
    @Size(min = 5)
    private String password;
}
