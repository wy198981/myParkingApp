package com.example.administrator.myparkingos.ui.onlineMonitorPage.report;

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
 * Created by Administrator on 2017-02-16.
 * 【在线监控】 -->> 【期限查询】 deal处理线上的
 */
public class ReportDealLine
{
    private Dialog dialog;
    private FlowRadioGroup rgSelectProvince;
    private Button btnCarInputOk;
    private Button btnCarIntCancel;
    private Button btnNoPlateCancel;

    public ReportDealLine(Activity mActivity)
    {
        dialog = new Dialog(mActivity); // @android:style/Theme.Dialog
        dialog.setContentView(R.layout.form_dealline_query);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager m = mActivity.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 2 / 3); // 改变的是dialog框在屏幕中的位置而不是大小
        p.width = (int) (d.getWidth() * 1 / 3); // 宽度设置为屏幕的0.65
        window.setAttributes(p);

        initView();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.parkdowncard_background);
        dialog.setTitle(mActivity.getResources().getString(R.string.parkMontior_unlicensedVehicleAdmission));
    }

    private void initView()
    {

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
