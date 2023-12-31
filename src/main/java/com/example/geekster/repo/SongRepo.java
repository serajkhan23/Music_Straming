package com.example.geekster.repo;

import com.example.geekster.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends JpaRepository<Song,Long> {
    List<Song> findAllBySongIdIn(List<Long> songIds);
    Song findFirstBySongId(Long songId);
}