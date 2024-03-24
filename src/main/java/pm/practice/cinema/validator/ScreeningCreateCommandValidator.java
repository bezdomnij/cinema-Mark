package pm.practice.cinema.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommandDto;

@Component
public class ScreeningCreateCommandValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ScreeningCreateCommandDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ScreeningCreateCommandDto command = (ScreeningCreateCommandDto) target;

        if (command.getTitle() == null || command.getTitle().isBlank()) {
            errors.rejectValue("title", "screeningcreate.title.notgiven");
        }
    }
}
