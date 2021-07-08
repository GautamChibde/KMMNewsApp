package com.example.newsapp.android.ui.profile

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.android.theme.NewsAppTypography
import com.example.newsapp.model.NewsCategories
import java.util.*


val gradients = listOf<Brush>(
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xff00b09b),
            Color(0xff96c93d),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xffD3CCE3),
            Color(0xffE9E4F0),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xffF57F17),
            Color(0xffFFEE58),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xff005AA7),
            Color(0xffFFFDE4),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xff00B4DB),
            Color(0xff0083B0),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xffFFEFBA),
            Color(0xffFFFFFF),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xff59C173),
            Color(0xffa17fe0),
            Color(0xff5D26C1),
        )
    ),
    Brush.horizontalGradient(
        colors = listOf(
            Color(0xffF57F17),
            Color(0xffFFEE58),
        )
    ),
)

@ExperimentalFoundationApi
@Preview
@Composable
fun Profile() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Explore", style = NewsAppTypography.h4)
        Spacer(modifier = Modifier.height(32.dp))
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            itemsIndexed(NewsCategories.values()) { index, item ->
                Column(
                    modifier = Modifier
                        .height(125.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(gradients[index]),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = item.value.replaceFirstChar {
                            if (it.isLowerCase()) it.titlecase(
                                Locale.UK
                            ) else it.toString()
                        },
                        style = NewsAppTypography.subtitle1
                    )
                }
            }
        }
    }
}