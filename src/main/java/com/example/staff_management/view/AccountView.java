package com.example.staff_management.view;

import com.example.staff_management.entity.Account;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountView {

    private String name;
    private String role;

    public static AccountView of(Account account) {
        return AccountView.builder().name(account.getName()).role(account.getRole()).build();
    }
}
