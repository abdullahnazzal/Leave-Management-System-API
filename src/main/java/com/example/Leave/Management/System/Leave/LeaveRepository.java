package com.example.Leave.Management.System.Leave;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{

    @Query("SELECT l FROM Leave l WHERE l.id = ?1")
    Optional<Leave> findUserById(Long id);
    
}
