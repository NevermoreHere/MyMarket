package com.exa.task;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskThreadPool {
    public static final ExecutorService EXEC = Executors.newCachedThreadPool();

}
