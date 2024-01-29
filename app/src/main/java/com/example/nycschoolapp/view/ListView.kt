package com.example.nycschoolapp.view




import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.nycschoolapp.model.ParagraphModel

@Composable
fun ListItemData(paragraphModel: ParagraphModel, onClick: () -> Unit)
{
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth().clickable(onClick=onClick)
            .height(100.dp),
            shape = RoundedCornerShape(4.dp),
            elevation = 4.dp
    ){
        Surface() {
            Column {
                Text(
                    modifier = Modifier.
                    padding(all = 5.dp),
                    text = paragraphModel.dbn,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )

                Text(
                    modifier = Modifier.
                    padding(all = 5.dp),
                    text = paragraphModel.school_name,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis

                )
            }
        }
    }


}