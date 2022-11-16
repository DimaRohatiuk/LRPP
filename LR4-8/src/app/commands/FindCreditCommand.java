package app.commands;
import app.bank.Bank;
public class FindCreditCommand implements BaseCommand{
    @Override
    public void execute(Bank bank) {
        bank.findCredit();
    }
}
