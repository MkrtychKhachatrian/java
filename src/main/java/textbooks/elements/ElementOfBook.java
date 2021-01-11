package textbooks.elements;

import textbooks.Display;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class ElementOfBook implements Display {

    private Color color;
    private Material material;
    private Size size;
    private static final Logger logger = LogManager.getLogger(ElementOfBook.class);

    protected ElementOfBook(Color color1, Material material1, Size size1) {
        this.color = color1;
        this.material = material1;
        this.size = size1;
    }

    @Override
    public void display(){
        StringBuilder sb = new StringBuilder();
        logger.info(sb.append(color).append(" ")
                .append(material).append(" ")
                .append(size));
    }
}
