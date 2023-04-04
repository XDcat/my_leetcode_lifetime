package com.zlj.designpattern.proxy.dynamic;

public class MovieProxy implements Movie {
    private Movie movie;

    public MovieProxy(Movie movie) {
        this.movie = movie;
    }


    @Override
    public void play() {
        System.out.println("Hello everyone! Movie will begin!");
        movie.play();
        System.out.println("Movie is completed! Thanks!");
    }
}
