package com.cg.movie.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.beans.Song;

public interface SongDao extends JpaRepository<Song, Integer>{

}
