package ru.startandroid.develop.multiplescreen

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class DetailsActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (resources.configuration.orientation
            == Configuration.ORIENTATION_LANDSCAPE
            && isLarge
        ) {
            finish()
            return
        }
        if (savedInstanceState == null) {
            val details = DetailsFragment.newInstance(intent
                .getIntExtra("position", 0))
            supportFragmentManager.beginTransaction()
                .add(androidx.appcompat.R.id.content, details).commit()
        }
    }

    val isLarge: Boolean
        get() = ((resources.configuration.screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
}