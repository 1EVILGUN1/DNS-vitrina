package dns.vitrina.service;

import dns.vitrina.dto.user.UserCreatedDto;
import dns.vitrina.dto.user.UserDto;
import dns.vitrina.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceCRUDImpl implements UserServiceCRUD {
    private final UserRepository repository;
    private final UserService service;
    @Override
    @Transactional
    public void create(UserCreatedDto dto) {

    }

    @Override
    @Transactional
    public void update(UserDto dto) {

    }

    @Override
    @Transactional
    public void delete(UserDto dto) {

    }
}
