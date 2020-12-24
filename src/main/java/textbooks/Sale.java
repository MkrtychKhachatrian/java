package textbooks;

public class Sale implements Display{
    private String nameSale;

    public Sale(String nameSale){
        this.nameSale = nameSale;
    }

    public void changePrice(Textbook textbook, float newPrice){
        textbook.setPrice(newPrice);
    }

    @Override
    public void display() {
        System.out.println(nameSale);
    }
}
