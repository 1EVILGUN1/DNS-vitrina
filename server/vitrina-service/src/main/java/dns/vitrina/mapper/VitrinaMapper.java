package dns.vitrina.mapper;

import dns.vitrina.dto.vitrina.VitrinaDto;
import dns.vitrina.dto.vitrina.VitrinaNameDto;
import dns.vitrina.dto.vitrina.VitrinaUpdatedDto;
import dns.vitrina.facade.UserFacade;
import dns.vitrina.model.Vitrina;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VitrinaMapper {
    private final UserFacade userFacade;

    public VitrinaDto mapToDto(Vitrina vitrina) {
        VitrinaDto dto = new VitrinaDto();
        dto.setId(vitrina.getId());
        dto.setName(vitrina.getName());
        dto.setX(vitrina.getX());
        dto.setY(vitrina.getY());
        dto.setHeight(vitrina.getHeight());
        dto.setWidth(vitrina.getWidth());
        return dto;
    }

    public Vitrina mapToVitrina(VitrinaUpdatedDto dto) {
        Vitrina vitrina = new Vitrina();
        vitrina.setId(dto.getId());
        vitrina.setName(dto.getName());
        return vitrina;
    }

    public List<VitrinaDto> mapToDtos(List<Vitrina> vitrinas) {
        List<VitrinaDto> dtos = new ArrayList<>();
        for (Vitrina vitrina : vitrinas) {
            dtos.add(mapToDto(vitrina));
        }
        return dtos;
    }

    public VitrinaNameDto mapToDtoName(VitrinaDto vitrina) {
        VitrinaNameDto dto = new VitrinaNameDto();
        dto.setId(vitrina.getId());
        dto.setName(vitrina.getName());
        return dto;
    }
}
