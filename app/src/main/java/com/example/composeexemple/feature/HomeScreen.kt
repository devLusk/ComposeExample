import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeexemple.R
import com.example.composeexemple.ui.theme.ComposeExempleTheme

// TEXTO DE BEM VINDO
@Composable
fun MainText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bem Vindo!",
            style = MaterialTheme.typography.headlineLarge,
        )
        Text(
            text = "vamos comecar",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

// AREA DE INPUT
@Composable
fun InputArea(modifier: Modifier = Modifier) {
    val (name, newNameValue) = remember { mutableStateOf("") }
    val (lastName, newLastNameValue) = remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = name,
            onValueChange = newNameValue,
            label = { Text(text = "Nome") },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(
            modifier = Modifier
                .padding(top = 20.dp)
        )
        TextField(
            value = lastName,
            onValueChange = newLastNameValue,
            label = { Text(text = "Sobrenome") },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

// BOTAO PARA CONTINUAR
@Composable
fun SendButton(modifier: Modifier = Modifier) {
    Button(
        modifier = Modifier
            .width(165.dp)
            .height(75.dp),
        shape = RoundedCornerShape(10),
        onClick = { /*TODO*/ },
    ) {
        Icon(
            modifier = Modifier
                .size(40.dp),
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Enviar"
        )
    }
}

// LOGO
@Composable
fun FooterLogo(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_dollars),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "SoyPobre",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(
                red = 16,
                green = 185,
                blue = 130,
                alpha = 255
            )
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MainText()
        Spacer(modifier = Modifier.height(50.dp))
        InputArea()
        Spacer(modifier = Modifier.height(50.dp))
        SendButton()
        Spacer(modifier = Modifier.height(50.dp))
        FooterLogo()
    }
}

// PREVIEW DE TUDO
@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPrev() {
    ComposeExempleTheme {
        HomeScreen()
    }
}