package ru.toffeantyri.unittests

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class HomeWorkFibTest{

    @Test
    fun `braces correctly`(){
        val result = HomeWorkFib.checkBraces("(a+b)")
        assertThat(result).isTrue()
    }

    @Test
    fun `braces not correctly`() {
        val result = HomeWorkFib.checkBraces("(a+b))")
        assertThat(result).isFalse()
    }

    @Test
    fun `braces inverted not correctly`() {
        val result = HomeWorkFib.checkBraces(")a+b(")
        assertThat(result).isFalse()
    }

    @Test
    fun `braces inverted not correctly 2`() {
        val result = HomeWorkFib.checkBraces(")(a+b)(")
        assertThat(result).isFalse()
    }


    @Test
    fun `fib 0 is 0`() {
        val result = HomeWorkFib.fib(0)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `fib 1 is 1`() {
        val result = HomeWorkFib.fib(1)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `fib n=8 is 21`(){
        val result = HomeWorkFib.fib(8)
        assertThat(result).isEqualTo(21)
    }

    @Test
    fun `fib n=9 is 34`(){
        val result = HomeWorkFib.fib(9)
        assertThat(result).isEqualTo(34)
    }

    @Test
    fun `fib n=10 is 55`(){
        val result = HomeWorkFib.fib(9)
        assertThat(result).isEqualTo(34)
    }



}