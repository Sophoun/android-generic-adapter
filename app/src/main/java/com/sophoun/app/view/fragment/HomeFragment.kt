package com.sophoun.app.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.app.R
import com.sophoun.app.view.adapter.SimpleAdapter
import com.sophoun.ui.state.BaseFragment
import com.sophoun.utils.DLog
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment() {

    private val simpleAdapter = SimpleAdapter()

    override fun layout(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DLog.i("HomeFragment created.")

        val list = mutableListOf<String>()
        repeat(300) {
            list.add("Hello World! $it")
        }

        recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = simpleAdapter

        simpleAdapter.addOnItemClickListener { view, position, item ->
            Log.i("Clicked:", "Item Clicked: ${view.id}")
        }

        simpleAdapter.setItems(list)
        simpleAdapter.notifyDataSetChanged()
    }
}