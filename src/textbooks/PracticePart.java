package textbooks;

import textbooks.elements.*;
import textbooks.type.TypeOfPracticePart;

public class PracticePart extends ElementOfBook implements Display {
    private TypeOfPracticePart typeOfPracticePart;

    public PracticePart(Color color1, Material material1, Size size1, TypeOfPracticePart typeOfPracticePart1) {
        super(color1, material1, size1);
        this.typeOfPracticePart = typeOfPracticePart1;
    }


    public String getTypeOfPracticePart() {
        return typeOfPracticePart.getPractice_s();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        PracticePart guest = (PracticePart) obj;
        return typeOfPracticePart == guest.typeOfPracticePart;
    }


    @Override
    public void display() {
        System.out.println("Practice part: ");
        super.display();
        System.out.println("Type of Practice part: " + typeOfPracticePart);
    }
}
