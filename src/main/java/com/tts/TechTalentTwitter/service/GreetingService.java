package com.tts.TechTalentTwitter.service;

import com.tts.TechTalentTwitter.model.Greeting;

public interface GreetingService {

    //this is the contract that anyone who implements GreetingService must fulfill
    Greeting getGreeting();

}