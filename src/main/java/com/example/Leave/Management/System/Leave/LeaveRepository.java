package com.example.Leave.Management.System.Leave;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long>{

    @Query("SELECT l FROM Leave l WHERE l.id = ?1")
    Optional<Leave> findLeaveById(Long id);

    @Query(value = "SELECT * FROM Leaves l WHERE l.user_id = :userId",nativeQuery = true)
    List<Leave> findLeaveByUserId(@Param("userId") Integer userId);
    // SELECT model 
    // FROM cars 
    // WHERE color = 'blue' 
    //   AND year > 2014;
    // SELECT * FROM USERS u WHERE u.status = 1
    // @Query("SELECT l FROM User l WHERE l.status = APPROVED")
    // Collection<Leave> findAllLeaveByStatus();
    // @Query("SELECT * FROM Leave l WHERE l.status = APPROVED")
    @Query(value = "SELECT * FROM Leaves l WHERE l.user_id = :userId AND l.status = :status",nativeQuery = true)
    List<Leave> findAllLeaveByStatus(@Param("userId") Integer userId, @Param("status") Integer status);
    
}
