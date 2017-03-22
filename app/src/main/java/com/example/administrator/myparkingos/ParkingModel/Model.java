package com.example.administrator.myparkingos.ParkingModel;

/**
 * Created by Administrator on 2017-02-22.
 */

public class Model
{
    public static boolean bFullComfirmOpen = false;
    public static String sMonthOutChargeType = "";
    public static boolean bCarYellowTmp = false;
    public static String strCarYellowTmpType="Tmp";

    public static boolean isStartGuide = false;

//    public static String LanguageFlag { get; set; }
//    public static ResourceDictionary SkinResource { get; set; }
//    public static ResourceDictionary LanguageResource { get; set; }


    public static String serverIP = "";
    public static String serverPort = "";

    /// <summary>
    /// 网络延时(单位为S)
    /// </summary>
    public static int NetDelayey = 5;

    /// <summary>
    /// 权限分配List
    /// </summary>
//    public static List<Rights> lstRights = new List<Rights>();

    /// <summary>
    /// token(用于访问服务器的唯一凭证)
    /// </summary>
    public static String token = "";

    /// <summary>
    /// 当前工作站的编号(唯一)
    /// </summary>
    public static int stationID = 1;

    /// <summary>
    /// 公司名称
    /// </summary>
    public static String sCompany = "";

    /// <summary>
    /// 用户名称
    /// </summary>
    public static String sUserName = "";

    /// <summary>
    /// 用户卡号
    /// </summary>
    public static String sUserCard = "";


    /// <summary>
    /// 用户密码
    /// </summary>
    public static String sUserPwd = "";

    /// <summary>
    /// 用户权限组编号
    /// </summary>
    public static int sGroupNo = 0;

//    public static DataTable sUserDT;

    public static boolean bCPHDJ = false;

    /// <summary>
    /// 数据库更新脚本的路径
    /// </summary>
    //public static string SqlUpdateFile = @"\SQL\Updateznykt.sql";

    /// <summary>
    /// 系统规模(卡号范围)
    /// </summary>
    public static String sPubGm;

    /// <summary>
    /// 工作站系统配置
    /// </summary>
    public static String sPubPz;

    /// <summary>
    /// LoginComputerName计算机名
    /// </summary>
    public static String sLocalPC;

    /// <summary>
    /// 系统管理员密码
    /// </summary>
    public static String sManagerPass;

    /// <summary>
    ///登录时间
    /// </summary>
//    public static DateTime dLoginTime;

    /// <summary>
    /// PubTc车场区号
    /// </summary>
    public static int iParkSector = 9;

    /// <summary>
    /// PubMJ门禁区号
    /// </summary>
    public static int iDoorSector = 8;

    /// <summary>
    /// 电梯门禁区号
    /// </summary>
    public static int Dt_DoorSector = 7;

    /// <summary>
    /// 控制机IP
    /// </summary>
//    public static String CtrIP = "192.168.168.168";

    /// <summary>
    /// 语言版本
    /// </summary>
    public static String Language = "Chinese";

    /// <summary>
    /// 是否启用帮助提示;
    /// </summary>
    public static boolean Helpflag = true;

    /// <summary>
    /// 门禁下载卡号的时候如果有掉包如果连续掉1秒钟的话就说明通讯不通，下载卡号失败
    /// </summary>
    public static int MJDownLoadCardOutTime = 1;

    public static String strTmpInTime = "";

    /// <summary>
    /// 计费器通讯模式
    /// 0:485
    /// 1:USB
    /// </summary>
    public static String strJFQ = "0";

    /// <summary>
    /// 发行器通讯模式
    /// </summary>
    public static String strFXQ = "0";

    /// <summary>
    /// 控制机通讯模式
    /// </summary>
    public static String strKZJ = "1";

    /// <summary>
    /// IC卡模式系统
    /// </summary>
    public static String strIC = "0";

    /// <summary>
    /// ID卡模式系统
    /// </summary>
    public static String strID = "0";

    /// <summary>
    /// 默认IP地址
    /// </summary>
    public static String strMIP = "192.168.1.99";

    /// <summary>
    /// 向导模式设置
    /// </summary>
    public static int MenuXD = 0;

    /// <summary>
    /// 设置进度
    /// </summary>
    public static int MenuJD = 0;

    /// <summary>
    /// 车牌识别模块类型
    /// </summary>
    public static int iAutoPlateType = 1;

    /// <summary>
    /// 0是软识别，1是硬识别
    /// </summary>
    public static int iRsbYsb = 0;

    /// <summary>
    /// PubTcno车场发行器机号
    /// </summary>
    public static int iFxID = 1;

    /// <summary>
    /// 0x5720表示USB发行器   0x5760临时卡计费器
    /// </summary>
    public static short UsbHid = 0x5720;

    /// <summary>
    /// 1 一卡通发行器  2  车场临时卡计费器
    /// </summary>
    public static int iFXMachineType = 2;

    /// <summary>
    /// 标识编号
    /// </summary>
    public static int iOperatorId;

    /// <summary>
    /// 操作员权限组编号
    /// </summary>
    public static int iOperatorRightId;

    /// <summary>
    /// 服务器名称
    /// </summary>
    public static String sPubServer;

    /// <summary>
    /// Sql Server Database
    /// </summary>
    public static String sPubDatabase;

    /// <summary>
    /// Sql Server登录用户
    /// </summary>
    public static String sPubUID;

    /// <summary>
    /// Sql Server登录密码
    /// </summary>
    public static String sPubPWD;

    /// <summary>
    /// Sql Server登录端口
    /// </summary>
    public static String sPubPort;

    /// <summary>
    /// PubLogin是否刷卡登录
    /// </summary>
    public static int iPubLoginType;

    /// <summary>
    /// 人像抓拍
    /// </summary>
    public static int iPersonVideo;

    /// <summary>
    /// 卡片物理号
    /// </summary>
    public static String sCardFixNO;

    /// <summary>
    /// 检测狗
    /// </summary>
    public static boolean bSoftDog;

    /// <summary>
    /// TCardsYes已经挂失
    /// </summary>
    public static int iLostReg;

    /// <summary>
    /// 发卡器串口
    /// </summary>
    public static int iParkCom = 1;

    /// <summary>
    /// 车场串口
    /// </summary>
    public static int iParkingCom = 1;

    /// <summary>
    /// 门禁串口
    /// </summary>
    public static int iMJCom = 1;

    /// <summary>
    /// 串口波特率
    /// </summary>
    public static int BaudRate = 4800;

    /// <summary>
    /// 串口波特率
    /// </summary>
    public static int BankBaudRate = 115200;

    /// <summary>
    /// USB手持机产品ID号0x5760：临时卡计费器。0x5750手持机
    /// </summary>
    public static int USBSProductID = 0x9750;

    /// <summary>
    /// 发行器
    /// </summary>
    public static int USBFProductID = 0x9720;

    /// <summary>
    /// 临时卡计费器
    /// </summary>
    public static int USBLProductID = 0x9760;

    /// <summary>
    /// 整个程序采用那种通讯方式。0：串口 1:TCP  2:USB
    /// </summary>
    public static int ComClass = 0;

    public static String[] ReadRepeat = new String[10];

    /// <summary>
    /// 判断是否启动读取脱机界面
    /// </summary>
    public static int ReadRecord = 0;

    /// <summary>
    /// 判断是否进入在线监控界面
    /// </summary>
    public static int Monitoring = 0;

    public static int iParking = 0;

    /// <summary>
    /// TPigDate归档日期
    /// </summary>
//    public static DateTime dArchiveDate;

    /// <summary>
    /// 此车场所有计算机设置的车道数组
    /// </summary>
    public static int[] iAllControlArray = new int[200]; //TComputerControl所有计算机的机号

    /// <summary>
    /// 此车场所有存在的机号个数
    /// </summary>
    public static int iAllControlCount;      //TAllControlRecord所有存在的机号个数(包括所有计算机的机号)

    /// <summary>
    /// 车场区号启用
    /// </summary>
    public static boolean bParkSector = true;

    /// <summary>
    /// 门禁区号启用
    /// </summary>
    public static boolean bDoorSector;

    /// <summary>
    /// 车场区号启用
    /// </summary>
    public static boolean bDtSector = true;

    /// <summary>
    /// 是否启用端口号
    /// </summary>
    public static boolean bStartPort = false;

    /// <summary>
    /// 是否启用每天最高限额
    /// </summary>
    public static int iZGXE = 0;

    /// <summary>
    /// 启用每天最高限额的方式
    /// </summary>
    public static int iZGXEType = 0;

    /// <summary>
    /// 是否启动自动备份功能
    /// </summary>
    public static boolean bIsBakSet;

    /// <summary>
    /// 备份路径
    /// </summary>
    public static String BakRoute;//备份路径

    /// <summary>
    /// 每天备份时间
    /// </summary>
    public static String BakTime;//每天备份时间

    /// <summary>
    /// 自动 弹出还是手动点击
    /// </summary>
    public static int iParkingWriteTempCar = 0;


    /// <summary>
    /// 当前电脑设置的车道数量
    /// </summary>
    public static int iChannelCount;

    /// <summary>
    /// 车道设置结构
    /// </summary>
    public class StructChannel
    {
        public int iInOut;
        public String sInOutName;
        public int iCtrlID;
        public int iOpenID;
        public int iOpenType;
        public String sCarVideo;
        public String sPersonVideo;
        public int iBigSmall;
        public int iCheckPortID;
        public int iOnLine;   //TempIn
        public int iTempOut;
        public int iOutCard;
        public String sIDAddress;
        public String sIDSignal;
        public String sSubJH;
        public int iXieYi;
        public String sIP;
        public String sPCName;
    }

    /// <summary>
    /// 车道设置结构数组
    /// </summary>
    /// <returns></returns>
    public static StructChannel[] Channels = new StructChannel[100];

    /// <summary>
    /// 是否启用车牌识别
    /// </summary>
    public static int IsCPHAuto = 0;

    /// <summary>
    /// 是否插入加密狗
    /// </summary>
    public static boolean bStart = false;

    /// <summary>
    /// 是否插入多路加密狗
    /// </summary>
    public static boolean bDStart = false;

    /// <summary>
    /// 使用软件发行卡片数量
    /// </summary>
    public static int iFaXingCount = 6;

    /// <summary>
    /// TCardsClass计算卡号的类型 (1-9999)为1类  10000-65535为2类
    /// </summary>
    public static int iTCardsClass = 2;

    /// <summary>
    /// TtkjTime中心收费吞卡超时
    /// </summary>
    public static int iTkjTimeOut = 5;

    /// <summary>
    /// TtkjMoney中心超时金额
    /// </summary>
    public static double iTkjTimeOutMoney = 0;

    /// <summary>
    /// 文件存盘路径
    /// </summary>
    public static String sImageSavePath = "D:";

    /// <summary>
    /// Imagesave图像存盘
    /// </summary>
    public static int iImageSave = 1;

    /// <summary>
    /// 启用视频
    /// </summary>
    public static int iEnableVideo = 0;            //TNoImage有无图像

    /// <summary>
    /// 网络摄像头
    /// </summary>
    public static int iEnableNetVideo = 0;

    /// <summary>
    /// 网络摄像头类型
    /// </summary>
    public static int iEnableNetVideoType = 0;

    /// <summary>
    /// 图象存盘天数
    /// </summary>
    public static int iImageSaveDays = 120;

    /// <summary>
    /// 图片自动删除
    /// </summary>
    public static int iImageAutoDel = 0;

    /// <summary>
    /// 每天图片自动删除的时间（几点开始执行
    /// </summary>
    public static int iImageAutoDelTime = 1;

    /// <summary>
    /// TJiankongka视频卡类
    /// </summary>
    public static int iVideoCardType = 0;

    /// <summary>
    /// 总车位数（999）
    /// </summary>
    public static int iParkTotalSpaces = 999;

    /// <summary>
    /// 加载时间方式
    /// </summary>
    public static int iLoadTimeType = 0;

    /// <summary>
    /// 时间加载间隔
    /// </summary>
    public static int iLoadTimeInterval = 20;

    /// <summary>
    /// 收费方式
    /// </summary>
    public static int iChargeType = 0;

    /// <summary>
    /// 收费选项
    /// </summary>
    public static int iChargeOption = 0;

    /// <summary>
    /// 下载有效卡号
    /// </summary>
    public static int iICCardDownLoad = 0;

    /// <summary>
    /// 显示道闸状态  软件控制道闸开关
    /// </summary>
    public static int iShowGateState = 1;

    /// <summary>
    /// 允许折扣
    /// </summary>
    public static int iDiscount = 0;

    /// <summary>
    /// 票据打印（TBillPrint）
    /// </summary>
    public static int iBillPrint = 0;

    /// <summary>
    /// 带小数点(Txsd)
    /// </summary>
    public static int iXsd = 0;

    /// <summary>
    /// 带小数点处理方法(TCNum)
    /// </summary>
    public static boolean bXsdHnadle = false;

    /// <summary>
    /// 允许免费车(TCFree)
    /// </summary>
    public static int iFreeCar = 0;

    /// <summary>
    /// 允许临免车(TTempFree)
    /// </summary>
    public static int iTempFree = 0;

    /// <summary>
    /// 实时下载(TTimeLost)
    /// </summary>
    public static int iRealTimeDownLoad = 0;

    /// <summary>
    /// 岗亭编号
    /// </summary>
    public static int iWorkstationNo = 1;

    /// <summary>
    /// 车场编号(TTCBianHao)
    /// </summary>
    public static int iParkingNo = 0;

    /// <summary>
    /// 图片不加水印(TCarPlace)
    /// </summary>
    public static int iCarPosLed = 1;

    /// <summary>
    /// 车位串口(TCarPlcomm)
    /// </summary>
    public static int iCarPosCom = 0;

    /// <summary>
    /// 车位机号(TCarPlNoNo)
    /// </summary>
    public static int iCarPosLedJH = 0;

    /// <summary>
    /// 收费显屏(TDisScreen)
    /// </summary>
    public static int iSFLed = 0;

    /// <summary>
    /// 收费屏串口(TScreenComm)
    /// </summary>
    public static int iSFLedCom = 0;

    /// <summary>
    /// 外接收费显示屏
    /// </summary>
    public static int iSFLedType = 0;

    /// <summary>
    /// 满位灯箱(TFullslight) 1月卡 2临时车 3储值车 5所有车禁止 0所有可以
    /// </summary>
    public static int iFullLight = 0;

    /// <summary>
    /// 满位串口(Tullcomm)
    /// </summary>
    public static int iFullCom = 0;

    /// <summary>
    /// 满位机号(TFullJhNo)
    /// </summary>
    public static int iFullJH = 0;

    /// <summary>
    /// 证件抓拍(TCertificate)
    /// </summary>
    public static int iIDCapture = 0;

    /// <summary>
    /// 证件抓拍口(g_sZjCatch)
    /// </summary>
    public static String sIDCaptureCard = "0";

    /// <summary>
    /// 视频卡监控口
    /// </summary>
    public static int[] g_iWatch = new int[2];

    /// <summary>
    /// 月卡超时收费
    /// </summary>
    public static int iYKOverTimeCharge = 0;

    /// <summary>
    /// 出卡机箱收卡显示
    /// </summary>
    public static int iReceiveCardDisplay = 0;

    /// <summary>
    /// 检测密码
    /// </summary>
    public static int iCheckPassType = 0;

    /// <summary>
    /// 凭密码退出在线监控  0无密码  1登录密码  2车场设置密码
    /// </summary>
    public static int iExitOnlineByPwd = 0;

    /// <summary>
    /// 进出时间限制
    /// </summary>
    public static int iInOutLimitSeconds = 0;

    /// <summary>
    /// 车牌对比
    /// </summary>
    public static int iCompareAccuracy = 0;

    /// <summary>
    /// 预置车牌
    /// </summary>
    public static String[] PreCarNoNo = new String[10];

    /// <summary>
    /// 预置颜色
    /// </summary>
    public static String[] PreCarColor = new String[10];

    /// <summary>
    /// 预置卡类
    /// </summary>
    public static String[] PreCardType = new String[10];

    /// <summary>
    /// 预置型号
    /// </summary>
    public static String[] PreCarXinHao = new String[10];

    /// <summary>
    /// 预置备注
    /// </summary>
    public static String[] PreCarRemark = new String[10];

    /// <summary>
    /// 预置备注数量
    /// </summary>
    public static int iPreCarRemarkMax = 0;

    /// <summary>
    /// 刷卡登录
    /// </summary>
    public static int iReadCardLogin = 0;

    /// <summary>
    /// 自动加载收费
    /// </summary>
    public static int iAutoLoadCharge = 0;

    /// <summary>
    /// 检测机号是否联通
    /// </summary>
    public static boolean TCheckControlOC = false;

    /// <summary>
    /// 机口个数
    /// </summary>
    public static int TRecord = 0;

    /// <summary>
    /// 为True时调出入管理，为false时不调用
    /// </summary>
    public static boolean TComeGoFlag = false;

    /// <summary>
    /// 为True时调系统设置，为false时调用初始化
    /// </summary>
    public static boolean TSystemDelete = false;

    /// <summary>
    ///
    /// </summary>
    public static long prevWndProc;


    public static boolean g_NotComeGoForm;

    public static boolean Quit_Flag = false;

    public static int Unload_Flag = 0;

    /// <summary>
    /// 中央收费口
    /// </summary>
    public static boolean OverCharge_Flag = false;

    /// <summary>
    /// 采集卡数量
    /// </summary>
    public static long g_iTotalCardNum = 0;

    /// <summary>
    /// 有无视频卡
    /// </summary>
    public static boolean g_IsHaveMiniCard = false;

    /// <summary>
    /// ID临时卡是否自动报价
    /// </summary>
    public static boolean TbBaoJia = false;

    /// <summary>
    /// ID临时卡是否二次授权
    /// </summary>
    public static boolean bIDIssue = false;

    /// <summary>
    /// 程序类型
    /// </summary>
    public static int iType = 0;

    /// <summary>
    /// 增加子客户代码
    /// </summary>
    public static int iSonType = 0;

    /// <summary>
    /// 主窗口标题
    /// </summary>
    public static String strCaption = "";

    public static String[] strTmpHead = new String[100];

    /// <summary>
    /// 管理员是否二次登录
    /// </summary>
    public static boolean bLogin = false;

    /// <summary>
    /// 管理员二次登录成功
    /// </summary>
    public static boolean[] bLoginOK = new boolean[1];

    /// <summary>
    /// 是否有备份数据库连接
    /// </summary>
    public static boolean bLinkType = false;

    /// <summary>
    /// 是否有备份数据库连接
    /// </summary>
    public static boolean bDatabaseBack = false;

    public static String[] strLinkFile = new String[4];

    public static boolean bIDFx = false;

    /// <summary>
    /// 是否选用大收费窗口
    /// </summary>
    public static boolean bTempBig = false;

    /// <summary>
    /// 是否捕捉单键
    /// </summary>
    public static boolean bKey = false;

    public static int[] keyF = new int[21];
    public static int[] keyNum = new int[10];
    public static int[] keyABC = new int[26];
    public static boolean bSFing = false;
    public static boolean[] bEnable = new boolean[40];

    public static int iISOAdd = 0;
//    public static long[][] lDogID = new long[1, 3];
    public static long[] lDogSN = new long[3];
//    public static String[] strDogPwd = new string[1, 3];
    public static String[] strDogStr = new String[3];
    public static int iSoftType = 0;

    public static int iDogType = 3;
    public static int iDogVersion = 0;
    public static int iDogVersionInit = 0;

    /// <summary>
    /// 定制狗
    /// </summary>
    public static boolean bDogTypeEn = false;

    /// <summary>
    /// 图像抓拍类型
    /// </summary>
    public static int iPhotoType = 0;

    /// <summary>
    /// 按人员姓名编号查询出入场记录
    /// </summary>
    public static int iQueryName = 0;

    /// <summary>
    /// 使用日期检测
    /// </summary>
    public static boolean bDayCheck = false;

    /// <summary>
    /// 使用起止日期
    /// </summary>
    public static String[] strDateStr = new String[2];

    /// <summary>
    /// 8类临时卡
    /// </summary>
    public static boolean bTemp8 = true;

    public static String[] CipherPwd = new String[100];
    public static byte[] byteBitMode = new byte[8];
    //Dim Character() ; * 1
//    public static string[,] strRegKey = new string[2, 11];
    public static boolean bNoDog = false;
    public static boolean bSfDec = false;
    public static boolean bDatabaseCreate = false;               //是否可直接在软件中创建数据库
    public static int iSectorTcc = 9;
    public static int iXieYi = 0;   //18

    /// <summary>
    /// 单视频卡轮流监控间隔时间(通讯延时用)
    /// </summary>
    public static int iVideoShiftTime = 5;
    public static int iVideo4 = 0;
    public static boolean bKbInput = false;
    public static boolean bKbFx = false;

    /// <summary>
    /// 月卡在设定时段收费，收费由下位机计算
    /// </summary>
    public static boolean bMonthCardCharge = false;
    public static int iNoDogCardMax = 5;

    /// <summary>
    /// true/false通信端口打开正常/未打开,只在打开断口和设定端口使用
    /// </summary>
    public static boolean PORT_OPEN_CarPlace = false;

    public static boolean bHandMac = false;
    public static int i2in1 = 0;
    public static int i2in1Out = 0;
    public static boolean b2in1 = false;
    public static boolean bNoCardTemp = false;
    public static boolean bDogInvalid = false;
    public static int iDayCheckDayMax = 60;
    public static int iDayCheckSetupCountMax = 60;
    public static boolean bTest = false;
//    public static string[,] strTel = new string[4, 100];
    public static boolean[] Myboooo = new boolean[3];
    public static boolean bAnXiaId = false;
    public static boolean bPlaceLed = false;

    public static long lRtl = 0;
    public static boolean bOutPrint = false;
    public static boolean bSleep = false;
    public static String strComSetting = "";

    /// <summary>
    /// ID临时卡出场收费可取消
    /// </summary>
    public static int iIdSfCancel = 0;

    public static int iSetTempCardType = 0;
    public static boolean bSfSD = false;
    public static String[] strArea = new String[58];

    /// <summary>
    /// 车牌默认省区
    /// </summary>
    public static String strAreaDefault = "粤";

    /// <summary>
    /// 电脑语音播报车牌
    /// </summary>
    public static boolean bPcTalkPlate = false;

    /// <summary>
    /// 控制机语音播报并显示车牌
    /// </summary>
    public static int iCtrlShowPlate = 1;

    public static int iTcCtrlCount = 0;
    public static int iTcCtrlMax = 0;
    public static int iLPRIndex = 0;
    public static boolean bAutoPlate = false;

    public static String strNetDir = "";

    /// <summary>
    /// ID卡软件开闸
    /// </summary>
    public static int iIDSoftOpen = 0;
    public static boolean bIdTempCard = false;
    public static long lMoneyMax = 9999;

    /// <summary>
    /// 控制一进一出
    /// </summary>
    public static int iIDOneInOneOut = 0;

    /// <summary>
    /// 分卡类一进一出(bSetupInOutID)
    /// </summary>
    public static boolean[] bID1In1OutCardTypeArray = new boolean[7];

    /// <summary>
    /// ID分卡类一进一出连接字符串(01010101)，保存数据库
    /// </summary>
    public static String sID1In1OutCardType = "";

    /// <summary>
    /// ID分卡类确认开闸
    /// </summary>
    public static int iIDComfirmOpen = 0;

    /// <summary>
    /// ID卡分卡类确认开闸
    /// </summary>
    public static boolean[] bIDComfirmOpenCardTypeArray = new boolean[7];

    /// <summary>
    /// ID卡分卡类确认开闸连接字符串，保存数据库(01010101)
    /// </summary>
    public static String sIDComfirmOpenCardType = "";
    public static byte[] byteMode = new byte[11];
    public static int iSetTempMoney = 0;
    public static String[] strCardType = new String[18];
    public static String[] strLoadFlag = new String[11];
    public static boolean bInMoney = false;
    //public static byte[] byteHead = new byte[26];
    public static byte[] byteBack = new byte[26];
    public static boolean bPlaceLed0 = false;
    public static boolean bDelRecord = false;
    public static boolean bSaveLog = false;
    public static boolean bQueryLog = false;

    /// <summary>
    /// 固定卡有效期剩余XX天提示
    /// </summary>
    public static int iIDNoticeDay = 10;

    public static String strRevision = "";

    /// <summary>
    /// 软件开闸不输入车牌
    /// </summary>
    public static int iSoftOpenNoPlate = 0;


    public static boolean bOutTalk = false;
    public static boolean bDispLY = false;
    public static int iBillPrintAuto = 0;

    /// <summary>
    /// 8类月卡
    /// </summary>
    public static boolean bMonth8 = true;

    /// <summary>
    /// 月卡在设定时段收费，IC卡选择为下载有效，收费由上位机计算
    /// </summary>
    public static boolean bMonthFdSf = false;

    public static boolean bPaiChe = false;
    public static String[] FilesJpgTemp = new String[50];
    public static String[] DateTimeTemp = new String[50];
    public static String[] CardNoTemp = new String[50];

    /// <summary>
    /// 地感抓拍图像，此记录继续往后处理
    /// </summary>
    public static boolean bAutoPhoto = false;

    /// <summary>
    /// 地感抓拍图像，拍完图像就不往后处理了
    /// </summary>
    public static boolean bPhotoDG = true;
    public static boolean bTempInInfo = false;
    public static boolean bAutoRecord = false;
    public static boolean[] bMoneyAddType = new boolean[8];
    public static int[] iMoneyAdd = new int[8];
    public static boolean[] bTempMoneyAdd = new boolean[10];
    public static boolean bLENOPaiChe = false;
    public static boolean bNewOcx = true;
    public static boolean bTTCBianHaoEn = false;
    public static boolean bTextRed = false;
    public static boolean bInOutDelay = false;
    public static boolean bDemoVersion = false;
    public static int iDisplayTime = 0;

    public static boolean bPhotoLog = false;

    /// <summary>
    /// 临时卡优惠次数：只针对C、D类卡
    /// </summary>
    public static boolean bTempDiscount = false;

    /// <summary>
    /// 控制机显示剩余车位,实时更新
    /// </summary>
    public static int iCtrlShowRemainPos = 0;        //bShowRemainCar

    /// <summary>
    /// 控制机显示屏显示用户加载的信息,实时更新
    /// </summary>
    public static int iCtrlShowInfo = 0;             //bShowInfo

    /// <summary>
    /// 隐藏公司名称
    /// </summary>
    public static boolean bLogoHide = false;

    /// <summary>
    /// 压地感或红外抓拍带延时
    /// </summary>
    public static boolean bPhotoDGDelay = false;

    /// <summary>
    /// 四字剩余车位显示屏
    /// </summary>
    public static boolean bLedFour = false;

    /// <summary>
    /// 视频分辨率
    /// </summary>
    public static int iVideoResolution = 0;

    /// <summary>
    /// 视频分辨率参数
    /// </summary>
//    public static int[,] iVideoResolutionParam = new int[6, 2];

    public static String strSqlPack = ""; // 数据库升级包

    /// <summary>
    /// 车队
    /// </summary>
    public static boolean[] bCheDuiArray = new boolean[4];

    /// <summary>
    /// 0 车场设置，1记录清理,2 初始化,3控制设置,4归档记录处理
    /// </summary>
    public static int iPwdType = 0;

    /// <summary>
    /// 控制设置凭密码
    /// </summary>
    public static int iCtrlSetHasPwd = 0;

    public static String[] strYYArea = new String[103];

    /// <summary>
    /// 剩余车位显示屏字数
    /// </summary>
    public static int iCarPosLedLen = 0;
    public static boolean bDogOK = false;

    /// <summary>
    /// 剩余车位屏显示发布信息(自动发送语音)
    /// </summary>
    public static int iRemainPosLedShowInfo = 0;

    public static boolean bSfLed0 = false;

    public static boolean bAutoDog = false;
    public static String strAutoSN = "";
    public static String[] strSN = new String[101];
    public static boolean bAutoDogOK = false;

    public static byte[] byteHeadMJ = new byte[26];
    public static byte[] byteBackMJ = new byte[26];

    /// <summary>
    /// 控制机显示车位号
    /// </summary>
    public static int iCtrlShowCW = 0;
    public static int iDogTypeTemp = 0;
    public static int iDogTypeReg = 0;
    public static int iNewXieYi = 0;
    public static int iMacNoAdd1 = 0;
    public static int iMacNoAdd2 = 0;
    public static int iComNoAdd1 = 0;

    /// <summary>
    /// 不读卡，仅识别车牌进出
    /// </summary>
    public static boolean bNoCardInOut = false;

    /// <summary>
    /// 入场识别车牌如系统没有，是否则弹出窗口人工确认
    /// </summary>
    public static boolean bInAutoCphConfirm = false;

    /// <summary>
    /// 出场识别车牌如系统没有，是否则弹出窗口人工确认
    /// </summary>
    public static boolean bOutAutoCphConfirm = false;
//    public static byte[,] byteLSXY = new byte[2, 6];
    public static int iLSIndex = 0;

    /// <summary>
    /// 视频亮度
    /// </summary>
    public static int iVideoBrightness = 0;

    /// <summary>
    /// 视频亮度值
    /// </summary>
//    public static int[,] iVideoBrightnessVal = new int[6, 4];

    /// <summary>
    /// 月卡延期收费规则
    /// </summary>
    public static int iMonthRule = 0;

    /// <summary>
    /// 月卡延期费用
    /// </summary>
//    public static int[,] iMonthDaysMoney = new int[7, 1];
    public static boolean bCardLog = true;

    /// <summary>
    /// 语音模式（欢迎光临/一路顺风
    /// </summary>
    public static int iCtrlVoiceMode = 0;
    public static int iLedSpeed = 0;

    /// <summary>
    /// 控制机语音播报并显示停车时间
    /// </summary>
    public static int iCtrlShowStayTime = 0;

    /// <summary>
    /// ID储值卡
    /// </summary>
    public static boolean bIdCzk4 = false;
    public static int iNewXieYiTemp = 0;
    public static int iNewXieYiReg = 0;
    public static boolean bEndDateEn = false;
    public static String strEndDate = "";
    public static String strVersionDate = "";
    public static boolean b2in1Old = false;

    /// <summary>
    /// 是否启用一键式快捷键
    /// </summary>
    public static int iOneKeyShortCut = 0;

    /// <summary>
    /// 启用车队模式(道闸常开)
    /// </summary>
    public static int iCheDui = 0;
    public static boolean bSetTempCardPlate = false;

    /// <summary>
    /// 车辆异常处理/无卡放行
    /// </summary>
    public static int iExceptionHandle = 0;

    /// <summary>
    /// 显示发卡机卡箱内卡片数量
    /// </summary>
    public static int iShowBoxCardNum = 0;

    public static int iTempNum = 0;
    public static String strTempNumInitDateTime = "";

    /// <summary>
    /// 主板音量
    /// </summary>
    public static String sCtrlVolume = "";
    public static boolean bPark = false;

    /// <summary>
    /// 仅显示临时固定储值剩余车位(1临时，2固定，3储值)
    /// </summary>
    public static int iOnlyShowThisRemainPos = 0;

    /// <summary>
    /// 临时车车位
    /// </summary>
    public static int iTempCarPlaceNum = 0;

    /// <summary>
    /// 固定车车位
    /// </summary>
    public static int iMonthCarPlaceNum = 0;

    /// <summary>
    /// 储值车车位
    /// </summary>
    public static int iMoneyCarPlaceNum = 0;
    public static boolean bTempCarPlace = false;
    public static boolean bMonthCarPlace = false;
    public static boolean bMoneyCarPlace = false;

    /// <summary>
    /// 剩余车位屏显示车牌
    /// </summary>
    public static int iRemainPosLedShowPlate = 0;
    public static boolean bParking = false;
    public static boolean bParkingNext = false;
    public static String strHelp = ""; //
    public static boolean bSoundBoxVoice = false;
    public static boolean bDoor = false;
    public static boolean bDoorSystem = false;
    public static boolean bParkSystem = true;

    /// <summary>
    /// 1:小数点后一位   2：小数点后两位  (仅北京收费)
    /// </summary>
    public static int iXsdNum = 1;

    //public bSaveNotIssueCardRecord ;    //保存未发行IC卡的刷卡记录

    public static boolean bNoDogNoSet = false;
    public static int iNoDogNoSetType = 0;
    public static String StrRegDate = "";

    /// <summary>
    /// 打印字体
    /// </summary>
    public static int iPrintFontSize = 8; //

    /// <summary>
    /// 远距离ID卡重复读卡优化处理
    /// </summary>
    public static int iIdReReadHandle = 0;         //bIdMemory
    public static long lMoneyMax1 = 9999;

    /// <summary>
    /// 语音/显示屏（3.0 or 4.1）
    /// </summary>
    public static int iCtrlVoiceLedVersion = 1;         //iLsType

    /// <summary>
    /// 门禁报警输入机号（关门为报警）
    /// </summary>
    public static int iAlarmJH = 0;

    /// <summary>
    /// 备份方式
    /// </summary>
    public static int iDataBakType = 0;

    /// <summary>
    /// 备份时间
    /// </summary>
    public static int iDataBakHour = 0;

    /// <summary>
    /// 备份路径
    /// </summary>
    public static String strDataBakPath = "";

    /// <summary>
    /// 白天起止小时，暂借用语音的自动切换时间
    /// </summary>
    public static int[] iHour = new int[2];

    /// <summary>
    /// 隐藏视频卡型号
    /// </summary>
    public static boolean bVideoCardHide = false;

    /// <summary>
    /// 换班登录打印小票
    /// </summary>
    public static int iReLoginPrint = 0;

    /// <summary>
    /// 入场打印条码
    /// </summary>
    public static int iBarCodePrint = 0;

    /// <summary>
    /// 多张卡共享同一个车位，基中一张卡入场后，其它同车位的卡不准入场
    /// </summary>
    public static int iForbidSamePosition = 0;

    /// <summary>
    /// 自动弹出车牌预置窗口
    /// </summary>
    public static int iAutoPrePlate = 0;

    /// <summary>
    /// 错误信息文件
    /// </summary>
    public static String sErrorFile = "";

    /// <summary>
    /// 保存详细日志（开闸窗口弹出、按开闸按钮、开闸记录等）
    /// </summary>
    public static int iDetailLog = 0;

    /// <summary>
    /// 免费卡不计入车位数
    /// </summary>
    public static int iFreeCardNoInPlace = 0;

    /// <summary>
    /// ID卡脱机播报显示车牌
    /// </summary>
    public static int iIdPlateDownLoad = 0;

    public static String[] str123ABC = new String[36];

    /// <summary>
    /// 检测卡口优先提取记录 提取记录优先
    /// </summary>
    public static int iCheckPortFirst = 0;

    /// <summary>
    /// 备份路径2
    /// </summary>
    public static String strDataBakPath2 = "";

    /// <summary>
    /// 全角显示
    /// </summary>
    public static boolean bvbWide = false;

    /// <summary>
    /// 允许重复记录
    /// </summary>
    public static boolean bYXCFJL = false;

    /// <summary>
    /// 门禁开门超时报警
    /// </summary>
    public static boolean bMJOpenTimeOutAlarm = false;

    /// <summary>
    /// 门禁开门超时XX秒才报警
    /// </summary>
    public static int iMJOpenTimeOutSec = 0;

    /// <summary>
    /// 背景可自行更换
    /// </summary>
    public static boolean bImgBack = false;
    public static long lType = 0;
    public static long lBaud = 0;
    public static long[] Baud = new long[10];
    public static long[] BaudNew = new long[10];
    public static String[] strType = new String[31];

    /// <summary>
    /// 在线监控累计金额隐藏
    /// </summary>
    public static int iSumMoneyHide = 0;

    /// <summary>
    /// 客户小蓝屏
    /// </summary>
    public static boolean bJdLed = false;

    /// <summary>
    /// 固定卡开闸方式
    /// </summary>
    public static byte byteMonthOpen = 0;

    /// <summary>
    /// 启用固定卡开闸方式
    /// </summary>
    public static boolean bMonthOpen = false;

    /// <summary>
    /// 启用收费窗口类型自定义
    /// </summary>
    public static boolean bTempTypeDefine = false;

    /// <summary>
    /// 收费窗口类型自定义
    /// </summary>
    public static String[] sTempTypeDefineArray = new String[8];

    /// <summary>
    /// 收费窗口类型自定义连接字符串，为了保存到数据库
    /// </summary>
    public static String sTempTypeDefine = "";

    /// <summary>
    /// 无狗不监控设备可以发卡
    /// </summary>
    public static boolean bNoDogFX = false;

    /// <summary>
    /// 延时多少秒计算
    /// </summary>
    public static int iDelayed = 30;

    /// <summary>
    /// 车场卡片格式加用户编码
    /// </summary>
    public static boolean bIcCardAddType = true;

    /// <summary>
    /// 是否把免费卡替换为储值卡
    /// </summary>
    public static boolean bStrShow = false;

    /// <summary>
    /// 自动进入车场在线监控
    /// </summary>
    public static boolean bAutoOpenMonitor = false;

    /// <summary>
    /// 启用掌上停车
    /// </summary>
    public static boolean bAppEnable = false;

    /// <summary>
    /// 是否带控制板 否就是带相机或者显示屏输出车牌
    /// </summary>
    public static boolean bIsKZB = true;

    /// <summary>
    /// 摄像机输出485
    /// </summary>
    public static boolean bOut485 = false;

    /// <summary>
    /// 摄像机开闸
    /// </summary>
    public static boolean bVideoCamera = false;

    /// <summary>
    /// 是否自动修改机号
    /// </summary>
    public static int iAutoUpdateJiHao = 1;

    /// <summary>
    /// false显示水晶报表 true显示显示传统报表
    /// </summary>
    public static boolean bReport = false;

    /// <summary>
    /// 启用特殊车牌处理
    /// </summary>
    public static boolean bSpecilCPH = false;

    /// <summary>
    /// 全字母车牌不处理
    /// </summary>
    public static boolean bCphAllEn = false;

    /// <summary>
    /// 车牌结果字符完全一样不处理
    /// </summary>
    public static boolean bCphAllSame = false;

    /// <summary>
    /// 协议备份
    /// </summary>
    public static int iXieYiBak = 0;

    /// <summary>
    /// 狗激光打印号
    /// </summary>
    public static String strDogPrintNum = "";

    /// <summary>
    /// 狗编号
    /// </summary>
    public static String strDogNum = "";

    /// <summary>
    /// 相机类型
    /// </summary>
    public static String strDogVideoType = "";

    /// <summary>
    /// 狗类型
    /// </summary>
    public static String strDogType = "";

    /// <summary>
    /// 软件类型
    /// </summary>
    public static String strSoftType = "";

    /// <summary>
    /// 提示信息框延时
    /// </summary>
    public static int iPromptDelayed = 10;


    /// <summary>
    /// 用于车牌识别
    /// </summary>
    public static int iAutoTop = 0;
    public static int iAutoLeft = 0;
    public static int iAutoRight = 0;
    public static int iAutoBottom = 0;

    public static int whiteDay = 7;
    public static int nightDay = 18;

    public static boolean bYellow2 = true;              //是否识别双层黄牌
    public static boolean bIndivi = false;              //是否识别个性化车牌
    public static boolean bArmPol = false;              //是否识别军牌
    public static boolean bArmy2 = false;              //是否识别双层军牌
    public static boolean bTractor = false;              //是否识别农用车牌
    public static boolean bOnlyDyellow = false;              //只识别双层黄牌
    public static boolean bEmbassy = false;              //是否识别使馆车牌
    public static boolean bDarmpolice = false;              //是否识别双层武警车牌
    public static boolean bOnlyLocation = false;              //只定位车牌


    public static boolean bMovingImage = false;                 //识别运动或静止图像
    public static boolean bFlipVertical = false;                 //是否 上下颠倒图像后识别
    public static boolean bVertCompress = false;                //是否 垂直方向压缩一倍识别
    public static int nMinPlateWidth = 60;                   //最小车牌宽度
    public static int nMaxPlateWidth = 400;                  //最大车牌宽度 ，以像素为单位
    public static boolean bDwordAligned = true;                   //是否 四字节对齐
    public static boolean bInputHalfHeightImage = false;         //是否输入场图像。
    public static boolean OutputSingleFrame = true;             //是否 只输出一个识别结果

    public static boolean bNight = false;                        //是否夜间模式。
    public static int nImageplateThr = 5;                    //车牌定位阈值。取值范围是 。。取值范围是 0-9，默认为 7
    public static int nImageRecogThr = 2;                    //车牌识别阈值 。取值范围是 0-9，默认为 2
    public static int nPlatesNum = 1;                        //需要识别车牌的最多个数。

    /// <summary>
    /// 默认省份(可以为空)
    /// </summary>
    public static String LocalProvince = "粤";

    /// <summary>
    /// 读卡延时
    /// </summary>
    public static int iReadCardTime = 100;

    /// <summary>
    /// 识别延时
    /// </summary>
    public static int iAutoYTime = 100;

    /// <summary>
    /// 临时卡收费0元是否自动开闸
    /// </summary>
    public static int iAutoKZ = 0;

    /// <summary>
    /// 临时卡是否有入场记录
    /// </summary>
    public static boolean iAutoCZJL = true;

    /// <summary>
    /// 0.成都识别模块 1.文通识别模块
    /// </summary>
    public static int iAutoPattern = 2;

    /// <summary>
    /// 0.不删除 1.删除
    /// </summary>
    public static int iAutoDeleteImg = 0;

    /// <summary>
    /// 0未知,1蓝色,2黄色,3白色,4黑色,5绿色
    /// </summary>
    public static int iAutoColor = 0;

    /// <summary>
    /// 是否启用军警车自动开闸放行。0：不启用，1：启用
    /// </summary>
    public static int iAutoColorSet = 0;

    /// <summary>
    /// 0牌车自动放行 0：不启用 1：启用
    /// </summary>
    public static int iAuto0Set = 0;

    /// <summary>
    /// 是否启用自动关闭弹出窗体
    /// </summary>
    public static int iAutoMinutes = 0;

    /// <summary>
    /// 启用自动关闭弹出窗体的时间
    /// </summary>
    public static int iAutoSetMinutes = 1;

    /// <summary>
    /// 可信度
    /// </summary>
    public static int iKXD = 0;

    public static int iAutoTime = 0;

    /// <summary>
    /// 车牌识别功能启用
    /// </summary>
    public static int iAutoPlateEn = 0;

    /// <summary>
    /// 对比经度
    /// </summary>
    public static int iAutoPlateDBJD = 2;

    /// <summary>
    /// 入场开闸方式
    /// </summary>
    public static int iInAutoOpenModel = 0;

    /// <summary>
    /// 出场开闸方式
    /// </summary>
    public static int iOutAutoOpenModel = 1;

    /// <summary>
    /// 识别车牌有效时间
    /// </summary>
    public static String iCphDelay = "";

    /// <summary>
    /// 相同车牌  在限制时间内不处理
    /// </summary>
    public static String iSameCphDelay = "0";

    public static String[] strBDPath = new String[11];

//    public static String sImageSavePathBD = @"E:\";

    /// <summary>
    /// 是否启用自动关闭弹出窗体
    /// </summary>
    public static boolean bInOutConfirm = false;

    /// <summary>
    /// 入口手动放行出口确认放行
    /// </summary>
    public static boolean bOutConfirm = false;

    /// <summary>
    /// 月卡入场开闸方式  0自动开闸 1确认开闸
    /// </summary>
    public static int iInMothOpenModel = 0;

    /// <summary>
    /// 月卡出场开闸方式 0自动开闸 1确认开闸
    /// </summary>
    public static int iOutMothOpenModel = 0;

    /// <summary>
    /// 启用多车位多车
    /// </summary>
    public static int iMorePaingCar = 0;

    /// <summary>
    /// 多车位多车的方式
    /// </summary>
    public static int iMorePaingType = 0;

    /// <summary>
    /// 临时车不下载到出口
    /// </summary>
    public static int iTempDown = 0;

    /// <summary>
    /// 车牌识别打折
    /// </summary>
    public static int iAutoCPHDZ = 0;

    /// <summary>
    /// 临时车入口不开闸时 播报语音类型
    /// </summary>
    public static boolean bAutoTemp = false;

    /// <summary>
    /// 是否软件需要时间限制
    /// </summary>
    public static boolean bZhuCe = false;////2015-08-05

    /// <summary>
    /// 启用中央收费
    /// </summary>
    public static int iCentralCharge = 0;

    /// <summary>
    /// 出口是否能收费
    /// </summary>
    public static int iOutCharge = 0;

    public static boolean bOverTimeSF = false;

    //2015-10-28 屏幕分辨率
    public static int iScreenWidth = 1440;
    public static int iScreenHeight = 900;

    /// <summary>
    /// 显示车牌号小图
    /// </summary>
    public static int iCPHPhoto = 0;

    /// <summary>
    /// 临时卡出场收费可取消
    /// </summary>
    public static int iSFCancel = 0;      //2016-02-19

    /// <summary>
    /// 设置最高限额的卡类 0:临时卡 1：储值卡 2：储值卡和临时卡
    /// </summary>
    public static int iZGType = 0;  //2016-03-21

    /// <summary>
    /// 无牌车入口自动开闸
    /// </summary>
    public static int iNoCPHAutoKZ = 0;  // 2016-02-24

    public static byte i485TT = 0;//深圳芊熠相机通透口

    /// <summary>
    /// 摄像机类型
    /// </summary>
    public static String strVideoType = "ZNYKTY5"; //摄像机开闸

    public static int iSkin = 0;//0 :冰川蓝 1:宝石蓝2:魔力黑



    public static int iModiTempType_VoiceSF = 0;   //收费可更改卡类时，弹出收费窗口播报收费 2016-06-15 zsd

    /// <summary>
    /// 是否启动ZNYKTY13 相机
    /// </summary>
    public static boolean bStartZNYKT13 = false;

    /// <summary>
    /// 临时车禁止驶入小车场
    /// </summary>
    public static int iTempCanNotInSmall = 0;

    /// <summary>
    /// 月卡过期多少天以后禁止入场
    /// </summary>
    public static int iMothOverDay = 0;

    public static int iSMPayment = 0; //启用扫码支付 2016-07-04

    public static int iOnlinePayEnabled = 0;

    public static String strWXAppID = "";//绑定支付的APPID（必须配置） 2016-07-04

    public static String strWXMCHID = "";//商户号（必须配置） 2016-07-04

    public static String strWXKEY = "";//商户支付密钥，参考开户邮件设置（必须配置） 2016-07-04

    public static String strZFBAppID = "";//支付宝APPID 2016-07-04

    public static String strZFBPID = "";//支付宝PID 2016-07-04

    public static boolean bPayTest = false; //扫码支付 测试模式

    /// <summary>
    /// 设备通讯的协议号
    /// </summary>
//    public static int DeviceProtocol { get; set; }

    public static int iVideoType = 0; //0代表臻识摄像机

    public static void DataInitRevision()
    {
        strRevision = "ZNYKT-T-YT.3.0.001." + iType + "." + iSonType + "." + iXieYi + ".160923";
    }

    public static void DataInit()
    {
        bTest = false;  //测试版
        bDemoVersion = false; //演示版
        bParkSystem = true; //默认只有车场系统
        bDoor = false;
        bDoorSystem = false; //默认只有门禁系统

        iDogType = 3; //2为3.0，3为3.3
        iNewXieYi = 1; //

        iSoftType = 0;   //0为标准软件，1为非标额外收费软件
        bLogoHide = false; //隐藏公司名称,Logo
        bVideoCardHide = false; //隐藏视频卡型号
        bImgBack = false; //背景可自行更换
        bNoDogFX = false; //无狗不监控设备可以发卡

        bDogTypeEn = false;  //定制狗

        iType = 0;  //界面 0 st,1 空,2 ncjyd,3 sdct/brt,4 KM_js,5 gd,6 ld,7 sc,8 DG ,9 jddc,10,kl,'11 oguan,12 km_Granity,13 BJXATD gfXX,14 anxia， 15 FZSY,16 hntczh 17 SZJD,18 BJJS,19 NJXZ ,
        //'20 SJZLT, 21 ninbofurui, 22 YDTK ,23 NJDM ,24 QDHLW ,25 HengSheng, 26 CDLY ,27 SEWO ,28,DXY,29 3RH
        //'30 CSJT '31 hjzn '32 NanNingJiuChuan '33 DNCT,34 carra,'35 HSST '36 SH_Granity, '37 xjs ,'38 shlk(bc) '39 sim
        //'40 HZQY  '41 RFD '42 ALK '43 GZNZ ' 44 ZD '45 WH汇林 '46 GZ文峻 '47 TX '48 ZM '49 ZQL
        //'50 GZTX '51 JNAWE '52 KST '53 SZZT '54 CZNZ '55 SZDR '56 XAQY '57 GSML '58 GYCT '59 FSQ
        //'60 NJJZ '61 ZFHD '62 TJKJ '63 CSBL' 64 CDYLD '65 SZNZ '66 BJSHJY '67 SZGF ' 68 NJGF '69 SZC
        //'70 SZHBX '71 AK '72 SHYG '73 SZSCM  '74 SDHZCH 125 GZDXM 102 DHCX 77 SJZAB 75 CAX(创安心) 141 BJHJS（） 91 NJJC 152 厦门兴宇达

        iSonType = 0;//子客户代码

        iXieYi = 0;

        strRevision = "ZNYKT-T-YT.2.0.001." + iType + "." + iSonType + "." + iXieYi + ".160722";

        iXieYiBak = iXieYi;

        strType[0] = "ST";
        strType[1] = "JS";
        strType[2] = "BRT";
        strType[3] = "RFD/HSST";
        strType[4] = "WFHS/SZYZCX/BJPLC/NJGF(CZAKD)/CSJT";
        strType[5] = "GDJY";
        strType[6] = "BAK";
        strType[7] = "SC/EDAB";
        strType[8] = "DG/SZKST/JSHAHL";
        strType[9] = "JDDC/GXJC/BJZMT/JNAWE/BZ/JSCZJX";
        strType[10] = "SZJD/XL/LYYS/DLRY,";
        strType[11] = "DXY/MST/JYD/TJSK/ZFHD";
        strType[12] = "SEWO/En/AK";
        strType[13] = "3RH/BC/fsq/gzbo/ZM/GSML";
        strType[14] = "sh Cranity";
        strType[15] = "DNCT";
        strType[16] = "HJ/HZLLL/XNRG/ZZLH/WHAJC/HFRG";
        strType[17] = "ALK/bjngm/GZNZ";
        strType[18] = "DSM/HZQY/SZCAX";
        strType[19] = "AB/SZDLGX/BJYCJJ/SZZHS";
        strType[20] = "ZD";
        strType[21] = "TX";
        strType[22] = "ZQL";
        strType[23] = "BS";
        strType[24] = "";
        strType[25] = "";
        strType[26] = "";
        strType[27] = "";
        strType[28] = "";
        strType[29] = "";
        strType[30] = "";


        byteBitMode[0] = 0x1;
        byteBitMode[1] = 0x2;
        byteBitMode[2] = 0x4;
        byteBitMode[3] = 0x8;
        byteBitMode[4] = 0x10;
        byteBitMode[5] = 0x20;
        byteBitMode[6] = 0x40;
//        byteBitMode[7] = 0x80; // 超过byte的范围

//        byteLSXY[0, 0] = 0x68;
//        byteLSXY[0, 1] = 0x69;    //临时卡收费
//        byteLSXY[0, 2] = 0x6A;    //入场报固定卡期限、车位、车牌
//        byteLSXY[0, 3] = 0x6B;    //出场报固定卡期限、车位、车牌
//        byteLSXY[0, 4] = 0x6C;    //储值卡余额
//        byteLSXY[0, 5] = 0x6D;    //报储值卡余额、收费、期限, 车牌
//
//        byteLSXY[1, 0] = 0x84;
//        byteLSXY[1, 1] = 0x85;
//        byteLSXY[1, 2] = 0x86;
//        byteLSXY[1, 3] = 0x87;
//        byteLSXY[1, 4] = 0x88;
//        byteLSXY[1, 5] = 0x89;

        FilesJpgTemp[0] = "";
        FilesJpgTemp[1] = "";
        FilesJpgTemp[2] = "";
        FilesJpgTemp[3] = "";
        FilesJpgTemp[4] = "";
        FilesJpgTemp[5] = "";
        FilesJpgTemp[6] = "";
        FilesJpgTemp[7] = "";
        FilesJpgTemp[8] = "";
        FilesJpgTemp[9] = "";
        FilesJpgTemp[10] = "";

        bOutTalk = false;
    }

//    #region 缓存权限/权限检查
//    protected static readonly object RightsLock = new object();
//    protected static Dictionary<string, Dictionary<string, Dictionary<string, Rights>>> dicCategoryFormNameItemName_Rights;
//
//    public static bool RightsHasLoaded
//    {
//        get
//        {
//            lock (RightsLock)
//            {
//                return null != dicCategoryFormNameItemName_Rights;
//            }
//        }
//    }
//
//    public static void LoadRights(List<Rights> lstRight, bool ClearFirst = true)
//    {
//        string Category;
//        string FormName;
//        string ItemName;
//        Dictionary<string, Rights> dicItemName_Right;
//        Dictionary<string, Dictionary<string, Rights>> dicFormNameItemName_Right;
//
//        lock (RightsLock)
//        {
//            if (null == dicCategoryFormNameItemName_Rights)
//            {
//                dicCategoryFormNameItemName_Rights = new Dictionary<string, Dictionary<string, Dictionary<string, Rights>>>();
//            }
//
//            if (ClearFirst)
//            {
//                dicCategoryFormNameItemName_Rights.Clear();
//            }
//
//            if (null == lstRight)
//            {
//                return;
//            }
//
//            foreach (Rights rgt in lstRight)
//            {
//                if (null == rgt.Category || null == rgt.FormName)
//                {
//                    continue;
//                }
//
//                Category = rgt.Category.Trim().ToLower();
//                FormName = rgt.FormName.Trim().ToLower();
//                ItemName = (rgt.ItemName ?? "").Trim().ToLower();
//
//                if (dicCategoryFormNameItemName_Rights.ContainsKey(Category))
//                {
//                    dicFormNameItemName_Right = dicCategoryFormNameItemName_Rights[Category];
//                }
//                else
//                {
//                    dicFormNameItemName_Right = new Dictionary<string, Dictionary<string, Rights>>();
//                    dicCategoryFormNameItemName_Rights.Add(Category, dicFormNameItemName_Right);
//                }
//
//                if (dicFormNameItemName_Right.ContainsKey(FormName))
//                {
//                    dicItemName_Right = dicFormNameItemName_Right[FormName];
//                }
//                else
//                {
//                    dicItemName_Right = new Dictionary<string, Rights>();
//                    dicFormNameItemName_Right.Add(FormName, dicItemName_Right);
//                }
//
//                if (dicItemName_Right.ContainsKey(ItemName))
//                {
//                    dicItemName_Right[ItemName] = rgt;
//                }
//                else
//                {
//                    dicItemName_Right.Add(ItemName, rgt);
//                }
//            }
//        }
//    }
//
//    public static Rights GetRight(string Category, string FormName, string ItemName)
//    {
//        Dictionary<string, Rights> dicItemName_Right;
//        Dictionary<string, Dictionary<string, Rights>> dicFormNameItemName_Right;
//
//        lock (RightsLock)
//        {
//            if (null == dicCategoryFormNameItemName_Rights || dicCategoryFormNameItemName_Rights.Count <= 0)
//            {
//                return null;
//            }
//
//            if (null == Category || null == FormName)
//            {
//                return null;
//            }
//
//            Category = Category.Trim().ToLower();
//            FormName = FormName.Trim().ToLower();
//            ItemName = (ItemName ?? "").Trim().ToLower();
//
//            if (!dicCategoryFormNameItemName_Rights.ContainsKey(Category))
//            {
//                return null;
//            }
//            dicFormNameItemName_Right = dicCategoryFormNameItemName_Rights[Category];
//
//            if (!dicFormNameItemName_Right.ContainsKey(FormName))
//            {
//                return null;
//            }
//            dicItemName_Right = dicFormNameItemName_Right[FormName];
//
//            if (!dicItemName_Right.ContainsKey(ItemName))
//            {
//                return null;
//            }
//
//            return dicItemName_Right[ItemName];
//        }
//    }
//    #endregion
}