package com.spring.mongo.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spring.mongo.demo.model.Home;
import com.spring.mongo.demo.model.HomeStats;
import com.spring.mongo.demo.model.Owner;
import com.spring.mongo.demo.repository.HomeRepository;
import com.spring.mongo.demo.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {
	@Autowired
	private HomeRepository repository;
	private final MongoTemplate mongoTemplate;

	public HomeServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<Home> getAll() {
		return repository.findAll();
	}

	@Override
	public Home createHome(Home home) {
		repository.save(home);
		return repository.findByIndex(home.getIndex());
	}

	@Override
	public void removeHomeById(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<Home> findHomeByType(String type) {
		return repository.findByType(type);
	}

	@Override
	public Home updateCity(int index, String city) {
		Home h = repository.findByIndex(index);
		h.setCity(city);
		repository.save(h);
		return repository.findByIndex(h.getIndex());
	}

	@Override
	public int getCountByCity(String city) {
		return repository.countByCity(city);
	}

	@Override
	public List<HomeStats> getHomeStatsByTypeAndSquare() {
		Aggregation aggregation = Aggregation.newAggregation(
				Aggregation.group("type")
						.sum("square").as("totalSquare")
						.count().as("count"),
				Aggregation.project()
						.andInclude("type", "totalSquare", "count"));

		AggregationResults<HomeStats> results = mongoTemplate.aggregate(
				aggregation, "home", HomeStats.class
		);

		return results.getMappedResults();
	}

	@Override
	public Optional<Home> findById(String s) {
		return repository.findById(s);
	}

	@Override
	public Map<String, String> deleteByOwner(Owner owner) {
		Map<String, String> result = new HashMap<>();
		boolean hasRecords = repository.existsByOwner(owner);
		if (hasRecords) {
			repository.deleteByOwner(owner);
			result.put("status", "OK");
			result.put("data", "Objects deleted");
		} else {
			result.put("data", "Owner not found");
			result.put("status", "FAIL");
		}
		return result;
	}
}