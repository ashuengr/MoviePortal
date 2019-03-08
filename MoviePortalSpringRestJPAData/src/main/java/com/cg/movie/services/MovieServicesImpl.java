package com.cg.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.dao.MovieDao;
import com.cg.movie.dao.SongDao;
import com.cg.movie.exceptions.MovieDetailsNotFoundException;
import com.cg.movie.exceptions.SongDetailsNotFoundException;

@Component("movieServices")
public class MovieServicesImpl implements MovieServices{
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private SongDao songDao;

	@Override
	public Movie acceptMovieDetails(Movie movie) {
		movie=movieDao.save(movie);
		return movie;
	}

	@Override
	public Song acceptSongDetails(Song song) {
       song=songDao.save(song);
		return song;
	}

	@Override
	public Movie getMovieDetails(int movieId) throws MovieDetailsNotFoundException {
		return movieDao.findById(movieId).orElseThrow(()->new MovieDetailsNotFoundException("Movie details not found for id"+movieId));
	}

	@Override
	public Song getSongDetails(int songId) throws SongDetailsNotFoundException {
		return songDao.findById(songId).orElseThrow(()->new SongDetailsNotFoundException("Song details not found for id"+songId));

	}

	@Override
	public List<Song> getAllSongDetails() {
		return songDao.findAll();

	}

	@Override
	public boolean removeSongDetails(int songId) throws SongDetailsNotFoundException {
		songDao.delete(getSongDetails(songId));
		 return true;
	}

}
