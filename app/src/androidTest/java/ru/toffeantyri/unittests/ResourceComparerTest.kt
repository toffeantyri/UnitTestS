package ru.toffeantyri.unittests

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resComparer: ResourceComparer //bad practice


    @Before //init for each test before start test case
    fun setupInstance() {
        resComparer = ResourceComparer()
    }

    @After   //end of each test case
    fun destroyAll() {
        //todo
    }

    @Test
    fun resIsEqualString_returnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resComparer.isEqual(context, R.string.app_name, "UnitTestS")
        assertThat(result).isTrue()
    }

    @Test
    fun resIsNotEqualString_returnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resComparer.isEqual(context, R.string.app_name, "APP_ANY")
        assertThat(result).isFalse()
    }

}