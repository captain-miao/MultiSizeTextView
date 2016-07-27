MultiSizeTextView
Android library to show multiple text size in a textView, only support text, size, color.

## screenshot
![screenshot_mutil_size](https://raw.githubusercontent.com/captain-miao/me.github.com/master/jpg/screenshot_mutil_size.jpg  "screenshot_mutil_size")



```java
    private String mDefaultText = "";
    private float  mDefaultTextSize = 14;
    private int    mDefaultTextColor = Color.BLACK;

    private String mBeforeText;
    private int    mBeforeTextColor;
    private float  mBeforeTextSize;

    private String mCenterText;
    private int    mCenterTextColor;
    private float  mCenterTextSize;

    private String mAfterText;
    private int    mAfterTextColor;
    private float  mAfterTextSize;
```
### Gradle
Get library from  [oss.sonatype.org.io](https://oss.sonatype.org/content/repositories/snapshots)
```java

repositories {

    maven { url 'https://oss.sonatype.org/content/repositories/releases' }
    maven { url "https://oss.sonatype.org/content/repositories/snapshots" }

}

dependencies {
    compile 'com.github.captain-miao:multisizetextview:1.0.0-SNAPSHOT'
}

```
### layout
```xml
    <com.github.captain_miao.multisizetextview.MultiSizeTextView
        android:id="@+id/multi_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"

        app:beforeText="@string/before_text"
        app:beforeTextColor="@color/red"
        app:beforeTextSize="@dimen/text_size_small"

        app:centerText="@string/app_name"
        app:centerTextColor="@color/gray"
        app:centerTextSize="@dimen/text_size_big"

        app:afterText="@string/after_text"
        app:afterTextColor="@color/blue"
        app:afterTextSize="@dimen/text_size_small"
        />
```
### change the center text
```java
    MultiSizeTextView textView = (MultiSizeTextView) findViewById(R.id.multi_text_view);

    textView.setCenterText("MultiSizeTextView");
```

### data binding
```
    app:centerText="@{centerText}"

    @BindingAdapter({"centerText"})
    public static void setMultiSizeTextViewCenterText(MultiSizeTextView textView, String text) {
        textView.setCenterText(text);
    }
```

## License
The MIT License (MIT)

Copyright (c) 2016 yan_lu

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
