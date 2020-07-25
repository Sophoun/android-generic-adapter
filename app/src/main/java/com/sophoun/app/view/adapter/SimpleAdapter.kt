package com.sophoun.app.view.adapter

import android.view.ViewGroup
import com.project.app.R
import com.sophoun.generic.adapter.GenericAdapter
import com.sophoun.generic.adapter.GenericViewHolder
import com.sophoun.utils.DLog
import kotlinx.android.synthetic.main.recycler_item.view.*

class SimpleAdapter : GenericAdapter<String>() {

    override fun attachViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder<String> {
        return SimpleViewHolder(parent)
    }

    class SimpleViewHolder(parent: ViewGroup) : GenericViewHolder<String>(parent, R.layout.recycler_item) {
        override fun bind(data: String) {
            super.bind(data)
            itemView.title.text = data
            DLog.i("Bind method invoked.")
        }
    }
}