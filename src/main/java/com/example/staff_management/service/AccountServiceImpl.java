package com.example.staff_management.service;

import com.example.staff_management.entity.Account;
import com.example.staff_management.form.CreateAccountForm;
import com.example.staff_management.form.UpdateAccountForm;
import com.example.staff_management.repository.AccountRepository;
import com.example.staff_management.view.AccountView;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public List<AccountView> getAccountList() {
        return accountRepository.findAll().stream().map(AccountView::of).toList();
    }

    @Override
    public List<AccountView> getAccountList(String name) {
        return accountRepository.findByNameLike(name).stream().map(AccountView::of).toList();
    }

    @Override
    public List<AccountView> getAccountList(String name, String role) {
        return accountRepository.findByNameLikeAndRole(name, role).stream().map(AccountView::of).toList();
    }

    @Override
    public AccountView create(CreateAccountForm form) {
        return AccountView.of(accountRepository.saveAndFlush(form.toAccount()));
    }

    @Override
    public AccountView update(Long id, UpdateAccountForm form) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account Not Found"));

        account.setName(form.getName());
        account.setRole(form.getRole());

        return  AccountView.of(accountRepository.save(account));
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }

}
