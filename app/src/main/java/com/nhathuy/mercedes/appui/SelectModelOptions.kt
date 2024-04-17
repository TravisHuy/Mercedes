package com.nhathuy.mercedes.appui

import android.graphics.BitmapFactory.Options
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhathuy.mercedes.R
import com.nhathuy.mercedes.components.FormattedPriceLabel
import com.nhathuy.mercedes.data.DataSource
import com.nhathuy.mercedes.ui.theme.CupCakesTheme

@Composable
fun SelectModelOptionsScreen(
    subtotal: String,
    options: List<String>,
    onSelectionChanged: (String) -> Unit = {},
    onCancelButtonClicked: () -> Unit = {},
    onNextButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier,
            verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier= Modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))) {
            options.forEach {
                item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = selectedValue == item,
                        onClick = {
                            selectedValue==item
                            onSelectionChanged(item)
                        }
                    ), verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedValue==item, onClick = {
                            selectedValue==item
                            onSelectionChanged(item)
                    })
                    Text(text = item)
                }
            }
            Divider(thickness = dimensionResource(id = R.dimen.divider), modifier = Modifier.padding(bottom = dimensionResource(
                id =  R.dimen.padding_medium
            )))
            FormattedPriceLabel(subtotal = subtotal,modifier= Modifier
                .align(Alignment.End)
                .padding(
                    top = dimensionResource(
                        id = R.dimen.padding_medium
                    ),
                    bottom = dimensionResource(id = R.dimen.padding_medium)
                ))
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
            ) {
            OutlinedButton(onClick = onCancelButtonClicked,modifier=Modifier.weight(1f)) {
                Text(text = stringResource(id = R.string.cancel))
            }
            Button(onClick = onNextButtonClicked,modifier=Modifier.weight(1f), enabled = selectedValue.isNotEmpty()) {
                Text(text = stringResource(id = R.string.next))
            }
        }
    }

}
@Preview
@Composable
fun TestPreview(){
    CupCakesTheme {
        SelectModelOptionsScreen(subtotal = "4444.4", options = listOf("option 1","option 2","option 3","option 4","option 5"), modifier = Modifier.fillMaxHeight())
    }
}