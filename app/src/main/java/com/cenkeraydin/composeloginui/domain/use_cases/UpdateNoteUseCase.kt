package com.cenkeraydin.composeloginui.domain.use_cases

import com.cenkeraydin.composeloginui.data.local.model.Note
import com.cenkeraydin.composeloginui.domain.repository.Repository
import javax.inject.Inject

class UpdateNoteUseCase @Inject constructor(
    private val repository: Repository
) {
   suspend operator fun invoke(note: Note) = repository.update(note)
}