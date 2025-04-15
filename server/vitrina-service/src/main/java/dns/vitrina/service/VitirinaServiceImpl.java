package dns.vitrina.service;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.dto.vitrina.VitrinaNameDto;
import dns.vitrina.exception.NotDateBaseUserException;
import dns.vitrina.facade.UserFacade;
import dns.vitrina.mapper.VitrinaMapper;
import dns.vitrina.repository.VitrinaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VitirinaServiceImpl implements VitrinaService{
    private final VitrinaRepository repository;
    private final VitrinaMapper mapper;
    private final UserFacade userFacade;

    @Override
    public VitrinaDto getById(Long id) {
        return   repository.findById(id).stream()
                .findFirst()
                .map(mapper::mapToDto)
                .orElseThrow(()-> new NotDateBaseUserException("По данному ID витрины не существует" + id));
    }

    @Override
    public List<VitrinaDto> getAll() {
        return mapper.mapToDtos(repository.findAll());
    }

    @Override
    public List<VitrinaNameDto> getAllNamesByIds(List<Long> ids) {
        return repository.findByIdIn(ids).stream()
                .map(mapper::mapToDto)
                .map(mapper::mapToDtoName)
                .toList();
    }
}
