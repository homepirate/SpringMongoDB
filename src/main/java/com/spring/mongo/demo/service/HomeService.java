package com.spring.mongo.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.mongo.demo.model.Home;
import com.spring.mongo.demo.model.HomeStats;
import com.spring.mongo.demo.model.Owner;

public interface HomeService {
	
	List<Home> getAll();

	Home createHome(Home home);

	void removeHomeById(String id);

	List<Home> findHomeByType(String type);

	Home updateCity(int index, String city);

	int getCountByCity(String city);
	List<HomeStats> getHomeStatsByTypeAndSquare();

	Optional<Home> findById(String s);

	Map<String, String> deleteByOwner(Owner owner);
}
