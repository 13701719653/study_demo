package com.study.myapplication.ui;

import android.content.Intent
import android.os.Bundle;
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView;
import com.base.baselibrary.adapter.RecyclerViewAdapter

import com.study.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList;

 class MainActivity : AppCompatActivity() {
    val array:ArrayList<String> by lazy{
        ArrayList<String>()
    }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        array.add("ui绘制流程")
        array.add("paint canvasg高级绘制")
         val rvAdapter = object :RecyclerViewAdapter<String>(array,R.layout.item_rv){
             override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                 super.onBindViewHolder(holder, position)
                 holder.itemView.findViewById<TextView>(R.id.tv).text = array[position]
             }
         }
         rvAdapter.setOnItemClick { viewHolder, position ->
             when(position){
                 0->{startActivity(Intent(this@MainActivity, PaintActivity::class.java))}
                 1->{}
             }
         }

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=rvAdapter

    }


}
