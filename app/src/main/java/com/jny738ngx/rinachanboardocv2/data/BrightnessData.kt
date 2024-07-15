package com.jny738ngx.rinachanboardocv2.data


enum class BrightnessLevel {Minimum,Low,High,Maximum}

data class BrightnessData(val name:String,val level: BrightnessLevel,val value:Int)

val brightnessLevels = listOf(
    BrightnessData("普通",BrightnessLevel.Minimum,16),
    BrightnessData("輝いて",BrightnessLevel.Low,32),
    BrightnessData("眩しい",BrightnessLevel.High,64),
    BrightnessData("光害",BrightnessLevel.Maximum,128),
)