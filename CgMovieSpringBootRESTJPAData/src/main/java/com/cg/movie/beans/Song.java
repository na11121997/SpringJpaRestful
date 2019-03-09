package com.cg.movie.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int songId;
	private int duration;

	@ManyToOne
	@JsonBackReference
	private Movie movie;
	public Song(int songId, int duration, Movie movie) {
		super();
		this.songId = songId;
		this.duration = duration;
		this.movie = movie;
	}


	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Song() {
	}

	public Song(int duration, Movie movie) {
		this.duration=duration;
		this.movie=movie;
	}

}
