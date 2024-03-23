package com.example.mobile1

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonList(){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var persons by remember { mutableStateOf(listOf<Person>()) }

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextField(
                value = name,
                placeholder = {Text(text="Nombre")},
                onValueChange = { text ->
                    name = text
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.size(16.dp))

            TextField(
                value = age,
                placeholder = {Text(text="Edad")},
                onValueChange = { text ->
                    age = text
                },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                onClick = {
                    if (name.isNotBlank() && age.isNotBlank()) {
                        val newPerson = Person(name = name, age = age.toInt())
                        persons = persons + newPerson
                    } else {
                        Toast.makeText(context, "Ingrese nombre y edad", Toast.LENGTH_SHORT).show()
                    }
                    name = ""
                    age = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Añadir"
                )
            }
        }

        Divider()

        Column(modifier = Modifier.fillMaxWidth()) {
            persons.forEach { person ->
                Text(text = "Nombre: ${person.name}, Edad: ${person.age}", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PersonListPreview(){
    PersonList()
}


