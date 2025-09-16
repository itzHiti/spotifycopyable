package kz.itzhiti.spotifycopyable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kz.itzhiti.spotifycopyable.ui.home.SpotifyHomeScreen
import kz.itzhiti.spotifycopyable.ui.theme.SpotifyCopyableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpotifyCopyableTheme {
                SpotifyHomeScreen()
            }
        }
    }
}