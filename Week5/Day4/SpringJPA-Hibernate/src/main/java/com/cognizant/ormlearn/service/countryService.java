package com.cognizant.ormlearn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.countryRepository;

@Service
public class countryService {

    @Autowired
    private countryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {

        return countryRepository.findAll();

    }

}