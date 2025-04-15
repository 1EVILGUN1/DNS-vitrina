package dns.vitrina.dto.task;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

//Dto создание задачи
@Data
public class TaskCreatedDto {

    @NotBlank(message = "Название задачи обязательно")
    @Size(max = 255, message = "Название не должно превышать 255 символов")
    private String name;

    @NotBlank(message = "Описание задачи обязательно")
    @Size(max = 1000, message = "Описание не должно превышать 1000 символов")
    private String description;

    @NotNull(message = "Дата завершения обязательна")
    @FutureOrPresent(message = "Дата завершения не может быть в прошлом")
    private LocalDate endDate;

    // Дополнительная проверка, если нужно гарантировать,
    // что endDate не раньше даты создания (если created генерится на сервере)
    @AssertTrue(message = "Дата завершения должна быть не раньше текущего дня")
    private boolean isEndDateValid() {
        return endDate.isAfter(LocalDate.now().minusDays(1));
    }
}