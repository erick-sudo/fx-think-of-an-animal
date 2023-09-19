package com.animal.guessing;

public class AnimalBehaviour implements IBehaviour {

    private IView view;

    public AnimalBehaviour(IView view) {
        this.view = view;
    }

    @Override
    public Node emptyTree() {
        String newAnimal = view.ask("What is your animal?");
        return new Node(newAnimal);
    }

    @Override
    public boolean processNonLeafNode(Node n) {
        return view.choose(n.getData());
    }

    @Override
    public boolean processLeafNode(Node n) {
        String q = n.getQuestion();
        if(view.choose(q)){
            return false;
        } else {
            String newAnimal = view.ask("You win! What is your animal?");
            String newQuestion = view.ask(String.format(
                    "Provide a yes/no question that distinguishes between %s and %s.\nYes = %s; no = %s",
                    newAnimal,
                    n.getData(),
                    newAnimal,
                    n.getData()
            ));
            n.extend(newQuestion, n.getData(), newAnimal);

            return true;
        }
    }
}
