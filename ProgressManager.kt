package com.budzen

import android.content.Context
import android.content.SharedPreferences

object ProgressManager {
    private const val PREF_NAME = "BudzenProgress"
    private const val KEY_LESSONS_COMPLETED = "lessons_completed"
    private const val KEY_CORRECT_ANSWERS = "correct_answers"

    fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun markLessonCompleted(context: Context) {
        val prefs = getSharedPreferences(context)
        val completed = prefs.getInt(KEY_LESSONS_COMPLETED, 0) + 1
        prefs.edit().putInt(KEY_LESSONS_COMPLETED, completed).apply()
    }

    fun increaseCorrectAnswers(context: Context) {
        val prefs = getSharedPreferences(context)
        val correct = prefs.getInt(KEY_CORRECT_ANSWERS, 0) + 1
        prefs.edit().putInt(KEY_CORRECT_ANSWERS, correct).apply()
    }

    fun getLessonsCompleted(context: Context): Int {
        return getSharedPreferences(context).getInt(KEY_LESSONS_COMPLETED, 0)
    }

    fun getCorrectAnswers(context: Context): Int {
        return getSharedPreferences(context).getInt(KEY_CORRECT_ANSWERS, 0)
    }
}