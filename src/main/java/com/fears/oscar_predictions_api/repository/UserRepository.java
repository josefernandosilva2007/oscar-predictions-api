package com.fears.oscar_predictions_api.repository;

import com.fears.oscar_predictions_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.nominations n
            """)
    List<User> findAllWithNomination();

    @Query("""
            SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.nominations n WHERE u.id = :id
            """)
    Optional<User> findByIdWithNomination(@Param("id") Long id);
}
