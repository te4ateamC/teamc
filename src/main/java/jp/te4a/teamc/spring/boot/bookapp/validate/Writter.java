package jp.te4a.teamc.spring.boot.bookapp.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = WritterValidator.class)
public @interface Writter {
    String message() default "Input ${validaterdValue}";

    // エラーメッセージ、${validatedValue}で入力値を埋め込み
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String ok();// 合格値を受け取るパラメータ
}