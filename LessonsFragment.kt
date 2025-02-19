package com.budzen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LessonsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lessons, container, false)

        val lessonList = view.findViewById<RecyclerView>(R.id.lessonList)
        lessonList.layoutManager = LinearLayoutManager(requireContext())

        val lessons = listOf("Lesson A", "Lesson B", "Lesson C")
        val adapter = LessonAdapter(lessons)
        lessonList.adapter = adapter

        return view
    }
}