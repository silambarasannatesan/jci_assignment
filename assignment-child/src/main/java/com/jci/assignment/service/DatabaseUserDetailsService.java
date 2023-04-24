package com.jci.assignment.service;

import com.jci.assignment.model.rbac.CustomUserDetails;
import com.jci.assignment.model.rbac.UserAccount;
import com.jci.assignment.model.rbac.UserRoleToPrivilege;
import com.jci.assignment.model.rbac.UserToRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import repo.UserAccountRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class DatabaseUserDetailsService implements UserDetailsService {

    private final
    UserAccountRepository userAccountRepository;

    public DatabaseUserDetailsService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        for (UserToRole userToRole : userAccount.getUserToRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userToRole.getRole().getRoleName()));
            for (UserRoleToPrivilege userRoleToPrivilege : userToRole.getRole().getUserRoleToPrivileges()) {
                authorities.add(new SimpleGrantedAuthority(userRoleToPrivilege.getPrivilege().getPrivilegeName()));
            }
        }

        return (UserDetails) new CustomUserDetails(userAccount.getUsername(), userAccount.getPassword(), userAccount.isActive(),"auth" );
    }
}