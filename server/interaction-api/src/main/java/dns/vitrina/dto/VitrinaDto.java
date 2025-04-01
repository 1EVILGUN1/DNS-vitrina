package dns.vitrina.dto;

import lombok.Data;

import java.util.List;

@Data
public class VitrinaDto {
    private Long id;
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
    private List<UserDto> usersToVitrina;
}
