package com.example.rickandmorty.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.rickandmorty.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String = "Rick and Morty",
    isVisible: Boolean = true,
) {
    val context = LocalContext.current
    TopAppBar(
        title = {
            Text(
                text = title
            )
        },
        colors =  TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon ={
            if (isVisible){
                Icon(
                    painter = painterResource(R.drawable.ic_arrowback),
                    contentDescription = "",
                    tint = Color(ContextCompat.getColor(context,R.color.iconColor))
                )
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {

                    Icon(
                        painter = painterResource(R.drawable.ic_settings),
                        contentDescription = "",
                        tint = Color(ContextCompat.getColor(context,R.color.iconColor))
                    )

            }
        }

    )


}

@Composable
@Preview(
    showBackground = true
)
fun ShowAppBar() {
    CustomAppBar()
}