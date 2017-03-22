package com.example.administrator.myparkingos.myUserControlLibrary.radioBtn;

/**
 * Created by Administrator on 2017-03-09.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;

/**
 * 自动换行RadioGroup
 *
 * @author xiehaibo
 *         个人博客 http://www.glmei.cn
 */
public class FlowRadioGroup extends RadioGroup
{

    public FlowRadioGroup(Context context)
    {
        super(context);
    }

    public FlowRadioGroup(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    /**
     * 显示7行5列
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int maxWidth = MeasureSpec.getSize(widthMeasureSpec);
        int childCount = getChildCount();
        int x = 0;
        int y = 0;
        int row = 0;

        for (int index = 0; index < childCount; index++)
        {
            final View child = getChildAt(index);
            if (child.getVisibility() != View.GONE)
            {
                child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
                // 此处增加onlayout中的换行判断，用于计算所需的高度
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                x += width;
                y = row * height + height;
                if (x > width * 5)// maxWidth
                {
                    x = width;
                    row++;
                    y = row * height + height;
                }
            }
        }
        // 设置容器所需的宽度和高度
        setMeasuredDimension(maxWidth, y);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        final int childCount = getChildCount();
        int maxWidth = r - l;
        int x = 0;
        int y = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < childCount; i++)
        {
            final View child = this.getChildAt(i);
            if (child.getVisibility() != View.GONE)
            {
                int width = child.getMeasuredWidth();
                int height = child.getMeasuredHeight();
                x += width;
                y = row * height + height;
                if (x > width * 5) // maxWidth
                {
                    x = width;
                    row++;
                    y = row * height + height;
                }
                child.layout(x - width, y - height, x, y);
            }
        }
    }
}
