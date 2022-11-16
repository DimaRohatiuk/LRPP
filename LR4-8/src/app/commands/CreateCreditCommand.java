package app.commands;

import app.bank.Bank;
public class CreateCreditCommand implements BaseCommand {
    @Override
    public void execute(Bank bank) {
        bank.createCredit();
    }
}
