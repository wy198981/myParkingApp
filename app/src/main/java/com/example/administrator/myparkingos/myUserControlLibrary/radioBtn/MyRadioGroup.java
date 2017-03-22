package com.example.administrator.myparkingos.myUserControlLibrary.radioBtn;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Created by Administrator on 2017-03-10.
 */
public class MyRadioGroup extends RadioGroup
{
    private final String TAG = MyRadioGroup.class.getSimpleName();
    private boolean isSingleColumn = true;
    private int mColumnNumber = 2;// 这里是一行显示的RadioButton的数量默认为2.
    private int mMaxWidth;// 所有RadioGroup的最大宽度。
    private int mEveryColumnWidth;// 指的是每个RadioButton的最大宽度。就是横着的长度除以每行显示的数量，得到的结果。
    private int mMaxColumnHeight = -1;// RadioButton中最高的高度。默认为setColumnHeight中的值，但是如果实际高度大于预设值则变为最大高度。
    private int[] mEveryColumnMaxWidth;// 每一列当中最长的宽度值，主要用于使一列的RadioButton的开始位置相同，看起来整齐。

    public void setColumnHeight(int px)
    {
        mMaxColumnHeight = px;
    }

    public void setColumnNumber(int columnNumber)
    {
        this.mColumnNumber = columnNumber;
    }

    public void setSingleColumn(boolean isSingleColumn)
    {
        this.isSingleColumn = isSingleColumn;
    }

    public MyRadioGroup(Context context)
    {
        super(context);
    }

    public MyRadioGroup(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        if (isSingleColumn)
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
        else
        {
            mEveryColumnMaxWidth = new int[mColumnNumber];
            mMaxWidth = MeasureSpec.getSize(widthMeasureSpec);
            mEveryColumnWidth = mMaxWidth / mColumnNumber;
            Log.i(TAG, "everyColumnWidth:" + mEveryColumnWidth + " maxWidth:"
                    + mMaxWidth + " columnNumber:" + mColumnNumber);
            int childCount = getChildCount();
            int y = 0;
            int row = 0;
            for (int index = 0; index < childCount; index++)
            {
                final View child = getChildAt(index);
                if (child.getVisibility() != View.GONE)
                {
                    child.measure(MeasureSpec.UNSPECIFIED,
                            MeasureSpec.UNSPECIFIED);
                    int height = child.getMeasuredHeight();// 计算单个RadioButton的宽高。
                    int width = child.getMeasuredWidth();
                    if (height < mMaxColumnHeight)
                    {
                        height = mMaxColumnHeight;
                    }
                    int columnNumber = index % mColumnNumber;// 这里是计算这个位置是属于第几列，从0开始。
                    if (mEveryColumnMaxWidth[columnNumber] < width)
                    {
                        mEveryColumnMaxWidth[columnNumber] = width;
                    }
                    if (index > 0 && columnNumber == 0)
                    {
                        row++;// 当到达了第0列的时候行数增加1.
                    }
                    y = row * height + height;
                }
            }
            // 设置RadioGroup所需的宽度和高度
            setMeasuredDimension(mMaxWidth, y);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        if (isSingleColumn)
        {
            super.onLayout(changed, l, t, r, b);
        }
        else
        {
            final int childCount = getChildCount();
            int x = 0;
            int y = 0;
            int row = 0;
            for (int i = 0; i < childCount; i++)
            {
                final View child = this.getChildAt(i);
                if (child.getVisibility() != View.GONE)
                {
                    int width = child.getMeasuredWidth();
                    int height = child.getMeasuredHeight();
                    int columnIndex = i % mColumnNumber;
                    // 这里x的位置代表了RadioButton的起始X轴的位置。
                    // 计算方法为用平均下来的每个RadioButton的最大宽度，
                    // 减去这一列最长的RadioButton的宽度然后除以2
                    // 然后加上相应的列数加成。
                    // 策略就是最长的处于中间。
                    //如果需要调整RadioButton的左右距离，请调整此处x值即可。
                    x = (mEveryColumnWidth - mEveryColumnMaxWidth[columnIndex])
                            / 2 + columnIndex * mEveryColumnWidth;
                    if (i > 0 && columnIndex == 0)
                    {
                        row++;
                    }
                    // 高度的方法类似。不过需要注意，这里不是以文字为对齐，而是以左侧的RadioButton的单选框对齐。请注意。
                    y = row * mMaxColumnHeight + (mMaxColumnHeight - height)
                            / 2;
                    child.layout(x, y, x + width, y + height);
                }
            }
        }
    }
}
