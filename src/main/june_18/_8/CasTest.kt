package main.june_18._8

import sun.misc.Unsafe

fun main(args: Array<String>) {
//    通过反射实例化Unsafe
    val field = Unsafe::class.java.getDeclaredField("theUnsafe")
    field.isAccessible = true
    val unsafe = field.get(null) as Unsafe
//   实例化对象
    val wife = unsafe.allocateInstance(Wife::class.java) as Wife
    wife.age = 18
    wife.name = "白玉"
    wife::class.java.declaredFields.forEach {
        println("${it.name} 对应的内存偏移地址:${unsafe.objectFieldOffset(it)}")
    }
    println("------------------------------------------------------------")
}

data class Wife(var age: Int = 0, var name: String = "")