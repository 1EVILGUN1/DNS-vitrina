package dns.vitrina.dto.vitrina;

import lombok.Data;

//Dto для отображения фигур на карте зала
@Data
public class VitrinaDto {
    private Long id;
    private String name;
    private int x;
    private int y;
    private int width;
    private int height;
}
