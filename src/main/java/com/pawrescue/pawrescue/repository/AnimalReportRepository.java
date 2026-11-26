package com.pawrescue.pawrescue.repository;

import com.pawrescue.pawrescue.entity.AnimalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalReportRepository extends JpaRepository<AnimalReport, Long> {
}