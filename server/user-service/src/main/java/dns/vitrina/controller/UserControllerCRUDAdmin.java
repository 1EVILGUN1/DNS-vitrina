package dns.vitrina.controller;

import dns.vitrina.dto.user.UserCreatedDto;
import dns.vitrina.dto.user.UserDto;
import dns.vitrina.service.UserServiceCRUD;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/users")
public class UserControllerCRUDAdmin {
    private final UserServiceCRUD service;

    @CrossOrigin
    @PostMapping
    public void create(@RequestBody @Valid UserCreatedDto dto) {
        service.create(dto);
    }

    @CrossOrigin
    @PutMapping
    public void update(@RequestBody UserDto dto) {
        service.update(dto);
    }

    @CrossOrigin
    @DeleteMapping
    public void delete(@RequestBody UserDto dto) {
        service.delete(dto);
    }
}
