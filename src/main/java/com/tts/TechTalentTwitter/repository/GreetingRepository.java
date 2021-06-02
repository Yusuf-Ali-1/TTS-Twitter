package com.tts.TechTalentTwitter.repository;


import com.tts.TechTalentTwitter.model.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Long> {
}