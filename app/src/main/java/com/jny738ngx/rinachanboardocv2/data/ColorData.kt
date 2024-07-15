package com.jny738ngx.rinachanboardocv2.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.jny738ngx.rinachanboardocv2.ui.theme.ThemeFamily

data class ThemeFamilyName(val name: String, val themeFamily: ThemeFamily)

val defaultThemes = listOf(
    ThemeFamilyName("μ's", ThemeFamily.Mius),
    ThemeFamilyName("Aqours", ThemeFamily.Aqours),
    ThemeFamilyName("虹ヶ咲", ThemeFamily.Niji),
    ThemeFamilyName("Liella", ThemeFamily.Liella),
    ThemeFamilyName("蓮ノ空", ThemeFamily.Hasu)
)

data class MemberColor(
    val id: Int,
    val memberName: String,
    val colorName: String,
    val themeFamily: ThemeFamily,
    val color: Color
)

fun Color.toHex(): String {
    val argb = this.toArgb()
    val rgb = argb and 0xFFFFFF
    return String.format("#%06X", rgb)
}

val memberColors = listOf(
    MemberColor(101,"高坂穗乃果","橙色",ThemeFamily.Mius,Color(0xfff38500)),
    MemberColor(102,"绚濑绘里","水蓝色",ThemeFamily.Mius,Color(0xff7aeeff)),
    MemberColor(103,"南小鸟","白色",ThemeFamily.Mius,Color(0xffcebfbf)),
    MemberColor(104,"园田海未","蓝色",ThemeFamily.Mius,Color(0xff1769ff)),
    MemberColor(105,"星空凛","黄色",ThemeFamily.Mius,Color(0xfffff832)),
    MemberColor(106,"西木野真姬","红色",ThemeFamily.Mius,Color(0xffff503e)),
    MemberColor(107,"东条希","紫罗兰色",ThemeFamily.Mius,Color(0xffc455f6)),
    MemberColor(108,"小泉花阳","绿色",ThemeFamily.Mius,Color(0xff6ae673)),
    MemberColor(109,"矢泽妮可","粉色",ThemeFamily.Mius,Color(0xffff4f91)),
    MemberColor(201,"高海千歌","蜜柑色",ThemeFamily.Aqours,Color(0xffff9547)),
    MemberColor(202,"樱内梨子","樱花粉色",ThemeFamily.Aqours,Color(0xffff9eac)),
    MemberColor(203,"松浦果南","祖母绿色",ThemeFamily.Aqours,Color(0xff27c1b7)),
    MemberColor(204,"黑泽黛雅","红色",ThemeFamily.Aqours,Color(0xffdb0839)),
    MemberColor(205,"渡边曜","亮蓝色",ThemeFamily.Aqours,Color(0xff66c0ff)),
    MemberColor(206,"津岛善子","白色",ThemeFamily.Aqours,Color(0xffc1cad4)),
    MemberColor(207,"国木田花丸","黄色",ThemeFamily.Aqours,Color(0xffffd010)),
    MemberColor(208,"小原鞠莉","紫罗兰色",ThemeFamily.Aqours,Color(0xffc252c6)),
    MemberColor(209,"黑泽露比","粉色",ThemeFamily.Aqours,Color(0xffff6fbe)),
    MemberColor(210,"CYaRon!","橙色",ThemeFamily.Aqours,Color(0xffffa434)),
    MemberColor(211,"AZALEA","粉色",ThemeFamily.Aqours,Color(0xffff5a79)),
    MemberColor(212,"Guilty Kiss","紫色",ThemeFamily.Aqours,Color(0xff825deb)),
    MemberColor(213,"YYY","BaB色",ThemeFamily.Aqours,Color(0xff53ab7f)),
    MemberColor(214,"鹿角圣良","天蓝色",ThemeFamily.Aqours,Color(0xff00ccff)),
    MemberColor(215,"鹿角理亚","纯白色",ThemeFamily.Aqours,Color(0xffbbbbbb)),
    MemberColor(216,"Saint Snow","红色",ThemeFamily.Aqours,Color(0xffcb3935)),
    MemberColor(399,"璃奈板","璃奈板粉",ThemeFamily.Niji,Color(0xfff971d4)),
    MemberColor(300,"高咲侑","黑色",ThemeFamily.Niji,Color(0xff1d1d1d)),
    MemberColor(301,"上原步梦","浅粉色",ThemeFamily.Niji,Color(0xffed7d95)),
    MemberColor(302,"中须霞","蜡笔黄色",ThemeFamily.Niji,Color(0xffe7d600)),
    MemberColor(303,"樱坂雫","浅蓝色",ThemeFamily.Niji,Color(0xff01b7ed)),
    MemberColor(304,"朝香果林","王室蓝色",ThemeFamily.Niji,Color(0xff485ec6)),
    MemberColor(305,"宫下爱","超橙色",ThemeFamily.Niji,Color(0xffff5800)),
    MemberColor(306,"近江彼方","堇色",ThemeFamily.Niji,Color(0xffa664a0)),
    MemberColor(307,"优木雪菜","猩红色",ThemeFamily.Niji,Color(0xffd81c2f)),
    MemberColor(308,"艾玛·维尔德","浅绿色",ThemeFamily.Niji,Color(0xff84c36e)),
    MemberColor(309,"天王寺璃奈","纸白色",ThemeFamily.Niji,Color(0xff9ca5b9)),
    MemberColor(310,"三船栞子","翡翠色",ThemeFamily.Niji,Color(0xff37b484)),
    MemberColor(311,"米娅·泰勒","白金银色",ThemeFamily.Niji,Color(0xffa9a898)),
    MemberColor(312,"钟岚珠","玫瑰金色",ThemeFamily.Niji,Color(0xfff8c8c4)),
    MemberColor(313,"DiverDiva","银紫色",ThemeFamily.Niji,Color(0xffab76f7)),
    MemberColor(314,"A·ZU·NA","意大利红色",ThemeFamily.Niji,Color(0xffff0042)),
    MemberColor(315,"QU4RTZ","奶茶色",ThemeFamily.Niji,Color(0xffd9db83)),
    MemberColor(316,"R3BIRTH","坦桑蓝色",ThemeFamily.Niji,Color(0xff424a9d)),
    MemberColor(401,"涩谷香音","金盏花色",ThemeFamily.Liella,Color(0xffff7f27)),
    MemberColor(402,"唐可可","蜡笔蓝色",ThemeFamily.Liella,Color(0xffa0fff9)),
    MemberColor(403,"岚千砂都","桃粉色",ThemeFamily.Liella,Color(0xffff6e90)),
    MemberColor(404,"平安名堇","蜜瓜绿色",ThemeFamily.Liella,Color(0xff74f466)),
    MemberColor(405,"叶月恋","宝石蓝色",ThemeFamily.Liella,Color(0xff0000a0)),
    MemberColor(406,"樱小路希奈子","玉米黄色",ThemeFamily.Liella,Color(0xfffff442)),
    MemberColor(407,"米女芽衣","胭脂红色",ThemeFamily.Liella,Color(0xffff3535)),
    MemberColor(408,"若菜四季","冰绿白色",ThemeFamily.Liella,Color(0xffb2ffdd)),
    MemberColor(409,"鬼冢夏美","鬼夏粉色",ThemeFamily.Liella,Color(0xffff51c4)),
    MemberColor(410,"薇恩·玛格丽特","优雅紫色",ThemeFamily.Liella,Color(0xffe49dfd)),
    MemberColor(411,"鬼冢冬毬","烟熏蓝色",ThemeFamily.Liella,Color(0xff4cd2e2)),
    MemberColor(412,"CatChu!","纯红色",ThemeFamily.Liella,Color(0xffe8243c)),
    MemberColor(413,"KALEIDOSCORE","梦幻蓝色",ThemeFamily.Liella,Color(0xffbcbcde)),
    MemberColor(414,"5yncri5e!","舞蹈黄色",ThemeFamily.Liella,Color(0xffffe840)),
    MemberColor(415,"柊摩央","热情酒红色",ThemeFamily.Liella,Color(0xffb05bd4)),
    MemberColor(416,"圣泽悠奈","热情太阳花色",ThemeFamily.Liella,Color(0xffe7c030)),
    MemberColor(417,"Sunny Passion","热情橙色",ThemeFamily.Liella,Color(0xffff683d)),
    MemberColor(501,"日野下花帆","太阳色",ThemeFamily.Hasu,Color(0xfff8b500)),
    MemberColor(502,"村野沙耶香","冰蓝色",ThemeFamily.Hasu,Color(0xff5383c3)),
    MemberColor(503,"乙宗梢","人鱼绿色",ThemeFamily.Hasu,Color(0xff68be8d)),
    MemberColor(504,"夕雾缀理","我的红色",ThemeFamily.Hasu,Color(0xffba2636)),
    MemberColor(505,"大泽瑠璃乃","瑠璃粉色",ThemeFamily.Hasu,Color(0xffe7609e)),
    MemberColor(506,"藤岛慈","天使白色",ThemeFamily.Hasu,Color(0xffc8c2c6)),
    MemberColor(507,"百生吟子","吟子青色",ThemeFamily.Hasu,Color(0xffa2d7dd)),
    MemberColor(508,"徒町小铃","小铃黄色",ThemeFamily.Hasu,Color(0xfffad764)),
    MemberColor(509,"安养寺姬芽","姬芽紫色",ThemeFamily.Hasu,Color(0xff9d8de2)),
    MemberColor(510,"Cerise Bouquet","玫瑰色",ThemeFamily.Hasu,Color(0xffda645f)),
    MemberColor(511,"DOLLCHESTRA","蓝色",ThemeFamily.Hasu,Color(0xff163bca)),
    MemberColor(512,"Mira-Cra Park!","黄色",ThemeFamily.Hasu,Color(0xffF3B171)),
)