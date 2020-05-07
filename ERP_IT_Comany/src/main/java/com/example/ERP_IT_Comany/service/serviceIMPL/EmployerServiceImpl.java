package com.example.ERP_IT_Comany.service.serviceIMPL;

import com.example.ERP_IT_Comany.entity.Employer;
import com.example.ERP_IT_Comany.repository.EmployerRepository;
import com.example.ERP_IT_Comany.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public Employer save(Employer employer) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        employer.setHashPassword(bCryptPasswordEncoder.encode(employer.getHashPassword()));
        return employerRepository.save(employer);
    }

    @Override
    public List<Employer> findAll() {
        return employerRepository.findAll();
    }
}
