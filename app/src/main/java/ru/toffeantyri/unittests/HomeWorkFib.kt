package ru.toffeantyri.unittests

object HomeWorkFib {

    /**
     * return th n-th fibonachi numb
     * fib(0) = 0
     * fib(1) = 1
     * fib(n) = fib(n-2) + fib(n-1)
     *
     * */

    fun fib(n: Int): Long {
        if (n == 0 || n == 1) {
            return n.toLong()
        }
        var a = 0L
        var b = 1L
        var c = 1L
        (1..n - 2).forEach { i ->
            a = b
            b = c
            c = a + b
        }

        return c
    }


    /**
     * check braces set correctly
     * (a+b)) return false
     * (a+b) return true
     * **/

    fun checkBraces(string: String): Boolean {
        return string.count { it == '(' } == string.count { it == ')' }
    }
}

