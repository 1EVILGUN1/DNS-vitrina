package dns.vitrina.controller;
import dns.vitrina.dto.user.UserAuthDto;
import dns.vitrina.dto.user.UserDto;
import dns.vitrina.service.UserService;
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
    public List<UserDto> getUsers() {
        List<UserDto> userDtos = service.getAll();
        log.info(userDtos.toString());
        return userDtos;
    }

    @CrossOrigin
    @GetMapping("/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return service.getById(userId);
    }
}
