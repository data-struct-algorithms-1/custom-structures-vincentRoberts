import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.compose.AppTheme
import ui.StackScreen
import ui.QueueScreen

@Composable
@Preview
fun App() {
    //StackScreen()
    QueueScreen()
}

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "Custom Data Structures"
    ) {
        AppTheme (){
            App()
        }
    }
}
