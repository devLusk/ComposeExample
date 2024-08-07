package com.example.composeexemple.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexemple.compose.ExposedDropMenu
import com.example.composeexemple.ui.theme.ComposeExempleTheme
import com.example.composeexemple.ui.theme.Seashell

// Componente para exibir o texto de inicio
@Composable
fun MainText(modifier: Modifier = Modifier) {
    Text(
        text = "Criação do Primeiro Orçamento!",
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier.padding(horizontal = 40.dp)
    )
}

// Componente para entrada de ganhos
@Composable
fun BudgetArea(modifier: Modifier = Modifier) {
    val (value, setValue) = remember { mutableStateOf("") }
    val (selectedOption, setSelectedOption) = remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(
            text = "GANHOS",
            modifier = Modifier.padding(horizontal = 40.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.padding(horizontal = 40.dp)
        ) {
            ExposedDropMenu(
                options = List(10) { "Opção ${it + 1}" },
                selectedOption = selectedOption,
                onOptionSelected = setSelectedOption
            )
            Spacer(modifier = Modifier.width(5.dp))
            OutlinedTextField(
                value = value,
                onValueChange = setValue,
                prefix = { Text(text = "R$") },
                maxLines = 1
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Adicionar"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 40.dp)
                .background(Seashell)
                .padding(16.dp)
        ) {
            // TODO: Adicionar funcionamento para adicionar os items
        }
    }
}

// Componente para a entrada de gastos
@Composable
fun SpendingArea(modifier: Modifier = Modifier) {
    val (spendingValue, setSpendingValue) = remember { mutableStateOf("") }
    val (selectedSpendingOption, setSelectedSpendingOption) = remember { mutableStateOf("") }

    Column(modifier = modifier) {
        Text(
            text = "GASTOS",
            modifier = Modifier.padding(horizontal = 40.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.padding(horizontal = 40.dp)
        ) {
            ExposedDropMenu(
                options = List(10) { "Opção ${it + 1}" },
                selectedOption = selectedSpendingOption,
                onOptionSelected = setSelectedSpendingOption
            )
            Spacer(modifier = Modifier.width(5.dp))
            OutlinedTextField(
                value = spendingValue,
                onValueChange = setSpendingValue,
                prefix = { Text(text = "R$") },
                maxLines = 1
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 40.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Adicionar"
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .padding(horizontal = 40.dp)
                .background(Seashell)
                .padding(16.dp)
        ) {
            // TODO: Adicionar funcionamento para adicionar os items
        }
    }
}

// Tela de orçamento
@Composable
fun BudgetScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(vertical = 16.dp)) {
        MainText()
        Spacer(modifier = Modifier.height(30.dp))
        BudgetArea()
        Spacer(modifier = Modifier.height(20.dp))
        SpendingArea()
    }
}

// Preview da tela de orçamento
@Preview(showSystemUi = true)
@Composable
private fun BudgetScreenPrev() {
    ComposeExempleTheme {
        BudgetScreen()
    }
}
