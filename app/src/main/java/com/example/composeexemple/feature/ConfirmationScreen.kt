package com.example.composeexemple.feature

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexemple.ui.theme.ComposeExempleTheme
import com.example.composeexemple.ui.theme.MountainMeadow
import com.example.composeexemple.ui.theme.Seashell

// Componente para exibir o texto principal
@Composable
fun MainTextConfirmation(modifier: Modifier = Modifier) {
    Text(
        text = "Confirme seus dados!",
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Bold,
        textAlign = androidx.compose.ui.text.style.TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
    )
}

// Componente para a área de informações
@Composable
fun InformationArea(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(Seashell)
    ) {

        // Área de saída do nome
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
        ) {
            Text(
                text = "NOME:",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Lucas Silva", // Adicionar funcionalidade para pegar o nome passado pelo usuário na HomeScreen
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = MountainMeadow,
                modifier = Modifier.padding(10.dp)
            )
        }

        // Área para ganhos totais e os itens
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
        ) {
            Row {
                Text(
                    text = "GANHOS:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MountainMeadow,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "R$ 5.487,99", // Adicionar lógica para somar o total dos items
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MountainMeadow,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Column {
                // Adicionar lógica para pegar os itens da BudgetScreen e colocar aqui
            }
        }

        // Área para gastos totais e os itens
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
        ) {
            Row {
                Text(
                    text = "GASTOS:",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier.padding(10.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "R$ 5.487,99", // Adicionar lógica para somar o total dos items
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier.padding(10.dp)
                )
            }
            Column {
                // Adicionar lógica para pegar os itens da BudgetScreen e colocar aqui
            }
        }
    }
}

@Composable
fun ConfirmationButtons(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
    ) {
        Text(
            text = "CONFIRMAR",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
    }

    Spacer(modifier = Modifier.height(20.dp))

    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp),
        colors = ButtonDefaults.buttonColors(Color.Gray)
    ) {
        Text(
            text = "VOLTAR",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp)
        )
    }
}

// Tela de confirmação
@Composable
fun ConfirmationScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        MainTextConfirmation()
        Spacer(modifier = Modifier.height(40.dp))
        InformationArea()
        Spacer(modifier = Modifier.height(60.dp))
        ConfirmationButtons()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ConfirmationScreenPrev() {
    ComposeExempleTheme {
        ConfirmationScreen()
    }
}
