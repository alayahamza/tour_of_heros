package com.angular.tour_of_heros.exception;

public class HeroNotFoundException extends RuntimeException {
    public HeroNotFoundException(String msg) {
        super(msg);
    }
}
