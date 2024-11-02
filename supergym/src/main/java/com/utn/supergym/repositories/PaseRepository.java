package com.utn.supergym.repositories;

import com.utn.supergym.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaseRepository extends JpaRepository<Pago, Long> {
}