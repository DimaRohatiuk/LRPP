package test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BankTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setupStream(){
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreSteam(){
        System.setOut(new PrintStream(originalOut));
    }

   // @Test
    //public void StarterTest() throws Exception {
       // System.setIn(new ByteArrayInputStream(("showbank\n").getBytes()));

      //  Menu.getMenu();

       // Assertions.assertFalse(outputStream.toString().isEmpty());
   // }



}
