package im.r_c.android.commonadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * CommonAdapter
 * Created by richard on 16/1/8.
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    public static ViewHolder instanceOf(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        //noinspection unchecked
        return (T) view;
    }

    public int getPosition() {
        return mPosition;
    }

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        mPosition = position;
        mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public ViewHolder setViewText(int viewId, CharSequence text) {
        ReflectHelper.invokeMethodIfExists("setText", getView(viewId), new Class[]{CharSequence.class}, text);
        return this;
    }

    public ViewHolder setViewText(int viewId, int resId) {
        ReflectHelper.invokeMethodIfExists("setText", getView(viewId), new Class[]{int.class}, resId);
        return this;
    }

    public ViewHolder setViewTextColor(int viewId, int color) {
        ReflectHelper.invokeMethodIfExists("setTextColor", getView(viewId), new Class[]{int.class}, color);
        return this;
    }

    public ViewHolder setViewTextSize(int viewId, float size) {
        ReflectHelper.invokeMethodIfExists("setTextSize", getView(viewId), new Class[]{float.class}, size);
        return this;
    }

    public ViewHolder setViewTextSize(int viewId, int unit, float size) {
        ReflectHelper.invokeMethodIfExists("setTextSize", getView(viewId), new Class[]{int.class, float.class}, unit, size);
        return this;
    }

    public ViewHolder setViewImageResource(int viewId, int resId) {
        ReflectHelper.invokeMethodIfExists("setImageResource", getView(viewId), new Class[]{int.class}, resId);
        return this;
    }

    public ViewHolder setViewImageBitmap(int viewId, Bitmap bitmap) {
        ReflectHelper.invokeMethodIfExists("setImageBitmap", getView(viewId), new Class[]{Bitmap.class}, bitmap);
        return this;
    }

    public ViewHolder setViewImageDrawable(int viewId, Drawable drawable) {
        ReflectHelper.invokeMethodIfExists("setImageDrawable", getView(viewId), new Class[]{Drawable.class}, drawable);
        return this;
    }

    public ViewHolder setViewImageURI(int viewId, Uri uri) {
        ReflectHelper.invokeMethodIfExists("setImageURI", getView(viewId), new Class[]{Uri.class}, uri);
        return this;
    }

    public ViewHolder setViewChecked(int viewId, boolean checked) {
        ReflectHelper.invokeMethodIfExists("setChecked", getView(viewId), new Class[]{boolean.class}, checked);
        return this;
    }

    public ViewHolder setViewOnClickListener(int viewId, View.OnClickListener listener) {
        ReflectHelper.invokeMethodIfExists("setOnClickListener", getView(viewId), new Class[]{View.OnClickListener.class}, listener);
        return this;
    }

    public ViewHolder setViewOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        ReflectHelper.invokeMethodIfExists("setOnLongClickListener", getView(viewId), new Class[]{View.OnLongClickListener.class}, listener);
        return this;
    }

    public ViewHolder setViewVisibility(int viewId, int visibility) {
        ReflectHelper.invokeMethodIfExists("setVisibility", getView(viewId), new Class[]{int.class}, visibility);
        return this;
    }

    public ViewHolder setViewProperty(int viewId, String propertyName, Object... params) {
        propertyName = Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        ReflectHelper.invokeMethodIfExists("set" + propertyName, getView(viewId), params);
        return this;
    }
}
