package com.john.bryce.couponsystem2.services;

import com.john.bryce.couponsystem2.repo.CompanyRepo;
import com.john.bryce.couponsystem2.repo.CouponRepo;
import com.john.bryce.couponsystem2.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ClientService {
    @Autowired
    protected CompanyRepo companyRepo;
    @Autowired
    protected CouponRepo couponRepo;
    @Autowired
    protected CustomerRepo customerRepo;

    public abstract boolean login(String email, String password);
}
