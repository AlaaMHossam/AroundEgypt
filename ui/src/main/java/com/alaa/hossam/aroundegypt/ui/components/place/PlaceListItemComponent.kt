package com.alaa.hossam.aroundegypt.ui.components.place

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.R

@Composable
fun PlaceListItemComponent(modifier: Modifier = Modifier) {
    Column {
        Surface(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .fillMaxWidth()
                .height(154.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(R.drawable.img_place_list_item_cover_dummy),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                PlaceRecommendedComponent(modifier = Modifier.align(Alignment.TopStart))
                Icon(
                    modifier = Modifier.align(Alignment.TopEnd),
                    painter = painterResource(R.drawable.icn_information),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface
                )
                Icon(
                    modifier = Modifier.align(Alignment.Center),
                    painter = painterResource(R.drawable.icn_360),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface
                )
                PlaceViewsComponent(modifier = Modifier.align(Alignment.BottomStart))
                Icon(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    painter = painterResource(R.drawable.icn_images),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.surface
                )
            }
        }

        Row {}
    }
}

@Preview
@Composable
private fun PlaceListItemComponentPreview() {
    PlaceListItemComponent()
}