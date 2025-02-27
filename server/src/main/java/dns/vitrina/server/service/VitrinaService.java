package dns.vitrina.server.service;

import dns.vitrina.server.dto.VitrinaDto;
import dns.vitrina.server.model.Vitrina;

import java.util.List;

public interface VitrinaService {

    Vitrina get(Long id);

    List<Vitrina> getAll();

    void update(Vitrina vitrina);
}
