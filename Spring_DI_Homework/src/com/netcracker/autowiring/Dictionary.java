package com.netcracker.autowiring;

import org.springframework.beans.factory.annotation.Autowired;

public class Dictionary {
    private int speakingPeople;

    //@Autowired
    //uncomment when use byName autowiring
    private Language language;

    //@Autowired
    //uncomment annotation when use byType or constructor autowiring
    public Dictionary(int speakingPeople, Language language) {
        this.speakingPeople = speakingPeople;
        this.language = language;
    }

    public Dictionary() {
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getSpeakingPeople() {
        return speakingPeople;
    }

    public void setSpeakingPeople(int speakingPeople) {
        this.speakingPeople = speakingPeople;
    }

}
