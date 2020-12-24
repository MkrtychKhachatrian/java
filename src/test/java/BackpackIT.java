import textbooks.*;
import textbooks.elements.Material;
import textbooks.elements.Color;
import textbooks.elements.Size;
import textbooks.type.TypeOfTheoryPart;
import textbooks.type.TypeOfPracticePart;
import exception.WrongInputException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class BackpackIT {
    ArrayList<Textbook> textbooks1,textbooks2;
    List<Backpack> backpackList;
    @Before
    public void setUp () {
        backpackList = new ArrayList<>();

        backpackList.add(mock(Backpack.class));
        backpackList.add(mock(Backpack.class));


        textbooks1 = new ArrayList<>();
        textbooks2 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            textbooks1.add(mock(Textbook.class));
            textbooks2.add(mock(Textbook.class));
        }

        textbooks2.add(mock(Textbook.class));

    }

    @Test
    public void getJumperPriceSum_IsSumCorrect_True() {
        //GIVEN
        when(textbooks1.get(0).getPrice()).thenReturn(300f);
        when(textbooks1.get(0).getTheoryPart()).thenReturn("lectures");

        when(textbooks1.get(1).getPrice()).thenReturn(100f);
        when(textbooks1.get(1).getTheoryPart()).thenReturn("lectures");

        when(textbooks1.get(2).getPrice()).thenReturn(200f);
        when(textbooks1.get(2).getTheoryPart()).thenReturn("tests");


        float expected = 400;

        //WHEN
        float actual = Backpack.getLecturesPriceSum(textbooks1);

        //THEN
        Assert.assertEquals(expected,actual,0);
        verify(textbooks1.get(2), times(0)).getPrice();
    }

    @Test
    public void ChangePrice_ChangePriceField_True(){
        when(textbooks1.get(0).getPrice()).thenReturn(200f);

        Sale sale1 = new Sale("Knowledge Day");
        Textbook textbook = new Textbook();
        sale1.changePrice(textbook, 200);

        Assert.assertEquals(textbooks1.get(0).getPrice(),textbook.getPrice(),0);
    }
    @Test(expected = WrongInputException.class)
    public void Input_IncorrectInput_ExceptionThrown()throws WrongInputException{
        doThrow(new WrongInputException("Not all data entered")).when(textbooks1.get(0)).input("");
        textbooks1.get(0).input("");
    }

    @Test
    public void getMostPopularTypeOfUpperCloth_IsPopularCorrect_True() {
        //GIVEN
        doReturn(true).when(textbooks1.get(0)).isExpensive();
        when(textbooks1.get(0).getTheoryPart()).thenReturn("lectures");

        doReturn(false).when(textbooks1.get(1)).isExpensive();
        when(textbooks1.get(1).getTheoryPart()).thenReturn("lectures");

        doReturn(false).when(textbooks1.get(2)).isExpensive();
        when(textbooks1.get(2).getTheoryPart()).thenReturn("documentation");


        doReturn(false).when(textbooks2.get(0)).isExpensive();
        when(textbooks2.get(0).getTheoryPart()).thenReturn("lectures");

        doReturn(true).when(textbooks2.get(1)).isExpensive();
        when(textbooks2.get(1).getTheoryPart()).thenReturn("manual");

        doReturn(false).when(textbooks2.get(2)).isExpensive();
        when(textbooks2.get(2).getTheoryPart()).thenReturn("manual");

        doReturn(true).when(textbooks2.get(3)).isExpensive();
        when(textbooks2.get(3).getTheoryPart()).thenReturn("manual");


        when(backpackList.get(0).getTextbooks()).thenReturn(textbooks1);
        when(backpackList.get(1).getTextbooks()).thenReturn(textbooks2);

        List<String> expected = Arrays.asList("lectures", "manual");

        //WHEN
        List<String> result = Backpack.getMostFrequentTheoryMaterials(backpackList);

        //THEN
        Assert.assertEquals(expected,result);
        verify(textbooks2.get(3), times(1)).getTheoryPart();
    }
}
