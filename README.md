# TabRadioButton for Android

[ ![Download](https://api.bintray.com/packages/zaaach/maven/TabRadioButton/images/download.svg) ](https://bintray.com/zaaach/maven/TabRadioButton/_latestVersion)

>   APP开发中，底部菜单经常使用RadioButton来实现切换，但使用系统自带的RadioButton的话，你会发现图片和文字并没有完全居中，于是就有了TabRadioButton。

TabRadioButton只对 `drawableLeft` 和`drawableTop`方向上的图片做了居中处理（这两个方向一般用的比较多）

-   图片和文字居中
-   可指定drawable的大小
-   自带缩放动画效果，手指按下和松开时触发（需要开启）

## Preview

<image src="https://github.com/zaaach/TabRadioButton/raw/master/art/screen.gif" style="zoom:75%">

## Download

Gradle:
```gradle
compile 'com.zaaach:tabradiobutton:1.0.1'
```

or Maven:
```xml
<dependency>
  <groupId>com.zaaach</groupId>
  <artifactId>tabradiobutton</artifactId>
  <version>1.0.1</version>
  <type>pom</type>
</dependency>
```

## How to use

1.  `TabRadioButton` 添加图片时要用`drawableLeft` 或 `drawableTop` 这两个属性~
2.  若需要动画效果，添加一行属性 `trb_enable_animation="true"` 即可启用缩放动画效果

```xml
<RadioGroup
     style="@style/TabRadioGroup">
     <com.zaaach.tabradiobutton.TabRadioButton
      	style="@style/TabRadioButtonWithText"
      	android:drawableTop="@drawable/tab_contact_icon_selector"
      	app:trb_enable_animation="true"
      	app:trb_drawable_size="24dp"
      	app:trb_scale_rate="0.8"
      	app:trb_duration="200"/>
</RadioGroup>
```
`attrs.xml` 自定义的属性：

```xml
<declare-styleable name="TabRadioButton">
  		<!-- 启用动画效果 -->
        <attr name="trb_enable_animation" format="boolean"/>
  		<!-- 动画时长 -->
        <attr name="trb_duration" format="integer"/>
  		<!-- 缩放比例 -->
        <attr name="trb_scale_rate" format="float"/>
  		<!-- drawable大小 -->
        <attr name="trb_drawable_size" format="dimension"/>
</declare-styleable>
```

`@style/TabRadioButtonWithText` 内容如下：

```xml
<style name="TabRadioButtonWithText">
        <item name="android:layout_width">0dp</item>
        <item name="android:layout_height">match_parent</item>
        <item name="android:layout_weight">1</item>
        <item name="android:button">@null</item>
        <item name="android:background">@null</item>
        <item name="android:textSize">12sp</item>
        <item name="android:textColor">@drawable/tab_text_color_selector</item>
        <item name="android:drawablePadding">2dp</item>
</style>
```

## Try it

:wink:

# 赞赏
如果你喜欢 TabRadioButton，感觉 TabRadioButton 帮助到了你，可以点右上角 "Star" 支持一下，谢谢！ ^_^
你还可以扫描下面的二维码~ 请作者喝一杯咖啡。

![支付宝](https://github.com/zaaach/TabRadioButton/raw/master/art/alipay.png)![微信支付](https://github.com/zaaach/TabRadioButton/raw/master/art/wechatpay.png)