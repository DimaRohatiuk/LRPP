package app.commands;
import app.bank.Bank;
public class BankCreateCommand implements BaseCommand{
    @Override
    public void execute(Bank bank) {
        bank.createBanks();
    }
}
