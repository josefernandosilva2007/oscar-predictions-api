package com.fears.oscar_predictions_api.repository;

import com.fears.oscar_predictions_api.entity.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NominationRepository extends JpaRepository<Nomination, Long> {
}
