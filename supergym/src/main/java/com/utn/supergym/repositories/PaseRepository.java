package com.utn.supergym.repositories;

import com.utn.supergym.entities.Pase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaseRepository extends JpaRepository<Pase, Long> {

}