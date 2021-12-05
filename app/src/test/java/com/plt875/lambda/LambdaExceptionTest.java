package com.plt875.lambda;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;

public class LambdaExceptionTest {
//    @Test
//    public void tryCatchInLambda() {
//        List.of("test0.txt", "test1.txt").forEach(item -> {
//            try {
//                Files.readAllLines(Path.of(item));
//            } catch (IOException e) {
//                System.out.println(e);
//                throw new RuntimeException(e);
//            }
//        });
//    }

    @Test
    public void wrapperMethod() {
        List.of("test0.txt", "test1.txt")
                .forEach(item -> readFile(item));
    }

    void readFile(String fileName) throws RuntimeException{
        try {
            Path file = Paths.get("src","test","resources", fileName);
            Files.readAllLines(file);
        } catch (IOException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }

    @Test
    public void genericWrapperMethod() {
        List.of("test0.txt", "test1.txt")
                .forEach(ThrowingConsumer.wrapper(item -> Files.readAllLines(Paths.get("src","test","resources", item))));
    }

    @FunctionalInterface
    interface ThrowingConsumer<T, E extends Exception> {
        void accept(T t) throws E;

        static <T> Consumer<T> wrapper(ThrowingConsumer<T, Exception> t) {
            return arg -> {
                try {
                    t.accept(arg);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            };
        }
    }

}
