package ru.toffeantyri.unittests

object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    /**
     * user name not valid if
     * ...user name/password is empty
     * ...user name is already taken
     * ... confirm password is not same as the password
     * ...password contains less then 2 digits
     * */

    fun validateRegistrationInput(
        userName: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) return false
        if (existingUsers.contains(userName)) return false
        if (password != confirmPassword) return false
        if (password.count { it.isDigit() } < 2) return false
        return true
    }

}