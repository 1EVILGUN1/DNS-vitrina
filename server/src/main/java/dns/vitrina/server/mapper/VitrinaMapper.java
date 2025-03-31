package dns.vitrina.server.mapper;

import dns.vitrina.server.dto.VitrinaDto;
import dns.vitrina.server.model.Vitrina;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {UserMapper.class})
public interface VitrinaMapper {
    VitrinaDto toDto(Vitrina vitrina);
    List<VitrinaDto> toDtoList(List<Vitrina> vitrinas);
    Vitrina toVitrina(VitrinaDto vitrinaDto);
}
