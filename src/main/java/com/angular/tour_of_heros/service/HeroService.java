package com.angular.tour_of_heros.service;

import com.angular.tour_of_heros.exception.HeroNotFoundException;
import com.angular.tour_of_heros.model.Hero;
import com.angular.tour_of_heros.repository.IHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    @Autowired
    IHeroRepository heroRepository;

    public List<Hero> fetchAllHeros() {
        return heroRepository.findAll();
    }

    public Hero fetchHeroById(int id) {
        Hero one = heroRepository.findOne(id);
        if (one == null) {
            throw new HeroNotFoundException("Hero with id : " + id + " not found");
        }
        return one;
    }

    public Hero fetchHeroByName(String name) {
        return heroRepository.findByName(name);
    }

    public void addHero(Hero hero) {
        heroRepository.save(hero);
    }

    public void deleteHero(int id) {
        heroRepository.delete(id);
    }

    public void updateHero(Hero hero) {
        Hero heroToUpdate = heroRepository.findOne(hero.getId());
        if (heroToUpdate != null) {
            heroToUpdate.setName(hero.getName());
            heroRepository.save(heroToUpdate);
        }

    }
}
