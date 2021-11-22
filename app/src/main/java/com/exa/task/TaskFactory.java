package com.exa.task;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public class TaskFactory extends AbstractTaskFactory{

    public static List<Future> futureList = Collections.synchronizedList(new ArrayList<>());

    public static Lock lock = new ReentrantLock();

    public static Condition condition = lock.newCondition();


    @SuppressWarnings("unchecked")
    public static <T, S, U> T createTask(S data, Class<U> clz, String name) {
        TaskFactory.lock.lock();

        try {
            Method method = clz.getDeclaredMethod("run", data.getClass());
            Object obj = clz.newInstance();

            // Future 版本
            Future<T> future = TaskThreadPool.EXEC.submit(new Callable<T>(){
                @Override
                public T call() throws Exception{
                    return (T) method.invoke(obj, data);
                }
            });
            futureList.add(future);
            TaskFactory.condition.signalAll();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        return null;
    }

//    public static void main(String[] args) throws InterruptedException {
////        TaskData<String> taskData = new TaskData<>();
//        new Thread(new TaskRunnable()).start();
//
//        TaskData<String> t1 = TaskData.<String>builder()
//                .data("import")
//                .orgId("org")
//                .userId("user")
//                .build();
//        TaskData<String> t2 = TaskData.<String>builder()
//                .data("haha")
//                .orgId("org")
//                .userId("user")
//                .build();
//        TaskData<String> t3 = TaskData.<String>builder()
//                .data("xixi")
//                .orgId("org")
//                .userId("user")
//                .build();
//        TaskFactory.createTask(t1, TaskImport.class, "import");
//        TaskFactory.createTask(t2, TaskImport.class, "haha");
//        TaskFactory.createTask(t3, TaskImport.class, "xixi");
//        while(true){
//            Thread.currentThread().sleep(1);
//        }
//    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture=new CompletableFuture<String>();
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                    System.out.println(Thread.currentThread().getName()+"执行.....");
//                    completableFuture.complete("success");//在子线程中完成主线程completableFuture的完成
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Thread t1=new Thread(runnable);
//        t1.start();//启动子线程
//
//        String result=completableFuture.get();//主线程阻塞，等待完成
//        System.out.println(Thread.currentThread().getName()+"1x:  "+result);
//        CompletableFuture<Void> future=CompletableFuture.runAsync(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    System.out.println(Thread.currentThread().getName()+"正在执行一个没有返回值的异步任务。");
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });
//        future.get();
//        System.out.println(Thread.currentThread().getName()+" 结束。");
//    }
//public static void main(String[] args) throws InterruptedException, ExecutionException {
//    CompletableFuture<String> ref1=  CompletableFuture.supplyAsync(()->{
//        try {
//            System.out.println(Thread.currentThread().getName()+"supplyAsync开始执行任务1.... ");
////                TimeUnit.SECONDS.sleep(1);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"supplyAsync: 任务1");
//        return "test1";
//    });
//
//    CompletableFuture<String> ref2= CompletableFuture.supplyAsync(()->{
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"thenApplyAsync: 任务2");
//        return "test2";
//    });
//
//    CompletableFuture<String> ref3=ref2.thenApplyAsync(value->{
//        System.out.println(Thread.currentThread().getName()+"thenApplyAsync: 任务2的子任务");
//        return  value+"test3";
//    });
//    CompletableFuture<String>nestedResult = ref3.thenCompose(value->
//            CompletableFuture.supplyAsync(()-> value+"test4"));
//
//    Thread.sleep(4000);
//    System.out.println(Thread.currentThread().getName()+ref3.get());
//    System.out.println(nestedResult.get());
//
//    CompletableFuture<Double>  d1= CompletableFuture.supplyAsync(new Supplier<Double>() {
//        @Override
//        public Double get() {
//            return 1d;
//        }
//    });
//
//    CompletableFuture<Double>  d2= CompletableFuture.supplyAsync(new Supplier<Double>() {
//        @Override
//        public Double get() {
//            return 2d;
//        }
//    });
//
//
//    CompletableFuture<Double> result=  d1.thenCombine(d2,(number1,number2)->{
//        return  number1+number2;
//    });
//
//
//    System.out.println(result.get());
//
//}

}

class TaskRunnable implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        while (true){
            TaskFactory.lock.lock();
            try {
                while (TaskFactory.futureList.isEmpty()) {
                    TaskFactory.condition.await();
                }
                System.out.println(TaskFactory.futureList.remove(0).get());
                TaskFactory.condition.signalAll();
            }catch (InterruptedException e){
                System.out.println(e);
            }
            finally {
                TaskFactory.lock.unlock();

            }
        }

    }
}

