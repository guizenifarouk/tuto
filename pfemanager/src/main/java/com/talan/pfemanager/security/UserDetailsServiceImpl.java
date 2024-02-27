package com.talan.pfemanager.security;

import com.talan.pfemanager.entity.User;
import com.talan.pfemanager.repository.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException("cannot find email = " + email));
        return user.map(UserDetailsImpl::new).get();

    }
}
