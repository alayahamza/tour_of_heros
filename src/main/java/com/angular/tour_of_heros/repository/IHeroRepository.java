package com.angular.tour_of_heros.repository;

import com.angular.tour_of_heros.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<Hero, Integer> {
    Hero findByName(String name);
}
