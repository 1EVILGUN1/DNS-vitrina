package dns.vitrina.server.controller;

import dns.vitrina.server.dto.UserAuthDto;
import dns.vitrina.server.dto.UserDto;
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
    public List<UserDto> getUsers() {
        return service.getAll();
    }

    @CrossOrigin
    @GetMapping("/user/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return service.get(userId);
    }
}
