package dns.vitrina.service;


import dns.vitrina.dto.task.TaskInTableResponseDto;
import dns.vitrina.dto.user.UserAuthDto;
import dns.vitrina.dto.user.UserDto;
import dns.vitrina.exception.AddedUserException;
import dns.vitrina.exception.NotDateBaseUserException;
import dns.vitrina.facade.TaskFacade;
import dns.vitrina.mapper.UserMapper;
import dns.vitrina.model.User;
import dns.vitrina.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;
    private final TaskFacade taskFacade;


    @Override
    public UserDto getById(Long id) {
        return repository.findById(id).stream()
                .findFirst()
                .map(mapper::userToUserDto)
                .orElseThrow(()-> new NotDateBaseUserException("нет пользователя с таким ID" + id));
    }

    @Override
    public void authenticate(UserAuthDto dto) {
        log.info("Запрос на авторизацию пользователя в бд: {}", dto.getLastName());
        if (!(repository.existsByLastName(dto.getLastName()))) {
            log.warn("Пользователь с фамилией {} нет в бд", dto.getLastName());
            throw new NotDateBaseUserException("Пользователь уже есть в бд");
        }
    }

    @Override
    public List<UserDto> getAll() {
        return mapper.usersToUserDtos(repository.findAll());
    }

    public UserDto getUserDto(Long userId) {
        UserDto userDto = getById(userId);
        List<TaskInTableResponseDto> tasks = taskFacade.getTasksByUserId(userId);
        userDto.setTasks(tasks);
        return userDto;
    }
}
