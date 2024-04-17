package com.nhathuy.mercedes.appui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.nhathuy.mercedes.data.OrderUiState

@Composable
fun OrderSummaryScreen(
    orderUiState: OrderUiState,
    onCancelButtonClicked : () ->Unit,
    onSendButtonClicked : (String ,String) -> Unit,
    modifier: Modifier=Modifier
){

}