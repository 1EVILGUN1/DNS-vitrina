package dns.vitrina.controller;

import dns.vitrina.dto.vitrina.VitrinaUpdatedDto;
import dns.vitrina.service.VitrinaServiceCRUD;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/vitrina")
public class VitrinaControllerCRUDAdmin {
    private final VitrinaServiceCRUD service;

    @CrossOrigin
    @PutMapping
    public void update(@RequestBody @Valid VitrinaUpdatedDto dto) {
        service.update(dto);
    }
}
