package textbooks.elements;

import exception.WrongInputException;

public enum Color {
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow"),
    GREEN("green");
    private String color_s;

    Color(String color_s) {
        this.color_s = color_s;
    }

    public String getColor_s() {
        return color_s;
    }

    public static Color getTypeByUrl(String url) throws WrongInputException {
        for (Color env : values()) {
            if (env.getColor_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No color found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Color: " + color_s.toUpperCase() + "\t";
    }
}
