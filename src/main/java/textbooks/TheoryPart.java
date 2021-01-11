package textbooks;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import textbooks.elements.*;
import textbooks.type.TypeOfTheoryPart;
import java.util.Objects;

public class TheoryPart extends ElementOfBook implements Display {
    private TypeOfTheoryPart typeOfTheoryPart;
    private static final Logger logger = LogManager.getLogger(TheoryPart.class);

    public TheoryPart(Color color1, Material material1, Size size1, TypeOfTheoryPart typeOfTheoryPart1) {
        super(color1, material1, size1);
        this.typeOfTheoryPart = typeOfTheoryPart1;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null || obj.getClass() != this.getClass()) { return false; }
        TheoryPart guest = (TheoryPart) obj;
        return typeOfTheoryPart == guest.typeOfTheoryPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfTheoryPart);
    }

    @Override
    public void display() {
        logger.info("Theory part: ");
        super.display();
        logger.info("Type of Theory part: " + typeOfTheoryPart);
    }
}
