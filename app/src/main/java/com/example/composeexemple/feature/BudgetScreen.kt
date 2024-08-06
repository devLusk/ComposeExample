package com.example.composeexemple.feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexemple.ui.theme.ComposeExempleTheme
import com.example.composeexemple.compose.ExposedDropMenu

@Composable
fun MainText(modifier: Modifier = Modifier) {
    Text(
        text = "Criação do Primeiro Orçamento!",
        fontSize = 32.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun BudgetArea(modifier: Modifier = Modifier) {
    val (value, setValue) = remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(
            text = "GANHOS"
        )
        Spacer(modifier = Modifier.padding(top = 15.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 40.dp)
        ) {
            ExposedDropMenu(
                options = List(10) { "Opção ${it + 1}" }
            )
            Spacer(modifier = Modifier.padding(10.dp))
            OutlinedTextField(
                value = value,
                placeholder = {
                    Text(text = "R$")
                },
                onValueChange = setValue,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun BudgetScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        MainText()
        Spacer(modifier = Modifier.padding(top = 40.dp))
        BudgetArea()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BudgetScreenPrev() {
    ComposeExempleTheme {
        BudgetScreen()
    }
}