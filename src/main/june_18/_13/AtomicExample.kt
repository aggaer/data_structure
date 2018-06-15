package main.june_18._13

import java.util.concurrent.atomic.AtomicReference

var count: AtomicReference<Int> = AtomicReference(0)

fun main(args: Array<String>) {
    count.compareAndSet(0, 2)
    count.compareAndSet(0, 1)
    count.compareAndSet(1, 3)
    count.compareAndSet(2, 4)
    count.compareAndSet(3, 5)
    println("count: ${count.get()}")
}