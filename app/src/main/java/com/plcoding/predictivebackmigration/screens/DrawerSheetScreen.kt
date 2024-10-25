package com.plcoding.predictivebackmigration.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DismissibleDrawerSheet
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun DrawerSheetScreen(
    modifier: Modifier = Modifier
) {


    var isDrawerSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Screen C",
            fontSize = 42.sp
        )
        Button(
            onClick = {
                scope.launch {
                    isDrawerSheetOpen = !isDrawerSheetOpen
                }
            }
        ) {
            Text(text = "Open drawer sheet")
        }
    }

    if (isDrawerSheetOpen) {
        DismissibleDrawerSheet(
            drawerState = DrawerState(DrawerValue.Open),
            drawerContainerColor = Color.Red
        ) {
            // Content of the drawer sheet
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text("This is the drawer sheet content")
                // Add more content here
            }
        }
    }
}