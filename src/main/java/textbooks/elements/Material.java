package textbooks.elements;

import exception.WrongInputException;

public enum Material {
    GLOSS("gloss"),
    PAPER("paper");
    private String material_s;

    Material(String material_s) { this.material_s = material_s; }

    public String getMaterial_s() {
        return material_s;
    }

    public static Material getTypeByUrl(String url) throws WrongInputException {
        for (Material env : values()) {
            if (env.getMaterial_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No material found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Material: " + material_s.toUpperCase() + "\t";
    }
}


