package ru.toffeantyri.unittests

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {


    @Test
    fun `empty user name return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "", "123", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `correctly data return true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Anton", "123", "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `user name is exist return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl", "123", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Anton", "", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is not equals conf pas return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Anton", "321", "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password equals conf pas return true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Anton", "123", "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `password not contains 2 digits return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Anton", "qwe", "qwe"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains 2 digits return true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Anton", "qwe12", "qwe12"
        )
        assertThat(result).isTrue()
    }


}