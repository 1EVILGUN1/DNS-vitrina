package dns.vitrina.service;

import dns.vitrina.dto.vitrina.VitrinaUpdatedDto;
import dns.vitrina.repository.VitrinaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class VitrinaServiceCRUDImpl implements VitrinaServiceCRUD{
    private final VitrinaRepository repository;
    private final VitrinaService service;

    @Override
    @Transactional
    public void update(VitrinaUpdatedDto dto) {

    }
}
