package com.example.mobile1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1.ui.theme.Mobile1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(
            text = "Hello $name!",
            color= Color.Green,
            fontSize = 40.sp,
            modifier = Modifier
                .background(Color.Yellow).fillMaxSize()
                .padding(16.dp)
                .background(Color.Blue)
        )
        Text(
            text = "Hello $name!",
            color= Color.Black,
            fontSize = 40.sp,
            modifier = Modifier
                .background(Color.Yellow).fillMaxSize()
                .padding(16.dp)
                .background(Color.Blue)
        )
    }

}
@Composable
fun BoxDemo() {

    val annotatedString = buildAnnotatedString {
        append("Link")

        pushStringAnnotation(tag = "policy", annotation = "https://google.com/policy")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append("privacy policy")
        }
        pop()
    }

    Box(
        modifier = Modifier
            .size(400.dp)
    ) {
        Text(
            text = annotatedString,
            color = Color.Blue,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
        )
        Text(
            text = "Text2",
            color = Color.Blue,
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.TopEnd)
        )
    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Mobile1Theme {
        Greeting("Alex!")
    }
}