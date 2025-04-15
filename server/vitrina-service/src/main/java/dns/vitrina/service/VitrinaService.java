package dns.vitrina.service;


import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.dto.vitrina.VitrinaNameDto;

import java.util.List;

public interface VitrinaService {

    VitrinaDto getById(Long id);

    List<VitrinaDto> getAll();

    List<VitrinaNameDto> getAllNamesByIds(List<Long> ids);

}
