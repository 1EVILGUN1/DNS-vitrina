package dns.vitrina.service;



import dns.vitrina.dto.vitrina.VitrinaDto;

import java.util.List;

public interface VitrinaService {

    VitrinaDto getById(Long id);

    List<VitrinaDto> getAll();

}
