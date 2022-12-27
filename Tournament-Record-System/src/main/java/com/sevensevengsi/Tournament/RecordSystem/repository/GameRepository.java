package com.sevensevengsi.Tournament.RecordSystem.repository;

import com.sevensevengsi.Tournament.RecordSystem.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {

}
