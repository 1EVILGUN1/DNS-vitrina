package dns.vitrina.controller;

import dns.vitrina.dto.user.UserDto;
import dns.vitrina.facade.UserFacade;
import dns.vitrina.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class UserControllerFacade implements UserFacade {
    private final UserServiceImpl service;

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }
}
