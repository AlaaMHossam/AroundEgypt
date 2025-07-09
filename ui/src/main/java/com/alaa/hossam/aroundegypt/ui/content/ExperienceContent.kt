package com.alaa.hossam.aroundegypt.ui.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alaa.hossam.aroundegypt.domain.model.Experience
import com.alaa.hossam.aroundegypt.ui.R
import com.alaa.hossam.aroundegypt.ui.components.experience_details.ExperienceDetailsTopComponent

@Composable
fun ExperienceContent(
    modifier: Modifier = Modifier,
    experience: Experience?,
    onFavoriteClick: (String) -> Unit
) {
    Column {
        ExperienceDetailsTopComponent(
            modifier = modifier,
            coverPhotoUrl = experience?.coverPhoto ?: "",
            views = experience?.views ?: 0
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp)
        ) {
            Column {
                Text(experience?.title ?: "", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(experience?.city ?: "", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = {},
                    content = {
                        Image(
                            painter = painterResource(R.drawable.icn_share),
                            contentDescription = null
                        )
                    })

                IconButton(
                    onClick = { experience?.id?.let { onFavoriteClick(it) } },
                    content = {
                        Image(
                            painter = painterResource(R.drawable.icn_action_favorite),
                            contentDescription = null
                        )
                    })

                Text(
                    text = experience?.likes.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }

        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 14.dp))
        Column(modifier = Modifier.padding(14.dp)) {
            Text("Description", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(experience?.description ?: "", fontSize = 14.sp, fontWeight = FontWeight.Medium)
        }
    }
}

@Preview
@Composable
private fun ExperienceContentPreview() {
    ExperienceContent(experience = Experience(), onFavoriteClick = {})
}