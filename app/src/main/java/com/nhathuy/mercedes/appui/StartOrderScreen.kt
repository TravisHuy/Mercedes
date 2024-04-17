package com.nhathuy.mercedes.appui

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nhathuy.mercedes.Greeting
import com.nhathuy.mercedes.R
import com.nhathuy.mercedes.data.DataSource.quantityOptions
import com.nhathuy.mercedes.ui.theme.CupCakesTheme

@Composable
fun StartOrderScreen(
    quantityOptions:List<Pair<Int,Int>>,
    onNextButtonClicked: (Int) ->Unit,
    modifier: Modifier = Modifier,
){
    Column(modifier = modifier,
    verticalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))) {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            Image(painter = painterResource(id = R.drawable.mercedes_img),
                contentDescription =null,modifier=Modifier.width(150.dp).clip(shape = CircleShape), contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_medium)))
            Text(text = stringResource(id = R.string.order_mercedes), style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(80.dp))
            quantityOptions.forEach {
                item ->
                SelectQuantityButton(
                    labelResourceId=item.first,
                    onClick ={onNextButtonClicked(item.second)},
                    modifier=Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun SelectQuantityButton(@StringRes labelResourceId: Int, onClick: () -> Unit, modifier: Modifier) {
    Button(onClick = onClick,modifier=modifier.widthIn(min = 250.dp)) {
        Text(stringResource(id = labelResourceId))
    }
}

@Preview
@Composable
fun StartScreenPreview(){
    CupCakesTheme {
       StartOrderScreen(quantityOptions = quantityOptions, onNextButtonClicked = {})
    }
}