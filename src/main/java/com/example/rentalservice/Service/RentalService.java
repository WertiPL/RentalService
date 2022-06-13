package com.example.rentalservice.Service;

import com.example.rentalservice.Model.Movie;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


//https://www.baeldung.com/rest-template 5,3
@Service
public class RentalService {
    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private final RestTemplate restTemplate;

    HttpEntity<Movie> request = new HttpEntity<>(new Movie("movie"));

    public Movie getMovie(Long id){
        return restTemplate.getForObject("http://localhost:8080/movie/{id}", Movie.class, id);
    }
    public ResponseEntity<Movie> rentMovie(Long id){
        return restTemplate.exchange("http://localhost:8080/movie/updateStatus/{id}", HttpMethod.PUT, request, Movie.class, id);
    }
    public ResponseEntity<Movie> returnMovie(Long id){
        return restTemplate.exchange("http://localhost:8080/movie/returnStatus/{id}", HttpMethod.PUT, request, Movie.class, id);
    }
}
