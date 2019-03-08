package com.cg.movie.services;

import java.util.List;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieDetailsNotFoundException;
import com.cg.movie.exceptions.SongDetailsNotFoundException;

public interface MovieServices {
	 Movie acceptMovieDetails(Movie movie);
	 Song acceptSongDetails(Song song);
	 Movie getMovieDetails(int movieId) throws MovieDetailsNotFoundException;
	 Song getSongDetails(int songId) throws SongDetailsNotFoundException;
	 List<Song>getAllSongDetails();
	 boolean removeSongDetails(int songId) throws SongDetailsNotFoundException;




}
