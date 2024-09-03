package com.cenkeraydin.composeloginui.domain.use_cases

import com.cenkeraydin.composeloginui.data.local.model.Note
import com.cenkeraydin.composeloginui.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke() : Flow<List<Note>> = repository.getAllNotes()

}