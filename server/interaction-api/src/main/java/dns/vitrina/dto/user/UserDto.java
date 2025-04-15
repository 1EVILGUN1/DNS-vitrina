package dns.vitrina.dto.user;

import lombok.Data;

import java.util.List;

//отображения пользователя в таблице сотрудников справа на главной странице
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
}