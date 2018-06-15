package main.june_18._12

import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

class LongFactor : Runnable {
    var count = 10000L

    override fun run() {
        var buyCount = 2500
        while (buyCount > 0) {
            if (count == 0L) {
                return
            }
            TimeUnit.MICROSECONDS.sleep(10)
            println("value: ${count--}")
            buyCount--
        }
    }
}

class AtomicFactor : Runnable {
    var atomicCount: AtomicLong = AtomicLong(10000)

    override fun run() {
        var buyCount = 2500
        while (buyCount > 0) {
            if (atomicCount.get() == 0L) {
                return
            }
            TimeUnit.MICROSECONDS.sleep(10)
            println("value: ${atomicCount.getAndDecrement()}")
            buyCount--
        }
    }
}

fun main(args: Array<String>) {
    val atomicFactor = AtomicFactor()
    val longFactor = LongFactor()
    val t1 = Thread(atomicFactor)
    t1.start()
    val t2 = Thread(atomicFactor)
    t2.start()
    val t3 = Thread(atomicFactor)
    t3.start()
    val t4 = Thread(atomicFactor)
    t4.start()
    while (t1.isAlive || t2.isAlive || t3.isAlive || t4.isAlive) {

    }
    println("result: ${atomicFactor.atomicCount.get()}")
//    println("result: ${longFactor.count}")
}