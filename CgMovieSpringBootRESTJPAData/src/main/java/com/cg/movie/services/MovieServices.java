package com.cg.movie.services;

import java.util.List;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieNotFoundException;


public interface MovieServices {
	Movie acceptMovieDetails(Movie movie);
	Movie getMovieDetails(int movieId) throws MovieNotFoundException;
	List<Movie> getAllMovieDetails();
	boolean removeMovieDetails(int movieId);
	Song acceptSongDetails(Song song);
	
}
