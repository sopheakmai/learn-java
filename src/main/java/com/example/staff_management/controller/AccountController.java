package com.example.staff_management.controller;

import com.example.staff_management.form.CreateAccountForm;
import com.example.staff_management.form.UpdateAccountForm;
import com.example.staff_management.service.AccountService;
import com.example.staff_management.view.AccountView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private AccountService accountService;

    @GetMapping
    public List<AccountView> list (@RequestParam String name, String role) {
        // TODO: search by name or role
        //  when name and role = null, return all accounts
        //  when name is not null, return accounts with the name search with LIKE
        //  when role is not null, return accounts with the role search equals
        //  when name and role are not null, return accounts with the name search with LIKE and role equals
        if (name != null && role != null) {
            return accountService.getAccountList(name, role);
        } else if (name != null) {
            return accountService.getAccountList(name, "");
        } else if (role != null) {
            return accountService.getAccountList("", role);
        } else {
            return accountService.getAccountList();
        }
    }

    @PostMapping
    public AccountView create(@Valid @RequestBody CreateAccountForm form) {
        return accountService.create(form);
    }


    @PutMapping
    public AccountView update(Long id, UpdateAccountForm form) {
        // TODO: implement update account
        return accountService.update(id, form);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        // TODO: implement delete account
        accountService.delete(id);
    }
}
