package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.model.beans.BlackListOpt;
import com.example.administrator.myparkingos.model.beans.gson.EntityBlackList;
import com.example.administrator.myparkingos.util.L;
import com.example.administrator.myparkingos.util.TimeConvertUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Administrator on 2017-03-13.
 */
public class FormAddBlackListView
{
    private Dialog dialog;
    private Activity mActivity;
    private Spinner spinProvince;
    private EditText etInputCarPlate;
    private TextView tvStartTime;
    private TextView tvEndTime;
    private EditText etReason;
    private Button btnAdd;
    private Button btnQuery;
    private Button btnDelete;
    private Button btnDeleteAll;
    private Button btnQuit;
    private ListView listView;
    private List<EntityBlackList> mEntityBlackLists;
    private BlackListAdapter blackListAdapter;
    private int listViewSelectIndex = 0; // 选择的项是在大于0,第一行是标题

    public FormAddBlackListView(Activity activity)
    {
        this.mActivity = activity;

        dialog = new Dialog(activity); // @android:style/Theme.Dialog
        dialog.setContentView(R.layout.form_addblacklist);
        dialog.setCanceledOnTouchOutside(true);

        Window window = dialog.getWindow();
        WindowManager m = activity.getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = window.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 2 / 3); // 改变的是dialog框在屏幕中的位置而不是大小
        p.width = (int) (d.getWidth() * 2 / 3); // 宽度设置为屏幕的0.65
        window.setAttributes(p);

        initView();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.parkdowncard_background);
        dialog.setTitle(activity.getResources().getString(R.string.parkMontior_blackListVehicle));


    }

    public void prepareLoadData()
    {

    }

    private void initView()
    {
        spinProvince = (Spinner) dialog.findViewById(R.id.spinProvince);
        etInputCarPlate = (EditText) dialog.findViewById(R.id.etInputCarPlate);
        tvStartTime = (TextView) dialog.findViewById(R.id.tvStartTime);
        tvEndTime = (TextView) dialog.findViewById(R.id.tvEndTime);
        etReason = (EditText) dialog.findViewById(R.id.etReson);
        btnAdd = (Button) dialog.findViewById(R.id.btnAddNew);
        btnQuery = (Button) dialog.findViewById(R.id.btnQuery);
        btnDelete = (Button) dialog.findViewById(R.id.btnDelete);
        btnDeleteAll = (Button) dialog.findViewById(R.id.btnDeleteAll);
        btnQuit = (Button) dialog.findViewById(R.id.btnQuit);
//        dataGridView = (DataGridView) dialog.findViewById(R.id.dataGridViewInfo);
        listView = (ListView) dialog.findViewById(R.id.listView);


        btnAdd.setOnClickListener(dialogListener);
        btnQuery.setOnClickListener(dialogListener);
        btnDelete.setOnClickListener(dialogListener);
        btnDeleteAll.setOnClickListener(dialogListener);
        btnQuit.setOnClickListener(dialogListener);

        tvStartTime.setOnClickListener(dialogListener);
        tvEndTime.setOnClickListener(dialogListener);


        // spinProvince设置相应的数据即可
        ArrayAdapter adapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                , mActivity.getResources().getStringArray(R.array.provinceArray));
        spinProvince.setAdapter(adapter);

        mEntityBlackLists = new ArrayList<>();
//        mEntityBlackLists.add(new EntityBlackList("粤A12345", "2017-03-08 00:00:00", "2017-03-08 23:59:59", "xiaoming", 0));
//        mEntityBlackLists.add(new EntityBlackList("粤A12345", "2017-03-08 00:00:00", "2017-03-08 23:59:59", "xiaoming", 0));
        blackListAdapter = new BlackListAdapter(mEntityBlackLists);
        listView.setAdapter(blackListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                L.i("onItemClick" + ", postion:" + position); // 记录当前选择进行删除
                listViewSelectIndex = position;
            }
        });
    }

    private int mYear;
    private int mMonth;
    private int mDay;
    private Calendar calendar;
    private View.OnClickListener dialogListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.btnAddNew:
                    onClickBlackListAddBtn();
                    break;
                case R.id.btnQuery:
                    onClickBlackListQueryBtn();
                    break;
                case R.id.btnDelete:
                    if (mEntityBlackLists != null && mEntityBlackLists.size() > 0
                            && listViewSelectIndex > 0 && listViewSelectIndex - 1 < (mEntityBlackLists.size()))
                    {
                        onClickBlackListDelBtn(mEntityBlackLists.get(listViewSelectIndex - 1));// listViewSelectIndex是listView下标，包含头部
                        listViewSelectIndex = 0;
                    }
                    else
                    {
                        Toast.makeText(mActivity, "选择删除的条目", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btnDeleteAll:
                    if (mEntityBlackLists != null && mEntityBlackLists.size() > 0)
                    {
                        onClickBlackListDelEach(mEntityBlackLists);
                    }
                    else
                    {
                        Toast.makeText(mActivity, "数据条目不存在", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.btnQuit:
                    onClickBlackListQuit();
                    break;
                case R.id.tvStartTime:
                    calendar = Calendar.getInstance();
                    new DatePickerDialog(mActivity, new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day)
                        {
                            mYear = year;
                            mMonth = month;
                            mDay = day;
                            //更新EditText控件日期 小于10加0
                            tvStartTime.setText(new StringBuilder().append(mYear).append("/")
                                    .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                    .append("/").append((mDay < 10) ? "0" + mDay : mDay));
                        }
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)).show();
                    break;
                case R.id.tvEndTime:
                    calendar = Calendar.getInstance();
                    new DatePickerDialog(mActivity, new DatePickerDialog.OnDateSetListener()
                    {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int day)
                        {
                            mYear = year;
                            mMonth = month;
                            mDay = day;
                            //更新EditText控件日期 小于10加0
                            tvEndTime.setText(new StringBuilder().append(mYear).append("/")
                                    .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                    .append("/").append((mDay < 10) ? "0" + mDay : mDay));
                        }
                    }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)).show();
                    break;
                default:
                {
                    break;
                }
            }
        }
    };

    public void onClickBlackListQuit()
    {

    }

    public void onClickBlackListDelBtn(EntityBlackList param)
    {

    }

    public void onClickBlackListDelEach(List<EntityBlackList> paramList)
    {

    }

    public void onClickBlackListQueryBtn()
    {

    }

    public void onClickBlackListAddBtn()
    {

    }

    public void show()
    {
        if (dialog != null)
        {
            prepareLoadData();// 显示之前加载数据
            dialog.show();
        }
    }

    public void dismiss()
    {
        if (dialog != null && dialog.isShowing())
        {
            clearDataInView();
            dialog.dismiss();
        }
    }

    class BlackListAdapter extends BaseAdapter
    {
        private List<EntityBlackList> mList;

        public BlackListAdapter(List<EntityBlackList> list)
        {
            mList = list;
        }

        @Override
        public int getCount()
        {
            int count = 0;
            if (mList == null)
            {
                count = 1;
            }
            else
            {
                count = mList.size() + 1;
            }
            return count;
        }

        @Override
        public Object getItem(int position)
        {
            if (position != 0)
            {
                return mList.get(position - 1);
            }
            else
            {
                return mList.get(0);
            }

        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder holder = null;
            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView = (mActivity).getLayoutInflater().inflate(
                        R.layout.blacklistview_item, null); // 需要使用getLayoutInflater方法，即需要在该context中
                holder.tv1 = (TextView) convertView.findViewById(R.id.tvText1);
                holder.tv2 = (TextView) convertView.findViewById(R.id.tvText2);
                holder.tv3 = (TextView) convertView.findViewById(R.id.tvText3);
                holder.tv4 = (TextView) convertView.findViewById(R.id.tvText4);
                holder.tv5 = (TextView) convertView.findViewById(R.id.tvText5);
                convertView.setTag(holder);// 保存起来，设置标记
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();// 获取标记
            }

            if (position == 0)
            {
                holder.tv1.setText(R.string.blackList_carId);
                holder.tv2.setText(R.string.blackList_startTime);
                holder.tv3.setText(R.string.blackList_endTime);
                holder.tv4.setText(R.string.blackList_reason);
                holder.tv5.setText(R.string.blackList_status);
            }
            else
            {
                holder.tv1.setText(mList.get(position - 1).getCPH());
                holder.tv2.setText(mList.get(position - 1).getStartTime());
                holder.tv3.setText(mList.get(position - 1).getEndTime());
                holder.tv4.setText(mList.get(position - 1).getReason());
                holder.tv5.setText(String.valueOf(mList.get(position - 1).getAddDelete()));
            }


            return convertView;
        }

        class ViewHolder
        {
            public TextView tv1;
            public TextView tv2;
            public TextView tv3;
            public TextView tv4;
            public TextView tv5;
        }
    }

    public void setData(List<EntityBlackList> entityBlackList)
    {
        if (entityBlackList == null)
        {
            return;
        }
        L.i("setJiHaoData" + entityBlackList.toString());

        mEntityBlackLists.clear(); // 如果换成 mEntityBlackLists = entityBlackList; //这里的数据为空??
        mEntityBlackLists.addAll(entityBlackList);
        blackListAdapter.notifyDataSetChanged();
    }

    /**
     * 从界面上获取所有数据
     */
    public BlackListOpt getAllDataFromUI()
    {
        BlackListOpt blackListOpt = new BlackListOpt();
        String province = spinProvince.getSelectedItem().toString();
        String tempCarNo = etInputCarPlate.getText().toString();
        if (TextUtils.isEmpty(tempCarNo))
        {
            Toast.makeText(mActivity, "车牌号不能为空", Toast.LENGTH_SHORT).show();
            return null;
        }

        String reason = etReason.getText().toString();
        if (TextUtils.isEmpty(reason))
        {
            Toast.makeText(mActivity, "原因不能为空", Toast.LENGTH_SHORT).show();
            return null;
        }

        if (tempCarNo.length() != 6)
        {
            Toast.makeText(mActivity, "长度必须要为6", Toast.LENGTH_SHORT).show();
            return null;
        }


        String startTime = tvStartTime.getText().toString();
        String endTime = tvEndTime.getText().toString();

        blackListOpt.setCPH(province + tempCarNo);

        // 时间段为:2017/3/14 ->2017:3:14 00:00:00的格式
        long stringToLong = TimeConvertUtils.stringToLong("yyyy/MM/dd", startTime);
        String resultStartTime = TimeConvertUtils.longToString(stringToLong);
        String resultEndTime = TimeConvertUtils.longToString(TimeConvertUtils.stringToLong("yyyy/MM/dd", endTime));

        blackListOpt.setStartTime(resultStartTime);
        blackListOpt.setEndTime(resultEndTime);
        blackListOpt.setReason(reason);
        blackListOpt.setDownloadSignal("000000000000000");
//                                     "000000000000000"
        blackListOpt.setAddDelete(0);
        return blackListOpt;
    }

    public String getCPHDataFromUI()
    {
        String province = spinProvince.getSelectedItem().toString();
        String tempCarNo = etInputCarPlate.getText().toString();
        if (TextUtils.isEmpty(tempCarNo))
        {
            Toast.makeText(mActivity, "车牌号不能为空", Toast.LENGTH_SHORT).show();
            return null;
        }
        if (tempCarNo.length() != 6)
        {
            Toast.makeText(mActivity, "长度必须要为6", Toast.LENGTH_SHORT).show();
            return null;
        }
        return province + tempCarNo;
    }

    /**
     * 问题一，查找某一个时候，如果没有查到时，则没有显示的了；(已经解决了)
     * 问题二，查询某一个车牌的时候，还是发现查询不到；
     * 问题三，如果碰到其他的逻辑，自己可以回头来看看；
     */

    public void clearDataInView()
    {
        etInputCarPlate.setText("");
        etReason.setText("");
    }
}
