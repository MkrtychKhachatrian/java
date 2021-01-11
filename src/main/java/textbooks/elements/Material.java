package textbooks.elements;

import exception.WrongInputException;

public enum Material {
    GLOSS("gloss"),
    PAPER("paper");
    private String materials;

    Material(String materials) { this.materials = materials; }

    public String getMaterials() {
        return materials;
    }

    public static Material getTypeByUrl(String url) throws WrongInputException {
        for (Material env : values()) {
            if (env.getMaterials().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No material found with url: [" + url + "]");
    }

    @Override
    public String toString() {
        return "Material: " + materials.toUpperCase() + "\t";
    }
}


