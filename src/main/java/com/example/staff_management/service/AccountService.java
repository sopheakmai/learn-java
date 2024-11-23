package com.example.staff_management.service;

import com.example.staff_management.form.CreateAccountForm;
import com.example.staff_management.form.UpdateAccountForm;
import com.example.staff_management.view.AccountView;

import java.util.List;

public interface AccountService {
    List<AccountView> getAccountList();
    List<AccountView> getAccountList(String name);
    List<AccountView> getAccountList(String name, String role);
    AccountView create(CreateAccountForm form);
    AccountView update(UpdateAccountForm form);
    void delete(Long id);
}
