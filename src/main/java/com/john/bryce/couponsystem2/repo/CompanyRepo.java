package com.john.bryce.couponsystem2.repo;

import com.john.bryce.couponsystem2.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company, Long> {
//    findBy
//    deleteBy
//    existsBy
    boolean existsByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmailAndIdNot(String name, long id);
}
