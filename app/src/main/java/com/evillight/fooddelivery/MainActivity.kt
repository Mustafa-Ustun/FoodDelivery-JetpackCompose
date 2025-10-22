package com.evillight.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.evillight.fooddelivery.data.OrderState
import com.evillight.fooddelivery.ui.screen.ProductDetailsScreen
import com.evillight.fooddelivery.ui.theme.AppTheme

private const val Product_Price_Per_Unit = 5.25
private const val Product_Currency = "$"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                var amount by remember { mutableIntStateOf(0) }
                val  totalPrice by remember { derivedStateOf { amount * Product_Price_Per_Unit } }
                ProductDetailsScreen(
                    onCheckOutClicked = {},
                    onRemoveItemClicked = {if (amount>0) amount = amount.dec()},
                    onAddItemClicked = {amount = amount.inc()},
                    orderState = OrderState(
                        amount = amount,
                        totalPrice = "$Product_Currency${totalPrice}"
                    )
                )
            }
        }
    }
}
