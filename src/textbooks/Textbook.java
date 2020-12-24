package textbooks;

import exception.WrongInputException;
import textbooks.elements.*;
import textbooks.type.*;


import java.util.Objects;
//import java.util.Scanner;

public  class Textbook implements Display {
    private TheoryPart theoryPart;
    private PracticePart practicePart;
    private String name;
    private String author;
    private String subject;
    private int pages;
    private float price;



    public Textbook(String name, String author, String subject, int pages, float price, TheoryPart theoryPart1, PracticePart practicePart1) {
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.pages = pages;
        this.price = price;
        this.theoryPart = theoryPart1;
        this.practicePart = practicePart1;
    }

    public Textbook() {}

    void setPrice(float price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        Textbook guest = (Textbook) obj;
        return price == guest.price && (Objects.equals(name, guest.name)) && (Objects.equals(author, guest.author))
                && (Objects.equals(subject, guest.subject)) && pages == guest.pages
                && theoryPart.equals(guest.theoryPart) && practicePart.equals(guest.practicePart);
    }


   public void input(String str1) throws WrongInputException{
       /*Scanner in = new Scanner(System.in);
       System.out.println("You can set info for textbook. Enter it in format: ");
       System.out.println("name/author/subject/pages/price/color/material/size/TypeOfTheoryPart/color/material/size/TypeOfPracticePart");*/
        String str = str1;
        try {
            //String str = in.nextLine();
            String tmp[] = str.split("/", 13);
            if (tmp.length < 13) throw new WrongInputException("Not all data entered");
            this.name = tmp[0];
            this.author = tmp[1];
            this.subject = tmp[2];
            this.pages = Integer.valueOf(tmp[3]);
            this.price = Float.valueOf(tmp[4]);
            this.theoryPart = new TheoryPart(Color.getTypeByUrl(tmp[5]), Material.getTypeByUrl(tmp[6]), Size.getTypeByUrl(tmp[7]), TypeOfTheoryPart.getTypeByUrl(tmp[8]));
            this.practicePart = new PracticePart(Color.getTypeByUrl(tmp[9]), Material.getTypeByUrl(tmp[10]), Size.getTypeByUrl(tmp[11]), TypeOfPracticePart.getTypeByUrl(tmp[12]));
        }
        catch (WrongInputException e) {
            System.out.println(e);
            throw e;
        }
    }

    @Override
    public void display() {
        System.out.println("name: " + name);
        System.out.println("author: " + author);
        System.out.println("subject: " + subject);
        System.out.println("pages: " + pages);
        System.out.println("price: " + price);
        theoryPart.display();
        practicePart.display();
        System.out.println("_______________________________________");
    }

    public String getTheoryPart() {
        return theoryPart.getTypeOfTheoryPart();
    }

    public float getPrice() {
        return price;
    }

    public boolean isExpensive () {
        return price > 200 ? true : false;
    }


    public static class Textbook1{
        private TheoryPart theoryPart;
        private String name;
        public Textbook1(String name1, TheoryPart theoryPart1) {
            this.name = name1;
            this.theoryPart = theoryPart1;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) { return true; }
            if (obj == null || obj.getClass() != this.getClass()) { return false; }
            Textbook.Textbook1 guest = (Textbook.Textbook1) obj;
            return (Objects.equals(name, guest.name)) && theoryPart.equals(guest.theoryPart);
        }

        public void display(){
            System.out.println("Name: " + name);
            theoryPart.display();
            System.out.println("_______________________________________");
        }
    }
}
