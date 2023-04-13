package com.example.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hilt.databinding.ActivityAddNoteBinding
import com.example.hilt.db.NoteEntity
import com.example.hilt.repository.DbRepository
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding;

    @Inject
    lateinit var repository: DbRepository;

    @Inject
    lateinit var noteEntity: NoteEntity;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.apply {
            btnSave.setOnClickListener {
                val title = edtTitle.text.toString();
                val desc = edtDesc.text.toString();
                if(title.isNotEmpty() || desc.isNotEmpty()){
                    noteEntity = NoteEntity(0, title, desc);
                    repository.saveNote(noteEntity);
                    finish();
                } else {
                    Snackbar.make(it,"Title and Description cannot be Empty",Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }
}