package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import os.osHibernate.UsersEntity;
import os.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersEntity usersEntity = userRepository.findByEmail(email);
        if (usersEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new User(usersEntity.getEmail(), usersEntity.getPassword(), getAuthority(usersEntity.getRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthority(String role) {
        return List.of(new SimpleGrantedAuthority(role));
    }
}

