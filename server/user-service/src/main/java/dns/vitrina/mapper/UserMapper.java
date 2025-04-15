package dns.vitrina.mapper;


import dns.vitrina.dto.user.UserAuthDto;
import dns.vitrina.dto.user.UserCreatedDto;
import dns.vitrina.dto.user.UserDto;
import dns.vitrina.facade.TaskFacade;
import dns.vitrina.facade.VitrinaFacade;
import dns.vitrina.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final VitrinaFacade vitrinaFacade;
    private final TaskFacade taskFacade;

    public UserDto ToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }

    public List<UserDto> ToDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(ToDto(user));
        }
        return userDtos;
    }

    public User userCreatedDtoToUser(UserCreatedDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        return user;
    }

    public User userToUserAuthDto(UserAuthDto dto) {
        User user = new User();
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        return user;
    }

    public User ToUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        return user;
    }
}
