
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {

        ArrayList<Currency> currencies = parseXMLString("INPUT");

        Currency usdCurrency = new Currency("N/A", 0.0);
        Currency eurCurrency = new Currency("N/A", 0.0);

        for (Currency currency : currencies) {
            if (currency.currencyName == "USD") usdCurrency = currency;
            if (currency.currencyName == "EUR") eurCurrency = currency;
        }

        printConversion(100.0, usdCurrency, eurCurrency );
        printAllCurrencies(currencies);
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

    public static void printAllCurrencies(ArrayList<Currency> currencies) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");

        String text = date.format(formatter);

        String header = String.format("%s: %s", "#BNR - Reference rates", text);
        System.out.println(header);
        for (Currency currency : currencies) {
            System.out.println(currency.getDescription());


//  Save result on BNR.properties

            BufferedWriter bufferedWriter = null;
            FileReader fr;

            try {
                fr = new FileReader(new File("text.txt"));
                bufferedWriter = new BufferedWriter(new FileWriter("BNR.proprieties"));

                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();

                while (line != null) {

                    bufferedWriter.write(line);

                    bufferedWriter.newLine();

                    line = br.readLine();
                }

                br.close();

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
                //Close the BufferedWriter
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }}}




