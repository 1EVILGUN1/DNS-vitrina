package dns.vitrina.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


//пока не определено
@Data
public class UserRequest {
    @Size(min = 5)
    @NotBlank
    private String firstName;
    @Size(min = 5)
    @NotBlank
    private String lastName;

}
