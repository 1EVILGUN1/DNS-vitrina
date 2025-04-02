package dns.vitrina.controller;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.facade.VitrinaFacade;
import dns.vitrina.service.VitrinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class VitrinaControllerFacade implements VitrinaFacade {
    private final VitrinaService service;


    @Override
    public VitrinaDto getVitrinaDtoById(Long vitrinaId) {
        return service.getById(vitrinaId);
    }

    @Override
    public List<VitrinaDto> getVitrinas() {
        return service.getAll();
    }
}
