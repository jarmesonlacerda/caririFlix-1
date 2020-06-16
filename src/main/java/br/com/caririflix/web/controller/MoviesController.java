package br.com.caririflix.web.controller;



import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caririflix.web.model.Movies;
import br.com.caririflix.web.service.MoviesService;

@Controller
@Path("/movies")
public class MoviesController {
    @Inject
    private Result result;
    @Inject
    private MoviesService moviesService;
    
    @Get ( " new " )
    public  void  create () {
        
    }
    
    @Post("")
    @IncludeParameters
    public void store(Movies movies) {          
        try {
            moviesService.save(movies);
            result.redirectTo(this); //Observação, Tiramos o get Customer
        } catch (Exception ex) {
            result.include(ex.getMessage());
            result.redirectTo(this).create();
        }    
    }

    @Post("update")
    public void update(Movies movies) {
        moviesService.update(movies);
        result.redirectTo(this);
    }

    @Get("id/{id}")
    public void getMoviesById(String id){
        Movies movies = moviesService.findById(id);    
        result.include("moviesToUpdate", movies);
        result.of(this).update(null);
    }    
    
    @Get("")
    public void getCustomers() {
       result.include("moviesList", moviesService.list());
    }
    
    @Post("remove")
    public void remove(String id){
        moviesService.delete(id);
        result.redirectTo(this).getCustomers();          
    }

}