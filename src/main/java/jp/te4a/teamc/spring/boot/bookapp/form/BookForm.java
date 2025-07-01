package jp.te4a.teamc.spring.boot.bookapp.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.te4a.teamc.spring.boot.bookapp.validate.TestValid;
import jp.te4a.teamc.spring.boot.bookapp.validate.Writter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookForm {
    private Integer id;
    @NotNull
    @Size(min=3)
    @TestValid(param="abc")
    private String title;
    @Writter(ok="東北タロウ")
    private String writter;
    private String publisher;
    @Min(0)
    private Integer price;
}
