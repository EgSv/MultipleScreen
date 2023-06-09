package ru.startandroid.develop.multiplescreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import ru.startandroid.develop.multiplescreen.TitlesFragment.onItemClickListener


class MainActivity : FragmentActivity(), onItemClickListener {
    var position = 0
    var withDetails = true
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) position = savedInstanceState.getInt("position")
        withDetails = findViewById<View?>(R.id.cont) != null
        if (withDetails) showDetails(position)
    }

    fun showDetails(pos: Int) {
        if (withDetails) {
            var details = supportFragmentManager
                .findFragmentById(R.id.cont) as DetailsFragment?
            if (details == null || details.position != pos) {
                details = DetailsFragment.newInstance(pos)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.cont, details).commit()
            }
        } else {
            startActivity(Intent(this, DetailsActivity::class.java).putExtra("position", position))
        }
    }

    override fun itemClick(position: Int) {
        this.position = position
        showDetails(position)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("position", position)
    }
}