package kz.itzhiti.spotifycopyable.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kz.itzhiti.spotifycopyable.ui.home.components.*

@Composable
fun SpotifyHomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(8.dp)
    ) {
        // 🔎 Приветствие
        Text(
            text = "Good evening",
            color = Color.White,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 🔎 Фильтры
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FilterButton("Все", isSelected = true)
            FilterButton("Музыка", isSelected = false)
            FilterButton("Подкасты", isSelected = false)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔎 Сетка плейлистов
        val playlists = listOf(
            "Chill Hits" to "https://i.scdn.co/image/ab67706f00000003c44a7c424f7a94d9d205c3df",
            "Top 50 Global" to "https://charts-images.scdn.co/assets/locale_en/regional/weekly/region_global_default.jpg",
            "RapCaviar" to "https://i.scdn.co/image/ab67706f000000032f1baf5edecf66e1f791d2e3",
            "Lo-Fi Beats" to "https://i.scdn.co/image/ab67706f000000039f8bba7d685a38d7e0d6b8c1",
            "Mood Booster" to "https://i.scdn.co/image/ab67706f0000000350373b457769278e41a61c1f",
            "Indie Mix" to "https://i.scdn.co/image/ab67706f00000003b9eeb8a83665c5d4c7ee9c33"
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(playlists) { (title, imageUrl) ->
                PlaylistCard(title = title, imageUrl = imageUrl)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🔎 Мини-плеер снизу
        PlayerBar(
            title = "FILLED WITH SIZZURP",
            artist = "FISTICALE, Mista Play",
            isPlaying = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 🔎 Навигация
        BottomNavBar()
    }
}
