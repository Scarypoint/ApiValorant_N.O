package com.beta.valorantapi.com
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay


@Composable
fun Menu(nav: NavHostController) {
    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Cursive,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    // Animación de color para las letras de los botones
    val buttonTextColor = remember { Animatable(Color.White) }

    LaunchedEffect(Unit) {
        while (true) {
            buttonTextColor.animateTo(Color.Red, animationSpec = tween(durationMillis = 1000))
            buttonTextColor.animateTo(Color.Green, animationSpec = tween(durationMillis = 1000))
            buttonTextColor.animateTo(Color.Blue, animationSpec = tween(durationMillis = 1000))
            buttonTextColor.animateTo(Color.Yellow, animationSpec = tween(durationMillis = 1000))
            delay(1000)
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = rememberImagePainter("https://media.valorant-api.com/gamemodes/e086db66-47fd-e791-ca81-06a645ac7661/listviewicontall.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Menú Principal Valorant API",
                style = TextStyle(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = Color.Cyan
                ),
                modifier = Modifier.padding(top = 90.dp)
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val buttonModifier = Modifier
                    .fillMaxWidth(0.27f)
                    .padding(vertical = 4.dp)

                val buttonColors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6200EE).copy(alpha = 0.5f),
                    contentColor = buttonTextColor.value // Usamos el color animado
                )

                Button(
                    onClick = { nav.navigate("agentes") },
                    colors = buttonColors,
                    modifier = buttonModifier
                ) {
                    Text(text = "Agentes", style = customTextStyle.copy(color = buttonTextColor.value))
                }
                Button(
                    onClick = { nav.navigate("weapons") },
                    colors = buttonColors,
                    modifier = buttonModifier
                ) {
                    Text(text = "Armas", style = customTextStyle.copy(color = buttonTextColor.value))
                }
                Button(
                    onClick = { nav.navigate("maps") },
                    colors = buttonColors,
                    modifier = buttonModifier
                ) {
                    Text(text = "Mapas", style = customTextStyle.copy(color = buttonTextColor.value))
                }
                Button(
                    onClick = { nav.navigate("sprays") },
                    colors = buttonColors,
                    modifier = buttonModifier
                ) {
                    Text(text = "Sprays", style = customTextStyle.copy(color = buttonTextColor.value))
                }
                Button(
                    onClick = { nav.navigate("playercards") },
                    colors = buttonColors,
                    modifier = buttonModifier
                ) {
                    Text(text = "Cards", style = customTextStyle.copy(color = buttonTextColor.value))
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // Añadimos un espacio extra al final
        }
    }
}