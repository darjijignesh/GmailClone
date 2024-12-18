package com.jignesh.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jignesh.gmailclone.DrawerMenuData

@Composable
fun GmailDrawerMenu(state: ScrollState) {
    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.AllMail,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Calendar,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Setting,
        DrawerMenuData.Help
    )



    Column(modifier = Modifier.verticalScroll(state)) {
        Text(
            text = "Gmail",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 20.sp,
            letterSpacing = 2.sp,
            color = Color.Red,
            fontWeight = FontWeight.Bold

        )

        menuList.forEach { item ->
            when {
                item.isHeader -> {
                    Text(text = item.title!!, fontWeight = FontWeight.Light, modifier = Modifier.padding(20.dp))
                }

                item.isDivider -> {
                    HorizontalDivider(modifier = Modifier.padding(top = 20.dp, bottom = 20.dp))
                }

                else -> {
                    MenuRowItem(item)
                }
            }
        }

    }
}

@Composable
fun MenuRowItem(item: DrawerMenuData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            imageVector = item.icon!!,
            contentDescription = item.title,
            modifier = Modifier.weight(0.5f)
        )
        Text(
            text = item.title!!, modifier = Modifier
                .weight(2.0f)
        )

    }
}