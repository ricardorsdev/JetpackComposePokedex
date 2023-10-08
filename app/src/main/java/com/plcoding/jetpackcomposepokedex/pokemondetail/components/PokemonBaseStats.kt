package com.plcoding.jetpackcomposepokedex.pokemondetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.jetpackcomposepokedex.data.models.PokemonEntry
import com.plcoding.jetpackcomposepokedex.util.parseStatToAbbr
import com.plcoding.jetpackcomposepokedex.util.parseStatToColor

@Composable
fun PokemonBaseStats(
    pokemonInfo: PokemonEntry,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember { pokemonInfo.stats.maxOf { it.baseStat } }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Base Stats:",
            fontSize = 20.sp,
            color = MaterialTheme.colors.onSurface
        )
        Spacer(modifier = Modifier.height(4.dp))

        pokemonInfo.stats.forEachIndexed { index, stat ->
            PokemonStat(
                statName = parseStatToAbbr(stat),
                statvalue = stat.baseStat,
                statMaxValue = maxBaseStat,
                statColor = parseStatToColor(stat),
                animDelay = index * animDelayPerItem
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}