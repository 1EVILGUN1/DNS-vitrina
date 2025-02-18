package dns.vitrina.server.mapper;

import dns.vitrina.server.dto.UserAuthDto;
import dns.vitrina.server.dto.UserDto;
import dns.vitrina.server.dto.UserRequest;
import dns.vitrina.server.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDto userToUserDto(User user);

    User userDtoToUserCreate(UserRequest userDto);

    UserAuthDto userToUserAuthDto(User user);
}
