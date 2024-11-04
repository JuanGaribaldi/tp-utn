package com.utn.supergym.repositories;

import com.utn.supergym.entities.Pase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaseRepository extends JpaRepository<Pase, Long> {

}