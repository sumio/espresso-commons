# Espresso Commons

A library of utilities commonly used with [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/index.html).

[![Javadocs](http://javadoc.io/badge/jp.jun_nama/espresso-commons.svg)](http://javadoc.io/doc/jp.jun_nama/espresso-commons)

- [`RecyclerViewUtils`](espresso-commons/src/main/java/jp/jun_nama/espresso/commons/RecyclerViewUtils.java): 
  A collection of [`ViewAction`](https://developer.android.com/reference/android/support/test/espresso/action/ViewActions.html)s and hamcrest matchers for [`RecyclerView`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html).
- [`MoreViewMatchers.childAtPosition()`](espresso-commons/src/main/java/jp/jun_nama/espresso/commons/MoreViewMatchers.java#L41): A workaround to [Issue 231461](https://code.google.com/p/android/issues/detail?id=231461)) that Espresso Test Recorder outputs incorrect implementation of `childAtPosition()`.

## Setup

Add the following lines to your Gradle dependencies:

```gradle
androidTestCompile('jp.jun_nama:espresso-commons:0.1.1') {
    exclude group: 'com.android.support'
}
```

## License

Copyright 2017 TOYAMA Sumio &lt;jun.nama@gmail.com&gt;  
Licensed under the
[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).

