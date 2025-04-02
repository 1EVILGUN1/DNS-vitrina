package dns.vitrina.service;


import dns.vitrina.dto.user.UserAuthDto;
import dns.vitrina.dto.user.UserDto;

import java.util.List;

public interface UserService {

    UserDto getById(Long id);

    void authenticate(UserAuthDto dto);

    List<UserDto> getAll();
}
