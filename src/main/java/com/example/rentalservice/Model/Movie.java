package com.example.rentalservice.Model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("data of Movie")
public class Movie {
    @ApiModelProperty("unique id of Movie")
    private Integer id;
    @ApiModelProperty("Name of Movie")
    private String name;
    private MovieCategory category;
    private Boolean isAvailable;

    public Movie(String name, MovieCategory category) {
        this.name = name;
        this.category = category;
        this.isAvailable = false;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public MovieCategory  getCategory() {
        return category;
    }
    public void setCategory(MovieCategory categorycategory) {
        this.category = category;
    }
    public Movie(Integer id, String name, MovieCategory  category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    public Movie( String name) {
        this.name = name;
    }
    public Movie() {

    }



}
