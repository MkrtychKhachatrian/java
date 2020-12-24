package textbooks.type;

import exception.WrongInputException;

public enum TypeOfTheoryPart {
    LECTURES("lectures"),
    DOCUMENTATION("documentation"),
    MANUAL("manual");

    private String theory_s;

    TypeOfTheoryPart(String theory_s) { this.theory_s = theory_s; }

    public String getTheory_s() {
        return theory_s;
    }

    public static TypeOfTheoryPart getTypeByUrl(String url) throws WrongInputException {
        for (TypeOfTheoryPart env : values()) {
            if (env.getTheory_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No enum found with url: [" + url + "]");
    }
}
