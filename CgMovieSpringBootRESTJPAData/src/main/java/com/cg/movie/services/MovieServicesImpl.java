package com.cg.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.daoservices.MovieDao;
import com.cg.movie.daoservices.SongDao;
import com.cg.movie.exceptions.MovieNotFoundException;
@Component("movieServices")
public class MovieServicesImpl implements MovieServices{

	@Autowired
	private MovieDao movieDao;
	@Autowired
	private SongDao songDao;
	public Movie acceptMovieDetails(Movie movie) {
		return movieDao.save(movie);
	}

	@Override
	public Movie getMovieDetails(int movieId) throws MovieNotFoundException{
		return movieDao.findById(movieId).orElseThrow
				(()-> new MovieNotFoundException("account detial not found"+movieId));
	}

	@Override
	public List<Movie> getAllMovieDetails() {
		return movieDao.findAll();
	}

	@Override
	public boolean removeMovieDetails(int movieId) {
		 movieDao.delete(getMovieDetails(movieId));
		 return true;
	}

	@Override
	public Song acceptSongDetails(Song song) {
		return songDao.save(song);
	}


}
