package com.example.recyclerview4

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.clickjude.view.*
import org.w3c.dom.Text

class RecyclerView4Adapter(private val singerList: List<RecyclerView4Item>) :
    RecyclerView.Adapter<RecyclerView4Adapter.RecyclerView4Holder>() {

    var callback : RecyclerView4AdapterCallback? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView4Adapter.RecyclerView4Holder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.clickjude, parent, false
        )
        return RecyclerView4Holder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView4Adapter.RecyclerView4Holder, position: Int) {
        val currentItem: RecyclerView4Item = singerList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView1.setOnClickListener{
            callback?.onClick(currentItem)
            println("歌手名:${currentItem.text1}")

        }

    }
    override fun getItemCount(): Int = singerList.size

    class RecyclerView4Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.imageView
        val textView1: TextView = itemView.textView1
        val textView2: TextView = itemView.textView2

    }
    interface RecyclerView4AdapterCallback{
        fun onClick(item:RecyclerView4Item)
    }
}


