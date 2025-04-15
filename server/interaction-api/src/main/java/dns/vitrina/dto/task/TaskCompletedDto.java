package dns.vitrina.dto.task;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

//Dto для проведенной задачи
@Data
public class TaskCompletedDto {

    @NotNull(message = "ID задачи обязательно")
    @Positive(message = "ID должен быть положительным числом")
    private Long id;

    @NotBlank(message = "Название задачи обязательно")
    @Size(max = 255, message = "Название не должно превышать 255 символов")
    private String name;

    @Size(max = 1000, message = "Описание не должно превышать 1000 символов")
    private String description;

    @NotNull(message = "Статус обязателен")
    private StatusTask status;

    @NotNull(message = "Дата создания обязательна")
    @PastOrPresent(message = "Дата создания не может быть в будущем")
    private LocalDate created;

    @NotNull(message = "Дата завершения обязательна")
    @FutureOrPresent(message = "Дата завершения не может быть в прошлом")
    private LocalDate endDate;

    // Дополнительные рекомендации:
    // 1. Если это DTO для завершения задачи, добавьте:
    @AssertTrue(message = "Статус должен быть SUCCESS")
    private boolean isStatusValid() {
        return status == StatusTask.SUCCESS;
    }

    // 2. Проверка, что endDate после created
    @AssertTrue(message = "Дата завершения должна быть после даты создания")
    private boolean isEndDateValid() {
        return endDate.isAfter(created) || endDate.isEqual(created);
    }
}