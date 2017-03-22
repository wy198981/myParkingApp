package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.ui.ChargeInfoFragment;
import com.example.administrator.myparkingos.ui.ChargeSpaceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-07.
 */
public class FragmentListManager
{
    private FragmentManager fragmentManager;

    private Fragment currentChargeFragment = new Fragment();
    private List<Fragment> fragmentsList = new ArrayList<>();
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private int currentIndex = 0;

    private void initChargeFragment( FragmentManager fragmentManager, @Nullable Bundle savedInstanceState)
    {
        this.fragmentManager = fragmentManager;

        if (savedInstanceState != null)
        { // “内存重启”时调用

            //获取“内存重启”时保存的索引下标
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);

            fragmentsList.removeAll(fragmentsList);
            fragmentsList.add(fragmentManager.findFragmentByTag(0 + ""));
            fragmentsList.add(fragmentManager.findFragmentByTag(1 + ""));
            fragmentsList.add(fragmentManager.findFragmentByTag(2 + ""));

            //恢复fragment页面
            restoreFragment();
        }
        else
        {      //正常启动时调用
            fragmentsList.add(new ChargeInfoFragment());
            fragmentsList.add(new ChargeSpaceFragment());
            showFragment();
        }
    }

    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    private void showFragment()
    {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //如果之前没有添加过
        if (!fragmentsList.get(currentIndex).isAdded())
        {
            transaction
                    .hide(currentChargeFragment)
                    .add(R.id.flchargeSpaceContainer, fragmentsList.get(currentIndex), "" + currentIndex);  //第三个参数为添加当前的fragment时绑定一个tag
        }
        else
        {
            transaction
                    .hide(currentChargeFragment)
                    .show(fragmentsList.get(currentIndex));
        }

        currentChargeFragment = fragmentsList.get(currentIndex);
        transaction.commit();
    }

    /**
     * 恢复fragment
     */
    private void restoreFragment()
    {
        FragmentTransaction mBeginTreansaction = fragmentManager.beginTransaction();

        for (int i = 0; i < fragmentsList.size(); i++)
        {
            if (i == currentIndex)
            {
                mBeginTreansaction.show(fragmentsList.get(i));
            }
            else
            {
                mBeginTreansaction.hide(fragmentsList.get(i));
            }

        }

        mBeginTreansaction.commit();

        //把当前显示的fragment记录下来
        currentChargeFragment = fragmentsList.get(currentIndex);
    }
}
