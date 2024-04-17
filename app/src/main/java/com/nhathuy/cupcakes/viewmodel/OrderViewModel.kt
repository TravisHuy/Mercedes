package com.nhathuy.cupcakes.viewmodel

import androidx.lifecycle.ViewModel
import com.nhathuy.cupcakes.data.DataSource
import com.nhathuy.cupcakes.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

private const val PRICE_PER_MERCEDES=50000.0
private const val PRICE_FOR_SAME_DAY_PICKUP=70000.0
class OrderViewModel : ViewModel() {

    /*
        mercedes state for this order
     */
    private val _uiState= MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
    val uiState : StateFlow<OrderUiState> = _uiState.asStateFlow()

    /*
        return a list of date options starting the current date and the following 5 dates
     */
    private fun pickupOptions(): List<String> {
        val dateOptions= mutableListOf<String>()
        val formatter =SimpleDateFormat("E MM d", Locale.getDefault())
        val calendar=Calendar.getInstance()

        repeat(6){
            dateOptions.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE,1)
        }
        return dateOptions
    }

    /*
        set  the quantity [numberMercedes] of mercedes for this order's and update the price
     */
    fun setQuantity(numberMercedes:Int){
        _uiState.update {
            currentState ->
                currentState.copy(
                    quantity = numberMercedes,
                    price = calculatePrice(quantity=numberMercedes)
                )

        }
    }
    /*
    * Set the model for the order and update the ViewModel state.
 * When a specific model is selected by the user, we need to determine the corresponding type of that model.
 * The type will be used to display appropriate attributes related to the selected model.
     */
    fun setModel(mercedesModel: String) {
        _uiState.update { currentState: OrderUiState -> // Explicitly specify OrderUiState
            val type = getTypeForModel(mercedesModel)
            currentState.copy(model = mercedesModel, type = type)
        }
    }
    /*
    * Determine the type of Mercedes for the given model.
    * The type is determined based on the provided model by checking it against predefined lists of models in DataSource.
     */
    private fun getTypeForModel(mercedesModel: String): String {
        return when {
            mercedesModel in DataSource.sendans_list -> "Sendans"
            mercedesModel in DataSource.suvs_list -> "SUVs"
            mercedesModel in DataSource.coupes_list -> "Coupes"
            mercedesModel in DataSource.convertibles_list -> "Convertibles"
            mercedesModel in DataSource.electric_list -> "Electric"
            mercedesModel in DataSource.additional_list -> "Additional"
            else -> "" // Handle cases where the model type is not found
        }
    }



    /*
     set the [pickupDate] for this order's state and update the price
     */
    fun setDate(pickDate: String){
        _uiState.update {
            currnetDate ->
            currnetDate.copy(date = pickDate,
            price = calculatePrice(pickDate=pickDate))
        }
    }
    /*
        reset order state
     */
    fun resetOrder(){
        _uiState.value=OrderUiState(pickupOptions = pickupOptions())
    }

    private fun calculatePrice(quantity: Int=_uiState.value.quantity,
    pickDate:String =_uiState.value.date): String {
            var calcutedPrice= quantity* PRICE_PER_MERCEDES
        if(pickupOptions()[0]==pickDate){
            calcutedPrice+= PRICE_FOR_SAME_DAY_PICKUP
        }
        val formattedPrice=NumberFormat.getCurrencyInstance().format(calcutedPrice)
        return formattedPrice
    }
}