package run;

import textbooks.*;
import textbooks.elements.*;
import textbooks.type.TypeOfPracticePart;
import textbooks.type.TypeOfTheoryPart;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {
        ArrayList<Textbook> textbooks = new ArrayList<>();
        Textbook tb1 = new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 250,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS));
        tb1.display();

        Sale sale1 = new Sale("Knowledge Day");
        sale1.changePrice(tb1, 280);
        System.out.println("Price changed on knowledge day: " + tb1.getPrice() + "\n\n");

        Textbook.Textbook1 tb2 = new Textbook.Textbook1("Tech",
                new TheoryPart(Color.BLUE, Material.GLOSS, Size.A5, TypeOfTheoryPart.LECTURES));
        tb2.display();

        /*Textbook.Textbook1 tb22 = new Textbook.Textbook1("Tech",
                new TheoryPart(Color.BLUE, Material.GLOSS, Size.A5, TypeOfTheoryPart.LECTURES));

        System.out.println(tb2.equals(tb22));*/


        Textbook tb3 = new Textbook();
        Scanner in = new Scanner(System.in);
        System.out.println("You can set info for textbook. Enter it in format: ");
        System.out.println("name/author/subject/pages/price/color/material/size/TypeOfTheoryPart/color/material/size/TypeOfPracticePart");
        String str = in.nextLine();
        tb3.input(str);
        tb3.display();


        Textbook tb4 = new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 280,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS));

        textbooks.add(tb1);
        textbooks.add(tb3);
        textbooks.add(tb4);

        Backpack backpack1 = new Backpack(textbooks);
        System.out.println("Here is out Backpack: \n------------------------\n");
        backpack1.display();

        System.out.println(tb1.equals(tb4));
    }

}
