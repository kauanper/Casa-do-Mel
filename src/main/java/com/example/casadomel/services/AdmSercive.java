package com.example.casadomel.services;

import com.example.casadomel.repositories.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmSercive {

    @Autowired
    AdmRepository admRepository;
}
