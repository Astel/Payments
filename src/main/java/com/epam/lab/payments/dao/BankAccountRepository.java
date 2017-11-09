package com.epam.lab.payments.dao;

import com.epam.lab.payments.domain.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Integer> {
}
