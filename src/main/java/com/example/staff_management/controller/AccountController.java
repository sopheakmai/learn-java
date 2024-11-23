package com.example.staff_management.controller;

import com.example.staff_management.form.CreateAccountForm;
import com.example.staff_management.form.UpdateAccountForm;
import com.example.staff_management.service.AccountService;
import com.example.staff_management.view.AccountView;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@SecurityRequirement(name = "basicAuth")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<AccountView> list (@RequestParam(required = false) String name, String role) {
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
    public AccountView create(@RequestBody CreateAccountForm form) {
        return accountService.create(form);
    }


    @PutMapping
    public AccountView update(@RequestBody UpdateAccountForm form) {
        // TODO: implement update account
        return accountService.update(form);
    }

    @DeleteMapping
    public void delete(@RequestBody Long id) {
        // TODO: implement delete account
        accountService.delete(id);
    }
}
