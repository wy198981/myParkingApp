package com.example.administrator.myparkingos.ui.onlineMonitorPage;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.ArrayMap;
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
import com.example.administrator.myparkingos.model.beans.JiHaoSelectInfo;
import com.example.administrator.myparkingos.model.beans.gson.EntityCarTypeInfo;
import com.example.administrator.myparkingos.model.beans.gson.EntityCardIssue;
import com.example.administrator.myparkingos.model.beans.gson.EntityParkJHSet;
import com.example.administrator.myparkingos.model.beans.gson.EntityRights;
import com.example.administrator.myparkingos.model.beans.gson.EntityUserInfo;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyAdapter;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyListView;
import com.example.administrator.myparkingos.myUserControlLibrary.scrollerList.MyOnItemClickListener;
import com.example.administrator.myparkingos.util.CommUtils;
import com.example.administrator.myparkingos.util.L;
import com.example.administrator.myparkingos.util.ScreenUtils;
import com.example.administrator.myparkingos.util.T;
import com.example.administrator.myparkingos.util.TimeConvertUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017-03-10.
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
public class ParkingPlateRegisterView implements View.OnClickListener
{
    private Spinner cmbHeader;
    private EditText txtCarNumber;
    private Spinner cmbUserNO;
    private Spinner cmbCarType;
    private EditText etCarNo;
    private TextView dtpStart;
    private EditText txtUserName;
    private TextView dtpEnd;
    private EditText txtMobileNumber;
    private EditText txtCarPlace;
    private EditText txtCarCount;
    private EditText txtAddress;
    private EditText txtCardYJ;
    private EditText txtMoney;
    private EditText txtRemarks;
    private ListView lvAllNo;
    private Button btnAddNew;
    private Button btnAdd;
    private Button btnDelete;
    private Button btnPrint;
    private Button btnQuit;
    private EditText txtSelectCPH;
    private EditText txtSelectUserName;
    private EditText txtSelectCarPlace;
    private EditText txtSelectAddress;


    private Dialog dialog;
    private ParkingMonitoringActivity mActivity;
    private MyJiHaoAdapter MyJiHaoAdapter;
    private Spinner cmbCarBrand;
    private ArrayList<ArrayList<JiHaoSelectInfo>> list;
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
    private CheckBox chkAutoUserNo;
    private CheckBox chkAutoCardNo;
    private CheckBox chkDCWDC;
    private ArrayAdapter spinnerUserNoAdapter;
    private ArrayAdapter spinnerCarTypeAdapter;
    private ArrayList<Button> buttonArrayList;

    private boolean isAdd;
    private boolean isDelete;
    private EditText etUserNo;
    private String flag;
    final static Map<String, AsyncTask<String, String, Object>> TaskMap = new ArrayMap<>();
    private CheckBox cbAllSelectJiHao;
    private ListView lvMutliCarNO;
    private Button btnAddMutliCar;
    private ArrayList<String> mutliCarList;

    public ParkingPlateRegisterView()
    {

    }

    public ParkingPlateRegisterView(ParkingMonitoringActivity activity)
    {
        this.mActivity = activity;
        dialog = new Dialog(mActivity); // @android:style/Theme.Dialog
        dialog.setContentView(R.layout.packplate_register);
        dialog.setCanceledOnTouchOutside(true);
        initDialog();

        initView();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.parkdowncard_background);
        dialog.setTitle(mActivity.getResources().getString(R.string.parkMontior_licenseVehicleRegister));
        flag = "add";
    }

    public void startLoadData()// 每次开始显示时，即更新数据
    {
        if (chkAutoUserNo.isChecked())
        {
            onSelectOnCarAutoNo(); // 刚开始默认的是选中
        }

        if (chkAutoCardNo.isChecked())
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
        cmbHeader = (Spinner) dialog.findViewById(R.id.cmbHeader);
        txtCarNumber = (EditText) dialog.findViewById(R.id.txtCarNumber);
        cmbUserNO = (Spinner) dialog.findViewById(R.id.cmbUserNO);
        cmbCarType = (Spinner) dialog.findViewById(R.id.cmbCarType);
        etCarNo = (EditText) dialog.findViewById(R.id.etCarNo);
        dtpStart = (TextView) dialog.findViewById(R.id.dtpStart);
        txtUserName = (EditText) dialog.findViewById(R.id.txtUserName);
        dtpEnd = (TextView) dialog.findViewById(R.id.dtpEnd);
        txtMobileNumber = (EditText) dialog.findViewById(R.id.txtMobileNumber);
        txtCarPlace = (EditText) dialog.findViewById(R.id.txtCarPlace);
        txtCarCount = (EditText) dialog.findViewById(R.id.txtCarCount);
        cmbCarBrand = (Spinner) dialog.findViewById(R.id.cmbCarBrand);
        txtAddress = (EditText) dialog.findViewById(R.id.txtAddress);
        txtCardYJ = (EditText) dialog.findViewById(R.id.txtCardYJ);
        txtMoney = (EditText) dialog.findViewById(R.id.txtMoney);
        txtRemarks = (EditText) dialog.findViewById(R.id.txtRemarks);
        lvAllNo = (ListView) dialog.findViewById(R.id.lvAllNo);
        btnAddNew = (Button) dialog.findViewById(R.id.btnAddNew);
        btnAdd = (Button) dialog.findViewById(R.id.btnAdd);
        btnDelete = (Button) dialog.findViewById(R.id.btnDelete);
        btnPrint = (Button) dialog.findViewById(R.id.btnPrint);
        btnQuit = (Button) dialog.findViewById(R.id.btnQuit);
        txtSelectCPH = (EditText) dialog.findViewById(R.id.txtSelectCPH);
        txtSelectUserName = (EditText) dialog.findViewById(R.id.txtSelectUserName);
        txtSelectCarPlace = (EditText) dialog.findViewById(R.id.txtSelectCarPlace);
        txtSelectAddress = (EditText) dialog.findViewById(R.id.txtSelectAddress);

        chkAutoUserNo = (CheckBox) dialog.findViewById(R.id.chkAutoUserNo);
        chkAutoCardNo = (CheckBox) dialog.findViewById(R.id.chkAutoCardNo);
        chkDCWDC = (CheckBox) dialog.findViewById(R.id.chkDCWDC);
        etUserNo = (EditText) dialog.findViewById(R.id.etUserNo);
        cbAllSelectJiHao = (CheckBox) dialog.findViewById(R.id.chkAllSelect);

        lvMutliCarNO = (ListView) dialog.findViewById(R.id.lvMutliCarNO);
        btnAddMutliCar = (Button) dialog.findViewById(R.id.btnAddMutliCar);

        chkAutoUserNo.setChecked(true);
        chkAutoCardNo.setChecked(true);

        chkAutoUserNo.setOnCheckedChangeListener(myCheckBoxEvent);
        chkAutoCardNo.setOnCheckedChangeListener(myCheckBoxEvent);
        chkDCWDC.setOnCheckedChangeListener(myCheckBoxEvent);
        cbAllSelectJiHao.setOnCheckedChangeListener(myCheckBoxEvent);

        buttonArrayList = new ArrayList<Button>();//放到数据组
        buttonArrayList.add(btnAddNew);
        buttonArrayList.add(btnAdd);
        buttonArrayList.add(btnDelete);
        buttonArrayList.add(btnPrint);
        buttonArrayList.add(btnQuit);

        dtpStart.setOnClickListener(this);
        dtpEnd.setOnClickListener(this);
        btnAddNew.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnPrint.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

        /**
         * 刚进入界面时，人员编号自动选中、车辆编号自动选中、按钮除了退出全部不可操作
         */

        btnDelete.setEnabled(false);
        btnPrint.setEnabled(false);
        btnQuit.setEnabled(false);

        btnAddNew.setEnabled(false);
        btnAdd.setEnabled(false);

        initJiHaoListView(); // 显示机号
        showProvinceAndCarBrandSpinnerView(); //显示品牌和省份下拉列表
        initDataGridView();// 显示dataGridView数据

        /**
         * 当点击了多车位多车，显示lvMutliCarNO的数据
         */
        mutliCarList = new ArrayList<>();
        ArrayAdapter<String> adapterMutliCar = new ArrayAdapter<String>(
                mActivity, android.R.layout.simple_list_item_1, mutliCarList);
        lvMutliCarNO.setAdapter(adapterMutliCar);
    }

    private void showProvinceAndCarBrandSpinnerView()
    {
        ArrayAdapter adapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                , mActivity.getResources().getStringArray(R.array.provinceArray));
        cmbHeader.setAdapter(adapter);

        ArrayAdapter brandAdapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                , mActivity.getResources().getStringArray(R.array.brandArray));
        cmbCarBrand.setAdapter(brandAdapter);
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
            case R.id.btnAddNew: // 新增
                innerOnNewClick();
                onPlateRegisterAddBtn();
                break;
            case R.id.btnAdd: // 保存，btnAdd需要和服务器的数据相互比较，所以需要这里有关联
                EntityCardIssue carIssue = innerOnSaveClick();
                if (carIssue == null)
                {
                    return;
                }
                L.i("carIssue:" + carIssue.toString());
                if (chkDCWDC.isChecked()) //  多车位
                {
                    L.i("chkDCWDC.isChecked()：" + true);
                    onPlateRegisterSaveWhenCheckMultiPace(carIssue);
                }
                else
                {
                    L.i("chkDCWDC.isChecked()：" + false);
                    if (!checkCPHValid(cmbHeader.getSelectedItem().toString() + txtCarNumber.getText().toString()))
                        return;

                    if (flag.equals("add"))
                    {
                        onPlateRegisterSaveNormal(carIssue);
                    }
                    else if (flag.equals("edit"))
                    {
                        //ID
                        //cardmodel.ID = Convert.ToInt32(ID);
                    }
                }
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
                        dtpStart.setText(new StringBuilder().append(mYear).append("/")
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
                        dtpEnd.setText(new StringBuilder().append(mYear).append("/")
                                .append((mMonth + 1) < 10 ? "0" + (mMonth + 1) : (mMonth + 1))
                                .append("/").append((mDay < 10) ? "0" + mDay : mDay));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            }
            case R.id.btnAddMutliCar:
                break;
            default:
            {

            }
        }
    }

    private boolean checkCPHValid(String cph)
    {
        L.i("checkCPHValid(String cph):" + cph);
        if (cph.equals(""))
        {
            T.showShort(mActivity, "请输入车牌");
            return false;
        }

//        if (!CommUtils.CheckUpCPH(cph)) // 这里检查车牌采用的正则表达式，需要用java的语言来翻译；
//        {
//            T.showShort(mActivity, "车牌号不规范!请重新输入！\n\n【" + cph + "】会引起车牌数据显示错误");
//            return false;
//        }
        return true;
    }

    /**
     * 当正常的保存时
     */
    public void onPlateRegisterSaveNormal(EntityCardIssue carIssue)
    {

    }

    /**
     * 当多车位选择时
     */
    public void onPlateRegisterSaveWhenCheckMultiPace(EntityCardIssue carIssue)
    {

    }

    /**
     * 点击click按钮之后，所作界面操作
     */
    private EntityCardIssue innerOnSaveClick()
    {
        if (flag.equals("add"))
        {
            if (isAdd == false)
            {
                T.showShort(mActivity, "无新增权限");
            }
        }
        else if (flag.equals("edit"))
        {
            String title = mActivity.getResources().getString(R.string.parkMontior_licenseVehicleRegister);
            List<EntityRights> lstRs = mActivity.GetRightsByName(title, "btnUpdate");// 后面再做整改
            if (lstRs == null || lstRs.size() == 0)
            {
                T.showShort(mActivity, "无修改权限");
                return null;
            }
            else
            {
                if (!lstRs.get(0).isCanOperate())
                {
                    T.showShort(mActivity, "无修改权限");
                    return null;
                }
            }
        }

        CarValidMachine();
        String temp = cmbCarType.getSelectedItem().toString();
        if (temp.trim().equals(""))
        {
            T.showShort(mActivity, "请选择车辆类型");
            return null;
        }

        if (!MachineChecked)
        {
            T.showShort(mActivity, "请选择停车场机号!");
            return null;
        }

        if (txtUserName.getText().toString().trim().equals(""))
        {
            T.showShort(mActivity, "请输入人员姓名!");
            return null;
        }


        if (txtCardYJ.getText().toString().trim().equals(""))
        {
            txtCardYJ.setText("0");
        }

        if (txtMoney.getText().toString().trim().equals(""))
        {
            txtMoney.setText("0");
        }

        return getCarIssueFromUI();
    }


    private EntityCardIssue getCarIssueFromUI()
    {


        EntityCardIssue carIssue = new EntityCardIssue();
        String trim = etCarNo.getText().toString().trim();
        carIssue.setCardNO(CommUtils.stringPadLeft(trim, 8, '0'));
        if (chkAutoUserNo.isChecked())
        {
            carIssue.setUserNO(etUserNo.getText().toString());
        }
        else
        {
            carIssue.setUserNO(cmbUserNO.getSelectedItem().toString());
        }
        carIssue.setCardState("0");
        String carYJ = txtCardYJ.getText().toString();
        if (carYJ.equals(""))
            carYJ = "0";

        L.i("txtCardYJ.getText():" + carYJ);
        carIssue.setCardYJ(Float.parseFloat(carYJ));


        carIssue.setSubSystem("10000");

        carIssue.setCarCardType(GetCarType(0));
        carIssue.setCarType(cmbCarBrand.getSelectedItem().toString());
        carIssue.setCarIssueDate(TimeConvertUtils.longToString(System.currentTimeMillis()));
        carIssue.setCarIssueUserCard(Model.sUserCard);

        carIssue.setBalance(Float.parseFloat(txtMoney.getText().toString()));

        long stringToLong = TimeConvertUtils.stringToLong("yyyy/MM/dd", dtpStart.getText().toString());
        String resultStartTime = TimeConvertUtils.longToString(stringToLong);
        carIssue.setCarValidStartDate(resultStartTime);

        stringToLong = TimeConvertUtils.stringToLong("yyyy/MM/dd", dtpEnd.getText().toString());
        carIssue.setCarValidEndDate(TimeConvertUtils.longToString(stringToLong));

        carIssue.setCPH(cmbHeader.getSelectedItem().toString() + txtCarNumber.getText().toString());
        carIssue.setCardType(cmbCarType.getSelectedItem().toString());

        carIssue.setCarPlace(txtCarPlace.getText().toString());
        carIssue.setCarValidMachine(sum);    //保存为2进制数
        carIssue.setCarValidZone("0000000001000000");

        carIssue.setCarMemo(txtRemarks.getText().toString().trim());

        carIssue.setIssueUserCard(Model.sUserCard);
        carIssue.setIssueDate(TimeConvertUtils.longToString(System.currentTimeMillis()));
        carIssue.setHolidayLimited("0000000");

        carIssue.setTelNumber("0");
        carIssue.setUserInfo("");
        carIssue.setTimeTeam("");
        return carIssue;
    }


    boolean MachineChecked = false;
    String sum = "";

    private void CarValidMachine()
    {
        MachineChecked = false;
        sum = "";
        for (int i = 0; i < 128; i++)
            sum += "1";

        for (ArrayList<JiHaoSelectInfo> o : list)
        {
            for (JiHaoSelectInfo m : o)
            {
                if (m.isChecked() == true)
                {
                    MachineChecked = true;
                    String Jihao = m.getJiHaoTxt();

                    sum = new StringBuffer(sum.substring(0, Integer.parseInt(Jihao))).append("0")
                            .append(sum.substring(Integer.parseInt(Jihao))).toString();
                }
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


    public void onPlateRegisterAddBtn()
    {

    }

    /**
     * 显示机号数据，每一行显示5个数
     */
    private int row = 0;
    private int column = 5;// 列数时固定的

    public void setJiHaoData(List<EntityParkJHSet> inList)
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
            ArrayList<JiHaoSelectInfo> tempList = new ArrayList<JiHaoSelectInfo>();
            for (int j = 0; j < column && (i * column + j) < inList.size(); j++)
            {
                tempList.add(new JiHaoSelectInfo(String.valueOf(inList.get(i * column + j).getCtrlNumber()), false));
            }

            list.add(tempList);
        }
        MyJiHaoAdapter.notifyDataSetChanged();
    }

    private void initJiHaoListView()
    {
        list = new ArrayList<ArrayList<JiHaoSelectInfo>>(); // 31个数，共有 1 - 30，加上127

        MyJiHaoAdapter = new MyJiHaoAdapter(mActivity, list);
        lvAllNo.setAdapter(MyJiHaoAdapter);
    }

    public void show()
    {
        if (dialog != null && dialog.isShowing() == false)
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

    public void setUIEnableWhenAddSuccess()
    {
        btnAddNew.setEnabled(true);
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(true);
        btnPrint.setEnabled(true);
        txtCarCount.setText("");
    }


    class MyJiHaoAdapter extends BaseAdapter
    {
        private Context context;
        private ArrayList<ArrayList<JiHaoSelectInfo>> mList;

        public MyJiHaoAdapter(Context context, ArrayList<ArrayList<JiHaoSelectInfo>> inList)
        {
            mList = inList;
            this.context = context;
        }

        @Override
        public int getCount()
        {
            if (mList == null)
            {
                return 0;
            }
            return mList.size();
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
            ArrayList<Button> buttonsList;
            if (convertView == null)
            {
                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.lvallno_item, null);

                buttonsList = new ArrayList<Button>();
                buttonsList.add((Button) convertView.findViewById(R.id.view1));
                buttonsList.add((Button) convertView.findViewById(R.id.view2));
                buttonsList.add((Button) convertView.findViewById(R.id.view3));
                buttonsList.add((Button) convertView.findViewById(R.id.view4));
                buttonsList.add((Button) convertView.findViewById(R.id.view5));

                convertView.setTag(buttonsList);
            }
            else
            {
                buttonsList = (ArrayList<Button>) convertView.getTag();
            }

            // 数据有限的情况的处理 position 表示第几行数据，
            if (position == row - 1)// 只有最后一行特殊处理
            {
                for (int i = 0; i < column; i++)
                {
                    if (i < mList.get(position).size())
                    {
                        final int currentRow = position;
                        final int currentColumn = i;

                        final JiHaoSelectInfo jiHaoSelectInfo = mList.get(position).get(i);
                        final String jiHao = jiHaoSelectInfo.getJiHaoTxt();
                        final Button button = buttonsList.get(i);
                        button.setText(jiHao);
                        button.setGravity(Gravity.CENTER);

                        if (jiHaoSelectInfo.isChecked() == true)
                        {
                            button.setBackgroundResource(R.drawable.jihao_select_yes);
                        }
                        else
                        {
                            button.setBackgroundResource(R.drawable.jihao_select_not);
                        }

                        button.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View v)
                            {
                                T.showShort(mActivity, "点击了，第" + currentRow + "行"
                                        + ", 第" + currentColumn + "列," + "机号为" + jiHao);
                                if (jiHaoSelectInfo.isChecked() == false)
                                {
                                    jiHaoSelectInfo.setChecked(true);
                                    button.setBackgroundResource(R.drawable.jihao_select_yes);
                                }
                                else
                                {
                                    jiHaoSelectInfo.setChecked(false);
                                    button.setBackgroundResource(R.drawable.jihao_select_not);
                                }
                            }
                        });
                    }
                    else
                    {
                        buttonsList.get(i).setVisibility(View.INVISIBLE);
                    }
                }
            }
            else
            {
                for (int i = 0; i < column; i++)
                {
                    final int currentRow = position;
                    final int currentColumn = i;
                    final Button o = buttonsList.get(i);
                    if (o.getVisibility() != View.VISIBLE)
                    {
                        o.setVisibility(View.VISIBLE);
                    }
                    final JiHaoSelectInfo jiHaoSelectInfo = mList.get(position).get(i);
                    final String jiHao = jiHaoSelectInfo.getJiHaoTxt();
                    o.setText(jiHao);
                    o.setGravity(Gravity.CENTER);
                    if (jiHaoSelectInfo.isChecked() == true)
                    {
                        o.setBackgroundResource(R.drawable.jihao_select_yes);
                    }
                    else
                    {
                        o.setBackgroundResource(R.drawable.jihao_select_not);
                    }

                    o.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v)
                        {
                            T.showShort(mActivity, "点击了，第" + currentRow + "行"
                                    + ", 第" + currentColumn + "列," + "机号为" + jiHao);

                            if (jiHaoSelectInfo.isChecked() == false)
                            {
                                jiHaoSelectInfo.setChecked(true);
                                o.setBackgroundResource(R.drawable.jihao_select_yes);
                            }
                            else
                            {
                                jiHaoSelectInfo.setChecked(false);
                                o.setBackgroundResource(R.drawable.jihao_select_not);
                            }
                        }
                    });
                }
            }
            return convertView;
        }

    }

    private List<String> spinnerUserNoList = new ArrayList<String>();

    public void setSpinnerUserNO(List<String> inList)
    {
        if (spinnerUserNoAdapter == null)
        {
            spinnerUserNoList = inList;
            spinnerUserNoAdapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province, spinnerUserNoList);

            cmbUserNO.setAdapter(spinnerUserNoAdapter);// 设置数据
        }
        else
        {
            spinnerUserNoList = inList;
            spinnerUserNoAdapter.notifyDataSetChanged(); // 这里没有更新数据??? 需要单独测试
        }
    }

    private List<String> spinnerCarTypeList = new ArrayList<String>();
    private Map<String, String> dicCardType = null;
    private Map<String, String> dicCardTypeValue = null;

    public void setSpinnerCarType(List<EntityCarTypeInfo> carTypeList)
    {
        if (carTypeList == null)
            return;
        binMapData(carTypeList);

        if (spinnerCarTypeAdapter == null)
        {
            spinnerCarTypeAdapter = new ArrayAdapter(mActivity.getApplicationContext(), R.layout.blacklist_spinner_province
                    , spinnerCarTypeList);
            cmbCarType.setAdapter(spinnerCarTypeAdapter);// 设置数据
        }
        else
        {
            spinnerCarTypeAdapter.notifyDataSetChanged();
        }
    }

    private void binMapData(List<EntityCarTypeInfo> carTypeList)
    {
        // 将数据存储起来
        if (dicCardType != null)
        {
            dicCardType.clear();
            dicCardType = null;
        }

        if (dicCardTypeValue != null)
        {
            dicCardTypeValue.clear();
            dicCardTypeValue = null;
        }

        dicCardType = new TreeMap<String, String>();
        dicCardTypeValue = new TreeMap<String, String>();

        for (int i = 0; i < carTypeList.size(); i++)
        {
            spinnerCarTypeList.add(carTypeList.get(i).getCardType());

            dicCardType.put(carTypeList.get(i).getIdentifying(), carTypeList.get(i).getCardType());
            dicCardTypeValue.put(carTypeList.get(i).getCardType(), carTypeList.get(i).getIdentifying());
        }
    }


    /**
     * 获取指定type 键值的 value, flag=0,CardType的数据；1,获取Identifying的值
     *
     * @param Flag
     * @return
     */
    public String GetCarType(int Flag)
    {
        String carType = cmbCarType.getSelectedItem().toString();
        String strRet = "无效卡";
        if (Flag == 0)
        {
            for (String m : dicCardTypeValue.keySet())
            {
                if (m.equals(carType))
                {
                    strRet = dicCardTypeValue.get(m);
                }
            }
        }
        else if (Flag == 1)
        {
            for (String m : dicCardType.keySet())
            {
                if (m.equals(carType))
                {
                    strRet = dicCardType.get(m);
                }
            }
        }
        return strRet;
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
        etUserNo.setVisibility(View.VISIBLE);
        etUserNo.setText(userNoStr);
        etUserNo.setEnabled(false);
        cmbUserNO.setVisibility(View.GONE);
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
                        cmbUserNO.setVisibility(View.GONE);
                        etUserNo.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        cmbUserNO.setVisibility(View.VISIBLE);
                        etUserNo.setVisibility(View.GONE);
                    }
                    break;
                case R.id.chkDCWDC:
                    break;
                case R.id.chkAllSelect:
                    if (buttonView.isChecked())
                    {
                        for (ArrayList<JiHaoSelectInfo> o : list)
                        {
                            for (JiHaoSelectInfo m : o)
                            {
                                m.setChecked(true);
                            }
                        }
                    }
                    else
                    {
                        for (ArrayList<JiHaoSelectInfo> o : list)
                        {
                            for (JiHaoSelectInfo m : o)
                            {
                                m.setChecked(false);
                            }
                        }
                    }
                    MyJiHaoAdapter.notifyDataSetChanged();
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

    private void innerOnNewClick()
    {
        flag = "add";
        String[] provinceText = mActivity.getResources().getStringArray(R.array.provinceArray);
        for (int i = 0; i < provinceText.length; i++)
        {
            if (provinceText[i].equals(Model.LocalProvince) == true)
            {
                cmbHeader.setSelection(i);
            }
        }

        cmbCarBrand.setSelection(0);
        cmbCarType.setSelection(0);
        dtpStart.setText(TimeConvertUtils.longToString("yyyy/MM/dd", System.currentTimeMillis()));
        dtpEnd.setText(TimeConvertUtils.longToString("yyyy/MM/dd", System.currentTimeMillis()));

        txtCarPlace.setText("");
        txtRemarks.setText("");
        txtUserName.setText("");
        txtMobileNumber.setText("");
        txtAddress.setText("");
        txtCardYJ.setText("0.0");
        txtMoney.setText("0.0");
        btnAdd.setEnabled(true);

        txtCardYJ.setEnabled(true);
        txtMoney.setEnabled(true);
        txtAddress.setEnabled(true);
        txtMobileNumber.setEnabled(true);
        dtpStart.setEnabled(true);
        dtpEnd.setEnabled(true);
        txtUserName.setEnabled(true);
        cmbCarType.setEnabled(true);
    }

    private String AsyncTaskFormat = "### PlateRegisterAsyncTask ### %1$d";
    private long AsyncTaskCount = 0;

    public class PlateRegisterAsyncTask extends AsyncTask<String, String, Object>
    {
        ParkingPlateRegisterView view = null;
        private String taskName = null;

        public PlateRegisterAsyncTask()
        {

        }

        public PlateRegisterAsyncTask(ParkingPlateRegisterView view)
        {
            this.view = view;
            taskName = String.format(AsyncTaskFormat, AsyncTaskCount++);
            L.i("AsyncTaskFormat:" + taskName);
        }

        public String getTaskName()
        {
            return taskName;
        }

        @Override
        protected void onPreExecute()
        {
        }


        @Override
        protected void onCancelled(Object o)
        {
        }

        @Override
        protected void onCancelled()
        {
        }

        // 执行相应的任务即可
        @Override
        protected Object doInBackground(String... params)
        {
            L.i("params:" + params[0]);
            view.putAsyncIntoContainer(this);
            return onExecuteExpectedTask();
        }

        @Override
        protected void onProgressUpdate(String... values)
        {

        }

        @Override
        protected void onPostExecute(Object o)
        {
            onEndExecuteTask(o);
            view.deleteAsyncFromContainer(this);
        }


        /**
         * 执行结束后
         *
         * @param o
         */
        public void onEndExecuteTask(Object o)
        {

        }

        /**
         * 执行相应的任务
         */
        public Object onExecuteExpectedTask()
        {
            return null;
        }

    }

    public void putAsyncIntoContainer(PlateRegisterAsyncTask task)
    {
        if (task == null)
        {
            return;
        }

        TaskMap.put(task.getTaskName(), task);
    }

    public int getAsyncTaskCount()
    {
        int size = TaskMap.size();
        if (size > 10/*Runtime.getRuntime().availableProcessors() * 5*/)
        {
            throw new ArrayIndexOutOfBoundsException("size:" + size + "出现错误");
        }
        return TaskMap.size();
    }

    public void deleteAsyncFromContainer(PlateRegisterAsyncTask task)
    {
        if (task == null)
        {
            return;
        }

        TaskMap.remove(task.getTaskName());
    }

    public void destoryContainer()
    {
        if (getAsyncTaskCount() == 0)
        {
            return;
        }

        Set<String> set = TaskMap.keySet();
        for (String temp : set)
        {
            PlateRegisterAsyncTask stringStringObjectAsyncTask = (PlateRegisterAsyncTask) TaskMap.get(temp);
            stringStringObjectAsyncTask.cancel(true);
            L.i("### destoryContainer:" + stringStringObjectAsyncTask.getTaskName());
            TaskMap.remove(temp);
        }
    }

    /**
     * 获取选择的机号
     *
     * @return
     */
    public List<String> getSelectJiHao()
    {
        List<String> intList = new ArrayList<>();
        for (ArrayList<JiHaoSelectInfo> o : list)
        {
            for (JiHaoSelectInfo m : o)
            {
                if (m.isChecked() == true)
                    intList.add(m.getJiHaoTxt());
            }
        }
        return intList;
    }


    public boolean getCheckBoxMultiCarValue()
    {
        return chkDCWDC.isChecked();
    }

    public List<String> getMutliCarCPH()
    {
        return mutliCarList;
    }

    public boolean getCheckAutoCarNoIsChecked()
    {
        return chkAutoCardNo.isChecked();
    }

    public EntityUserInfo GetPersonnel()
    {
        EntityUserInfo entityUserInfo = new EntityUserInfo();

        entityUserInfo.setUserNO(cmbUserNO.getSelectedItem().toString());
        entityUserInfo.setUserName(txtUserName.getText().toString());
        entityUserInfo.setHomeAddress(txtAddress.getText().toString().trim());

        entityUserInfo.setWorkTime(TimeConvertUtils.longToString("yyyy-MM-dd 00:00:00", System.currentTimeMillis()));
        entityUserInfo.setBirthDate(TimeConvertUtils.longToString("yyyy-MM-dd 00:00:00", System.currentTimeMillis()));
        entityUserInfo.setMobNumber(txtMobileNumber.getText().toString().trim());
        String carCount = txtCarCount.getText().toString();
        entityUserInfo.setCarPlaceNo(Integer.parseInt(carCount.equals("") ? "1" : carCount));

        Log.i("GetPersonnel:", entityUserInfo.toString());
        return entityUserInfo;
    }
}
