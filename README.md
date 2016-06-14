# Common Adapter for Android

[![License](https://img.shields.io/github/license/mashape/apistatus.svg?maxAge=2592000)]()
[![Release](https://jitpack.io/v/richardchien/common-adapter-android.svg)](https://jitpack.io/#richardchien/common-adapter-android)

A reusable adapter inherited from BaseAdapter.

## Usage

Add the following to your module's `build.gradle`:

```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}

dependencies {
    compile 'com.github.richardchien:common-adapter-android:v1.0.0'
}
```

Then use it:

```java
mListView = (ListView) findViewById(R.id.list_view);
mListView.setAdapter(new CommonAdapter<Bean>(this, mDataList, R.layout.list_item) {
    @Override
    public void onPostBindViewHolder(ViewHolder holder, Bean bean) {
        holder.setViewText(R.id.text_title, bean.getTitle())
                .setViewText(R.id.text_description, bean.getDesciption())
                .setViewProperty(R.id.text_description, "text", bean.getDesciption() + " Changed")
                .setViewImageResource(R.id.image_view, bean.getImageResId());
    }
});
```

## Reference

- [Android-打造万能适配器](http://www.imooc.com/learn/372)
