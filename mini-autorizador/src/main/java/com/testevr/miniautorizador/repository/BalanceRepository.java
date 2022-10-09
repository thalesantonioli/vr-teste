package com.testevr.miniautorizador.repository;

import com.testevr.miniautorizador.model.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalanceRepository extends JpaRepository<Balance, Long> {

}
