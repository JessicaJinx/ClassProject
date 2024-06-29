package com.john.bryce.couponsystem2.repo;

import com.john.bryce.couponsystem2.entity.Company;
import com.john.bryce.couponsystem2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String name, long id);

    @Modifying
    @Query(value = "DELETE FROM customer_coupons WHERE customer_id = ?", nativeQuery = true)
    void deleteCustomerCouponHistoryByCustomerId(Long customerId);

}
