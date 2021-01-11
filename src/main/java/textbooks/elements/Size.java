package textbooks.elements;

import exception.WrongInputException;

public enum Size {
    A4("A4"),
    SRA5("SRA5"),
    A5("A5");
    private String sizes;

    Size(String sizes) { this.sizes = sizes; }

    public String getSizes() {
        return sizes;
    }

    public static Size getTypeByUrl(String url) throws WrongInputException {
        for (Size env : values()) {
            if (env.getSizes().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No size found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Size: " + sizes.toUpperCase() + "\t";

    }
}
