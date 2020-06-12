package br.com.caririflix.web.service;

import br.com.caririflix.web.DAO.MoviesDAO;
import br.com.caririflix.web.model.Movies;
import br.com.caririflix.web.util.exceptions.CaririFlixException;


public class MoviesService {
    MoviesDAO moviesDAO =  new MoviesDAO();
    
    public void save(Movies movies)throws CaririFlixException{
        if(movies.getName() == null || movies.getName().isEmpty())
            throw new CaririFlixException("Por favor insira o nome Filme");

        if(movies.getGenre() == null || movies.getGenre().isEmpty())
            throw new CaririFlixException("Por favor insira o Gênero");

        if(movies.getRelease_date()== null || movies.getRelease_date().isEmpty())
            throw new CaririFlixException("Por favor insira a Data de Lançamento");

        if(movies.getDirection()== null || movies.getDirection().isEmpty())
            throw new CaririFlixException("Por favor insira os Responsaveis pela Direção");

        if(movies.getSynopsis()== null || movies.getSynopsis().isEmpty())
            throw new CaririFlixException("Por favor insira uma Sinopse");
            moviesDAO.save(movies);
    }
    
}