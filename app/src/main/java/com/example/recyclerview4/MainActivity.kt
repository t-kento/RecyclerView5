package com.example.recyclerview4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.size

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val singerList: List<RecyclerView4Item> = musicList()

        recyclerView.apply {
            adapter = RecyclerView4Adapter(singerList)
            layoutManager = LinearLayoutManager(this@MainActivity).apply {
                orientation = RecyclerView.VERTICAL

            }
            setHasFixedSize(true)
        }
    }

    private fun musicList(): List<RecyclerView4Item> {

        val list = mutableListOf<RecyclerView4Item>()


        for (i in 0..11) {
            var a: MutableList<String> = mutableListOf(
                "コブクロ", "馬場俊英", "backnumber", "コブクロ", "ZARD", "キロロ",
                "コブクロ", "ZARD", "コブクロ", "コブクロ", "SPEED", "ゆず"
            )
            var b: MutableList<String> = mutableListOf(
                "蒼く優しく", "スタートライン", "高嶺の花子さん", "door", "永遠", "BestFriend",
                "心", "負けないで", "未来", "卒業", "my graduation", "桜木町"
            )

            val drawable = when (i % 12) {
                0 -> R.drawable.aokuyasashiku
                1 -> R.drawable.baba
                2 -> R.drawable.backnumber
                3 -> R.drawable.door
                4 -> R.drawable.eienn
                5 -> R.drawable.kiroro
                6 -> R.drawable.kokoro
                7 -> R.drawable.makenaide
                8 -> R.drawable.mirai
                9 -> R.drawable.sotugyou
                10 -> R.drawable.speed
                else -> R.drawable.yuzu
            }

            val item = RecyclerView4Item(drawable, "歌手：${a[i]}", "曲名：${b[i]}")
            list += item
        }
        return list

    }
}
