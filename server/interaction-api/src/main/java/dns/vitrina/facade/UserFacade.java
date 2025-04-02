package dns.vitrina.facade;

import dns.vitrina.dto.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "user-service",path = "/user-service")
public interface UserFacade {

    @GetMapping("/{userId}")
    UserDto getUserById(@PathVariable("vitrinaId") Long userId);

    @GetMapping
    List<UserDto> getAllUsers();
}
