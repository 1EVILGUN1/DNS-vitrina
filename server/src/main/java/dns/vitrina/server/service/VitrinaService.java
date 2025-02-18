package dns.vitrina.server.service;

import dns.vitrina.server.dto.VitrinaDto;

import java.util.List;

public interface VitrinaService {

    VitrinaDto get(Long id);

    List<VitrinaDto> getAll();

    void update(VitrinaDto vitrinaDto);
}
