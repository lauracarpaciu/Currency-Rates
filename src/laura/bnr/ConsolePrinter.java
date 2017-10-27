package laura.bnr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConsolePrinter implements CurrencyPrinter {
//    create a print method for printing on console
    @Override
    public void print(ArrayList<Currency> currencies) {
//        create date object

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
// obtain an object with String type
        String text = date.format(formatter);

        String header = String.format("%s: %s", "#BNR - Reference rates", text);
        System.out.println(header);
//        create a foreach loop and print the result
        for (Currency currency : currencies) {
            System.out.println(currency.getDescription());
        }
    }
}

