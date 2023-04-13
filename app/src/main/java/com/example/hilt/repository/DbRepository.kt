package com.example.hilt.repository

import com.example.hilt.db.NoteDao
import com.example.hilt.db.NoteEntity
import javax.inject.Inject

class DbRepository
@Inject constructor(
    private val dao: NoteDao
) {
    fun saveNote(note: NoteEntity) = dao.insertNote(note)
    fun updateNote(note: NoteEntity) = dao.updateNote(note)
    fun deleteNote(note: NoteEntity) = dao.deleteNote(note)
    fun getNoteDetail(id: Int) = dao.getNoteDetail(id)
    fun getAllNotes() = dao.getAllNotes()
}