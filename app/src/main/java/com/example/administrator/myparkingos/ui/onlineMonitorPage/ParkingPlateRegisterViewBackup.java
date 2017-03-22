package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.administrator.mydistributedparkingos.R;
import com.example.administrator.myparkingos.ParkingModel.Model;
import com.example.administrator.myparkingos.constant.ColumnName;
import com.example.administrator.myparkingos.model.beans.gson.EntityParkJHSet;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyAdapter;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyListView;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyOnItemClickListener;
import com.example.administrator.myparkingos.util.L;
import com.example.administrator.myparkingos.util.ScreenUtils;
import com.example.administrator.myparkingos.util.TimeConvertUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017-03-10.
 */
public class ParkingPlateRegisterViewBackup implements View.OnClickListener
{
    private Spinner spinnerPlateProvince;
    private TextView tvRegistCarNo;
    private Spinner spinnerPersonNo;
    private Spinner spinnerPlateRegistCarType;
    private EditText etCarNo;
    private TextView etValidStartTime;
    private EditText etPersonName;
    private TextView etValidEndTime;
    private EditText etPhoneNo;
    private EditText etCarSpaces;
    private EditText etCarSpaceNum;
    private EditText etAddress;
    private EditText plateReistDeposit;
    private EditText etChargeMoney;
    private EditText etPlateReistRemarks;
    private ListView lvAllNo;
    private Button btnAdd;
    private Button btnSave;
    private Button btnLogout;
    private Button btnPrintBill;
    private Button btnQuit;
    private EditText etQueryCarNo;
    private EditText etQueryPersonNo;
    private EditText etQuerySpace;
    private EditText etQueryAddress;


    private Dialog dialog;
    private Activity mActivity;
    private MyJiHaoAdapter MyJiHaoAdapter;
    private Spinner spinnerCarModel;
    private ArrayList<ArrayList<Integer>> list;
    private Calendar calendar;
    private int mYear;
    private int mMonth;
    private int mDay;
    private HorizontalScrollView horizontalScrollView;
    private int[] columns;
    private MyAdapter listViewMyJiHaoAdapter;

    private String[] from = new String[]{
            ColumnName.c1, ColumnName.c2, ColumnName.c3, ColumnName.c4, ColumnName.c5, ColumnName.c6, ColumnName.c7, ColumnName.c8
            , ColumnName.c9, ColumnName.c10, ColumnName.c11, ColumnName.c12, ColumnName.c13, ColumnName.c14, ColumnName.c15, ColumnName.c16
            , ColumnName.c17, ColumnName.c18, ColumnName.c19
    };

    public static final String CONST_CAR_NO = "88000001";
    public static final String CONST_CAR_NO_PREFIX = "88"; // 前缀
    public static final String CONST_USER_NO = "A00001";
    public static final String CONST_USER_NO_PREFIX = "A";

    private ArrayList<HashMap<String, String>> items = new ArrayList<HashMap<String, String>>();
    private MyListView myLisView;
    private CheckBox cbOperatorNoAuto;
    private CheckBox cbCarNoAuto;
    private CheckBox cbMultiSpaceMultiCar;
    private ArrayAdapter spinnerUserNoAdapter;
    private ArrayAdapter spinnerCarTypeAdapter;
    private ArrayList<Button> buttonArrayList;

    private boolean isAdd;
    private boolean isDelete;
    private EditText etPersonNo;
    private String flag;

    public ParkingPlateRegisterViewBackup(Activity activity)
    {
        this.mActivity = activity;
        dialog = new Dialog(mActivity); // @android:style/Theme.Dialog
        dialog.setContentView(R.layout.packplate_register);
        dialog.setCanceledOnTouchOutside(true);
        initDialog();

        initView();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.parkdowncard_background);
        dialog.setTitle(mActivity.getResources().getString(R.string.parkMontior_licenseVehicleRegister));
    }

    public void startLoadData()// 每次开始显示时，即更新数据
    {
        if (cbOperatorNoAuto.isChecked())
        {
            onSelectOnCarAutoNo(); // 刚开始默认的是选中
        }

        if (cbCarNoAuto.isChecked())
        {
            onSelectOnUserAutoNo();
        }
    }


    private void initDialog()
    {
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);

        int screenWidth = ScreenUtils.getScreenWidth(mActivity);
        int screenHeight = ScreenUtils.getScreenHeight(mActivity);
        lp.width = screenWidth * 2 / 3; // 宽度
        lp.height = screenHeight * 2 / 3; // 高度

        dialogWindow.setAttributes(lp);
    }

    private void initView()
    {
        spinnerPlateProvince = (Spinner) dialog.findViewById(R.id.cmbHeader);
        tvRegistCarNo = (TextView) dialog.findViewById(R.id.txtCarNumber);
        spinnerPersonNo = (Spinner) dialog.findViewById(R.id.cmbUserNO);
        spinnerPlateRegistCarType = (Spinner) dialog.findViewById(R.id.cmbCarType);
        etCarNo = (EditText) dialog.findViewById(R.id.etCarNo);
        etValidStartTime = (TextView) dialog.findViewById(R.id.dtpStart);
        etPersonName = (EditText) dialog.findViewById(R.id.txtUserName);
        etValidEndTime = (TextView) dialog.findViewById(R.id.dtpEnd);
        etPhoneNo = (EditText) dialog.findViewById(R.id.txtMobileNumber);
        etCarSpaces = (EditText) dialog.findViewById(R.id.txtCarPlace);
        etCarSpaceNum = (EditText) dialog.findViewById(R.id.txtCarCount);
        spinnerCarModel = (Spinner) dialog.findViewById(R.id.cmbCarBrand);
        etAddress = (EditText) dialog.findViewById(R.id.txtAddress);
        plateReistDeposit = (EditText) dialog.findViewById(R.id.txtCardYJ);
        etChargeMoney = (EditText) dialog.findViewById(R.id.txtMoney);
        etPlateReistRemarks = (EditText) dialog.findViewById(R.id.txtRemarks);
        lvAllNo = (ListView) dialog.findViewById(R.id.lvAllNo);
        btnAdd = (Button) dialog.findViewById(R.id.btnAddNew);
        btnSave = (Button) dialog.findViewById(R.id.btnAdd);
        btnLogout = (Button) dialog.findViewById(R.id.btnDelete);
        btnPrintBill = (Button) dialog.findViewById(R.id.btnPrint);
        btnQuit = (Button) dialog.findViewById(R.id.btnQuit);
        etQueryCarNo = (EditText) dialog.findViewById(R.id.txtSelectCPH);
        etQueryPersonNo = (EditText) dialog.findViewById(R.id.txtSelectUserName);
        etQuerySpace = (EditText) dialog.findViewById(R.id.txtSelectCarPlace);
        etQueryAddress = (EditText) dialog.findViewById(R.id.txtSelectAddress);

        cbOperatorNoAuto = (CheckBox) dialog.findViewById(R.id.chkAutoUserNo);
        cbCarNoAuto = (CheckBox) dialog.findViewById(R.id.chkAutoCardNo);
        cbMultiSpaceMultiCar = (CheckBox) dialog.findViewById(R.id.chkDCWDC);
        etPersonNo = (EditText) dialog.findViewById(R.id.etUserNo);

        cbOperatorNoAuto.setChecked(true);
        cbCarNoAuto.setChecked(true);

        cbOperatorNoAuto.setOnCheckedChangeListener(myCheckBoxEvent);
        cbCarNoAuto.setOnCheckedChangeListener(myCheckBoxEvent);
        cbMultiSpaceMultiCar.setOnCheckedChangeListener(myCheckBoxEvent);

        buttonArrayList = new ArrayList<Button>();//放到数据组
        buttonArrayList.add(btnAdd);
        buttonArrayList.add(btnSave);
        buttonArrayList.add(btnLogout);
        buttonArrayList.add(btnPrintBill);
        buttonArrayList.add(btnQuit);

        etValidStartTime.setOnClickListener(this);
        etValidEndTime.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnLogout.setOnClickListener(this);
        btnPrintBill.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

        /**
         * 刚进入界面时，人员编号自动选中、车辆编号自动选中、按钮除了退出全部不可操作
         */

        btnLogout.setEnabled(false);
        btnPrintBill.setEnabled(false);
        btnQuit.setEnabled(false);

        btnAdd.setEnabled(false);
        btnSave.setEnabled(false);

        initJiHaoListView(); // 显示机号
        showProvinceAndCarBrandSpinnerView(); //显示品牌和省份下拉列表
        initDataGridView();// 显示dataGridView数据
    }

    private void showProvinceAndCarBrandSpinnerView()
    {
        ArrayAdapter adapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                , mActivity.getResources().getStringArray(R.array.provinceArray));
        spinnerPlateProvince.setAdapter(adapter);

        ArrayAdapter brandAdapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                , mActivity.getResources().getStringArray(R.array.brandArray));
        spinnerCarModel.setAdapter(brandAdapter);
    }

    private void initDataGridView()
    {
        horizontalScrollView = (HorizontalScrollView) dialog.findViewById(R.id.plate_register_hs);
        columns = new int[]{
                R.id.column1, R.id.column2, R.id.column3,
                R.id.column4, R.id.column5, R.id.column6, R.id.column7,
                R.id.column8, R.id.column9, R.id.column10, R.id.column11,
                R.id.column12, R.id.column13, R.id.column14, R.id.column15, R.id.column16,
                R.id.column17, R.id.column18, R.id.column19
        };

        listViewMyJiHaoAdapter = new MyAdapter(mActivity, items, R.layout.plate_register_item,
                from, columns, R.color.difColor3, R.color.difColor3);
        listViewMyJiHaoAdapter.setMyOnItemClickListener(new MyOnItemClickListener()
        {
            @Override
            public void OnItemClickListener(
                    View view, int line, int row,
                    long id
            )
            {
                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this, row + 1 + "/" + line, Toast.LENGTH_SHORT).show();
                Log.i("touch", row + "/" + (line + 1));
            }
        });

        myLisView = new MyListView(mActivity, horizontalScrollView, columns, R.id.plate_register_hs, R.id.plate_register_list, R.id.plate_register_head, listViewMyJiHaoAdapter);

//        initGridViewDataTest();
    }

    private void initGridViewDataTest()
    {
        ArrayList<HashMap<String, String>> inItems = new ArrayList<>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(ColumnName.c1, "11111");
        map.put(ColumnName.c2, "11111");
        map.put(ColumnName.c3, "11111");
        map.put(ColumnName.c4, "11111");
        map.put(ColumnName.c5, "11111");
        map.put(ColumnName.c6, "11111");
        map.put(ColumnName.c7, "11111");
        map.put(ColumnName.c8, "11111");
        map.put(ColumnName.c9, "11111");
        map.put(ColumnName.c10, "11111");
        map.put(ColumnName.c11, "11111"); // 充值余额
        map.put(ColumnName.c12, "11111"); // 车辆押金
        map.put(ColumnName.c13, "11111");
        map.put(ColumnName.c14, "11111"); //车位
        map.put(ColumnName.c15, "11111");
        map.put(ColumnName.c16, "11111");
        map.put(ColumnName.c17, "11111");//下载标识
        map.put(ColumnName.c18, "11111");// 车场备注
        map.put(ColumnName.c19, "11111");
        inItems.add(map);
        setGridViewData(inItems);
    }

    public void setGridViewData(ArrayList<HashMap<String, String>> inItems)
    {
        if (inItems == null || inItems.size() <= 0)
        {
            return;
        }
        items.clear();
        items.addAll(inItems);
        listViewMyJiHaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAddNew:
                innnerOnClickAdd();
                onPlateRegisterAddBtn();
                break;
            case R.id.btnAdd:
                onPlateRegisterSaveBtn();
                break;
            case R.id.btnDelete:
                onPlateRegisterDeleteBtn();
                break;
            case R.id.btnPrint:
                onPlateRegisterPrintBtn();
                break;
            case R.id.btnQuit:
                onPlateRegisterQuitBtn();
                break;
            case R.id.dtpStart:
            {
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
                        etValidStartTime.setText(new StringBuilder().append(mYear).append("/")
                                .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                .append("/").append((mDay < 10) ? "0" + mDay : mDay));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            }
            case R.id.dtpEnd:
            {
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
                        etValidEndTime.setText(new StringBuilder().append(mYear).append("/")
                                .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                .append("/").append((mDay < 10) ? "0" + mDay : mDay));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            }
            default:
            {

            }
        }
    }

    public void onPlateRegisterQuitBtn()
    {

    }

    public void onPlateRegisterPrintBtn()
    {

    }

    public void onPlateRegisterDeleteBtn()
    {

    }

    public void onPlateRegisterSaveBtn()
    {

    }

    public void onPlateRegisterAddBtn()
    {

    }

    /**
     * 显示机号数据，每一行显示5个数
     */
    private int row = 0;
    private int column = 5;// 列数时固定的

    public void setData(List<EntityParkJHSet> inList)
    {
        if (inList == null || inList.size() == 0)
        {
            return;
        }
        list.clear();

        row = ((inList.size() % column == 0) ? (inList.size() / column) : (inList.size() / column + 1));
        L.i("row:" + row); // row = 7;
        for (int i = 0; i < row; i++) // 31个数，共有 1 - 30，加上127
        {
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for (int j = 0; j < column && (i * column + j) < inList.size(); j++)
            {
                tempList.add(inList.get(i * column + j).getCtrlNumber());
            }
            list.add(tempList);
        }
        MyJiHaoAdapter.notifyDataSetChanged();
    }

    private void initJiHaoListView()
    {
        list = new ArrayList<ArrayList<Integer>>(); // 31个数，共有 1 - 30，加上127

        MyJiHaoAdapter = new MyJiHaoAdapter(mActivity, list);
        lvAllNo.setAdapter(MyJiHaoAdapter);
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
                    onBtnOk();
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
            startLoadData();
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

    class MyJiHaoAdapter extends BaseAdapter
    {
        private Context context;
        private List<ArrayList<Integer>> mArray;

        public MyJiHaoAdapter(Context context, List<ArrayList<Integer>> array)
        {
            mArray = array;
            this.context = context;
        }

        @Override
        public int getCount()
        {
            if (mArray == null)
            {
                return 0;
            }
            return mArray.size();
        }

        @Override
        public Object getItem(int position)
        {
            return position;
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ViewHolder viewHolder;
            if (convertView == null)
            {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.lvallno_item, null);
                viewHolder = new ViewHolder();

                viewHolder.tv1 = (Button) convertView.findViewById(R.id.view1);
                viewHolder.tv2 = (Button) convertView.findViewById(R.id.view2);
                viewHolder.tv3 = (Button) convertView.findViewById(R.id.view3);
                viewHolder.tv4 = (Button) convertView.findViewById(R.id.view4);
                viewHolder.tv5 = (Button) convertView.findViewById(R.id.view5);

                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            if (position == row - 1)
            {
                viewHolder.tv1.setText(String.valueOf(mArray.get(position).get(0)));
                viewHolder.tv2.setVisibility(View.INVISIBLE);
                viewHolder.tv3.setVisibility(View.INVISIBLE);
                viewHolder.tv4.setVisibility(View.INVISIBLE);
                viewHolder.tv5.setVisibility(View.INVISIBLE);
            }
            else
            {
                if (viewHolder.tv2.getVisibility() != View.VISIBLE)
                {
                    viewHolder.tv2.setVisibility(View.VISIBLE);
                    viewHolder.tv3.setVisibility(View.VISIBLE);
                    viewHolder.tv4.setVisibility(View.VISIBLE);
                    viewHolder.tv5.setVisibility(View.VISIBLE);
                }

                viewHolder.tv1.setText(String.valueOf(mArray.get(position).get(0)));
                viewHolder.tv2.setText(String.valueOf(mArray.get(position).get(1)));
                viewHolder.tv3.setText(String.valueOf(mArray.get(position).get(2)));
                viewHolder.tv4.setText(String.valueOf(mArray.get(position).get(3)));
                viewHolder.tv5.setText(String.valueOf(mArray.get(position).get(4)));
            }

            return convertView;
        }

        public class ViewHolder
        {
            public Button tv1;
            public Button tv2;
            public Button tv3;
            public Button tv4;
            public Button tv5;
        }
    }

    private List<String> spinnerUserNoList = new ArrayList<String>();

    public void setSpinnerUserNO(List<String> inList)
    {
        if (spinnerUserNoAdapter == null)
        {
            spinnerUserNoList = inList;
            spinnerUserNoAdapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                    , spinnerUserNoList);

            spinnerPersonNo.setAdapter(spinnerUserNoAdapter);// 设置数据
        }
        else
        {
            spinnerUserNoList = inList;
            spinnerUserNoAdapter.notifyDataSetChanged(); // 这里没有更新数据??? 需要单独测试
        }
    }

    private String[] spinnerCarTypeArray = new String[0];

    public void setSpinnerCarType(String[] array)
    {
        if (spinnerCarTypeAdapter == null)
        {
            spinnerCarTypeArray = array;
            spinnerCarTypeAdapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                    , spinnerCarTypeArray);
            spinnerPlateRegistCarType.setAdapter(spinnerCarTypeAdapter);// 设置数据
        }
        else
        {
            spinnerCarTypeArray = array;
            spinnerCarTypeAdapter.notifyDataSetChanged();
        }
    }

    /**
     * 当车辆编号自动选择后，发生的动作
     */
    public void onSelectOnCarAutoNo()
    {

    }

    /**
     * 当用户编号自动选择后，发生的动作
     */
    public void onSelectOnUserAutoNo()
    {

    }

    /**
     * 设置的车辆编号的文本显示
     *
     * @param carNoStr
     */
    public void setCarNoText(String carNoStr)
    {
        L.i("setCarNoText:" + carNoStr);
        etCarNo.setText(carNoStr);
        etCarNo.setEnabled(false);
    }

    /**
     * 设置用户编号的文本显示
     *
     * @param userNoStr
     */
    public void setUserNoText(String userNoStr)
    {
        L.i("setUserNoText:" + userNoStr);// 设置的用户编号信息
        etPersonNo.setVisibility(View.VISIBLE);
        etPersonNo.setText(userNoStr);
        etPersonNo.setEnabled(false);
        spinnerPersonNo.setVisibility(View.GONE);
    }

    private CompoundButton.OnCheckedChangeListener myCheckBoxEvent = new CompoundButton.OnCheckedChangeListener()
    {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
        {
            switch (buttonView.getId())
            {
                case R.id.chkAutoCardNo:
                    if (buttonView.isChecked())
                    {
                        etCarNo.setEnabled(false);
                    }
                    else
                    {
                        etCarNo.setEnabled(true);
                    }
                    break;
                case R.id.chkAutoUserNo:
                    if (buttonView.isChecked())
                    {
                        spinnerPersonNo.setVisibility(View.GONE);
                        etPersonNo.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        spinnerPersonNo.setVisibility(View.VISIBLE);
                        etPersonNo.setVisibility(View.GONE);
                    }
                    break;
                case R.id.chkDCWDC:
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 获取按钮中所有的文本
     *
     * @return
     */
    public String[] getBtnTagText()
    {
        String[] name = new String[buttonArrayList.size()];
        for (int i = 0; i < buttonArrayList.size(); i++)
        {
            name[i] = (String) buttonArrayList.get(i).getTag();
        }
        return name;
    }

    public void setBtnEnable(boolean[] value)
    {
        for (int i = 0; i < buttonArrayList.size(); i++)
        {
            if (value[i] == true)
            {
                buttonArrayList.get(i).setEnabled(true);
            }
        }
    }

    public boolean getIsAdd()
    {
        return isAdd;
    }

    public boolean getIssDelete()
    {
        return isDelete;
    }

    public void setIsAdd(boolean isAdd)
    {
        this.isAdd = isAdd;
    }

    public void setIsDelete(boolean isDelete)
    {
        this.isDelete = isDelete;
    }

    private void innnerOnClickAdd()
    {
        flag = "add";
        String[] provinceText = mActivity.getResources().getStringArray(R.array.provinceArray);
        for (int i = 0; i < provinceText.length;i ++)
        {
            if (provinceText[i].equals(Model.LocalProvince) == true)
            {
                spinnerPlateProvince.setSelection(i);
            }
        }

        spinnerPlateRegistCarType.setSelection(0);
        spinnerCarModel.setSelection(0);
        etValidStartTime.setText(TimeConvertUtils.longToString("yyyy/MM/dd", System.currentTimeMillis()));
        etValidEndTime.setText(TimeConvertUtils.longToString("yyyy/MM/dd", System.currentTimeMillis()));

        etCarSpaces.setText("");
        etPlateReistRemarks.setText("");
        etPersonName.setText("");
        etPhoneNo.setText("");
        etAddress.setText("");
        plateReistDeposit.setText("0.0");
        etChargeMoney.setText("0.0");
        btnSave.setEnabled(true);

        plateReistDeposit.setEnabled(true);
        etChargeMoney.setEnabled(true);
        etAddress.setEnabled(true);
        etPhoneNo.setEnabled(true);
        etValidStartTime.setEnabled(true);
        etValidEndTime.setEnabled(true);
        etPersonName.setEnabled(true);
        spinnerPlateRegistCarType.setEnabled(true);

    }
}
