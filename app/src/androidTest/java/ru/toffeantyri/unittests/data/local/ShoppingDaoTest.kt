package ru.toffeantyri.unittests.data.local

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import ru.toffeantyri.unittests.getOrAwaitValue

@RunWith(JUnit4::class)
@SmallTest
class ShoppingDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ShoppingItemsDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ShoppingItemsDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.shoppingDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() = runTest() {
        val item = ShoppingItem("", 1, 1f, "url", 1)
        dao.insertShoppingItem(item)
        val allItems = dao.observeAllShoppingItems().getOrAwaitValue()
        assertThat(allItems.contains(item)).isTrue()
    }

    @Test
    fun deleteShoppingItem() = runTest {
        val item = ShoppingItem("", 1, 1f, "url", 1)
        dao.insertShoppingItem(item)
        dao.deleteShoppingItem(item)

        val allItems = dao.observeAllShoppingItems().getOrAwaitValue()
        //assertThat(allItems.contains(item).not()).isTrue()
        assertThat(allItems).doesNotContain(item)
    }

    @Test
    fun observeTotalPriceSum() = runTest {
        val item = ShoppingItem("", 2, 10f, "url", 1)
        val item2 = ShoppingItem("", 4, 5.5f, "url", 2)
        val item3 = ShoppingItem("", 0, 100f, "url", 3)
        dao.insertShoppingItem(item)
        dao.insertShoppingItem(item2)
        dao.insertShoppingItem(item3)

        val totalPrice = dao.observeTotalPrice().getOrAwaitValue()

        assertThat(totalPrice).isEqualTo((2 * 10f) + (4 * 5.5f) + (0 * 100f))


    }

}