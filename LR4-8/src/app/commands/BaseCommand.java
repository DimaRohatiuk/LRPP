package app.commands;
import app.bank.Bank;
public interface BaseCommand {
    void execute(Bank bank) throws Exception;
}
