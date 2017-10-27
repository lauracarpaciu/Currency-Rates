package laura.bnr;

import laura.bnr.Currency;
import laura.bnr.CurrencyPrinter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements CurrencyPrinter {
    @Override
    public void print(ArrayList<Currency> currencies) {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("BNR.proprieties"));


            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            String text = date.format(formatter);

            String header = String.format("%s: %s", "#BNR - Reference rates", text);
            bufferedWriter.write(header);
            bufferedWriter.newLine();

            for (Currency currency : currencies) {
                bufferedWriter.write(currency.getDescription());
                bufferedWriter.newLine();
            }

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
    }
}
