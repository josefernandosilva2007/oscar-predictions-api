package com.fears.oscar_predictions_api.repository;

import com.fears.oscar_predictions_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.nominations n
            """)
    List<User> findAllWithNomination();
}
