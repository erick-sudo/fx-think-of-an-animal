package com.animal.guessing;

public class Game {

    private DecisionTree tree;

    private IView view;

    public Game(IView view) {
        this.view = view;
    }

    public void play() {
        help(); // Display the help message
        boolean again = true;
        while(again) {
            if(view.choose("is your animaal a cat?")) {
                again = view.choose("I won! Play again?");
            } else {
                again = view.choose("You won! Play again?");
            }
        }
    }

    public void load(String fname) throws Exception {

    }

    public void save(String fname) throws Exception {

    }

    public String display() {
        return null;
    }

    private void help() {
        String helpMessage = "Think of an animal.If my tree is non-empty, I will ask some yes/no questions to try to determine what it is.";

    }
}
