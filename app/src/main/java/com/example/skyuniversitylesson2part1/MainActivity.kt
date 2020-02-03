package com.example.skyuniversitylesson2part1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
//import androidx.databinding.DataBindingUtil
//import com.example.skyuniversitylesson2part1.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

   // private lateinit var binding: ActivityMainBinding

    private val userName: UserName = UserName("Alex Bulavin")

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //recipe_text.setText.(Html.fromHtml.(getTextByID(R.string.recipe_text)))
//        setText (R.string.hello_message)
//        val String htmlTaggedString.getString(R.string.recipe_text)
//        recipe_text.setText.(Html.fromHtml(R.string.recipe_text))
        findViewById<Button>(R.id.done_button).setOnClickListener{addRecipeNotes(it)}
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        binding.userName = userName
         val editText = findViewById<EditText>(R.id.racipe_notes)
         val recipeNoteTextView = findViewById<TextView>(R.id.note_complete_text)
         val recipeText = findViewById<TextView>(R.id.recipe_text)
         val recipeTextSource = getString(R.string.recipe_text)
        findViewById<EditText>(R.id.racipe_notes).setOnEditorActionListener{editText

        }

        //findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
//        binding.doneButton.setOnClickListener {
//            addRecipeNotes(it)
        }

        private fun addRecipeNotes(view: View){
            val editText = findViewById<EditText>(R.id.racipe_notes)
            val recipeNoteTextView = findViewById<TextView>(R.id.note_complete_text)
            val recipeText = findViewById<TextView>(R.id.recipe_text)
            val recipeTextSource = getString(R.string.recipe_text)

                recipeNoteTextView.text = editText.text//.toString()

                recipeText.setText(Html.fromHtml(recipeTextSource))
                editText.visibility = View.GONE
                view.visibility = View.GONE
                recipeNoteTextView.visibility = View.VISIBLE

//            binding.apply {
//                //binding.nicknameText.text = binding.nicknameEdit.text
//                userName?.recipeNoteTextView = editText.text.toString()
//                invalidateAll()
//                binding.racipeNotes.visibility = View.GONE
//                binding.doneButton.visibility = View.GONE
//                binding.noteCompleteText.visibility = View.VISIBLE

            // Hide the keyboard.
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }

}
