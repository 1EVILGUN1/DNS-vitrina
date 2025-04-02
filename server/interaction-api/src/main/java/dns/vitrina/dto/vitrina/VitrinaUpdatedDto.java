package dns.vitrina.dto.vitrina;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VitrinaUpdatedDto {
    @NotBlank
    private Long id;
    @NotBlank
    private String name;
}
