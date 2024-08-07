import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexemple.R
import com.example.composeexemple.ui.theme.ComposeExempleTheme
import com.example.composeexemple.ui.theme.MountainMeadow

// Componente para exibir o texto de boas-vindas
@Composable
fun MainText(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Bem Vindo!",
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Vamos começar",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

// Componente para a área de entrada de dados
@Composable
fun InputArea(modifier: Modifier = Modifier) {
    val (name, setName) = remember { mutableStateOf("") }
    val (lastName, setLastName) = remember { mutableStateOf("") }

    Column(modifier = modifier) {
        TextField(
            value = name,
            onValueChange = setName,
            label = { Text(text = "Nome") },
            placeholder = { Text(text = "Digite seu nome") },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = lastName,
            onValueChange = setLastName,
            label = { Text(text = "Sobrenome") },
            placeholder = { Text(text = "Digite seu sobrenome") },
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// Componente para o botão de envio
@Composable
fun SendButton(modifier: Modifier = Modifier) {
    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .width(165.dp)
            .height(75.dp),
        shape = RoundedCornerShape(10)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Enviar",
            modifier = Modifier.size(40.dp)
        )
    }
}

// Componente para o logo no rodapé
@Composable
fun FooterLogo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_dollars),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "SoyPobre",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = MountainMeadow
        )
    }
}

// Tela principal do aplicativo
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column {
        Column(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth()
                .padding(40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            MainText()
            Spacer(modifier = Modifier.height(50.dp))
            InputArea()
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                SendButton()
            }
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            FooterLogo()
        }
    }
}

// Preview da tela principal
@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    ComposeExempleTheme {
        HomeScreen()
    }
}
