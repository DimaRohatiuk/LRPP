package test.Commands;

import app.bank.Bank;
import app.commands.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GlobalCommandsTest {
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

    @Test
    public void createCreditCommandTest(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        Assertions.assertEquals(1,bank.getCreditList().size());
        Assertions.assertEquals("First",bank.getCreditList().get(0).getName());
    }

    @Test
    public void BankCreateCommandTest(){
        System.setIn(new ByteArrayInputStream(("Yorik\n1234\n2\n").getBytes()));

        BankCreateCommand command = new BankCreateCommand();
        Bank bank = new Bank();
        command.execute(bank);

        Assertions.assertFalse(bank.banksSet().getBankName().isEmpty());
    }

    @Test
    public void ChangeCreditCommandTest(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n1\nSecond\n2000\n4\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        ChangeCreditCommand command1 = new ChangeCreditCommand();
        command1.execute(bank);

        Assertions.assertEquals("Second",bank.getCreditList().get(0).getName());
    }

    @Test
    public void DeleteCreditCommandTest(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n2\n1\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        DeleteCreditCommand command1 = new DeleteCreditCommand();
        command1.execute(bank);

        Assertions.assertEquals(0,bank.getCreditList().size());
    }

    @Test
    public void FindCreditCommandTestOne(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n1\nFirst\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        FindCreditCommand command1 = new FindCreditCommand();
        command1.execute(bank);

        Assertions.assertTrue(outputStream.toString().contains("First"));
    }

    @Test
    public void FindCreditCommandTestTwo(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n2\n100\n1500\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        FindCreditCommand command1 = new FindCreditCommand();
        command1.execute(bank);

        Assertions.assertTrue(outputStream.toString().contains("First"));
    }

    @Test
    public void FindCreditCommandTestThree(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n3\n1\n5\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        FindCreditCommand command1 = new FindCreditCommand();
        command1.execute(bank);

        Assertions.assertTrue(outputStream.toString().contains("First"));
    }

    @Test
    public void ShowBanksCommandTest(){
        System.setIn(new ByteArrayInputStream(("Yorik\n1234\n1\n").getBytes()));
        Bank bank = new Bank();

        BankCreateCommand command = new BankCreateCommand();
        command.execute(bank);

        ShowBanksCommand command1 = new ShowBanksCommand();
        command1.execute(bank);

        Assertions.assertFalse(outputStream.toString().contains("null"));
    }

    @Test
    public void ShowCreditCommandTest(){
        System.setIn(new ByteArrayInputStream(("First\n1000\n2\n").getBytes()));

        CreateCreditCommand command = new CreateCreditCommand();
        Bank bank = new Bank();
        command.execute(bank);

        ShowCreditCommand command1 = new ShowCreditCommand();
        command1.execute(bank);

        Assertions.assertTrue(outputStream.toString().contains("First"));
    }

}
