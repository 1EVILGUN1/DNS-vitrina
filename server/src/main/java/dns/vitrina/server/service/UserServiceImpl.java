package dns.vitrina.server.service;

import dns.vitrina.server.dto.UserAuthDto;
import dns.vitrina.server.dto.UserDto;
import dns.vitrina.server.dto.UserRequest;

import java.util.List;

public interface UserServiceImpl {

    void create(UserRequest request);

    void update(Long id, UserDto userDto);

    void delete(Long id);

    UserDto get(Long id);

    void authenticate(UserAuthDto userAuthDto);

    List<UserDto> getAll();
}
