package bots;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;

public class WaitBot {
    private WebDriver driver;

    public WaitBot(WebDriver driver){
        this.driver = driver;
    }

    public FluentWait<WebDriver> fluentWait(){

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(100))
                .ignoreAll(getExceptions());
    }

    private ArrayList<Class<? extends Exception>> getExceptions() {
        ArrayList<Class<? extends Exception>> exceptions = new ArrayList<>();

        // Reflection / field issues
        exceptions.add(NoSuchFieldException.class);
        exceptions.add(NoSuchMethodException.class);
        exceptions.add(IllegalAccessException.class);
        exceptions.add(InstantiationException.class);

        // I/O and file handling
        exceptions.add(IOException.class);
        exceptions.add(FileNotFoundException.class);
        exceptions.add(EOFException.class);

        // Runtime / unchecked exceptions
        exceptions.add(NullPointerException.class);
        exceptions.add(IndexOutOfBoundsException.class);
        exceptions.add(ArrayIndexOutOfBoundsException.class);
        exceptions.add(IllegalArgumentException.class);
        exceptions.add(ClassCastException.class);
        exceptions.add(ArithmeticException.class);

        // Class loading
        exceptions.add(ClassNotFoundException.class);

        // Threading / concurrency
        exceptions.add(InterruptedException.class);

        // Parsing / formatting
        exceptions.add(NumberFormatException.class);
        exceptions.add(ParseException.class);

        return exceptions;
    }



}
