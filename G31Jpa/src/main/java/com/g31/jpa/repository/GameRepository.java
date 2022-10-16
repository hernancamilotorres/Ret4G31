package com.g31.jpa.repository;

import com.g31.jpa.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Camilo Torres C
 */

public interface GameRepository extends JpaRepository<Game, Long> {
}
