package com.cg.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.services.MovieServices;



@Controller
public class MovieServicesController {
	@Autowired
	MovieServices movieServices;
	
	@RequestMapping(value= {"/sayHello"},method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("hello world ",HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptMovieDetails",method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptMovieDetails(@ModelAttribute Movie movie) {
		movie=movieServices.acceptMovieDetails(movie);
		  return new ResponseEntity<>("Movie details successfully added - movieId :"+movie.getMovieId(),HttpStatus.OK);
	}
	
	@RequestMapping(value={"/getMovieDetails"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
    public ResponseEntity<Movie> getAssociateDetailsRequestParam(@RequestParam int movieId) throws MovieNotFoundException{
        Movie movie=movieServices.getMovieDetails(movieId);
        return new ResponseEntity<Movie>(movie,HttpStatus.OK);
    }
	@RequestMapping(value={"/getAllMovieDetails"},method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE,headers="Accept=application/json")
	public ResponseEntity<List<Movie>>getMovieDetailsPathParam() {
		  return new ResponseEntity<List<Movie>>(movieServices.getAllMovieDetails(),HttpStatus.OK);
	}
	@RequestMapping(value="/acceptSongDetails",method=RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptSongDetails(@RequestParam int movieId,int duration) {
		Movie movie=movieServices.getMovieDetails(movieId);
		Song song=new Song(duration, movie);
		movieServices.acceptSongDetails(song);
		  return new ResponseEntity<>("Songs details successfully added - SongId :"+song.getSongId(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/removeAssociateDetails",method=RequestMethod.DELETE)
	public ResponseEntity<String> removetAssociateDetails(@RequestParam int movieId) throws MovieNotFoundException{
		movieServices.removeMovieDetails(movieId);
		return new ResponseEntity<>("Movie details successfully removed ",HttpStatus.OK);
}
}
