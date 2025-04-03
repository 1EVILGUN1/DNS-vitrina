package dns.vitrina.controller;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.dto.vitrina.VitrinaNameDto;
import dns.vitrina.facade.VitrinaFacade;
import dns.vitrina.mapper.VitrinaMapper;
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
    private final VitrinaMapper mapper;


    @Override
    public VitrinaDto getVitrinaDtoById(Long vitrinaId) {
        return service.getById(vitrinaId);
    }

    @Override
    public List<VitrinaDto> getVitrinas() {
        return service.getAll();
    }

    @Override
    public VitrinaNameDto getVitrinaNameDtoById(Long vitrinaId) {
        return mapper.mapToDtoName(service.getById(vitrinaId));
    }

    @Override
    public List<VitrinaNameDto> getVitrinaNamesByIds(List<Long> vitrinaIds) {
        return service.getAllNamesByIds(vitrinaIds);
    }
}
