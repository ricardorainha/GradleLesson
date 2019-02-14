package com.ricardorainha.gradlelesson.jokeslib;

import com.ricardorainha.gradlelesson.jokeslib.database.JokesDatabase;

public class JokeFactory {

    public static String getJoke() {
        return JokesDatabase.getRandomJoke();
    }

}
