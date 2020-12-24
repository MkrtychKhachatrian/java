package textbooks;

import textbooks.elements.*;
import textbooks.type.TypeOfTheoryPart;

public class TheoryPart extends ElementOfBook implements Display {
    private TypeOfTheoryPart typeOfTheoryPart;

    public TheoryPart(Color color1, Material material1, Size size1, TypeOfTheoryPart typeOfTheoryPart1) {
        super(color1, material1, size1);
        this.typeOfTheoryPart = typeOfTheoryPart1;
    }


    public String getTypeOfTheoryPart() {
        return typeOfTheoryPart.getTheory_s();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        TheoryPart guest = (TheoryPart) obj;
        return typeOfTheoryPart == guest.typeOfTheoryPart;
    }

    @Override
    public void display() {
        System.out.println("Theory part: ");
        super.display();
        System.out.println("Type of Theory part: " + typeOfTheoryPart);
    }
}
