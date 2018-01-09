package com.angular.tour_of_heros.controller;

import com.angular.tour_of_heros.model.Hero;
import com.angular.tour_of_heros.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HeroController {

    @Autowired
    private HeroService heroService;

    @GetMapping(value = "/heroes")
    public List<Hero> all() {
        return heroService.fetchAllHeros();
    }

    @GetMapping(value = "/hero/{id}")
    public Hero byIdVariable(@PathVariable("id") int id) {
        return heroService.fetchHeroById(id);
    }

    @GetMapping(value = "/hero")
    public Hero byName(@RequestParam("name") String name) {
        return heroService.fetchHeroByName(name);
    }

    @PostMapping(value = "/hero")
    public void addHero(@RequestBody Hero hero) {
        heroService.addHero(hero);
    }

    @PutMapping(value = "/hero")
    public void updateHero(@RequestBody Hero hero) {
        heroService.updateHero(hero);
    }

    @DeleteMapping(value = "/hero/{id}")
    public void deleteHero(@PathVariable("id") int id) {
        heroService.deleteHero(id);
    }

}
