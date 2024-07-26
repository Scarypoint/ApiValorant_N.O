package com.beta.valorantapi.com
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter


@Composable
fun AgentsScreen(valorantViewModel: ValorantViewModel = viewModel()) {
    val agentList by valorantViewModel.agentsList.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberImagePainter("https://media.valorant-api.com/maps/2fb9a4fd-47b8-4e7d-a969-74b4046ebd53/listviewicontall.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (agentList.isNotEmpty()) {
                AgenteItem(agent = agentList[currentIndex])

                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (currentIndex > 0) currentIndex--
                        },
                        enabled = currentIndex > 0,
                        colors = buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Atrás", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (currentIndex < agentList.size - 1) currentIndex++
                        },
                        enabled = currentIndex < agentList.size - 1,
                        colors = buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Siguiente", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun AgenteItem(agent: Agents) {
    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace, // Cambia esto a la fuente que prefieras
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp, // Tamaño de la fuente
        color = Color.White // Color de la fuente
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = agent.displayName,
            style = customTextStyle
        )
        AsyncImage(
            model = agent.displayIcon,
            contentDescription = null,
            modifier = Modifier.size(150.dp) // Ajusta el tamaño de la imagen aquí
        )
        Text(
            text = agent.description,
            style = customTextStyle
        )
    }
}
@Composable
fun WeaponItem(weapon: Weapons) {
    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = weapon.displayName,
            style = customTextStyle
        )
        AsyncImage(
            model = weapon.displayIcon,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = weapon.category,
            style = customTextStyle
        )
    }
}
@Composable
fun WeaponScreen(valorantViewModel: ValorantViewModel = viewModel()) {
    val weaponList by valorantViewModel.weaponsList.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberImagePainter("https://media.valorant-api.com/maps/690b3ed2-4dff-945b-8223-6da834e30d24/listviewicontall.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (weaponList.isNotEmpty()) {
                WeaponItem(weapon = weaponList[currentIndex])

                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (currentIndex > 0) currentIndex--
                        },
                        enabled = currentIndex > 0,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Atrás", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (currentIndex < weaponList.size - 1) currentIndex++
                        },
                        enabled = currentIndex < weaponList.size - 1,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Siguiente", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun MapsItem(maps: Maps) {
    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = maps.displayName,
            style = customTextStyle
        )
        AsyncImage(
            model = maps.splash,
            contentDescription = null,
            modifier = Modifier.size(350.dp)
        )
        maps.tacticalDescription?.let {
            Text(
                text = it,
                style = customTextStyle
            )
        }
    }
}

@Composable
fun MapScreen(valorantViewModel: ValorantViewModel = viewModel()) {
    val mapsList by valorantViewModel.mapsList.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberImagePainter("https://media.valorant-api.com/maps/12452a9d-48c3-0b02-e7eb-0381c3520404/listviewicontall.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (mapsList.isNotEmpty()) {
                MapsItem(maps = mapsList[currentIndex])

                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (currentIndex > 0) currentIndex--
                        },
                        enabled = currentIndex > 0,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Atrás", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (currentIndex < mapsList.size - 1) currentIndex++
                        },
                        enabled = currentIndex < mapsList.size - 1,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Siguiente", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun SpraysItem(sprays: Sprays) {
    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = sprays.displayName,
            style = customTextStyle
        )
        AsyncImage(
            model = sprays.fullTransparentIcon,
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )
    }
}

@Composable
fun SpraysScreen(valorantViewModel: ValorantViewModel = viewModel()) {
    val spraysList by valorantViewModel.spraysList.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberImagePainter("https://media.valorant-api.com/maps/de28aa9b-4cbe-1003-320e-6cb3ec309557/listviewicontall.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (spraysList.isNotEmpty()) {
                SpraysItem(sprays = spraysList[currentIndex])

                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (currentIndex > 0) currentIndex--
                        },
                        enabled = currentIndex > 0,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Atrás", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (currentIndex < spraysList.size - 1) currentIndex++
                        },
                        enabled = currentIndex < spraysList.size - 1,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Siguiente", color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun CardsItem(cards: PlayerCards) {
    val customTextStyle = androidx.compose.ui.text.TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.White
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        Text(
            text = cards.displayName,
            style = customTextStyle
        )
        AsyncImage(
            model = cards.largeArt,
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )
    }
}
@Composable
fun PlayerCardsScreen(valorantViewModel: ValorantViewModel = viewModel()) {
    val cardsList by valorantViewModel.cardsList.collectAsState()
    var currentIndex by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberImagePainter("https://media.valorant-api.com/maps/224b0a95-48b9-f703-1bd8-67aca101a61f/listviewicontall.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (cardsList.isNotEmpty()) {
                CardsItem(cards = cardsList[currentIndex])

                Row(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            if (currentIndex > 0) currentIndex--
                        },
                        enabled = currentIndex > 0,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Atrás", color = Color.White)
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        onClick = {
                            if (currentIndex < cardsList.size - 1) currentIndex++
                        },
                        enabled = currentIndex < cardsList.size - 1,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF6200EE).copy(alpha = 0.5f)
                        )
                    ) {
                        Text("Siguiente", color = Color.White)
                    }
                }
            }
        }
    }
}