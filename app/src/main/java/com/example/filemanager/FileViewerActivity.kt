package com.example.filemanager

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class FileViewerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_viewer)

        val textViewContent: TextView = findViewById(R.id.textViewContent)
        val filePath = intent.getStringExtra("filePath")

        filePath?.let {
            val file = File(it)
            if (file.exists() && file.isFile) {
                val content = file.readText()
                textViewContent.text = content
            } else {
                textViewContent.text = "Unable to open file."
            }
        }
    }
}
