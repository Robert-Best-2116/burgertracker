package com.robertbest.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robertbest.burgertracker.models.Burger;
import com.robertbest.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> allBurgers(){
		return burgerRepository.findAll();
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;
	}
	
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
	
	

}
