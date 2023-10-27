package com.spring.mongo.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.mongo.demo.model.Home;
import com.spring.mongo.demo.model.HomeStats;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HomeController {

	@Autowired
	private HomeService homeService;

	@GetMapping("/get-all")
	public List<Home> getAll() {
		return homeService.getAll();
	}

	@PostMapping("/create-home")
	public Home createHome(@RequestBody Home home){
		return homeService.createHome(home);
	}

	@DeleteMapping("/delete-by-id/{id}")
	public String deleteById(@PathVariable String id){
		homeService.removeHomeById(id);
		return "Home with " + id + " deleted";
	}

	@GetMapping("/get-by-type/{type}")
	public List<Home> getByType(@PathVariable String type){
		return homeService.findHomeByType(type);
	}

	@PutMapping("/change-city/{index}")
		public Home changeCityByIndex(@PathVariable int index, @RequestParam String city){

		return homeService.updateCity(index, city);
	}

	@GetMapping("/get-count-by-city/{city}")
	public int getCountByCity(@PathVariable String city){
		return homeService.getCountByCity(city);
	}

	@GetMapping("/get-info-by-type")
	public List<HomeStats> getInfoStats(){
		return homeService.getHomeStatsByTypeAndSquare();
	}

	@GetMapping("/get-by-id/{id}")
	public Optional<Home> getHomeById(@PathVariable String id){
		return homeService.findById(id);
	}

	@DeleteMapping("/delete-by-owner")
	public Map<String, String> deleteByOwner(@RequestBody Owner owner){
		Map<String, String> result = homeService.deleteByOwner(owner);
		return result;
	}
}
