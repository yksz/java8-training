package ch03.ex22;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Answer {

    // <U> CompletableFuture<U> thenCompose(Function<? super T,? extends CompletionStage<U>> fn)

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long begin = System.currentTimeMillis();
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
            return "Hello ";
        }).thenCompose((s) -> CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            return s + "World!";
        }));
        System.out.println(cf.get());
        long end = System.currentTimeMillis();
        System.out.println((end - begin) / 1000.0 + " [sec]");
    }

}
