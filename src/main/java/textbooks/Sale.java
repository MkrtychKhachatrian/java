package textbooks;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sale implements Display{
    private String nameSale;

    private static final Logger logger = LogManager.getLogger(Sale.class);

    public Sale(String nameSale){
        this.nameSale = nameSale;
    }

    public void changePrice(Textbook textbook, float newPrice){
        textbook.setPrice(newPrice);
    }

    @Override
    public void display() {
        logger.info(nameSale);
    }
}
