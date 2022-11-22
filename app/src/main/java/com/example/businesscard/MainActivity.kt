package com.example.businesscard

import android.graphics.drawable.Icon
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Surface(color = Color(0xFF063042)){
        NameCard(
            img = painterResource(id = R.drawable.android_logo),
            name = stringResource(R.string.name_text),
            title = stringResource(R.string.title_text)
        )
        ContactInfo()
    }
}

@Composable
fun NameCard(
    img: Painter,
    name: String,
    title: String,
    modifier: Modifier = Modifier
){
    val imgModifier = Modifier.size(150.dp)
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = img,
            contentDescription = null,
            modifier = imgModifier
        )
        Text(
            text = name,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp),
            color = Color.White
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )

    }
}

@Composable
fun ContactInfo(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 50.dp, bottom = 50.dp)
            .wrapContentHeight(Alignment.Bottom),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(Modifier.padding(bottom = 16.dp)) {
            Icon(Icons.Rounded.Phone, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(text = "+62 8181 8169 69",color = Color.White, modifier = Modifier.padding(start = 24.dp))
        }
        Row(Modifier.padding(bottom = 16.dp)) {
            Icon(Icons.Rounded.Share, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(text = "@mohiqbalrafsanjani", color = Color.White, modifier = Modifier.padding(start = 24.dp))
        }
        Row(Modifier.padding(bottom = 16.dp)) {
            Icon(Icons.Rounded.Email, contentDescription = null, tint = Color(0xFF3ddc84))
            Text(text = "mohiqbalrafsanjani@gmail.com", color = Color.White, modifier = Modifier.padding(start = 24.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        HomeScreen()
    }
}