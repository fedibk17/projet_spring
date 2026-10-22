package com.app.rdv.security.service;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.app.rdv.security.entities.repositories.AppUserRepository;
import com.app.rdv.security.entities.repositories.AppRoleRepository;
@Service
@AllArgsConstructor
public class ServiceAuthentication implements IServiceAuthentication{

    private  AppUserRepository appUserRepository;
    private  AppRoleRepository appRoleRepository;
    private  PasswordEncoder passwordEncoder;

    @Override
    public AppUser createAppUser(AppUser appUser) {
        // unicité du username
        if (appUserRepository.findByUsername(appUser.getUsername()) != null) {
            throw new RuntimeException("Username " + appUser.getUsername() + " existe déjà");
        }
        // cryptage du mot de passe
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole createAppRole(AppRole appRole) {
        // unicité du role
        if (appRoleRepository.findByRole(appRole.getRole()) != null) {
            throw new RuntimeException("Le rôle " + appRole.getRole() + " existe déjà");
        }
        return appRoleRepository.save(appRole);
    }

    @Override
    public Boolean addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRole(role);
        if (appUser == null || appRole == null) {
            return false;
        }
        if (!appUser.getRoles().contains(appRole)) {
            appUser.getRoles().add(appRole);
            appUserRepository.save(appUser);
        }
        return true;
    }

    @Override
    public AppUser loadAppUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
