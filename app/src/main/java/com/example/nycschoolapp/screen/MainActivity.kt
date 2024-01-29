package com.example.nycschoolapp.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.nycschoolapp.model.ParagraphModel
import com.example.nycschoolapp.ui.theme.NycSchoolAppTheme
import com.example.nycschoolapp.view.ListItemData

import com.example.nycschoolapp.viewModel.ParagraphViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val paragraphModel by viewModels<ParagraphViewModel>()
        super.onCreate(savedInstanceState)
        setContent {
            NycSchoolAppTheme {
                // A surface container using the 'background' color from the theme

                    Greeting(modelList = paragraphModel.pargraphListResponse)
                    paragraphModel.getParagraphList()
            }
        }
    }
}

@Composable
fun Greeting(modelList: List<ParagraphModel>) {
    var context = LocalContext.current
    LazyColumn{
        itemsIndexed(items= modelList){
            index, item ->
            ListItemData(item, onClick = {
                var intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("DetailItem",item.overview_paragraph)
                context.startActivity(intent)
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NycSchoolAppTheme {
       var modelItem=ParagraphModel("Default Dbn", "Default School", "")
        ListItemData(modelItem, onClick = {})
    }
}