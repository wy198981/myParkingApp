package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.app.Activity;
import android.app.Dialog;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.myUserControlLibrary.radioBtn.FlowRadioGroup;

/**
 * Created by Administrator on 2017-03-10.
 */
public class ParkingOutNOPlateNoView
{
    private Dialog dialog;
    private FlowRadioGroup rgSelectProvince;
    private Button btnCarInputOk;
    private Button btnNoPlateCancel;

    public ParkingOutNOPlateNoView(Activity mActivity)
    {
        dialog = new Dialog(mActivity); // @android:style/Theme.Dialog
        dialog.setContentView(R.layout.parkingout_noplate);
        dialog.setCanceledOnTouchOutside(true);


        Window window = dialog.getWindow();
        WindowManager m = mActivity.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 1 / 2); // 改变的是dialog框在屏幕中的位置而不是大小
        p.width = (int) (d.getWidth() * 1 / 2); // 宽度设置为屏幕的0.65
        window.setAttributes(p);
//        initView();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.parkdowncard_background);
        dialog.setTitle(mActivity.getResources().getString(R.string.parkMontior_unlicensedVehicleAppearance));
    }



    private View.OnClickListener dialogListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.btnCarInputOk:
                {
                    onBtnOk();
                    break;
                }
                case R.id.btnNoPlateCancel:
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

    protected void onBtnOk()
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
