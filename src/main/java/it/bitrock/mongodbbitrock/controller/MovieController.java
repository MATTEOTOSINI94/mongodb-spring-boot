package it.bitrock.mongodbbitrock.controller;

import it.bitrock.mongodbbitrock.dto.MovieDTO;


import it.bitrock.mongodbbitrock.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/find-all-movies")
      public ResponseEntity<Page<MovieDTO>> findAllMoviesPaginate(@RequestParam(defaultValue = "1") Integer page){
        return movieService.findAllMoviePaginate(page);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<MovieDTO> findMovieById(@PathVariable String id){
        return movieService.findMovieById(id);
    }

    @GetMapping("/movie")
    public ResponseEntity<MovieDTO> findMovieByTitle(@RequestParam String title){
        return movieService.findMovieByTitle(title);
    }

    @GetMapping("/movies-by-comment")
    public ResponseEntity<List<MovieDTO>> findMoviesByCommentEmail(@RequestParam String email){
        return movieService.findMoviesByCommentEmail(email);
    }

    @GetMapping("/movie-by-comment")
    public ResponseEntity<MovieDTO> findMovieByComment(String id){
        return movieService.findMovieByCommentId(id);
    }


    @GetMapping("/movies-by")
    public ResponseEntity<List<MovieDTO>> findMovieByRatingNumReviews(@RequestParam Double rating,@RequestParam Double numReviews){
        return movieService.findMovieByRatingNumReviews(rating,numReviews);
    }

}
