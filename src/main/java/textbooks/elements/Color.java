package textbooks.elements;

import exception.WrongInputException;

public enum Color {
    RED("red"),
    BLUE("blue"),
    YELLOW("yellow"),
    GREEN("green");
    final String colors;

    Color(String colors) {
        this.colors = colors;
    }

    public String getColors() {
        return colors;
    }

    public static Color getTypeByUrl(String url) throws WrongInputException {
        for (Color env : values()) {
            if (env.getColors().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No color found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Color: " + colors.toUpperCase() + "\t";
    }
}
