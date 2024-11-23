package com.example.staff_management.form;


import com.example.staff_management.entity.Account;
import com.example.staff_management.utils.PasswordUtils;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountForm {
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    private String role;

    public Account toAccount() {
        return Account.builder()
                .name(name)
                .role(role)
                .build();
    }
}
