package com.example.week1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.ui.res.painterResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week1.ui.theme.Week1Theme

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = intent.getStringExtra("id") ?: "티빙"
        enableEdgeToEdge()
        setContent {
            Week1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Profile(
                        name = id,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Profile(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)

    ) {
        Icon(
            modifier = Modifier
                .size(35.dp),
            imageVector = Icons.Default.ChevronLeft,
            contentDescription = null,
            tint = Color.White,
            )

        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(horizontal = 25.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_tving),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.Yellow)
                )
                Spacer(modifier = Modifier.width(18.dp))
                Text(
                    text = name,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            Button(
                onClick = {},
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                    .height(35.dp)
                    .width(112.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    "프로필 전환",
                    color = Color(0xFFAAAAAA),
                    fontSize = 12.sp
                )

            }

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1A1A1A)
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 28.dp, horizontal = 20.dp)
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(
                        text="나의 이용권",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "사용중인 이용권이 없습니다",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text= "티빙캐시",
                        color = Color.White,
                        fontSize = 14.sp)
                    Text(
                        text="0",
                        color = Color.White,

                    )
                }

            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 13.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1A1A1A)
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "이용권을 구매하고  ",
                                fontSize = 12.sp,
                                color = Color.White
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_tvn),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(37.dp)
                                    .background(Color(0xFF1A1A1A))
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Image(
                                painter = painterResource(id = R.drawable.ic_jtbc),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(52.dp)
                                    .background(Color(0xFF1A1A1A))
                            )
                            Text(
                                text=" 등 인기 시리즈와",
                                color= Color.White,
                                fontSize = 12.sp
                            )

                        }
                        Text(
                            text = "다양한 영화 콘텐츠를 자유롭게 시청하세요!",
                            fontSize = 12.sp,
                            color = Color.White
                        )

                    }
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

            }

        }
        Button(
            onClick ={
                val intent = Intent(context, SignInActivity::class.java)
                context.startActivity(intent)

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp)
                .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(4.dp))
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
            Text("로그아웃", color = Color(0xFFAAAAAA))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Week1Theme {
        Profile(name = "ds")
    }
}