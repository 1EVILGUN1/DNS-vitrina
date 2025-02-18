package dns.vitrina.server.service;

import dns.vitrina.server.dto.VitrinaDto;
import dns.vitrina.server.exception.NotDateBaseUserException;
import dns.vitrina.server.mapper.VitrinaMapper;
import dns.vitrina.server.model.Vitrina;
import dns.vitrina.server.repository.VitrinaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VitirinaServiceImpl implements VitrinaService{
    private final VitrinaRepository repository;
    private final VitrinaMapper mapper;

    @Override
    public VitrinaDto get(Long id) {
        Vitrina vitrina = repository.findById(id).stream()
                .findFirst()
                .orElseThrow(()-> new NotDateBaseUserException("По данному ID витрины не существует"+ id));
        return mapper.toDto(vitrina);
    }

    @Override
    public List<VitrinaDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    @Transactional
    public void update(VitrinaDto vitrinaDto) {
        Vitrina vitrinaUpdate = repository.findById(vitrinaDto.getId()).orElseThrow(()-> new NotDateBaseUserException("нет витрины"));
        vitrinaUpdate.setName(vitrinaDto.getName());
        repository.save(vitrinaUpdate);
    }
}
