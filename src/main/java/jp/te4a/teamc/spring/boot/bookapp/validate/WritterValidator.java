package jp.te4a.teamc.spring.boot.bookapp.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class WritterValidator implements ConstraintValidator<Writter, String> {

    private String ok;

    @Override
    public void initialize(Writter annotation) {
        this.ok = annotation.ok();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // okの値と比較する等、バリデーションロジックを書く
        if (value == null) {
            return true; // nullはバリデーションしない場合
        }

        if (!ok.equals(value)) {
            // デフォルトメッセージを使うために一旦disableしてから再設定
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Input " + value)
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
