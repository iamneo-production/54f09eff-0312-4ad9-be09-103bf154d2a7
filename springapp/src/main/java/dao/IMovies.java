package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Movies;

public interface IMovies extends JpaRepository<Movies,Integer>{

}
