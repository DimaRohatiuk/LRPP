package app.commands;
import app.bank.Bank;
public class ShowBanksCommand implements BaseCommand{
    @Override
    public void execute(Bank bank) {
        bank.showBanks();
    }
}
