package com.john.bryce.couponsystem2.services;

import org.springframework.stereotype.Service;

@Service
public class CompanyService extends ClientService{

    @Override
    public boolean login(String email, String password) {
        return false;
    }
}
