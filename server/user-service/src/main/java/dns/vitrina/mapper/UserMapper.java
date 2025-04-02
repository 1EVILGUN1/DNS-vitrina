package dns.vitrina.mapper;


import dns.vitrina.dto.user.UserAuthDto;
import dns.vitrina.dto.user.UserCreatedDto;
import dns.vitrina.dto.user.UserDto;
import dns.vitrina.dto.user.UserRequest;
import dns.vitrina.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    @Mapping(target = "tasks", ignore = true) // tasks устанавливаются в сервисе
    UserDto userToUserDto(User user);

    List<UserDto> usersToUserDtos(List<User> users);

    // Заменяем UserRequest на UserCreatedDto для создания пользователя
    User userCreatedDtoToUser(UserCreatedDto userCreatedDto);

    UserAuthDto userToUserAuthDto(User user);
}
