import textbooks.PracticePart;
import textbooks.Sale;
import textbooks.Textbook;
import textbooks.TheoryPart;
import textbooks.type.*;
import textbooks.elements.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class BackpackTest {

    @Test
    public void EqualsTextbook1_IsObjectSame_True(){
        Textbook.Textbook1 textbook1 = new Textbook.Textbook1("Tech",
                new TheoryPart(Color.BLUE, Material.GLOSS, Size.A5, TypeOfTheoryPart.LECTURES));
        Textbook.Textbook1 textbook2 = new Textbook.Textbook1("Tech",
                new TheoryPart(Color.BLUE, Material.GLOSS, Size.A5, TypeOfTheoryPart.LECTURES));
        Assert.assertTrue(textbook1.equals(textbook1) && textbook2.equals(textbook1));
        textbook1.display();
    }

    @Test
    public void EqualsLook_IsObjectSame_True(){
        Textbook textbook1 = new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 250,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS));
        Textbook textbook2 = new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 250,
                new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
                new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS));
        Assert.assertTrue(textbook1.equals(textbook2) && textbook2.equals(textbook1));
        textbook1.display();
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Input_IncorrectInput_ExceptionThrown(){
        Textbook look = new Textbook();

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("No enum found with url: [BBB] in Practice part");

        String str1 = "engname/mukuch/eng/100/333/red/gloss/A4/manual/blue/paper/A5/FAIL";
        look.input(str1);
    }

   @Test
    public void ChangePrice_ChangePriceField_True(){
       Textbook textbook = new Textbook("Math basics", "Khachatrian Mkrtych", "Math", 100, 250,
               new TheoryPart(Color.RED, Material.PAPER, Size.A4, TypeOfTheoryPart.LECTURES),
               new PracticePart(Color.RED, Material.GLOSS, Size.A5, TypeOfPracticePart.TESTS));
        Sale sale1 = new Sale("Knowledge Day");

        sale1.changePrice(textbook, 280);
        sale1.display();
        textbook.display();
    }
}