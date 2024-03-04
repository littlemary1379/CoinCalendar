package com.example.coincalendar.ui.widget

import android.content.Context
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent

object CalendarWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        // Glance Widget은 반드시 provideContent 내부에서 UI가 선언되어야만함
        provideContent {
            Button(
                text = "test", onClick = {
                    println("test Log")
                })
        }
    }
}