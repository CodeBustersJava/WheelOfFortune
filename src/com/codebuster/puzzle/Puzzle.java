package com.codebuster.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.codebuster.enums.Category;

public class Puzzle {
    public static String currentPhrase;

    List<String> Occupation = Arrays.asList("Doctor", "Teacher", "Dog_Walker", "Software_Developer", "Musician", "Film_Producer");
    List<String> Quotations = Arrays.asList("It's raining cats and dogs", "Hasta La Vista Baby", "A party without cake is just a meeting", "Talk is cheap, show me the code", "Musician", "Film_Producer");
    List<String> Amazon_Leadership_Principles = Arrays.asList("Dive Deep", "Costumer Obsession", "Are Right, A Lot", "Ownership", "Learn and Be Curios", "Think Big", "Insist on Highest Standards", "Invent and Simplify", "Hire and Develop the Best", "Bias for Action", "Earn Trust", "Frugality", "Have Backbone Disagree and Commit", "Deliver Results");
    List<String> Categories = Arrays.asList("Occupation", "Quotations", "Amazon_Leadership_Principles");

    public String randomPhrase() {
        //shuffle and get the first category.
        Collections.shuffle(Categories);
    String currentCategory = Categories.get(0);

    if(currentCategory.equalsIgnoreCase("Occupation")){
        Collections.shuffle(Occupation);
        currentPhrase = Occupation.get(0);
        System.out.println(currentPhrase);
    } else if(currentCategory.equalsIgnoreCase("Quotations")){
        Collections.shuffle(Quotations);
        currentPhrase = Quotations.get(0);
    } else if(currentCategory.equalsIgnoreCase("Amazon_Leadership_Principles")){
        Collections.shuffle(Amazon_Leadership_Principles);
        currentPhrase = Amazon_Leadership_Principles.get(0);
    }
    return currentPhrase;
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