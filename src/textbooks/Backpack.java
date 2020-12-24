package textbooks;

import java.util.*;

public class Backpack implements Display {
    private ArrayList<Textbook> textbooks;

    public Backpack(ArrayList<Textbook> textbooks) {
        this.textbooks = new ArrayList<>();
        this.textbooks = textbooks;
    }

    @Override
    public void display() {
        ListIterator<Textbook> lookListIterator = textbooks.listIterator();
        while (lookListIterator.hasNext()){
            lookListIterator.next().display();
        }
    }

    public ArrayList<Textbook> getTextbooks() {
        return textbooks;
    }

}
