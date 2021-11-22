package com.exa.task;

import com.exa.entity.Account;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class TaskImport implements AutoCloseable{

    static final ThreadLocal<Account> ctx = new ThreadLocal<>();

    public TaskImport(Account account){
        ctx.set(account);
    }

    public static Account getAccount(){
        return ctx.get();
    }

    public String run(TaskData taskData){

        return taskData.toString();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}
