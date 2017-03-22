package com.example.administrator.myparkingos.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.mydistributedparkingos.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-07.
 */
public class FragmentChargeManager
{
    private FragmentManager mFragmentManager;

    private Fragment currentChargeFragment = new Fragment();
    private List<Fragment> fragmentsList = new ArrayList<>();
    public static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private int currentIndex = 0;

    public FragmentChargeManager(FragmentManager fragmentManager)
    {
        mFragmentManager = fragmentManager;
    }

    public void init(@Nullable Bundle savedInstanceState)
    {
        if (savedInstanceState != null)
        { // “内存重启”时调用

            //获取“内存重启”时保存的索引下标
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);

            fragmentsList.removeAll(fragmentsList);
            fragmentsList.add(mFragmentManager.findFragmentByTag(0 + ""));
            fragmentsList.add(mFragmentManager.findFragmentByTag(1 + ""));

            //恢复fragment页面
            restoreFragment();
        }
        else
        {      //正常启动时调用
            fragmentsList.add(new ChargeInfoFragment());
            fragmentsList.add(new ChargeSpaceFragment());
            showFragment(currentIndex);
        }
    }

    /**
     * 使用show() hide()切换页面
     * 显示fragment
     */
    public void showFragment(int index)
    {
        currentIndex = index;

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

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
    public void restoreFragment()
    {
        FragmentTransaction mBeginTreansaction = mFragmentManager.beginTransaction();

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

    /**
     * 获取当前fragment的名称
     * @return
     */
    public String getCurrentFragmentName()
    {
        if (currentChargeFragment != null)
        {
            return currentChargeFragment.getClass().getName();
        }
        return null;
    }

    /**
     * 设置界面的数据
     * @param chargeInfo
     * @param chargeSpace
     */
    public void setData(ArrayList<String> chargeInfo, ArrayList<String> chargeSpace)
    {
        if (chargeInfo != null && chargeInfo.size() > 0)
        {
            ChargeInfoFragment fragment = (ChargeInfoFragment) fragmentsList.get(0);
            fragment.setData(chargeInfo);
        }

        if (chargeSpace != null && chargeSpace.size() > 0)
        {
            ChargeSpaceFragment fragment = (ChargeSpaceFragment) fragmentsList.get(1);
            fragment.setData(chargeSpace);
        }
    }

    public int getCurrentIndex()
    {
        return currentIndex;
    }
}
