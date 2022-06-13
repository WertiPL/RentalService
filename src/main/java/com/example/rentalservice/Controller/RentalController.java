package com.example.rentalservice.Controller;

import com.example.rentalservice.Model.Movie;
import com.example.rentalservice.Service.RentalService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class RentalController {

private final RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @ApiOperation(value = "Find Movie by id", notes = "provide information about Movie by id")
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Movie> getMovie(@ApiParam(value = "unique id of Movie", example = "1")@PathVariable("id") Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @ApiOperation(value = "Return movie to rental by id", notes = "Change isAvailable in database to false")
    @PutMapping (value = "/updateBack/{id}")
    public ResponseEntity<Movie> returnMovie(@ApiParam(value = "unique id of Movie", example = "1")@PathVariable("id") Long id) {
        return rentalService.returnMovie(id);
    }

    @ApiOperation(value = "Return movie to rental by id", notes = "Change isAvailable in database to true")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Movie> rentMovie(@ApiParam(value = "unique id of Movie", example = "1")@PathVariable("id") Long id) {
        return rentalService.rentMovie(id);
    }


}
