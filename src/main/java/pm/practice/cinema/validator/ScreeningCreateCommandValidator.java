package pm.practice.cinema.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pm.practice.cinema.dto.incoming.ScreeningCreateCommand;

@Component
public class ScreeningCreateCommandValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ScreeningCreateCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ScreeningCreateCommand command = (ScreeningCreateCommand) target;

        if (command.getTitle() == null || command.getTitle().isBlank()) {
            errors.rejectValue("title", "screeningcreate.title.notgiven");
        }
    }
}
