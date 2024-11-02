package `in`.rahul.androidkotlinb2.session2_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import `in`.rahul.androidkotlinb2.R

@Composable
fun BasicJetpack(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Android Logo",
                modifier = Modifier.size(98.dp)
            )
            Column {
                Text(
                    text = "Hello, $name!",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Hi! this",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
        Text(
            text = "Hi! this is description and i want to check long text i am adding some raw data to check that.",
            fontSize = 16.sp,
            modifier = Modifier.padding(top = 16.dp)
        )
        Button(
            onClick = { /* Handle button click */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Click me")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            Modifier
                .background(Color(0xFF8BC34A))
                .fillMaxWidth()
                .height(250.dp)
              //  .size(250.dp)
        ) {
            Text("Center", Modifier.align(Alignment.Center))
            Text("Top Start", Modifier.align(Alignment.TopStart))
            Text("Top End", Modifier.align(Alignment.TopEnd))
            Text("Bottom Start", Modifier.align(Alignment.BottomStart))
            Text("Bottom End", Modifier.align(Alignment.BottomEnd))
        }
    }
}

@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text(text = "Count is $count")
    }
}

@Preview
@Composable
fun demo(){
    BasicJetpack(name = "Android")
}