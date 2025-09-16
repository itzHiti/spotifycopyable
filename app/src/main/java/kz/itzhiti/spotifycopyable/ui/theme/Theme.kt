package kz.itzhiti.spotifycopyable.ui.theme

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kz.itzhiti.spotifycopyable.R
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.size

private val DarkColorScheme = darkColorScheme(
    primary = SpotifyGreen,
    secondary = SpotifyLightGray,
    background = SpotifyBlack,
    surface = SpotifyDarkGray,
    onPrimary = SpotifyBlack,
    onSecondary = SpotifyWhite,
    onBackground = SpotifyWhite,
    onSurface = SpotifyWhite
)

private val LightColorScheme = lightColorScheme(
    primary = SpotifyGreen,
    secondary = SpotifyLightGray,
    background = SpotifyWhite,
    surface = SpotifyLightGray,
    onPrimary = SpotifyWhite,
    onSecondary = SpotifyBlack,
    onBackground = SpotifyBlack,
    onSurface = SpotifyBlack
)

@Composable
fun SpotifyCopyableTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    Image(
        painter = painterResource(id = R.drawable.spotify_logo),
        contentDescription = "Spotify Logo",
        modifier = Modifier.size(120.dp)
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
