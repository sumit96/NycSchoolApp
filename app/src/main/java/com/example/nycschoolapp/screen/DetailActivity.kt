package com.example.nycschoolapp.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nycschoolapp.ui.theme.NycSchoolAppTheme

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var data=intent.getStringExtra("DetailItem")
        super.onCreate(savedInstanceState)
        setContent {
            NycSchoolAppTheme {
                // A surface container using the 'background' color from the theme
                    Greeting2("$data")

            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(
        modifier = Modifier.
        padding(all = 5.dp),
        text = "$name",
        style = androidx.compose.material.MaterialTheme.typography.body1,
        overflow = TextOverflow.Ellipsis

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    NycSchoolAppTheme {
        Greeting2("No Detail")
    }
}