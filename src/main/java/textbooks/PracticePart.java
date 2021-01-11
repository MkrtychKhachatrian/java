package textbooks;

import textbooks.elements.*;
import textbooks.type.TypeOfPracticePart;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Objects;

public class PracticePart extends ElementOfBook implements Display {
    private TypeOfPracticePart typeOfPracticePart;
    private static final Logger logger = LogManager.getLogger(PracticePart.class);

    public PracticePart(Color color1, Material material1, Size size1, TypeOfPracticePart typeOfPracticePart1) {
        super(color1, material1, size1);
        this.typeOfPracticePart = typeOfPracticePart1;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        PracticePart guest = (PracticePart) obj;
        return typeOfPracticePart == guest.typeOfPracticePart;
    }
    @Override
    public int hashCode() {
        return Objects.hash(typeOfPracticePart);
    }


    @Override
    public void display() {
        logger.info("Practice part: ");
        super.display();
        logger.info("Type of Practice part: " + typeOfPracticePart);
    }
}
