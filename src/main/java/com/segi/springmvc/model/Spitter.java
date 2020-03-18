package com.segi.springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author chenzx
 * @date 2018-10-09 下午 4:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spitter {
    private Long id;
    @NotBlank(message = "{username.notblank}")
    private String username;
    @NotBlank
    @Pattern(regexp = ".{3,12}", message = "{password.pattern}")
    private String password;
    private String email;

    public Spitter(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
