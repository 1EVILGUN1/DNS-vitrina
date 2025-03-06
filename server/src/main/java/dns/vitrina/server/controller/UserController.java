package dns.vitrina.server.controller;

import dns.vitrina.server.dto.UserAuthDto;
import dns.vitrina.server.dto.UserDto;
import dns.vitrina.server.model.Task;
import dns.vitrina.server.model.User;
import dns.vitrina.server.model.Vitrina;
import dns.vitrina.server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @CrossOrigin
    @PostMapping("/login")
    public void authenticate(@RequestBody UserAuthDto userAuthDto) {
        service.authenticate(userAuthDto);
    }

    @CrossOrigin
    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> userDtos = service.getAll();
        log.info(userDtos.toString());
        return userDtos;
    }

    @CrossOrigin
    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Long userId) {
        return service.get(userId);
    }

    @CrossOrigin
    @PostMapping("/create-task/{userId}")
    public void createTask (@PathVariable Long userId, @RequestBody Task task) {
        service.createTask(userId, task);
    }

    @CrossOrigin
    @PutMapping("/success-task/{userId}")
    public void successTask(@PathVariable Long userId, @RequestBody Task task) {
        service.successTask(userId, task);
    }

    @CrossOrigin
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user) {
        service.create(user);
    }

    @CrossOrigin
    @PostMapping("/add-vitrina/{userId}")
    public void addVitrina(@PathVariable Long userId, @RequestBody Vitrina vitrina) {
        service.addVitrinaUser(userId, vitrina);
    }

    @CrossOrigin
    @PostMapping("/vitrina")
    public void updateVitrina(@RequestBody Vitrina vitrina) {
        service.updateVitrina(vitrina);
    }
}
