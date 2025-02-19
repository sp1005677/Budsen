package com.budzen

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LessonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)

        val lessonList = findViewById<RecyclerView>(R.id.lessonList)
        lessonList.layoutManager = LinearLayoutManager(this)

        val lessons = listOf("Lesson 1", "Lesson 2", "Lesson 3")
        val adapter = LessonAdapter(lessons)
        lessonList.adapter = adapter

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Closes the activity
        }
    }
}