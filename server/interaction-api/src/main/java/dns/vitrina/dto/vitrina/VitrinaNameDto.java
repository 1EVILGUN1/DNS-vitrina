package dns.vitrina.dto.vitrina;

import lombok.Data;

//Dto нужна для отображения название витрин пользователя слева где при нажатии открывается его список закрепленных витрин
@Data
public class VitrinaNameDto {
    private Long id;
    private String name;
}
