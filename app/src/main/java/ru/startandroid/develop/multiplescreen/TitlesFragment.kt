package ru.startandroid.develop.multiplescreen

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.ListFragment

class TitlesFragment: ListFragment() {

    interface onItemClickListener {
        fun itemClick(position: Int)
    }

    var listener: onItemClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(requireActivity(),
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.headers))
        listAdapter = adapter
    }

    fun onAttach(activity: AppCompatActivity) {
        super.onAttach(activity)
        listener = activity as onItemClickListener?
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        listener?.itemClick(position)
    }
}