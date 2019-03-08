package com.cg.movie.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.movie.exceptions.MovieDetailsNotFoundException;
import com.cg.movie.exceptions.SongDetailsNotFoundException;
import com.cg.movie.response.CustomeResponse;

@ControllerAdvice
public class MovieExceptionAspect {
	@ExceptionHandler(MovieDetailsNotFoundException.class)
	  public ResponseEntity<CustomeResponse> handleMovieDetailsNotFoundException(Exception e) {
	     
		  CustomeResponse response = new CustomeResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		  return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	  }
	@ExceptionHandler(SongDetailsNotFoundException.class)
	  public ResponseEntity<CustomeResponse> handleSongDetailsNotFoundException(Exception e) {
	     
		  CustomeResponse response = new CustomeResponse(e.getMessage(),HttpStatus.EXPECTATION_FAILED.value());
		  return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	  }
}
