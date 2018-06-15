package main.june_18._12

import java.util.concurrent.atomic.AtomicLong

@Volatile
var _longVal: AtomicLong = AtomicLong(0)

class LoopVolatile : Runnable {

    override fun run() {
        var i = 0L
        while (i < 10000000L) {
            _longVal.getAndIncrement()
            i++
        }
    }
}

class HoopVolatile : Runnable {
    override fun run() {
        var i = 0L
        while (i < 10000000L) {
            _longVal.getAndIncrement()
            i++
        }
    }
}

fun main(args: Array<String>) {
    val t1 = Thread(LoopVolatile())
    t1.start()
    val t2 = Thread(HoopVolatile())
    t2.start()
    while (t1.isAlive || t2.isAlive) {

    }
    println("final val is $_longVal")
}