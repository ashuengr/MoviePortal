package com.cg.movie.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.movie.beans.Movie;

public interface MovieDao extends JpaRepository<Movie,Integer>{

}
