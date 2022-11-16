package app;
import app.menu.Menu;
import app.utils.ApplicationLogger;
import org.apache.log4j.PropertyConfigurator;

public class Starter {
    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("log4j.properties");
        ApplicationLogger.logFatal("error");
        Menu.start();
    }
}
