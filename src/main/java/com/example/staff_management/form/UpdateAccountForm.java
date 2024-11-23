package com.example.staff_management.form;


import com.example.staff_management.entity.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountForm {
    @NotBlank
    private Long id;

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    private String role;

    @NotBlank
    private String status;

    public Account toAccount() {
        return Account.builder()
                .name(name)
                .status(status)
                .role(role)
                .build();
    }
}
