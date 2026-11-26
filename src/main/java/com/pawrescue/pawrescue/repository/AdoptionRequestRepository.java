package com.pawrescue.pawrescue.repository;

import com.pawrescue.pawrescue.entity.AdoptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AdoptionRequestRepository
        extends JpaRepository<AdoptionRequest, Integer> {

    List<AdoptionRequest> findByEmail(String email);
}