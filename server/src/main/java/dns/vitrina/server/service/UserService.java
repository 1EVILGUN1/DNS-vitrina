package dns.vitrina.server.service;

import dns.vitrina.server.dto.UserAuthDto;
import dns.vitrina.server.dto.UserDto;
import dns.vitrina.server.dto.UserRequest;
import dns.vitrina.server.exception.AddedUserException;
import dns.vitrina.server.exception.NotDateBaseUserException;
import dns.vitrina.server.mapper.UserMapper;
import dns.vitrina.server.model.User;
import dns.vitrina.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServiceImpl {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    @Transactional
    public void create(UserRequest request) {
        log.info("Добавление пользователя в бд: {}", request);
        if (repository.existsByLastName(request.getLastName())) {
            log.warn("Пользователь с фамилией {} уже есть в бд", request.getLastName());
            throw new AddedUserException("Пользователь уже есть в бд");
        }
        User createdUser = mapper.userDtoToUserCreate(request);
        repository.save(createdUser);
        log.info("Пользователь {} добавлен в бд", createdUser.getLastName());
    }

    @Override
    public void update(Long id, UserDto userDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserDto get(Long id) {
        User user = repository.findById(id).stream()
                .findFirst()
                .orElseThrow(()-> new NotDateBaseUserException("нет пользователя с таким ID"+ id));
        return mapper.userToUserDto(user);
    }

    @Override
    public void authenticate(UserAuthDto userAuthDto) {
        log.info("Запрос на авторизацию пользователя в бд: {}", userAuthDto.getLastName());
        if (!(repository.existsByLastName(userAuthDto.getLastName()))) {
            log.warn("Пользователь с фамилией {} нет в бд", userAuthDto.getLastName());
            throw new NotDateBaseUserException("Пользователь уже есть в бд");
        }
    }

    @Override
    public List<UserDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::userToUserDto)
                .toList();
    }
}
