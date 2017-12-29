# TabRadioButton for Android

[ ![Download](https://api.bintray.com/packages/zaaach/maven/TabRadioButton/images/download.svg) ](https://bintray.com/zaaach/maven/TabRadioButton/_latestVersion)

>   APP开发中，底部菜单经常使用RadioButton来实现切换，但使用系统自带的RadioButton的话，你会发现图片和文字并没有完全居中，于是就有了TabRadioButton。

TabRadioButton只对 `drawableLeft` 和`drawableTop`方向上的图片做了居中处理（这两个方向一般用的比较多）

## Preview

![screenshot](https://github.com/zaaach/TabRadioButton/raw/master/art/screen.jpg)

## Download

Gradle:
```gradle
compile 'com.zaaach:tabradiobutton:1.0.0'
```

or Maven:
```xml
<dependency>
  <groupId>com.zaaach</groupId>
  <artifactId>tabradiobutton</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

## How to use

用到`RadioButton`的地方替换成`TabRadioButton` 就可以了，so easy ~ ~ ~

添加图片时用`drawableLeft` 和 `drawableTop` 这两个属性！！！

```xml
<RadioGroup
     android:id="@+id/rg_top"
     style="@style/TabRadioGroup">
     <com.zaaach.tabradiobutton.TabRadioButton
     		style="@style/TabRadioButtonWithText"
     		android:drawableTop="@drawable/tab_conversation_icon_selector"
     		android:text="@string/conversation" />
     <com.zaaach.tabradiobutton.TabRadioButton
          	android:id="@+id/rb_contact"
            style="@style/TabRadioButtonWithText"
            android:drawableTop="@drawable/tab_contact_icon_selector"
            android:text="@string/contact" />
     <com.zaaach.tabradiobutton.TabRadioButton
            style="@style/TabRadioButtonWithText"
            android:drawableTop="@drawable/tab_plugin_icon_selector"
            android:text="@string/plugin" />
     <com.zaaach.tabradiobutton.TabRadioButton
            style="@style/TabRadioButtonWithText"
            android:drawableTop="@drawable/tab_now_icon_selector"
            android:text="@string/now" />
</RadioGroup>
```
## Try it

:wink:

## 还有红包~
![红包](https://github.com/zaaach/CityPicker/blob/city-picker/art/1514356638768.jpg)