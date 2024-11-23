package com.example.staff_management.form;

import com.example.staff_management.entity.Account;
import com.example.staff_management.utils.PasswordUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountForm {
    @NotBlank
    @Size(min = 2, max = 100)
    @Schema(example = "sopheak")
    private String name;

    @NotBlank
    @Min(8)
    @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\W_]).+$", message = "Password should contain at least one number , uppercase , lowercase, special character.")
    @Schema(example = "Admin123@")
    private String password;
    @NotBlank
    @Schema(example = "admin")
    private String role;
    @NotBlank
    @Schema(example = "normal")
    private String status;

    public Account toAccount() {
        return Account.builder()
                .name(name)
                .password(PasswordUtils.encodedPassword(password))
                .role(role)
                .status(status)
                .build();
    }
}
