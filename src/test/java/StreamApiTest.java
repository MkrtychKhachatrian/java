import textbooks.*;
import textbooks.type.*;
import textbooks.elements.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class StreamApiTest {
    private ArrayList<Textbook> textbooks,textbooks1;
    Backpack backpack1, backpack2;
    @Before
    public void init() {
        textbooks = new ArrayList<>();
        textbooks.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 300,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.LABS))
        );
        textbooks.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 100,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS))
        );
        textbooks.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 200,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.DOCUMENTATION),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS))
        );
        textbooks1 = new ArrayList<>();
        textbooks1.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 50,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.LABS))
        );
        textbooks1.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 400,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.MANUAL),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS))
        );
        textbooks1.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 150,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.MANUAL),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS))
        );
        textbooks1.add(new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 500,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.MANUAL),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS))
        );

        backpack1 = new Backpack(textbooks);
        backpack2 = new Backpack(textbooks1);
    }
    @Test
    public void getLecturesPriceSum_IsSumCorrect_True() {
        //GIVEN
        float expected = 400;

        //WHEN
        float actual = Backpack.getLecturesPriceSum(textbooks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }
    @Test
    public void getLecturesPriceSum_IsNull_True() {
        //GIVEN
        float expected = 0;

        //WHEN
        float actual = Backpack.getLecturesPriceSum(null);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }
    @Test
    public void getLecturesPriceSum_isEmpty_True() {
        //GIVEN
        textbooks = new ArrayList<>();

        float expected = 0;
        //WHEN
        float actual = Backpack.getLecturesPriceSum(textbooks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getMaxPrice_IsMaxCorrect_True() {
        //GIVEN
        double expected = 300;

        //WHEN
        float actual = Backpack.getMaxPrice(textbooks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getAveragePrice_IsAverageCorrect_True() {
        //GIVEN
        double expected = 200;

        //WHEN

        float actual = Backpack.getAveragePrice(textbooks);

        //THEN
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getGroupByCondition_isFilterCorrect_True() {
        //GIVEN
        Map<Boolean, List<Textbook>> expected = new HashMap<>();
        expected.put(Boolean.TRUE, Arrays.asList(textbooks.get(0)));
        expected.put(Boolean.FALSE, Arrays.asList(textbooks.get(1),textbooks.get(2)));

        //WHEN
        Map<Boolean, List<Textbook>> actual;
        actual = Backpack.getGroupByCondition(textbooks, p -> p.getTheoryPart().equals(TypeOfTheoryPart.LECTURES.getTheory_s()) &&
                p.getPrice() > 100);

        //THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMostPopularTypeOfTheoryPart() {
        //GIVEN
        List<Backpack> wardrobeList = Arrays.asList(backpack1, backpack2);
        List<String> expected = Arrays.asList("lectures", "manual");

        //WHEN
        List<String> actual = Backpack.getMostFrequentTheoryMaterials(wardrobeList);

        //THEN
        Assert.assertEquals(actual, expected);
    }
}