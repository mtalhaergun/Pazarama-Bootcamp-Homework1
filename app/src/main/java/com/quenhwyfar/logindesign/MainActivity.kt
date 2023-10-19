package com.quenhwyfar.logindesign

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quenhwyfar.logindesign.ui.theme.LoginDesignTheme
import com.quenhwyfar.logindesign.ui.theme.Purple80
import com.quenhwyfar.logindesign.ui.theme.TextColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginDesignTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Login()
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Login(){

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSuccessful by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = "Login Logo"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "USER LOGIN",
            color = TextColor,
            style = TextStyle(fontWeight = FontWeight.Bold,),
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username")},
            modifier = Modifier.padding(4.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password")},
            modifier = Modifier.padding(4.dp),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                isSuccessful = username == "Talha" && password == "123456"
                if (isSuccessful) {
                    Toast.makeText(context,"Login Successful!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context,"Login Failed!", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("LOGIN")
        }
    }
}

