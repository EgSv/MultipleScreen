package ru.startandroid.develop.multiplescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetailsFragment: Fragment() {

    val position: Int
    get() = arguments?.getInt("position", 0)!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v: View = inflater.inflate(R.layout.details, container, false)
        val tv: TextView = v.findViewById<View>(R.id.tvText) as TextView
        tv.text = resources.getStringArray(R.array.content)[position]
        return v
    }

    companion object {
        fun newInstance(pos: Int): DetailsFragment {
            val details = DetailsFragment()
            val args = Bundle()
            args.putInt("position", pos)
            details.arguments = args
            return details
        }
    }
}