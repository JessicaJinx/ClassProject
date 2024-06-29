package com.john.bryce.couponsystem2.repo;

import com.john.bryce.couponsystem2.entity.Company;
import com.john.bryce.couponsystem2.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {


    @Modifying
    @Query(value = "DELETE FROM customer_coupons WHERE coupon_id in (select id from `coupon` where company_id = ?)", nativeQuery = true)
    void deleteCouponId(Long companyId);
}
