package com.evillight.fooddelivery.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppsColors provides extendedColors,
        LocalAppTypography provides extendedTypography
    ) {
        MaterialTheme(
            content = content
        )
    }
}

object AppTheme{
    val colors: AppColors
    @Composable
    get() = LocalAppsColors.current
    val typography: AppTypography
    @Composable
    get() = LocalAppTypography.current
}