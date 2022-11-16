package app.commands;
import app.bank.Bank;
public class ShowCreditCommand implements BaseCommand{
    @Override
    public void execute(Bank bank) {
        bank.printCredits();
    }
}

