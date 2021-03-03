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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
                MyApp(showDetail = {
                    Intent(baseContext, DetailActivity::class.java).apply {
                        this.putExtra("resId", it.resId)
                        this.putExtra("detailDsc", it.detailDsc)
                        this.putExtra("titleDsc", it.titleDsc)
                    }.run {
                        startActivity(this)
                    }
                })
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(showDetail: (DogEntity) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        DogList(getData(), showDetail = showDetail)
    }
}

// 获取数据
fun getData(): List<DogEntity> {
    val dogs = arrayListOf<DogEntity>()
    dogs.add(
        DogEntity(
            R.drawable.olddog,
            "老狗",
            "它是老狗，能识路",
            "一种常见的犬科哺乳动物，与狼为同一种动物，生物学分类上是狼的一个亚种。狗是人类最早驯养的一个物种。有人饲养的称为家犬，无人饲养的狗称常被称为“野狗”或“流浪狗”。狗的寿命最多可超过二十年，平均则为十数年，与猫的平均寿命相近。若无发生意外，平均寿命以小型犬为长。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.blackdog,
            "黑狗",
            "它是黑狗，晚上看不见",
            "DNA分析显示狗不单单是灰狼的近亲，更是各地不同灰狼亚种的混血后代。现代狗的祖先约在1.1万至1.6万年前开始在西欧被人类驯化，更早之前人类饲养的古代狗已经灭绝，如在比利时所发现距今3.6万年及阿尔泰山所发现约3.3万年前的标本，显示已经中断的驯化事件，这些更早期的古代狗并未留下现存后代。2016年的研究表明，现代狗至少经过两次驯化，人类在亚洲驯化狗，发生在超过1.4万年前，一小部分家犬和人通过欧亚大陆西迁。这意味着，所有现代家犬，还有纽格莱奇墓犬，它们的祖先可追溯回到亚洲。基因检测发现旧石器时代的欧洲犬，很多基因型在现代欧洲犬中找不到。这结果意味着，古欧洲犬没留下多少后代，有可能是因为亚洲犬在新石器时代就逐渐取代了古欧洲犬",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.caiquandog,
            "柴犬",
            "它是柴犬，能看家",
            "日本犬种之一。属于中小型犬种。柴犬于1936年（昭和11年）12月16日被指定为日本的天然纪念物[1]（指定了六种日本犬种的其中一个），亦是现存六种日本犬中其中一种小型犬。根据日本犬保存会，日本境内饲养的日本本土犬种里，约有八成为柴犬。柴犬最早是被培育作为狩猎鸟类、昆虫、兔子等小型动物的猎犬[4]。即使有着试图保存犬种的努力，但柴犬在第二次世界大战期间因食物短缺和战后犬瘟热爆发而近乎绝种[5]。后继的柴犬都是由幸存下来的三种犬种培育而成[6]，三种犬种分别为长野县的信州柴犬、岐阜县的美浓柴犬，以及鸟取县和岛根县的山阴柴犬[3]。信州柴犬的特征包括扎实的里层犬毛以及密集的外层犬毛，体型属小型，其颜色为赤色。美浓柴犬则有着厚实、竖起的耳朵。其尾巴为镰刀型，与现代柴犬的卷尾不同。山阴柴犬的体型较现代柴犬大，并大多为全身黑色，与现代黑色柴犬仍然有部分白色和褐色毛发的特征不同[3]。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.cutedog,
            "可爱犬",
            "它是可爱犬，真可爱",
            "狗在与人的长期互动中习得了与人类行为和谐一致的特殊习性，更获得了靠高淀粉饮食茁壮成长的能力。[3]各种狗的形状、大小、毛色都有显著不同。[4]狗可用作陪伴、看家护院、捕猎、放牧、载货、拉车、警用、军用、做宠物、帮助身障人士等，因此有“人类的好朋友”这一美誉。此外有些地区也将狗作为食物，例如东亚的北朝鲜、韩国、中国部分地区、东南亚的越南、欧洲的瑞士、法国、美国夏威夷等地。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.jiwawadog,
            "吉娃娃犬",
            "它是吉娃娃犬，真小啊",
            "吉娃娃犬以细小的体型、大眼睛、特别大的耳朵和直竖的尾巴为特征。美国犬业俱乐部仅承认一种吉娃娃犬，但其实此犬种有许多型态、花色和长短毛之分。以长短毛来分，可分为短毛与长毛，短毛是我们目前较常见的，而长毛吉娃娃身上的毛光泽且柔软，后肢肌肉较发达。生性懦弱且对冷很敏感，喜欢热，爱晒太阳。长毛种耳朵、四肢、尾巴皆有装饰毛，但长度并未拖地，在花色方面，墨西哥地区以前以黑色品种居多，不过现在毛色已呈多样化，包括奶油色、红色、褐色、黑色中掺有黄褐色、各种混色。另外它们的重量介于1至5公斤之间，美国犬业俱乐部不认可超过3公斤的吉娃娃犬。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.douniuquandog,
            "斗牛犬",
            "它是斗牛犬，能斗牛吗？",
            "斗牛犬（英文名：Bulldog）是犬科犬属的动物，是家犬的一个亚种，原产英国，起源于19世纪，狗中最具有战斗力的犬种之一。直到1835年英格兰禁止逗引公牛之前，属于非常常见的品种。此后，经过有选择的培育，性格逐渐变文雅。现有法国斗牛犬、英国斗牛、荷兰斗牛犬，美国斗牛犬等类型。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.labuladuodog,
            "拉布拉多犬",
            "它是拉布拉多犬，是一種中大型犬類，天生個性溫和、活潑、沒有攻擊性和智商高",
            "拉布拉多犬或称拉布拉多拾猎犬（简称拉布拉多；英语：Labrador Retriever）是一种中大型犬类，天生个性温和、活泼、没有攻击性和智商高，是适合被选作导盲犬或其他工作犬的狗品种，跟黄金猎犬、哈士奇并列三大低攻击性犬类之一。在美国犬业俱乐部中拉布拉多是目前登记数量最多的品种。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.muyangquandog,
            "牧羊犬",
            "它是牧羊犬，能看住羊吗？",
            "牧羊犬是一类受人驯养的犬种，属于活泼且聪明的犬只。原来的培养目的为了对家畜，尤其是羊只进行守卫与集赶。除了原先的作业用途之外，现今的许多牧羊犬成为了家中的宠物。",
            false
        )
    )
    dogs.add(
        DogEntity(
            R.drawable.kejidog,
            "柯基犬",
            "它是柯基犬，有活力",
            "是一种小型犬，它们的胆子很大，也相当机警，能高度警惕地守护家园，是最受欢迎的小型护卫犬之一。 [1]",
            false
        )
    )
    return dogs;
}

@Composable
fun DogList(dogs: List<DogEntity>, showDetail: (DogEntity) -> Unit) {
    LazyColumn {
        items(dogs) { dog ->
            DogListItem(dog = dog, showDetail = showDetail)
        }
    }
}

@Composable
fun DogListItem(dog: DogEntity, showDetail: (DogEntity) -> Unit) {
    val image = painterResource(id = dog.resId)



    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = {
                showDetail(dog)
            })
    ) {
        val imageModifier = Modifier
            .height(200.dp)
            .width(120.dp)
            .clip(RoundedCornerShape(4.dp))
        Image(
            image, "dog", modifier = imageModifier,
            alignment = Alignment.Center, contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.width(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = dog.titleDsc,
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,

                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = dog.detailSmailDsc,
                style = typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,

                )

            Spacer(modifier = Modifier.height(30.dp))

            var textDogAdopt = "收养"
            if (dog.adopt) {
                textDogAdopt = "已收养"
            }

            Button(onClick = {
                dog.adopt = !dog.adopt
            }, enabled = !dog.adopt) {
                Text(text = textDogAdopt)
            }


        }

    }
}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(showDetail = {

        })
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(showDetail = {

        })
    }
}
