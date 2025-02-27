package dns.vitrina.server.controller;

import dns.vitrina.server.model.Vitrina;
import dns.vitrina.server.service.VitrinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class VitrinaController {
    private final VitrinaService service;

    @CrossOrigin
    @GetMapping("/vitrins")
    public List<Vitrina> getVitrinas() {
        return service.getAll();
    }

}
