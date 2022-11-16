package app.commands;

import app.bank.Bank;
public class ChangeCreditCommand implements BaseCommand {
    @Override
    public void execute(Bank bank) {
        bank.changeCredit();
    }
}
