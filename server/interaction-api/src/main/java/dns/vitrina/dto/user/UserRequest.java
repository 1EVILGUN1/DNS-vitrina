package dns.vitrina.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {
    @Size(min = 5)
    @NotBlank
    String firstName;
    @Size(min = 5)
    @NotBlank
    String lastName;
}
