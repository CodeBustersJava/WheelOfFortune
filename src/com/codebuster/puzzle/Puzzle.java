package com.codebuster.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.codebuster.enums.Category;

public class Puzzle {

    //FIELDS or INSTANCE VARIABLES
    char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private Category category; // Category Enum

    List<String> list =
        Arrays.asList(new String[]{"Hasta La Vista Baby!", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
                   "It's Raining It's Pouring", Category.QUOTATION.toString(),
           });








    //CONSTRUCTORS

    public Puzzle() {
    }

    public Puzzle(String[] list, Category category) {
        setList(String[] list);
        setCategory(category);
    }

    //ACCESSOR METHODS

    public char[] getLetters() {
        return letters;
    }

    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}