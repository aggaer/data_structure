package main.june_18._13

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater


class AtomicFieldUpdaterExample {
    @Volatile
    var count = 100
    var updater: AtomicIntegerFieldUpdater<AtomicFieldUpdaterExample> = java.util.concurrent.atomic.AtomicIntegerFieldUpdater.newUpdater(AtomicFieldUpdaterExample::class.java, "count")
}

fun main(args: Array<String>) {
    val updaterExample = AtomicFieldUpdaterExample()
    if (updaterExample.updater.compareAndSet(updaterExample, 100, 188)) {
        println("update success,count: ${updaterExample.count}")
    }
}