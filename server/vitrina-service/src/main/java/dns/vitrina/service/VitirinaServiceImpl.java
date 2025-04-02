package dns.vitrina.service;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.exception.NotDateBaseUserException;
import dns.vitrina.mapper.VitrinaMapper;
import dns.vitrina.model.Vitrina;
import dns.vitrina.repository.VitrinaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public VitrinaDto getById(Long id) {
        return   repository.findById(id).stream()
                .findFirst()
                .map(mapper::toDto)
                .orElseThrow(()-> new NotDateBaseUserException("По данному ID витрины не существует" + id));
    }

    @Override
    public List<VitrinaDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


}
