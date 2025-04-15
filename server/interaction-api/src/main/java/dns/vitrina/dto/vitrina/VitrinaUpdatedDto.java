package dns.vitrina.dto.vitrina;

import dns.vitrina.dto.user.UserDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

//Dto для обновленной витрины с новыми пользователями и именем в окне изменения витрины
@Data
public class VitrinaUpdatedDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    private List<UserDto> users;
}
