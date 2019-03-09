package com.cg.movie.beans;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int movieId;
	private String movieName;
	private String movieDirector;
	@OneToMany(mappedBy="movie",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@MapKey
	@JsonManagedReference
	private Map<Integer, Song> songs;
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieDirector=" + movieDirector
				+ ", songs=" + songs + "]";
	}

	public Movie() {
	}

	public Map<Integer, Song> getSongs() {
		return songs;
	}

	public void setSongs(Map<Integer, Song> songs) {
		this.songs = songs;
	}

	public Movie(int movieId, String movieName, String movieDirector, Map<Integer, Song> songs) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.songs = songs;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}


}
