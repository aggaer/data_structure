package main.june_18._11

import java.util.concurrent.TimeUnit

class AtomicIncrement : Runnable {
    @Volatile
    private var num = 0L
    val list = arrayListOf<Long>()
    override fun run() {
        while (num <= 100) {
            println("${Thread.currentThread().name}::$num")
            list.add(++num)
        }
    }
}

fun main(args: Array<String>) {
    val atomicIncrement = AtomicIncrement()
    Thread(atomicIncrement).start()
    Thread(atomicIncrement).start()
    Thread(atomicIncrement).start()
    Thread(atomicIncrement).start()
    TimeUnit.SECONDS.sleep(10)
    println(atomicIncrement.list)
}