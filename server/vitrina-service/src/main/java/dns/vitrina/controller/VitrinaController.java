package dns.vitrina.controller;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.service.VitrinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/vitrina")
public class VitrinaController {
    private final VitrinaService service;

    @CrossOrigin
    @GetMapping
    public List<VitrinaDto> getVitrinas() {
        return service.getAll();
    }

    @CrossOrigin
    @GetMapping("/{vitrinaId}")
    public VitrinaDto getVitrina(@PathVariable Long vitrinaId) {
        return service.getById(vitrinaId);
    }

}
