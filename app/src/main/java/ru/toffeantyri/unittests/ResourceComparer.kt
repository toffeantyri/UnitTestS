package ru.toffeantyri.unittests

import android.content.Context
import androidx.annotation.StringRes


class ResourceComparer {

    fun isEqual(context: Context, @StringRes resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}