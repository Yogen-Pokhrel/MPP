package Lab9.prob8;

import java.util.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));

        // Query 1: Find all transactions from year 2011 and sort them by value (small
        // to high).
        System.out.println("Query 1: Find all transactions from year 2011 and sort them by value (small to high)");
        transactions.stream().filter(x -> x.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        // Query 2: What are all the unique cities where the traders work?
        System.out.println("Query 2: What are all the unique cities where the traders work?");
        transactions.stream().map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);

        // Query 3: Find all traders from Cambridge and sort them by name.
        System.out.println("Query 3: Find all traders from Cambridge and sort them by name.");
        transactions.stream().map(Transaction::getTrader).filter(x -> x.getCity().equals("Cambridge")).distinct()
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);

        // Query 4: Return a string of all traders names sorted alphabetically.
        System.out.println("Query 4: Return a string of all traders names sorted alphabetically.");
        transactions.stream().map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName)).distinct()
                .forEach(System.out::println);

        // Query 5: Are there any trader based in Milan?
        boolean isPresentInMilan = transactions.stream().map(Transaction::getTrader)
                .filter(x -> x.getCity().equals("Milan")).findAny().isPresent();
        System.out.println("Query 5: Are there any trader based in Milan?\n" + isPresentInMilan);

        // Query 6: Update all transactions so that the traders from Milan are set to
        // Cambridge.
        ArrayList<Transaction> updatedTransactions = transactions.stream()
                .reduce(
                        new ArrayList<Transaction>(),
                        (transactionList, transaction) -> {
                            Trader trader = transaction.getTrader();
                            if (trader.getCity().equals("Milan")) {
                                trader.setCity("Cambridge");
                            }
                            ArrayList<Transaction> newList = new ArrayList<>(transactionList);
                            newList.add(transaction);
                            return newList;
                        },
                        (list1, list2) -> {
                            ArrayList<Transaction> result = new ArrayList<>(list1);
                            result.addAll(list2);
                            return result;
                        });

        updatedTransactions.forEach(System.out::println);

        // Query 7: What's the highest value in all the transactions?
        Optional<Integer> maxValue = transactions.stream().map(Transaction::getValue).max(Integer::compare);
        System.out.println("Query 7: What's the highest value in all the transactions?\n" + maxValue.get());
    }
}
