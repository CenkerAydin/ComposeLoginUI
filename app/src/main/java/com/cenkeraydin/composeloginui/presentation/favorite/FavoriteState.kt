package com.cenkeraydin.composeloginui.presentation.favorite

import com.cenkeraydin.composeloginui.common.ScreenViewState
import com.cenkeraydin.composeloginui.data.local.model.Note

data class FavoriteState(
    val notes: ScreenViewState<List<Note>> = ScreenViewState.Loading
)
