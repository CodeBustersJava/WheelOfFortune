package com.codebuster.puzzle;

import com.codebuster.game.Game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Puzzle {
    public static String currentPhrase;
    public static String currentCategory;
    public static boolean solvedPuzzle = false;
    public static List<Character> guessedRightLetters = new ArrayList<>();
    public static List<String> consonants = Arrays.asList("B", "C", "D", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T", "V", "W", "X", "Z", "Y");
    public static List<String> vowels = Arrays.asList("A", "E", "I", "O", "U");
    List<String> Occupation = Arrays.asList("DOCTOR", "TEACHER", "DOG WALKER", "SOFTWARE DEVELOPER", "MUSICIAN", "FILM PRODUCER");
    List<String> Quotations = Arrays.asList("IT IS RAINING CATS AND DOGS", "HASTA LA VISTA BABY", "A PARTY WITHOUT CAKE IS JUST A MEETING", "TALK IS CHEAP SHOW ME THE CODE");
    List<String> Amazon_Leadership_Principles = Arrays.asList("DIVE DEEP", "CUSTOMER OBSESSION", "ARE RIGHT A LOT", "OWNERSHIP", "LEARN AND BE CURIOS", "THINK BIG", "INSIST ON HIGHEST STANDARDS",
            "INVENT AND SIMPLIFY", "HIRE AND DEVELOP THE BEST", "BIAS FOR ACTION", "EARN TRUST", "FRUGALITY", "HAVE BACKBONE DISAGREE AND COMMIT", "DELIVER RESULTS");
    List<String> Categories = Arrays.asList("Occupation", "Quotations", "Amazon Leadership Principles");

    public String randomPhrase() {
        //shuffle and get the first category.
        Collections.shuffle(Categories);
        currentCategory = Categories.get(0);

        if (currentCategory.equalsIgnoreCase("Occupation")) {
            Collections.shuffle(Occupation);
            currentPhrase = Occupation.get(0);
        } else if (currentCategory.equalsIgnoreCase("Quotations")) {
            Collections.shuffle(Quotations);
            currentPhrase = Quotations.get(0);
        } else if (currentCategory.equalsIgnoreCase("Amazon Leadership Principles")) {
            Collections.shuffle(Amazon_Leadership_Principles);
            currentPhrase = Amazon_Leadership_Principles.get(0);
        }
        return currentPhrase;
    }

    public static String showPuzzle() {
        char[] puzzle = currentPhrase.toCharArray();
        StringBuilder currentPuzzle = new StringBuilder();
        //iterate through each letter in puzzle
        for (char letter : puzzle) {
            if (guessedRightLetters.contains(letter)) {
                currentPuzzle.append(letter);
            } else if (letter == ' ') {
                currentPuzzle.append(" ");
            } else {
                currentPuzzle.append("_");
            }
        }
        return currentPuzzle.toString();
    }

        public static void solvePuzzle(String input) {
        if (input.equals(currentPhrase)) {
            System.out.println("Congratulations, you won!!! Collect your $5000 reward");
            int totalWinnings = Game.currentPlayer.roundEarningsMoney;
            totalWinnings += 5000;
            System.out.println("Your prize money is $" + totalWinnings);
            System.out.println("Your prizes ");
            Game.currentPlayer.getRoundEarningsPrize();
            solvedPuzzle = true;
        } else {
            System.out.println("You guessed wrong, better luck next time!");
            Game.getTheNextPlayer();
        }
    }
}


//    //FIELDS or INSTANCE VARIABLES
//    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//    private Category category; // Category Enum
//
//    List<String> list =
//            Arrays.asList(new String[]{"Hasta La Vista Baby!", Category.QUOTATION.toString(),
//                    "It's Raining It's Pouring", Category.QUOTATION.toString(),
//                    "A party without cake is just a meeting", Category.QUOTATION.toString(),
//                    "Amazon River", Category.LANDMARK.toString(),
//                    "Grand Teton National Park", Category.LANDMARK.toString(),
//                    "Golden Gate Bridge", Category.LANDMARK.toString(),
//                    "A Bowl of Warm Corned Beef and Cabbage", Category.FOOD_AND_DRINKS.toString(),
//                    "Alfalfa Sprouts", Category.FOOD_AND_DRINKS.toString(),
//                    "Assorted Peppermint Sticks", Category.FOOD_AND_DRINKS.toString(),
//                    "Antique Furniture Restorer", Category.OCCUPATION.toString(),
//                    "Certified Yoga Instructor", Category.OCCUPATION.toString(),
//                    "DEA Agent", Category.OCCUPATION.toString(),
//                    "Dance the Night Away by Van Halen", Category.SONG_ARTIST.toString(),
//                    "My Generation by The Who", Category.SONG_ARTIST.toString(),
//                    "Red White and Blue by Lynyrd Skynyrd", Category.SONG_ARTIST.toString(),
//                    "Bringing Laundry Home to mom and dad", Category.COLLEGE_LIFE.toString(),
//                    "Falling Asleep in the Library", Category.COLLEGE_LIFE.toString(),
//                    "Playing in the Marching Band", Category.COLLEGE_LIFE.toString(),
//                    "Automatic Garage Door Opener", Category.AROUND_THE_HOUSE.toString(),
//                    "Broadband Internet Connection", Category.AROUND_THE_HOUSE.toString(),
//                    "Ceramic Incense Burner", Category.AROUND_THE_HOUSE.toString(),
//                    "Luke Skywalker", Category.CHARACTER.toString(),
//                    "Mr Magoo", Category.CHARACTER.toString(),
//                    "Princess Leia", Category.CHARACTER.toString(),
//                    "Long Clawed Marsupial Mouse", Category.LIVING_THING.toString(),
//                    "Hummingbird", Category.LIVING_THING.toString(),
//                    "Living Fossil", Category.LIVING_THING.toString(),
//                    "Amazing Performers", Category.PEOPLE.toString(),
//                    "Award Nominees", Category.PEOPLE.toString(),
//                    "Clockmakers", Category.PEOPLE.toString(),
//                    "Aspen Colorado", Category.ON_THE_MAP.toString(),
//                    "Argentine Patagonia", Category.ON_THE_MAP.toString(),
//                    "Cape Town South Africa", Category.ON_THE_MAP.toString(),
//
//            });
//
//
//    //CONSTRUCTORS
//
//    public Puzzle() {
//    }
//
//    public Puzzle(String[] list, Category category) {
//        setList(String[]list);
//        setCategory(category);
//    }
//
//    //ACCESSOR METHODS
//
//    public char[] getLetters() {
//        return letters;
//    }
//
//    public void setLetters(char[] letters) {
//        this.letters = letters;
//    }
//
//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public ArrayList<String> getList() {
//        return list;
//    }
//
//    public void setList(ArrayList<String> list) {
//        this.list = list;
//    }
//}