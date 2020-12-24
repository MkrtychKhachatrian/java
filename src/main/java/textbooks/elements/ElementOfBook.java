package textbooks.elements;

import textbooks.Display;

public abstract class ElementOfBook implements Display {
    private Color color;
    private Material material;
    private Size size;

    protected ElementOfBook(Color color1, Material material1, Size size1) {
        this.color = color1;
        this.material = material1;
        this.size = size1;
    }

    @Override
    public void display(){
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(color).append(" ")
                .append(material).append(" ")
                .append(size));
    };
}
