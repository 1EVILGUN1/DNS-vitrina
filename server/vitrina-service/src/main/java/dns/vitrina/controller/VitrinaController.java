package dns.vitrina.controller;

import dns.vitrina.server.dto.VitrinaDto;
import dns.vitrina.server.model.Vitrina;
import dns.vitrina.server.service.VitrinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VitrinaController {
    private final VitrinaService service;

    @CrossOrigin
    @GetMapping("/vitrins")
    public List<VitrinaDto> getVitrinas() {
        return service.getAll();
    }

    @CrossOrigin
    @GetMapping("/vitrina/{vitrinaId}")
    public Vitrina getVitrina(@PathVariable Long vitrinaId) {
        return service.get(vitrinaId);
    }

}
