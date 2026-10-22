package com.app.rdv.security.service;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;

public interface IServiceAuthentication {
    AppUser createAppUser(AppUser appUser);
    AppRole createAppRole (AppRole appRole);
    Boolean addRoleToUser(String username, String role);
    AppUser loadAppUserByUsername(String username);
}
