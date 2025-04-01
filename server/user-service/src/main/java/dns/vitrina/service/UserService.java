package dns.vitrina.service;


import dns.vitrina.exception.AddedUserException;
import dns.vitrina.mapper.UserMapper;
import dns.vitrina.model.User;
import dns.vitrina.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements UserServiceImpl {
    private final UserRepository repository;
    private final VitrinaService vitrinaService;
    private final TaskService taskService;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public void create(User user) {
        log.info("Добавление пользователя в бд: {}", user);
        if (repository.existsByLastName(user.getLastName())) {
            log.warn("Пользователь с фамилией {} уже есть в бд", user.getLastName());
            throw new AddedUserException("Пользователь уже есть в бд");
        }
        repository.save(user);
        log.info("Пользователь {} добавлен в бд", user.getLastName());
    }

    @Transactional
    public void createTask(long userId, Task task){
        User user = get(userId);
        vitrinaService.get(task.getVitrinaId());
        task.setCreated(LocalDate.now());
        task.setStatus(StatusTask.PENDING);
        log.info("Create task user {}, task {}", user.getId(), task);
        taskService.save(task);
        user.getTasks().add(task);
        log.info("added task {}", user.getTasks());
        repository.save(user);
        log.info("Created task {}", user.getTasks());
    }

    public void successTask(long userId, Task task){
        User user = get(userId);
        vitrinaService.get(task.getVitrinaId());
        TaskSuccess taskSuccess = new TaskSuccess();
        taskSuccess.setVitrinaId(task.getVitrinaId());
        taskSuccess.setUserId(userId);
        taskSuccess.setName(task.getName());
        taskSuccess.setDescription(task.getDescription());
        taskSuccess.setCompletedAt(LocalDate.now());
        log.info("task success {}", taskSuccess);
        user.getTasks().remove(task.getId());
        log.info("removed task {}", user.getTasks());
        repository.save(user);
        taskService.delete(task);
        taskService.saveSuccess(taskSuccess);
        log.info("Task success {}", taskSuccess);
    }

    public void addVitrinaUser(long userId, Vitrina vitrina){
        User user = get(userId);
        vitrinaService.get(vitrina.getId());
        vitrina.addUserToVitrina(user);
        log.info("added vitrina user {}", vitrina.getUsersToVitrina());
        vitrinaService.update(vitrina);
        log.info("Saved vitrina user {}", vitrina.getUsersToVitrina());
    }

    public void updateVitrina(Vitrina vitrina){
        vitrinaService.update(vitrina);
    }

    @Override
    public void update(Long id, UserDto userDto) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User get(Long id) {
        User user = repository.findById(id).stream()
                .findFirst()
                .orElseThrow(()-> new NotDateBaseUserException("нет пользователя с таким ID"+ id));
        return user;
    }

    @Override
    public void authenticate(UserAuthDto userAuthDto) {
        log.info("Запрос на авторизацию пользователя в бд: {}", userAuthDto.getLastName());
        User user = userMapper.userAuthDtoToUser(userAuthDto);
        if (!(repository.existsByLastName(user.getLastName()))) {
            log.warn("Пользователь с фамилией {} нет в бд", user.getLastName());
            throw new NotDateBaseUserException("Пользователь уже есть в бд");
        }
    }

    @Override
    public List<User> getAll() {
        return repository.findAll().stream()
                .toList();
    }
}
