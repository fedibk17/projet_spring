package com.app.rdv.security.service;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private IServiceAuthentication iServiceAuthentication;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iServiceAuthentication.loadAppUserByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException("User with " + username + " does not exist");
        }

        String[] roles = appUser.getRoles().stream()
                .map(AppRole::getRole)
                .toArray(String[]::new);

        return User
                .withUsername(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(roles)
                .build();
    }
}
