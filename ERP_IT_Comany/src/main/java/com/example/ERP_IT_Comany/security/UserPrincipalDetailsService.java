package com.example.ERP_IT_Comany.security;

import com.example.ERP_IT_Comany.entity.Employer;
import com.example.ERP_IT_Comany.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

   private final EmployerRepository employerRepository;
    @Autowired
    public UserPrincipalDetailsService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Employer employer = employerRepository.findByLogin(login);
        UserPrincipal userPrincipal = new UserPrincipal(employer);
        return userPrincipal;

    }

}
