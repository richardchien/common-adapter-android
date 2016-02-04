# Common Adapter for Android

A reusable adapter inherited from BaseAdapter.

## Usage

```java
mListView = (ListView) findViewById(R.id.list_view);
mListView.setAdapter(new CommonAdapter<Bean>(this, mDataList, R.layout.list_item) {
    @Override
    public void onPostCreateView(ViewHolder holder, Bean bean) {
        holder.setViewText(R.id.text_title, bean.getTitle())
                .setViewText(R.id.text_description, bean.getDesciption())
                .setViewImageResource(R.id.image_view, bean.getImageResId());
    }
});
```

## Reference

- [Android-打造万能适配器](http://www.imooc.com/learn/372)
