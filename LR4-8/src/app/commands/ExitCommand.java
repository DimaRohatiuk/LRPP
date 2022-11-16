package app.commands;

import app.bank.Bank;
public class ExitCommand implements BaseCommand {
    @Override
    public void execute(Bank bank) {
        System.exit(0);
    }
}
