package dns.vitrina.mapper;


import dns.vitrina.dto.VitrinaDto;
import dns.vitrina.model.Vitrina;
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
