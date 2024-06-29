package com.john.bryce.couponsystem2.services;

import com.john.bryce.couponsystem2.entity.Company;
import com.john.bryce.couponsystem2.entity.Coupon;
import com.john.bryce.couponsystem2.entity.Customer;
import com.john.bryce.couponsystem2.exceptions.CouponSystemException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminService extends ClientService{

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Transactional
    public void addCompany(Company company){
        if (companyRepo.existsByEmail(company.getEmail())) {
            throw new CouponSystemException("company email already exists");
        }
        if (companyRepo.existsByName(company.getName())) {
            throw new CouponSystemException("company name already exists");
        }
        companyRepo.save(company);
    }

    @Transactional
    public void updateCompany(Company company){
        Company companyFromDb = companyRepo.findById(company.getId()).orElseThrow(() -> new CouponSystemException("company not found"));

        if (!companyFromDb.getName().equalsIgnoreCase(company.getName())) {
            throw new CouponSystemException("company name can't be update");
        }

        if (companyRepo.existsByEmailAndIdNot(company.getEmail(), company.getId())) {
            throw new CouponSystemException("company email already exists");
        }
        companyRepo.save(company);
    }

    @Transactional
    public void deleteCompany(long companyId){
        if (!companyRepo.existsById(companyId)) {
            throw new CouponSystemException("company not found");
        }

        couponRepo.deleteCouponId(companyId);
        companyRepo.deleteById(companyId);
    }

    public List<Company> getAllCompanies(){
        return companyRepo.findAll();
    }

    public Company getSingleCompany(long companyId) {
        return companyRepo.findById(companyId).orElseThrow(() -> new CouponSystemException("company not found"));
    }
//    -------------------------------------------------------------------------

    @Transactional
    public void addCustomer(Customer customer){
        if (customerRepo.existsByEmail(customer.getEmail())) {
            throw new CouponSystemException("customer email already exists");
        }
        customerRepo.save(customer);
    }

    @Transactional
    public void updateCustomer(Customer customer){

        if (!customerRepo.existsById(customer.getId())) {
            throw new CouponSystemException("customer not found");
        }

        if (customerRepo.existsByEmailAndIdNot(customer.getEmail(), customer.getId())) {
            throw new CouponSystemException("customer email already exists");
        }
        customerRepo.save(customer);
    }

    @Transactional
    public void deleteCustomer(long customerId) {
        if (!customerRepo.existsById(customerId)) {
            throw new CouponSystemException("customer not found");
        }
        customerRepo.deleteCustomerCouponHistoryByCustomerId(customerId);
        customerRepo.deleteById(customerId);
    }

    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    public Customer getSingleCustomer(long customerId){
        return customerRepo.findById(customerId).orElseThrow(() -> new CouponSystemException("Customer not found"));
    }

}
