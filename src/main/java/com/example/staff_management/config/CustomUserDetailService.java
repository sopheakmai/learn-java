package com.example.staff_management.config;

import com.example.staff_management.entity.Account;
import com.example.staff_management.repository.AccountRepository;
import com.example.staff_management.utils.PasswordUtils;
import com.example.staff_management.view.AccountView;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByName(username);

        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(
            account.getName(),
            account.getPassword(),
            new ArrayList<>()
        );



        //  TODO: find user from database table accounts by username
        //  and return user accordingly
//        if (username.equals("admin")) {
//            return new User(username, "password", new ArrayList<>());
//        }
//        throw new UsernameNotFoundException("User not found");
    }
}
