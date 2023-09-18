package com.animal.guessing;

public class Game {

    private DecisionTree tree;

    private IView view;

    public Game(IView view) {
        this.view = view;
        AnimalBehaviour animalBehaviour = new AnimalBehaviour(this.view);
        this.tree = new DecisionTree(animalBehaviour);
    }

    public void play() {
        help(); // Display the help message
        boolean again = true;
        while(again) {
            if(tree.execute()) {
                again = view.choose("I won! Play again?");
            } else {
                again = view.choose("You won! Play again?");
            }
        }
    }

    public void load(String fname) throws Exception {
        view.display("Load: Under Development");
    }

    public void save(String fname) throws Exception {
        view.display("Save: Under Development");
    }

    public String display() {
        view.display("DecisionTree: Under Development");
        return "";
    }

    private void help() {
        String helpMessage = "Think of an animal.If my tree is non-empty, I will ask some yes/no questions to try to determine what it is.";
        view.display(helpMessage);
    }
}
