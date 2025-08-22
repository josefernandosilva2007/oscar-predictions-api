package com.fears.oscar_predictions_api.repository;

import com.fears.oscar_predictions_api.entity.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Long> {
}
