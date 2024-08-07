package com.example.composeexemple.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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

// Componente para entrada de ganhos e gastos
@Composable
fun BudgetArea(
    modifier: Modifier = Modifier,
    title: String
) {
    val (value, setValue) = remember { mutableStateOf("") }
    val (selectedOption, setSelectedOption) = remember { mutableStateOf("") }
    val savedValues = remember { mutableStateListOf<String>() }

    val options = if (title == "GANHOS") {
        listOf("Emprego", "Investimentos", "Freelance", "Aluguel", "Pensão", "Prêmios", "Aposentadoria")
    } else {
        listOf("Casa", "Alimentação", "Transporte", "Educação", "Saúde", "Lazer", "Roupas")
    }

    Column(modifier = modifier) {
        Text(
            text = title,
            modifier = Modifier.padding(horizontal = 40.dp),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.padding(horizontal = 40.dp)
        ) {
            ExposedDropMenu(
                options = options,
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
            onClick = {
                if (selectedOption.isEmpty() || value.isEmpty()) return@Button
                savedValues.add("$selectedOption | R$ $value")

                setSelectedOption("")
                setValue("")
            },
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
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
                .padding(horizontal = 40.dp)
                .background(Seashell)
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
        ) {
            savedValues.forEach {
                Text(it)
            }
        }
    }
}

// Componente para o botao de continuar
@Composable
fun StageButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = "Finalizar"
        )
    }
}

// Tela de orçamento
@Composable
fun BudgetScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(vertical = 16.dp)) {
        MainText()
        Spacer(modifier = Modifier.height(30.dp))
        BudgetArea(title = "GANHOS")
        Spacer(modifier = Modifier.height(20.dp))
        BudgetArea(title = "GASTOS")
        Spacer(modifier = Modifier.weight(1f))
        StageButton()
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