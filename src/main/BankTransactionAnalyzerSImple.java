import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String[] args) throws IOException {
        final BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final String fileName = args[0];

        final Path path = Path.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(BankTransactions, Month.JANUARY));

        }
}
