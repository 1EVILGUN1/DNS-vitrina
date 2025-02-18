package dns.vitrina.server.dto;

import lombok.Data;

import java.util.List;


@Data
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    List<VitrinaDto> vitrins;
}