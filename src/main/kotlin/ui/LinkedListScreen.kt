package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import interfaces.LinkedList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LinkedListScreen(list: LinkedList<String>) {

    var listSize by remember { mutableStateOf(list.size()) }
    var inputText by remember { mutableStateOf("") }

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()).fillMaxSize()
    )
    {
        Spacer(modifier = Modifier.height(64.dp))
        Text(
            text ="${list.javaClass}",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputText,
            onValueChange = { inputText = it },
            label = { Text("Enter element") },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                list.addFirst(inputText)
                listSize = list.size()
                inputText = ""
            }) {
                Text("Add First")
            }

            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                list.addLast(inputText)
                listSize = list.size()
                inputText = ""
            }) {
                Text("Add Last")
            }

            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                list.removeFirst()
                listSize = list.size()
            }) {
                Text("Remove First")
            }

            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                list.removeLast()
                listSize = list.size()
            }) {
                Text("Remove Last")
            }

            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                list.clear()
                listSize = list.size()
            }) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text("List Size: $listSize")

        Spacer(modifier = Modifier.height(8.dp))
        Text("List Elements:")

        Spacer(modifier = Modifier.height(8.dp))
        Text(list.toString())

        Spacer(modifier = Modifier.height(8.dp))

    }
}