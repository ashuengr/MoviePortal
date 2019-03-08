package com.cg.movie.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int songId;
	private String songName;
	private String songType;
	private String singerName;
	@ManyToOne
	private Movie movie;
	public Song() {}
	public Song(int songId, String songName, String songType, String singerName, Movie movie) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.songType = songType;
		this.singerName = singerName;
		this.movie = movie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((movie == null) ? 0 : movie.hashCode());
		result = prime * result + ((singerName == null) ? 0 : singerName.hashCode());
		result = prime * result + songId;
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		result = prime * result + ((songType == null) ? 0 : songType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (movie == null) {
			if (other.movie != null)
				return false;
		} else if (!movie.equals(other.movie))
			return false;
		if (singerName == null) {
			if (other.singerName != null)
				return false;
		} else if (!singerName.equals(other.singerName))
			return false;
		if (songId != other.songId)
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		if (songType == null) {
			if (other.songType != null)
				return false;
		} else if (!songType.equals(other.songType))
			return false;
		return true;
	}
	public int getSongId() {
		return songId;
	}
	public void setSongId(int songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongType() {
		return songType;
	}
	public void setSongType(String songType) {
		this.songType = songType;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", songType=" + songType + ", singerName=" + singerName
				+ ", movie=" + movie + "]";
	}

}
