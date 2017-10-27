package laura.bnr;

import laura.bnr.ConsolePrinter;
import laura.bnr.Currency;
import laura.bnr.FilePrinter;

import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        String url = "http://bnr.ro/nbrfxrates.xml";

        String xmlString = new String();

        NetworkManager manager = new NetworkManager();
        try {
            xmlString = manager.getXMLString(url);
        } catch (Exception e) {
            e.getMessage();
        }


        System.out.println(xmlString);

        ArrayList<Currency> currencies = parseXMLString("INPUT");

        Currency usdCurrency = new Currency("N/A", 0.0);
        Currency eurCurrency = new Currency("N/A", 0.0);

        for (Currency currency : currencies) {
            if (currency.currencyName == "USD") usdCurrency = currency;
            if (currency.currencyName == "EUR") eurCurrency = currency;
        }

        printConversion(100.0, usdCurrency, eurCurrency );

        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.print(currencies);

        FilePrinter filePrinter = new FilePrinter();
        filePrinter.print(currencies);
    }


    public static ArrayList<Currency> parseXMLString(String input) {
        ArrayList<Currency> currencies = new ArrayList<Currency>();
        currencies.add(new Currency("EUR", 4.5340));
        currencies.add(new Currency("CHF", 4.1952));
        currencies.add(new Currency("USD", 4.1702));
        return currencies;
    }

    public static void printConversion(Double units, Currency fromCurrency, Currency toCurrency) {
        Double rate = fromCurrency.rateRON / toCurrency.rateRON;
        String text = String.format("%s %s = %s %s.", units, fromCurrency.currencyName, Double.toString(rate * units), toCurrency.currencyName);
        System.out.println(text);
    }

}




