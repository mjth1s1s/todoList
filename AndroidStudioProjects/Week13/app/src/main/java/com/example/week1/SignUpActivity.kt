package com.example.week1
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
// ✅ 올바른 import
import androidx.compose.material3.OutlinedTextField


import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week1.ui.theme.Week1Theme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUp(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SignUp(name: String, modifier: Modifier = Modifier) {
    var id by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var next by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (next) {
        PwScreen(id)
    } else {

        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(horizontal = 24.dp, vertical = 32.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start

            ) {
                Icon(
                    modifier = Modifier
                        .size(35.dp),
                    imageVector = Icons.Default.ChevronLeft,
                    contentDescription = null,
                    tint = Color.White,

                    )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "아이디를 입력해주세요.",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    style = TextStyle(
                        fontSize = 23.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Spacer(modifier = Modifier.height(28.dp))

                OutlinedTextField(
                    value = id,
                    onValueChange = { id = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(4.dp)
                        ),
                    placeholder = {
                        Text(
                            "아이디",
                            color = Color(0xFFAAAAAA)
                        )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color(0xFF2C2C2C),
                        unfocusedContainerColor = Color(0xFF2C2C2C),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(4.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "영문 소문자 또는 영문 소문자, 숫자 조합 6~12 자리",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray,

                        )
                )
            }
            Button(
                onClick = {
                    val isLowerOrNum = id.all { it.isLowerCase() || it.isDigit() }
                    val validLength = id.length in 6..12

                    isError = !(isLowerOrNum && validLength)

                    if (isError) {
                        Toast.makeText(context, "아이디 조건에 맞지 않습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        next = true
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 32.dp)
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "다음",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun PwScreen(id: String) {
    var pw by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    var pwVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .background(Color.Black)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start

        ) {
            Icon(
                modifier = Modifier
                    .size(35.dp),
                imageVector = Icons.Default.ChevronLeft,
                contentDescription = null,
                tint = Color.White,

                )

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "비밀번호를 입력해주세요.",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontSize = 23.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                ),
            )
            Spacer(modifier = Modifier.height(28.dp))

            OutlinedTextField(
                value = pw,
                onValueChange = { pw = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(4.dp)
                    ),
                placeholder = {
                    Text(
                        "비밀번호",
                        color = Color.White
                    )
                },
                visualTransformation = if (pwVisible) {
                    VisualTransformation.None
                } else{
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    val icon = if (pwVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    }
                    IconButton(onClick = {
                        pwVisible = !pwVisible
                    }) {
                        Icon(imageVector = icon,
                            contentDescription = null,
                            tint = Color.LightGray)
                    }
                },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF2C2C2C),
                    unfocusedContainerColor = Color(0xFF2C2C2C),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(4.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "영문, 숫자, 특수문자(~!@#$%^&*) 조합 8~15자리",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Gray,

                    )
            )
        }
        Button(
            onClick = {
                val isLower = pw.any {it.isLowerCase() }
                val hasDigit = pw.any {it.isDigit()}
                val specialChars = "~!@#\\\$%^&*"
                val hasChar = pw.any { it in specialChars }
                val validLength = pw.length in 8..15

                isError = !(isLower && hasDigit && hasChar && validLength)

                if(isError) {
                    Toast.makeText(context, "비밀번호 조건에 맞지 않습니다.", Toast.LENGTH_SHORT).show()
                } else {
                    val intent = Intent().apply {
                        putExtra("id", id)
                        putExtra("pw", pw)
                    }
                    (context as Activity).setResult(Activity.RESULT_OK, intent)
                    (context as Activity).finish()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "다음",
                color = Color.White
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Week1Theme {
        SignUp("ss")
    }
}