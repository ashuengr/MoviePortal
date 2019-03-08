package com.cg.movie.controllers;

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
import com.cg.movie.exceptions.MovieDetailsNotFoundException;
import com.cg.movie.exceptions.SongDetailsNotFoundException;
import com.cg.movie.services.MovieServices;

@Controller
public class MovieServicesController {
@Autowired
MovieServices movieServices;

@RequestMapping(value= {"/getSongDetails"},method=RequestMethod.GET,
produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
public ResponseEntity<Song> getSongDetailsRequestParam(@RequestParam int songId) throws SongDetailsNotFoundException{
Song song = movieServices.getSongDetails(songId);
return new ResponseEntity<Song>(song,HttpStatus.OK);
}
@RequestMapping(value= {"/getMovieDetails"},method=RequestMethod.GET,
produces=MediaType.APPLICATION_JSON_VALUE, headers="Accept=application/json")
public ResponseEntity<Movie> getMovieDetailsRequestParam(@RequestParam int movieId) throws MovieDetailsNotFoundException{
Movie movie = movieServices.getMovieDetails(movieId);
return new ResponseEntity<Movie>(movie,HttpStatus.OK);
}
@RequestMapping(value= {"/acceptMovieDetails"},method=RequestMethod.POST,
consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ResponseEntity<String> acceptMovieDetails(@ModelAttribute Movie movie){
	movie = movieServices.acceptMovieDetails(movie);
return new ResponseEntity<>("Movie details successfully added.\n Movie ID: "+movie.getMovieId(),HttpStatus.OK);
}
@RequestMapping(value= {"/acceptSongDetails"},method=RequestMethod.POST,
consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ResponseEntity<String> acceptSongDetails(@ModelAttribute Song song){
	song = movieServices.acceptSongDetails(song);
return new ResponseEntity<>("Song details successfully added.\n Song ID: "+song.getSongId(),HttpStatus.OK);
}
@RequestMapping(value= {"/removeSongDetails"},method=RequestMethod.DELETE,
consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
public ResponseEntity<String> removeSongDetails(@RequestParam int songId) throws SongDetailsNotFoundException{
	movieServices.removeSongDetails(songId);
return new ResponseEntity<>("Songdetails removed successfully",HttpStatus.OK);
}
}
