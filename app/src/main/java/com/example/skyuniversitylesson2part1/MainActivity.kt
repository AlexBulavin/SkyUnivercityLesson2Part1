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

         val recipeText = findViewById<TextView>(R.id.recipe_text)
         recipeText.setText(Html.fromHtml(getString(R.string.recipe_text)))

        findViewById<EditText>(R.id.recipe_notes).setOnKeyListener({_, keyCode, _ ->
            //Добавил обработчик нажатия экранной клавиатуры
            if (keyCode == KeyEvent.KEYCODE_ENTER) {
                //при нажатии экранного  ENTER вызывается addNoteToRecipe
                addNoteToRecipe(recipe_notes)
                //Действие привязано к объекту nickname_edit
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        })

        //Связываем setOnClickListener() с findViewById<TextView> и функцией вызова клавиатуры с передачей возможности редактировать пользовательский текст
         findViewById<TextView>(R.id.note_complete_text).setOnClickListener({

             changeRecipeNote(note_complete_text)
         })
     }

        private fun addNoteToRecipe(view: View){
            val editText = findViewById<EditText>(R.id.recipe_notes)
            val recipeNoteTextView = findViewById<TextView>(R.id.note_complete_text)

                recipeNoteTextView.text = editText.text//.toString()
                editText.visibility = View.GONE
                view.visibility = View.GONE
                recipeNoteTextView.visibility = View.VISIBLE

            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

        private fun changeRecipeNote(view: View){
            val editText = findViewById<EditText>(R.id.recipe_notes)
            val recipeNoteTextView = findViewById<TextView>(R.id.note_complete_text)

            editText.text = recipeNoteTextView.editableText //.toString()

            //recipeText.setText(Html.fromHtml(getString(R.string.recipe_text)))
            editText.visibility = View.VISIBLE
            view.visibility = View.VISIBLE
            recipeNoteTextView.visibility = View.GONE

            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
}
