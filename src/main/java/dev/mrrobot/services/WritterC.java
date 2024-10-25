package dev.mrrobot.services;

import lombok.SneakyThrows;

import java.io.PrintWriter;
import java.io.Writer;

public class WritterC {

    private static WritterC instance;
    private Writer writter;

    @SneakyThrows
    private WritterC() {
    }

    public WritterC getInstance() {
        if (instance == null) instance = new WritterC();
        return instance;
    }

    @SneakyThrows
    public WritterC init(String outputDir) {
        writter = new PrintWriter(outputDir);
        return this;
    }

    @SneakyThrows
    public WritterC add(String content) {
        writter.append(content);
        return this;
    }

    @SneakyThrows
    public void close() {
        writter.close();
    }
}
