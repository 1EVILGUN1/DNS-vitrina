package dns.vitrina.service;

import dns.vitrina.server.dto.UserAuthDto;
import dns.vitrina.server.dto.UserDto;
import dns.vitrina.server.dto.UserRequest;
import dns.vitrina.server.model.User;

import java.util.List;

public interface UserServiceImpl {

    void create(User user);

    void update(Long id, UserDto userDto);

    void delete(Long id);

    User get(Long id);

    void authenticate(UserAuthDto userAuthDto);

    List<User> getAll();
}
