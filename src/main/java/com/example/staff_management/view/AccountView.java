package com.example.staff_management.view;

import com.example.staff_management.entity.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountView {

    private Long id;
    private String name;
    private String role;
    private String status;

    public static AccountView of(Account account) {
        return AccountView.builder().id(account.getId()).name(account.getName()).role(account.getRole()).status(account.getStatus()).build();
    }
}
