package dns.vitrina.service;

import dns.vitrina.dto.user.UserCreatedDto;
import dns.vitrina.dto.user.UserDto;

public interface UserServiceCRUD {

    void create(UserCreatedDto dto);

    void update(UserDto dto);

    void delete(UserDto dto);
}
