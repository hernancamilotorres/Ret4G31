package com.g31.jpa.repository;

import com.g31.jpa.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Camilo Torres C
 */

public interface MessageRepository extends JpaRepository<Message, Long>{
    
}
