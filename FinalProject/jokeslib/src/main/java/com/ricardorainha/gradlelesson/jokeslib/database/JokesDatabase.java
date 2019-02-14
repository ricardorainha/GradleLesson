package com.ricardorainha.gradlelesson.jokeslib.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokesDatabase {

    private static Random RANDOM = new Random();
    private static List<String> jokes = new ArrayList<>();
    static {
        jokes.add("Did you hear about the monkeys who shared an Amazon account?\nThey were Prime mates.");
        jokes.add("Don't use \"beef stew\" as a computer password.\nIt's not stroganoff.");
        jokes.add("Have you heard of that new band \"1023 Megabytes\"?\nThey're pretty good, but they don't have a gig just yet.");
        jokes.add("PATIENT: Doctor, I need your help. I'm addicted to checking my Twitter!\nDOCTOR: I'm so sorry, I don't follow.");
        jokes.add("Q: What is the biggest lie in the entire universe?\nA: \"I have read and agree to the Terms & Conditions.\"");
        jokes.add("Q: What do you call it when you have your mom's mom on speed dial?\nA: Instagram.");
        jokes.add("Q: What should you do after your Nintendo game ends in a tie?\nA: Ask for a Wii-match!");
        jokes.add("Q: How does a computer get drunk?\nA: It takes screenshots.");
        jokes.add("Q: Why did the PowerPoint Presentation cross the road?\nA: To get to the other slide.");
        jokes.add("Q: Why did the computer show up at work late?\nA: It had a hard drive.");
    }

    public static String getRandomJoke() {
        return jokes.get(RANDOM.nextInt(jokes.size()));
    }
}
