package org.example.security;

import org.example.entities.Roles;
import org.example.entities.Usuarios;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;

public class SecurityUser implements UserDetails {

    private Usuarios usuarios;

    public SecurityUser(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Roles roles : usuarios.getRoles()) {
            System.out.println("User role : " + roles.getName());
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(roles.getName());
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return usuarios.getPassword();
    }

    @Override
    public String getUsername() {
        return usuarios.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}