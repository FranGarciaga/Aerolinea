package org.example.security;

import org.example.repositories.UsuariosRepositorio;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private UsuariosRepositorio usuariosRepositorio;

    public JpaUserDetailsService(UsuariosRepositorio usuariosRepositorio) {
        this.usuariosRepositorio = usuariosRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuariosRepositorio.findByUsername(username)
                .map(SecurityUser::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}