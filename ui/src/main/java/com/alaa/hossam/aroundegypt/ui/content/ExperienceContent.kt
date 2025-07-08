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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alaa.hossam.aroundegypt.ui.R
import com.alaa.hossam.aroundegypt.ui.components.experience_details.ExperienceDetailsTopComponent

@Composable
fun ExperienceContent(modifier: Modifier = Modifier) {
    Column {
        ExperienceDetailsTopComponent()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(14.dp)
        ) {
            Column {
                Text("Abu Simbel Temples")
                Text("Aswan, Egypt.")
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
                    onClick = {},
                    content = {
                        Image(
                            painter = painterResource(R.drawable.icn_action_favorite),
                            contentDescription = null
                        )
                    })

                Text("45")
            }

        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 14.dp))
        Column(modifier = Modifier.padding(14.dp)) {
            Text("Description")
            Text("The Abu Simbel temples are two massive rock temples at Abu Simbel, a village in Nubia, southern Egypt, near the border with Sudan. They are situated on the western bank of Lake Nasser, about 230 km southwest of Aswan (about 300 km by road). The twin temples were originally carved out of the mountainside in the 13th century BC, during the 19th dynasty reign of the Pharaoh Ramesses II. They serve as a lasting monument to the king and his queen Nefertari, and commemorate his victory at the Battle of Kadesh. Their huge external rock relief figures have become iconic.")
        }
    }
}

@Preview
@Composable
private fun ExperienceContentPreview() {
    ExperienceContent()
}