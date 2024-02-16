package ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import datastructures.FIFOStack
import datastructures.LIFOStack
import datastructures.fifoStackOf
import datastructures.lifoStackOf
import interfaces.Stack

@Composable
fun StackScreen() {

    Column(Modifier.padding(16.dp)) {
        Text(
            "Stack",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )

        val stackList = listOf(
            lifoStackOf(1.0, 2.0, 3.0, 4.0),
            LIFOStack<String>().apply { pushAll(setOf("MySQL", "SQLite", "Mongo")) } ,
            FIFOStack<String>().apply {
                push("1st Element In")
                push("2nd Element In")
                push("3rd Element In")
                push("4th Element In")
            },
            fifoStackOf("Cat", "Dog", "Horse", "Cow")
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(stackList) { stack ->
                StackContent(stack = stack, stack.javaClass.simpleName)
            }
        }
    }

}

@Composable
fun StackContent(stack: Stack<*>, cardTitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
    ) {
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = "LIFO Stack", style = MaterialTheme.typography.bodyLarge)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp)){
            Text(text = "Size: ${stack.size()}\n${stack}", modifier = Modifier.weight(1f))
            Text(text = "Popped Element: ${stack.pop()}", modifier = Modifier.weight(1f))
            Text(text = "Size: ${stack.size()}\n${stack}", modifier = Modifier.weight(1f))
        }
    }
}
