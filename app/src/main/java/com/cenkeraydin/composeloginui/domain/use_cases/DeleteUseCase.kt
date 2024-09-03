package com.cenkeraydin.composeloginui.domain.use_cases

import com.cenkeraydin.composeloginui.domain.repository.Repository
import javax.inject.Inject

class DeleteUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(id: Long) = repository.delete(id)

}