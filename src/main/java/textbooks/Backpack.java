package textbooks;

import textbooks.type.TypeOfTheoryPart;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Backpack implements Display {
    private ArrayList<Textbook> textbooks;

    public Backpack(ArrayList<Textbook> textbooks) {
        this.textbooks = new ArrayList<>();
        this.textbooks = textbooks;
    }

    @Override
    public void display() {
        ListIterator<Textbook> lookListIterator = textbooks.listIterator();
        while (lookListIterator.hasNext()){
            lookListIterator.next().display();
        }
    }

    public ArrayList<Textbook> getTextbooks() {
        return textbooks;
    }

    public static float getLecturesPriceSum(List<Textbook> list) {
    return (float) Stream.ofNullable(list).flatMap(x->x.stream()).
            filter(x -> x.getTheoryPart().equals(TypeOfTheoryPart.LECTURES.getTheory_s())).
            mapToDouble((Textbook::getPrice)).
            sum();

    }

    public static float getMaxPrice(List<Textbook> list) {
        return (float) list.stream().
                mapToDouble(Textbook::getPrice).
                max().orElseThrow(NoSuchElementException::new);
    }

    public static float getAveragePrice(List<Textbook> list) {
        return (float) list.stream().
                mapToDouble(Textbook::getPrice).
                average().orElseThrow(NoSuchElementException::new);
    }

    public static Map<Boolean, List<Textbook>> getGroupByCondition(List<Textbook> list, Predicate<Textbook> booleanCondition) {
        return list.stream().
                collect(Collectors.partitioningBy(booleanCondition));
    }

    public static List<String> getMostFrequentTheoryMaterials(List<Backpack> wardrobeList) {

        List<String> result = new ArrayList<>();
        wardrobeList.stream()
                .flatMap(x -> x.getTextbooks().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(Textbook::isExpensive))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(x -> x.getTheoryPart(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }

}
