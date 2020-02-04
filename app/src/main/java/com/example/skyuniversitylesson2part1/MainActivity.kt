package com.example.skyuniversitylesson2part1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val recipeText = findViewById<TextView>(R.id.recipe_text)//Передал из string текст рецепта во view
         recipeText.setText(Html.fromHtml(getString(R.string.recipe_text)))
         val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
         val editText = findViewById<EditText>(R.id.recipe_notes)
         val recipeNoteTextView = findViewById<TextView>(R.id.note_complete_text)

        findViewById<EditText>(R.id.recipe_notes).setOnKeyListener({_, keyCode, _ ->
            //Добавил обработчик нажатия экранной клавиатуры
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //при нажатии экранного  ENTER переприсваиваем редактируемый текст нередактируемому
                //и скрываем клавиатуру
                recipeNoteTextView.text = editText.text//нередактируемый текст = редактируемый текст
                editText.visibility = View.GONE//скрыли редактируемый текст
                recipeNoteTextView.visibility = View.VISIBLE//показали нередактируемый текст
                //Скрываем клавиатуру
                imm.hideSoftInputFromWindow(recipe_notes.windowToken, 0)
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        })

        //Связываем setOnClickListener() с findViewById<TextView> и функцией вызова клавиатуры с передачей возможности редактировать пользовательский текст
         findViewById<TextView>(R.id.note_complete_text).setOnClickListener({
             //Отображаем клавиатуру
             imm.toggleSoftInputFromWindow(recipe_notes.windowToken, InputMethodManager.SHOW_IMPLICIT, 0)
             //Делаем редактируемый текст видимым, а не редактируемый - невидимым
             editText.visibility = View.VISIBLE //показали редактируемый текст
             recipeNoteTextView.visibility = View.GONE//скрыли нередактируемый текст
         })
     }
}
