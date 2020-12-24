package textbooks.type;

import exception.WrongInputException;

public enum TypeOfPracticePart {
    TASKS("tasks"),
    LABS("labs"),
    TESTS("tests");

    private String practice_s;

    TypeOfPracticePart(String practice_s) { this.practice_s = practice_s; }

    public String getPractice_s() {
        return practice_s;
    }

    public static TypeOfPracticePart getTypeByUrl(String url) throws WrongInputException {
        for (TypeOfPracticePart env : values()) {
            if (env.getPractice_s().equals(url)) {
                return env;
            }
        }
        throw new WrongInputException("No enum found with url: [" + url + "]");
    }
}
