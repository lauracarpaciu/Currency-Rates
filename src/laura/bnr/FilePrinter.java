package laura.bnr;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements CurrencyPrinter {
    @Override
    public void print(ArrayList<Currency> currencies) {
// use BufferedWrriter class to write in the file BNR.proprieties
        BufferedWriter bufferedWriter = null;
        {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter("BNR.proprieties"));
                LocalDate date = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
                String text = date.format(formatter);
                String header = String.format("%s: %s", "#BNR - Reference rates", text);
                bufferedWriter.write(header);
                bufferedWriter.newLine();
//create a foreach loop; and save the output with write method ;
                for (Currency currency : currencies) {
                    bufferedWriter.write(currency.getDescription());
                    bufferedWriter.newLine();
                }

            } catch (Exception e) {
                e.printStackTrace();

            } finally {
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
}
