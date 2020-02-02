package com.example.skyuniversitylesson2part1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //recipe_text.setText.(Html.fromHtml.(getTextByID(R.string.recipe_text)))
//        setText (R.string.hello_message)
//        val String htmlTaggedString.getString(R.string.recipe_text)
//        recipe_text.setText.(Html.fromHtml(R.string.recipe_text))
    }
}
