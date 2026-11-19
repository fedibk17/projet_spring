package com.app.rdv.security.controller;

import com.app.rdv.security.entities.AppRole;
import com.app.rdv.security.entities.AppUser;
import com.app.rdv.security.service.IServiceAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
@PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
public class AuthenticationController {
    IServiceAuthentication iServiceAuthentication;

    @PostMapping("/adduser")
    public AppUser addAppUser(@RequestBody AppUser appUser) {
        return iServiceAuthentication.createAppUser(appUser);
    }

    @PostMapping("/addrole")
    public AppRole addAppRole(@RequestBody AppRole appRole) {
        return iServiceAuthentication.createAppRole(appRole);
    }

    @PostMapping("/roletouser")
    public Boolean addRoleToUser(@RequestParam String username,
                                 @RequestParam String role) {
        return iServiceAuthentication.addRoleToUser(username, role);
    }
}
