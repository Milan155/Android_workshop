package com.example.recycleview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView

class MainActivity : AppCompatActivity() {


    private lateinit var sliderLayout: SliderLayout
     var map = HashMap<String, Int>()

     private lateinit var recyclerView: RecyclerView
     private lateinit var list: MutableList<model>




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          sliderLayout = findViewById(R.id.slider1)
          recyclerView = findViewById(R.id.recyclerview)
          list = ArrayList()

        map.put("item1", R.drawable.food1)
        map.put("item2", R.drawable.food2)
        map.put("item3", R.drawable.food3)

        for (i in map.keys) {
            var textsilder = TextSliderView(this)
            textsilder.description(i)
            textsilder.image(map.get(i)!!)
            sliderLayout.addSlider(textsilder)
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal)

        var manager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = manager


        list.add(model(R.drawable.food1, "item1"))
        list.add(model(R.drawable.food2, "item2"))
        list.add(model(R.drawable.food3, "item3"))

        var myadapter = Myadapter(applicationContext, list as ArrayList<model>)
        recyclerView.adapter = myadapter


    }
}