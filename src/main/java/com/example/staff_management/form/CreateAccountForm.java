package com.example.staff_management.form;

import com.example.staff_management.entity.Account;
import com.example.staff_management.utils.PasswordUtils;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountForm {
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;


    // TODO: validate password
    //  - at least 8 characters
    //  - at least 1 uppercase letter
    //  - at least 1 lowercase letter
    //  - at least 1 number
    //  - at least 1 special character
    // Done
    @NotBlank
    @Min(8)
    @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\W_]).+$")
    private String password;
    @NotBlank
    private String role;

    public Account toAccount() {
        return Account.builder()
                .name(name)
                .password(PasswordUtils.encodedPassword(password))
                .role(role)
                .build();
    }
}
