package laura.bnr;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsolePrinter implements CurrencyPrinter {
    @Override
    public void print(ArrayList<Currency> currencies) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

        String text = date.format(formatter);

        String header = String.format("%s: %s", "#BNR - Reference rates", text);
        System.out.println(header);
        for (Currency currency : currencies) {
            System.out.println(currency.getDescription());
        }
    }
}

