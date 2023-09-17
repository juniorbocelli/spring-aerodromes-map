package com.juniorbocelli.xmobotscase.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.juniorbocelli.xmobotscase.user.data.datasources.impl.UserDatasourcesLocalImpl;
import com.juniorbocelli.xmobotscase.user.data.models.UserModel;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    public UserDatasourcesLocalImpl userDatasourcesLocalImpl;
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomAuthenticationManager(UserDatasourcesLocalImpl userDatasourcesLocalImpl,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDatasourcesLocalImpl = userDatasourcesLocalImpl;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserModel user = userDatasourcesLocalImpl.findByUsername(authentication.getName());

        if (user != null) {
            if (bCryptPasswordEncoder.matches(authentication.getCredentials().toString(), user.getPassword())) {
                List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

                return new UsernamePasswordAuthenticationToken(((UserModel) authentication.getPrincipal()).getEmail(),
                        authentication.getCredentials(), grantedAuthorityList);
            } else {
                throw new BadCredentialsException("Senha inválida");
            }
        } else {
            throw new BadCredentialsException("Usuário inexistente");
        }
    }
}