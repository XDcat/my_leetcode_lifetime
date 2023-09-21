package com.zlj.concurrent.printnumber.pool.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Lianjie Zeng <zenglianjie@foxmail.com>
 * Created on 2023-09-02
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 3, 3L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(3));
        CompletableFuture<Void> t1 = CompletableFuture.runAsync(() -> System.out.println("Hello World"), pool);
        System.out.println(t1);
        t1.complete(null);
        System.out.println(t1);

        CompletableFuture<String> t2 = CompletableFuture.supplyAsync(() -> "Hello, it's a supply!", pool);
        System.out.println(t2.get());
        CompletableFuture<String> t3 = t2.thenApply(s -> s + "Continue");
        System.out.println(t3.get());

        CompletableFuture.supplyAsync(() -> "Hello, it's a supply!", pool)
                .thenApply(s -> s + "Continue input and output, just like a pipeline")
                .thenAccept(s -> System.out.println(s + "Accept will end the pipeline"));

        CompletableFuture.supplyAsync(() -> "Hello, it's a supply!", pool)
                .thenApply(s -> s + "Continue input and output, just like a pipeline")
                .thenRun(() -> System.out.println("Run can't both input and output"));

    }
}
