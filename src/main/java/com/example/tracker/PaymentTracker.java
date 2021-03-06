package com.example.tracker;

import com.example.tracker.concurrent.DaemonThreadFactory;
import com.example.tracker.domain.CcyBalance;
import com.example.tracker.domain.Transaction;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * It is assumed that the input is always correct. Invalid inputs will cause the program to die by throwing an exception.
 * Invalid (not existing) path to a file will end up as described above.
 * A path to a file can be either relative or absolute.
 * An input is expected to be read from standard input, an output of the program is sent to standard output by default.
 * A report for the first time is executed immediately and then periodically after each minute.
 */
public class PaymentTracker {
    private static final String EXIT_CMD = "quit";
    private static final long REPORT_PERIOD_SEC = 60;

    private final Map<String, CcyBalance> balances = new ConcurrentHashMap<>();
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new DaemonThreadFactory());


    public static void main(String[] args) throws IOException {
        new PaymentTracker().run(args);
    }

    private void run(String[] args) throws IOException {
        if (args.length != 0) {
            readFile(Paths.get(args[0]));
        }
        executor.scheduleAtFixedRate(() -> printBalances(System.out), 0, REPORT_PERIOD_SEC, TimeUnit.SECONDS);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals(EXIT_CMD)) {
            processInput(input);
        }
    }

    private void processInput(String input) {
        Transaction tran = Transaction.parse(input);
        balances.compute(tran.currency, (k, v) -> (v == null) ? new CcyBalance(k, tran.amount) : v.addAmount(tran.amount));
    }

    private void readFile(Path file) throws IOException {
        Files.lines(file).forEach(this::processInput);
    }

    private void printBalances(OutputStream out) {
        PrintWriter writer = new PrintWriter(out);
        writer.println("Net Balances as per " + ZonedDateTime.now() + ":");
        balances.values().stream().filter(holder -> holder.getBalance() != 0)
                .forEach((holder) -> writer.println(holder.getCurrency() + " " + holder.getBalance()));
        writer.flush();
    }

}
