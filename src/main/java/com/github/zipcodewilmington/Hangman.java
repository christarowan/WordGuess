package com.github.zipcodewilmington;

// Christa Law

import java.util.Scanner;
import java.lang.Math;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */

public class Hangman {

    public static void main(String[] args) {

        while (true) {

            String[] wordList = {"cat", "dog", "fox", "pig", "hen"};
            String word = wordList[(int) (Math.random() * 5)];


            int numberOfTries = 0;
            int triesAllowed = word.length();
            char letterGuessed;
            boolean notDone = false;
            boolean won = false;

            Scanner sc = new Scanner(System.in);
            System.out.println("Hello, let's play Hangman.");               //Add outer loop asking if the player would like to play again.
            char[] currentGuess = "---".toCharArray();

            while (numberOfTries < triesAllowed) {

                System.out.println("Please guess a letter:");
                letterGuessed = sc.next().charAt(0);
                if (word.indexOf(letterGuessed) > -1) {
                    currentGuess[word.indexOf(letterGuessed)] = letterGuessed;
                    System.out.println("Yes, that is correct.");
                } else {
                    System.out.println("That letter is not in this word.");
                }
                System.out.println(currentGuess);
                for (char c : currentGuess) {
                    // System.out.println(c == '-');
                    notDone = false;
                    if (c == '-') {
                        notDone = true;
                        break;
                    }
                }
                if (notDone == false) {
                    won = true;
                    System.out.println("Congratulations,you guessed the word!");
                    break;
                }
                numberOfTries++;
            }
            if (won == false) {
                System.out.println("Sorry, you are out of guesses, you lost this game.");
            }
            System.out.println("Would you like to play again? (y/n)");
            String response = sc.next();
            if (!response.equals("y")) {break;}
        }

    }
}
