package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.myUserControlLibrary.radioBtn.FlowRadioGroup;
import com.example.administrator.myparkingos.util.L;

/**
 * Created by Administrator on 2017-03-10.
 */
public class ParkingPlateNoInputView
{
    private Dialog dialog;
    private FlowRadioGroup rgSelectProvince;
    private Button btnCarInputOk;
    private Button btnCarIntCancel;
    private Activity mActivity;
    private EditText etCPH;
    private String province = null;
    private int mInOut = 0;// 0,in;1,out

    public ParkingPlateNoInputView(Activity activity, int inOut)
    {
        this.mInOut = inOut;
        this.mActivity = activity;
        dialog = new Dialog(activity); // @android:style/Theme.Dialog
        dialog.setContentView(R.layout.dialog_carin);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager m = activity.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 2 / 3); // 改变的是dialog框在屏幕中的位置而不是大小
        p.width = (int) (d.getWidth() * 1 / 4); // 宽度设置为屏幕的0.65
        window.setAttributes(p);

        dialog.getWindow().setBackgroundDrawableResource(R.drawable.parkdowncard_background);
        dialog.setTitle(activity.getResources().getString(R.string.parkMontior_carInTitle));
        initView();
        province = mActivity.getResources().getStringArray(R.array.provinceArray)[0]; // 下标为0
        L.i("@@@@@@@@@@@@@@@@@@@@@@@@@@@@2 province:" + province);
    }


    private void initView()
    {
        rgSelectProvince = (FlowRadioGroup) dialog.findViewById(R.id.rgSelectProvince);

        btnCarInputOk = (Button) dialog.findViewById(R.id.btnCarInputOk);
        btnCarIntCancel = (Button) dialog.findViewById(R.id.btnCarIntCancel);

        etCPH = (EditText) dialog.findViewById(R.id.etCPH);

        btnCarInputOk.setOnClickListener(diaListern);
        btnCarIntCancel.setOnClickListener(diaListern);

        final int charMaxNum = 6;
        etCPH.addTextChangedListener(new TextWatcher()
        {
            private CharSequence temp;//监听前的文本

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                temp = s;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                /** 得到光标开始和结束位置 ,超过最大数后记录刚超出的数字索引进行控制 */
                int editStart = etCPH.getSelectionStart();
                int editEnd = etCPH.getSelectionEnd();
                L.i("editStart:" + editStart + ", editEnd:" + editEnd + "temp.length():" + temp.length());
                if (temp.length() > charMaxNum)
                {
                    Toast.makeText(mActivity, "你输入的字数已经超过了限制！", Toast.LENGTH_LONG).show();
                    s.delete(editStart - 1, editEnd);
                    int tempSelection = editStart;
                    etCPH.setText(s);
                    etCPH.setSelection(tempSelection - 1);
                }
                String CPH = s.toString();
                if (temp.length() >= 4)
                {
                    onClickTextInput(province + CPH, temp.length()); // 在出场时，也是模糊对比进场获取车牌吗?
                }

            }
        });
    }

    public void onClickTextInput(final String s, final int Precision)
    {

    }


    private View.OnClickListener diaListern = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.btnCarInputOk:
                {

                    for (int i = 0; i < rgSelectProvince.getChildCount(); i++)
                    {
                        RadioButton tempRadio = (RadioButton) rgSelectProvince.getChildAt(i);
                        if (tempRadio.isChecked())
                        {
                            province = mActivity.getResources().getStringArray(R.array.provinceArray)[i];
                            L.i("显示的车牌:" + province + etCPH.getText().toString());
                            Toast.makeText(mActivity, "显示数据," + province, Toast.LENGTH_SHORT).show();
                            break;
                        }
                    }
                    if (mInOut == 0)
                    {
                        onCarInBtnOk(province + etCPH.getText().toString());
                    }
                    else
                    {
                        onCarOutBtnOk(province + etCPH.getText().toString());
                    }
                    break;
                }
                case R.id.btnCarIntCancel:
                {
                    onBtnCancel();
                    break;
                }
                default:
                {
                    break;
                }
            }
        }
    };

    public void onCarOutBtnOk(String s)
    {

    }

    protected void onCarInBtnOk(final String getCPH)
    {

    }

    protected void onBtnCancel()
    {

    }

    public void show()
    {
        if (dialog != null)
        {
            dialog.show();
        }
    }

    public void dismiss()
    {
        if (dialog != null && dialog.isShowing())
        {
            dialog.dismiss();
        }
    }
}
