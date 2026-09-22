package com.retrivedmods.lynxclient.util

import com.retrivedmods.lynxclient.game.TranslationManager
import java.util.Locale

inline val String.translatedSelf: String
    get() {
        return TranslationManager.getTranslationMap(Locale.getDefault().language)[this]
            ?: this
    }