package dns.vitrina.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreatedDto {
    @NotBlank
    @Size(min = 5)
    private String firstName;
    @NotBlank
    @Size(min = 5)
    private String lastName;
    @NotBlank
    @Size(min = 5)
    private String password;
}
