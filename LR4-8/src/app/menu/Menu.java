package app.menu;

import app.bank.Bank;
import app.commands.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private static Bank bank;
    private static Map<String, BaseCommand> userChoose;

    public static void start() throws Exception {
        userChoose = new HashMap<>();
        userChoose.put("createbank", new BankCreateCommand());
        userChoose.put("showbank", new ShowBanksCommand());
        userChoose.put("createcredit", new CreateCreditCommand());
        userChoose.put("deletecredit", new DeleteCreditCommand());
        userChoose.put("changecredit", new ChangeCreditCommand());
        userChoose.put("showcredit", new ShowCreditCommand());
        userChoose.put("findcredit", new FindCreditCommand());
        userChoose.put("writeinfile", new WriteToFileCommand());
        userChoose.put("readfromfile", new WriteToFileCommand());
        userChoose.put("exit", new ExitCommand());

        bank = new Bank();
        while (true){
            getMenu();
        }
    }

    public static void getMenu() throws Exception {
        System.out.print("""
                Список всіх доступних команд:
                \t[1] Вибрати Банк - createbank
                \t[2] Показати Банк - showbank
                \t[3] Створити Кредит - createcredit
                \t[4] Видалити Кредит - deletecredit
                \t[5] Змінити Кредит - changecredit
                \t[6] Показати Кредити - showcredit
                \t[7] Знайти Кредити - findcredit
                \t[8] Запис у файл - writeinfile
                \t[9] Зчитування з файлу - readfromfile
                \t[10] Вихід - exit
                Введіть ваш вибір:\s""");
        userChoose();
    }

    private static void userChoose() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String Input = scanner.nextLine();

        BaseCommand command = userChoose.get(Input);
        if (command != null) {
            userChoose.get(Input).execute(bank);
        } else {
            throw new IllegalArgumentException("Ви ввели невірну команду!");
        }
    }
}
