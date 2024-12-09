package com.example.lazycolumnlazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lazycolumnlazyrow.Book.Companion.list

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp, start = 5.dp, end = 5.dp)
            ) {
                HeaderText("Гарри Поттер")
                BookLazyRow()
                BookLazyColumn()
            }
        }
    }
}

@Composable
fun HeaderText(header: String) {
    Text(
        text = header,
        fontSize = 36.sp,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        textAlign = TextAlign.Center
    )
}

@Composable
fun BookLazyRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(list) { list ->
            BookRow(list)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun BookLazyColumn() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
    ) {
        item {
            HeaderText("Гарри Поттер")
        }
        items(list) { list ->
            BookRow(list)
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun BookRow(book: Book) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = book.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(width = 150.dp, height = 240.dp)
                .padding(5.dp)
        )
        Column {
            Text(
                text = book.name,
                fontSize = 22.sp
            )
            Text(
                text = "${book.price} руб.",
                fontSize = 18.sp
            )
        }

    }
}