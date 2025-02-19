package com.budzen.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = BudzenBlue,
    secondary = BudzenGold,
    background = BudzenGray
)

private val LightColorScheme = lightColorScheme(
    primary = BudzenBlue,
    secondary = BudzenGold,
    background = BudzenGray
)

@Composable
fun BudzenTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(colorScheme = colors, content = content)
}