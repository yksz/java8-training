package ch06.ex11;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CompletableFutureUtils {

    public static <T> CompletableFuture<T> repeat(
            Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action)
                .thenCompose(auth -> {
                    if (until.test(auth))
                        return CompletableFuture.completedFuture(auth);
                    else
                        return repeat(action, until);
                });
    }

    public static void main(String[] args) throws Exception {
        repeat(() -> {
            System.out.println("Enter username and password: <username> <password>");
            Scanner sc = new Scanner(System.in);
            String username = sc.next();
            String password = sc.next();
            System.out.println("username=" + username + ", password=" + password);
            return new PasswordAuthentication(username, password.toCharArray());
        }, auth -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            boolean successful = new String(auth.getPassword()).equals("secret");
            System.out.println("Authentication " + (successful ? "success" : "failed"));
            return successful;
        }).get();
        System.out.println("Complete");
    }

}
