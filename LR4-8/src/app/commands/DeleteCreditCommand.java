package app.commands;

import app.bank.Bank;
public class DeleteCreditCommand implements BaseCommand {
    @Override
    public void execute(Bank bank) {
        bank.deleteCredit();
    }
}
