package app.commands;

import app.bank.Bank;
import static app.file.FileWriting.writeInFile;

public class WriteToFileCommand implements BaseCommand{
    @Override
    public void execute(Bank bank) throws Exception {
        writeInFile(bank);
    }
}
