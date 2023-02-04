package com.robertbest.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robertbest.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{

	List<Burger> findAll();
}
