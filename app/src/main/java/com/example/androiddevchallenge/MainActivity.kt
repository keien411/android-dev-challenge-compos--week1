/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.entity.DogEntity
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        DogList(getData())
    }
}

// 获取数据
fun getData(): List<DogEntity>{
    val dogs = arrayListOf<DogEntity>()
    dogs.add(DogEntity(R.drawable.olddog, "老狗", "它是老狗，能识路", false))
    dogs.add(DogEntity(R.drawable.blackdog, "黑狗", "它是黑狗，晚上看不见", false))
    dogs.add(DogEntity(R.drawable.caiquandog, "柴犬", "它是柴犬，能看家", false))
    dogs.add(DogEntity(R.drawable.cutedog, "可爱犬", "它是可爱犬，真可爱", false))
    dogs.add(DogEntity(R.drawable.jiwawadog, "吉娃娃犬", "它是吉娃娃犬，真小啊", false))
    dogs.add(DogEntity(R.drawable.douniuquandog, "斗牛犬", "它是斗牛犬，能斗牛吗？", false))
    dogs.add(DogEntity(R.drawable.labuladuodog, "拉布拉多犬", "它是拉布拉多犬，是一種中大型犬類，天生個性溫和、活潑、沒有攻擊性和智商高", false))
    dogs.add(DogEntity(R.drawable.muyangquandog, "牧羊犬", "它是牧羊犬，能看住羊吗？", false))
    dogs.add(DogEntity(R.drawable.kejidog, "柯基犬", "它是柯基犬，有活力", false))
    return dogs;
}

@Composable
fun DogList(dogs: List<DogEntity>) {
    LazyColumn{
        items(dogs) { dog ->
            DogListItem(dog = dog)
        }
    }
}

@Composable
fun DogListItem(dog: DogEntity) {
    val image = painterResource(id = dog.resId)
    Row(modifier = Modifier.padding(16.dp)) {
        val imageModifier = Modifier
            .height(200.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(4.dp))
        Image(image, "dog", modifier = imageModifier,
            alignment = Alignment.Center, contentScale = ContentScale.Fit)

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = dog.titleDsc,
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )

            Button(onClick = {
                Log.d("TAG", "DogListItem: "+dog.titleDsc)
            }) {

            }
        }

    }
}

@Composable
fun DogDetail() {
    val image = painterResource(id = R.drawable.olddog)

    Column(modifier = Modifier.padding(16.dp)) {
        val imageModifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
        Image(image, "blackDog", modifier = imageModifier,
            alignment = Alignment.Center, contentScale = ContentScale.Fit)

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题标题",
            style = typography.h6,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = "Ready... Set... GO!2", style = typography.body2)
        Text(text = "Ready... Set... GO!3", style = typography.body2)
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
