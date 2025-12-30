package com.sumithra.demo.repository;

import com.sumithra.demo.entity.Pastes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PastesRepository extends JpaRepository<Pastes,String> {
}
