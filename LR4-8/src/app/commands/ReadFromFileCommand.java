package app.commands;
import app.bank.Bank;
public class ReadFromFileCommand implements BaseCommand{
    @Override
    public void execute(Bank bank) {
        bank.readFromFile();
    }
}

