package dns.vitrina.facade;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.dto.vitrina.VitrinaNameDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "vitrina-service", path = "/vitrina-service")
public interface VitrinaFacade {

    @GetMapping("/{vitrinaId}") // Относительный путь
    VitrinaDto getVitrinaDtoById(@PathVariable("vitrinaId") Long vitrinaId);

    @GetMapping // Корневой путь сервиса
    List<VitrinaDto> getVitrinas();

    @GetMapping("/user-vitrina/{vitrinaId}")
    VitrinaNameDto getVitrinaNameDtoById(@PathVariable("vitrinaId") Long vitrinaId);

    @GetMapping("/user-vitrina")
    List<VitrinaNameDto> getVitrinaNamesByIds(@RequestParam("vitrinaIds") List<Long> vitrinaIds);


}
