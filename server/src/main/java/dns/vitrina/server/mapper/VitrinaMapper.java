package dns.vitrina.server.mapper;

import dns.vitrina.server.dto.VitrinaDto;
import dns.vitrina.server.model.Vitrina;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VitrinaMapper {
    VitrinaDto toDto(Vitrina vitrina);
    Vitrina toVitrina(VitrinaDto vitrinaDto);
}
