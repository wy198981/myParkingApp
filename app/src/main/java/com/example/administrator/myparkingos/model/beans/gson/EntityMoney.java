package com.example.administrator.myparkingos.model.beans.gson;      //

/**
 * Created by Administrator on 2017-03-17.
 */
public class EntityMoney
{

    private Long ID;      //自增长唯一标识
    private String CardNO;      //卡号
    private String UserNO;      //人员编号
    private String CPH;      //车牌号码
    private String OptDate;      //操作时间
    private float SFJE;      //本次收费金额
    private float Balance;      //余额。
    private String OperatorNO;      //操作员编号
    private String OptType;      //操作类型。1为发卡收费记录，E为发卡押金记录，F延期记录，3为IC充值记录，9为IC卡无卡退款记录，7为IC卡有卡退款记录，D为IC卡退卡记录
    private String NewStartDate;      //新开始日期
    private String NewEndDate;      //新结束日期
    private String LastEndDate;      //上次结束日期
    private String CardType;      //参考卡片定义Model结构同名字段
    private String CarCardType;      //参考卡片发行Model结构同名字段
    private String CardState;      //参考卡片发行Model结构同名字段
    private float CardYJ;      //参考卡片发行Model结构同名字段
    private String SubSystem;      //参考卡片发行Model结构同名字段
    private String CarIssueDate;      //参考卡片发行Model结构同名字段
    private String CarIssueUserCard;      //参考卡片发行Model结构同名字段
    //    private float Balance;      //参考卡片发行Model结构同名字段
    private String CarValidStartDate参考卡片发行Model结构同名字段;      //
    private String CarValidEndDate;      //参考卡片发行Model结构同名字段
    //    private String CPH;      //参考卡片发行Model结构同名字段
    private String CarColor;      //参考卡片发行Model结构同名字段
    private String CarType;      //参考卡片发行Model结构同名字段
    private String CarPlace;      //参考卡片发行Model结构同名字段
    private String CarWithdrawCardDa参考卡片发行Model结构同名字段te;      //
    private String CarWithdrawOptCar参考卡片发行Model结构同名字段d;      //
    private String CarValidMachine;      //参考卡片发行Model结构同名字段
    private String CarValidZone;      //参考卡片发行Model结构同名字段
    private String CarMemo;      //参考卡片发行Model结构同名字段
    private String IssueDate;      //参考卡片发行Model结构同名字段
    private String WithdrawDate;      //参考卡片发行Model结构同名字段
    private String IssueUserCard;      //参考卡片发行Model结构同名字段
    private String WithdrawUserCard;      //参考卡片发行Model结构同名字段
    private String LossregDate;      //参考卡片发行Model结构同名字段
    private String LossregUserCard;      //参考卡片发行Model结构同名字段
    private String CardIDNO;      //参考卡片发行Model结构同名字段
    private int Tempnumber;      //参考卡片发行Model结构同名字段
    private String TimeTeam;      //参考卡片发行Model结构同名字段
    private String HolidayLimited;      //参考卡片发行Model结构同名字段
    private String UserInfo;      //参考卡片发行Model结构同名字段
    private String BackCardNum;      //参考卡片发行Model结构同名字段
    private String CardIdLossState;      //参考卡片发行Model结构同名字段
    private String CardIdUnLossState参考卡片发行Model结构同名字段;      //
    private String UnLossDate;      //参考卡片发行Model结构同名字段
    private String UnLossUer;      //参考卡片发行Model结构同名字段
    private String CarFailID;      //参考卡片发行Model结构同名字段
    private String CaRFailOKNO;      //参考卡片发行Model结构同名字段
    private String CardLossMachine;      //参考卡片发行Model结构同名字段
    private String DownLoadState;      //参考卡片发行Model结构同名字段
    private String DownloadSignal;      //参考卡片发行Model结构同名字段
    private String CPHDownloadSignal参考卡片发行Model结构同名字段;      //
    private String Res1;      //参考卡片发行Model结构同名字段
    private String Res2;      //参考卡片发行Model结构同名字段
    private int MonthType;      //参考卡片发行Model结构同名字段
    private String UserName;      //参考人员Model结构同名字段
    private String Sex;      //参考人员Model结构同名字段
    private int HomeAddress;      //参考人员Model结构同名字段
    private String DeptName;      //参考人员Model结构同名字段
    private String Job;      //参考人员Model结构同名字段
    private String WorkTime;      //参考人员Model结构同名字段
    private String BirthDate;      //参考人员Model结构同名字段
    private String IDCard;      //参考人员Model结构同名字段
    private String MaritalStatus;      //参考人员Model结构同名字段
    private String HighestDegree;      //参考人员Model结构同名字段
    private String PoliticalStatus;      //参考人员Model结构同名字段
    private String School;      //参考人员Model结构同名字段
    private String Speciality;      //参考人员Model结构同名字段
    private String ForeignLanguage;      //参考人员Model结构同名字段
    private String Skill;      //参考人员Model结构同名字段
    private String TelNumber;      //参考人员Model结构同名字段
    private String MobNumber;      //参考人员Model结构同名字段
    private String ZipCode;      //参考人员Model结构同名字段
    private String NativePlace;      //参考人员Model结构同名字段
    private int CarPlaceNo;      //参考人员Model结构同名字段

    public Long getID()
    {
        return ID;
    }

    public void setID(Long ID)
    {
        this.ID = ID;
    }

    public String getCardNO()
    {
        return CardNO;
    }

    public void setCardNO(String cardNO)
    {
        CardNO = cardNO;
    }

    public String getUserNO()
    {
        return UserNO;
    }

    public void setUserNO(String userNO)
    {
        UserNO = userNO;
    }

    public String getCPH()
    {
        return CPH;
    }

    public void setCPH(String CPH)
    {
        this.CPH = CPH;
    }

    public String getOptDate()
    {
        return OptDate;
    }

    public void setOptDate(String optDate)
    {
        OptDate = optDate;
    }

    public float getSFJE()
    {
        return SFJE;
    }

    public void setSFJE(float SFJE)
    {
        this.SFJE = SFJE;
    }

    public float getBalance()
    {
        return Balance;
    }

    public void setBalance(float balance)
    {
        Balance = balance;
    }

    public String getOperatorNO()
    {
        return OperatorNO;
    }

    public void setOperatorNO(String operatorNO)
    {
        OperatorNO = operatorNO;
    }

    public String getOptType()
    {
        return OptType;
    }

    public void setOptType(String optType)
    {
        OptType = optType;
    }

    public String getNewStartDate()
    {
        return NewStartDate;
    }

    public void setNewStartDate(String newStartDate)
    {
        NewStartDate = newStartDate;
    }

    public String getNewEndDate()
    {
        return NewEndDate;
    }

    public void setNewEndDate(String newEndDate)
    {
        NewEndDate = newEndDate;
    }

    public String getLastEndDate()
    {
        return LastEndDate;
    }

    public void setLastEndDate(String lastEndDate)
    {
        LastEndDate = lastEndDate;
    }

    public String getCardType()
    {
        return CardType;
    }

    public void setCardType(String cardType)
    {
        CardType = cardType;
    }

    public String getCarCardType()
    {
        return CarCardType;
    }

    public void setCarCardType(String carCardType)
    {
        CarCardType = carCardType;
    }

    public String getCardState()
    {
        return CardState;
    }

    public void setCardState(String cardState)
    {
        CardState = cardState;
    }

    public float getCardYJ()
    {
        return CardYJ;
    }

    public void setCardYJ(float cardYJ)
    {
        CardYJ = cardYJ;
    }

    public String getSubSystem()
    {
        return SubSystem;
    }

    public void setSubSystem(String subSystem)
    {
        SubSystem = subSystem;
    }

    public String getCarIssueDate()
    {
        return CarIssueDate;
    }

    public void setCarIssueDate(String carIssueDate)
    {
        CarIssueDate = carIssueDate;
    }

    public String getCarIssueUserCard()
    {
        return CarIssueUserCard;
    }

    public void setCarIssueUserCard(String carIssueUserCard)
    {
        CarIssueUserCard = carIssueUserCard;
    }

    public String getCarValidStartDate参考卡片发行Model结构同名字段()
    {
        return CarValidStartDate参考卡片发行Model结构同名字段;
    }

    public void setCarValidStartDate参考卡片发行Model结构同名字段(String carValidStartDate参考卡片发行Model结构同名字段)
    {
        CarValidStartDate参考卡片发行Model结构同名字段 = carValidStartDate参考卡片发行Model结构同名字段;
    }

    public String getCarValidEndDate()
    {
        return CarValidEndDate;
    }

    public void setCarValidEndDate(String carValidEndDate)
    {
        CarValidEndDate = carValidEndDate;
    }

    public String getCarColor()
    {
        return CarColor;
    }

    public void setCarColor(String carColor)
    {
        CarColor = carColor;
    }

    public String getCarType()
    {
        return CarType;
    }

    public void setCarType(String carType)
    {
        CarType = carType;
    }

    public String getCarPlace()
    {
        return CarPlace;
    }

    public void setCarPlace(String carPlace)
    {
        CarPlace = carPlace;
    }

    public String getCarWithdrawCardDa参考卡片发行Model结构同名字段te()
    {
        return CarWithdrawCardDa参考卡片发行Model结构同名字段te;
    }

    public void setCarWithdrawCardDa参考卡片发行Model结构同名字段te(String carWithdrawCardDa参考卡片发行Model结构同名字段te)
    {
        CarWithdrawCardDa参考卡片发行Model结构同名字段te = carWithdrawCardDa参考卡片发行Model结构同名字段te;
    }

    public String getCarWithdrawOptCar参考卡片发行Model结构同名字段d()
    {
        return CarWithdrawOptCar参考卡片发行Model结构同名字段d;
    }

    public void setCarWithdrawOptCar参考卡片发行Model结构同名字段d(String carWithdrawOptCar参考卡片发行Model结构同名字段d)
    {
        CarWithdrawOptCar参考卡片发行Model结构同名字段d = carWithdrawOptCar参考卡片发行Model结构同名字段d;
    }

    public String getCarValidMachine()
    {
        return CarValidMachine;
    }

    public void setCarValidMachine(String carValidMachine)
    {
        CarValidMachine = carValidMachine;
    }

    public String getCarValidZone()
    {
        return CarValidZone;
    }

    public void setCarValidZone(String carValidZone)
    {
        CarValidZone = carValidZone;
    }

    public String getCarMemo()
    {
        return CarMemo;
    }

    public void setCarMemo(String carMemo)
    {
        CarMemo = carMemo;
    }

    public String getIssueDate()
    {
        return IssueDate;
    }

    public void setIssueDate(String issueDate)
    {
        IssueDate = issueDate;
    }

    public String getWithdrawDate()
    {
        return WithdrawDate;
    }

    public void setWithdrawDate(String withdrawDate)
    {
        WithdrawDate = withdrawDate;
    }

    public String getIssueUserCard()
    {
        return IssueUserCard;
    }

    public void setIssueUserCard(String issueUserCard)
    {
        IssueUserCard = issueUserCard;
    }

    public String getWithdrawUserCard()
    {
        return WithdrawUserCard;
    }

    public void setWithdrawUserCard(String withdrawUserCard)
    {
        WithdrawUserCard = withdrawUserCard;
    }

    public String getLossregDate()
    {
        return LossregDate;
    }

    public void setLossregDate(String lossregDate)
    {
        LossregDate = lossregDate;
    }

    public String getLossregUserCard()
    {
        return LossregUserCard;
    }

    public void setLossregUserCard(String lossregUserCard)
    {
        LossregUserCard = lossregUserCard;
    }

    public String getCardIDNO()
    {
        return CardIDNO;
    }

    public void setCardIDNO(String cardIDNO)
    {
        CardIDNO = cardIDNO;
    }

    public int getTempnumber()
    {
        return Tempnumber;
    }

    public void setTempnumber(int tempnumber)
    {
        Tempnumber = tempnumber;
    }

    public String getTimeTeam()
    {
        return TimeTeam;
    }

    public void setTimeTeam(String timeTeam)
    {
        TimeTeam = timeTeam;
    }

    public String getHolidayLimited()
    {
        return HolidayLimited;
    }

    public void setHolidayLimited(String holidayLimited)
    {
        HolidayLimited = holidayLimited;
    }

    public String getUserInfo()
    {
        return UserInfo;
    }

    public void setUserInfo(String userInfo)
    {
        UserInfo = userInfo;
    }

    public String getBackCardNum()
    {
        return BackCardNum;
    }

    public void setBackCardNum(String backCardNum)
    {
        BackCardNum = backCardNum;
    }

    public String getCardIdLossState()
    {
        return CardIdLossState;
    }

    public void setCardIdLossState(String cardIdLossState)
    {
        CardIdLossState = cardIdLossState;
    }

    public String getCardIdUnLossState参考卡片发行Model结构同名字段()
    {
        return CardIdUnLossState参考卡片发行Model结构同名字段;
    }

    public void setCardIdUnLossState参考卡片发行Model结构同名字段(String cardIdUnLossState参考卡片发行Model结构同名字段)
    {
        CardIdUnLossState参考卡片发行Model结构同名字段 = cardIdUnLossState参考卡片发行Model结构同名字段;
    }

    public String getUnLossDate()
    {
        return UnLossDate;
    }

    public void setUnLossDate(String unLossDate)
    {
        UnLossDate = unLossDate;
    }

    public String getUnLossUer()
    {
        return UnLossUer;
    }

    public void setUnLossUer(String unLossUer)
    {
        UnLossUer = unLossUer;
    }

    public String getCarFailID()
    {
        return CarFailID;
    }

    public void setCarFailID(String carFailID)
    {
        CarFailID = carFailID;
    }

    public String getCaRFailOKNO()
    {
        return CaRFailOKNO;
    }

    public void setCaRFailOKNO(String caRFailOKNO)
    {
        CaRFailOKNO = caRFailOKNO;
    }

    public String getCardLossMachine()
    {
        return CardLossMachine;
    }

    public void setCardLossMachine(String cardLossMachine)
    {
        CardLossMachine = cardLossMachine;
    }

    public String getDownLoadState()
    {
        return DownLoadState;
    }

    public void setDownLoadState(String downLoadState)
    {
        DownLoadState = downLoadState;
    }

    public String getDownloadSignal()
    {
        return DownloadSignal;
    }

    public void setDownloadSignal(String downloadSignal)
    {
        DownloadSignal = downloadSignal;
    }

    public String getCPHDownloadSignal参考卡片发行Model结构同名字段()
    {
        return CPHDownloadSignal参考卡片发行Model结构同名字段;
    }

    public void setCPHDownloadSignal参考卡片发行Model结构同名字段(String CPHDownloadSignal参考卡片发行Model结构同名字段)
    {
        this.CPHDownloadSignal参考卡片发行Model结构同名字段 = CPHDownloadSignal参考卡片发行Model结构同名字段;
    }

    public String getRes1()
    {
        return Res1;
    }

    public void setRes1(String res1)
    {
        Res1 = res1;
    }

    public String getRes2()
    {
        return Res2;
    }

    public void setRes2(String res2)
    {
        Res2 = res2;
    }

    public int getMonthType()
    {
        return MonthType;
    }

    public void setMonthType(int monthType)
    {
        MonthType = monthType;
    }

    public String getUserName()
    {
        return UserName;
    }

    public void setUserName(String userName)
    {
        UserName = userName;
    }

    public String getSex()
    {
        return Sex;
    }

    public void setSex(String sex)
    {
        Sex = sex;
    }

    public int getHomeAddress()
    {
        return HomeAddress;
    }

    public void setHomeAddress(int homeAddress)
    {
        HomeAddress = homeAddress;
    }

    public String getDeptName()
    {
        return DeptName;
    }

    public void setDeptName(String deptName)
    {
        DeptName = deptName;
    }

    public String getJob()
    {
        return Job;
    }

    public void setJob(String job)
    {
        Job = job;
    }

    public String getWorkTime()
    {
        return WorkTime;
    }

    public void setWorkTime(String workTime)
    {
        WorkTime = workTime;
    }

    public String getBirthDate()
    {
        return BirthDate;
    }

    public void setBirthDate(String birthDate)
    {
        BirthDate = birthDate;
    }

    public String getIDCard()
    {
        return IDCard;
    }

    public void setIDCard(String IDCard)
    {
        this.IDCard = IDCard;
    }

    public String getMaritalStatus()
    {
        return MaritalStatus;
    }

    public void setMaritalStatus(String maritalStatus)
    {
        MaritalStatus = maritalStatus;
    }

    public String getHighestDegree()
    {
        return HighestDegree;
    }

    public void setHighestDegree(String highestDegree)
    {
        HighestDegree = highestDegree;
    }

    public String getPoliticalStatus()
    {
        return PoliticalStatus;
    }

    public void setPoliticalStatus(String politicalStatus)
    {
        PoliticalStatus = politicalStatus;
    }

    public String getSchool()
    {
        return School;
    }

    public void setSchool(String school)
    {
        School = school;
    }

    public String getSpeciality()
    {
        return Speciality;
    }

    public void setSpeciality(String speciality)
    {
        Speciality = speciality;
    }

    public String getForeignLanguage()
    {
        return ForeignLanguage;
    }

    public void setForeignLanguage(String foreignLanguage)
    {
        ForeignLanguage = foreignLanguage;
    }

    public String getSkill()
    {
        return Skill;
    }

    public void setSkill(String skill)
    {
        Skill = skill;
    }

    public String getTelNumber()
    {
        return TelNumber;
    }

    public void setTelNumber(String telNumber)
    {
        TelNumber = telNumber;
    }

    public String getMobNumber()
    {
        return MobNumber;
    }

    public void setMobNumber(String mobNumber)
    {
        MobNumber = mobNumber;
    }

    public String getZipCode()
    {
        return ZipCode;
    }

    public void setZipCode(String zipCode)
    {
        ZipCode = zipCode;
    }

    public String getNativePlace()
    {
        return NativePlace;
    }

    public void setNativePlace(String nativePlace)
    {
        NativePlace = nativePlace;
    }

    public int getCarPlaceNo()
    {
        return CarPlaceNo;
    }

    public void setCarPlaceNo(int carPlaceNo)
    {
        CarPlaceNo = carPlaceNo;
    }

    @Override
    public String toString()
    {
        return "EntityMoney{" +
                "ID=" + ID +
                ", CardNO='" + CardNO + '\'' +
                ", UserNO='" + UserNO + '\'' +
                ", CPH='" + CPH + '\'' +
                ", OptDate='" + OptDate + '\'' +
                ", SFJE=" + SFJE +
                ", Balance=" + Balance +
                ", OperatorNO='" + OperatorNO + '\'' +
                ", OptType='" + OptType + '\'' +
                ", NewStartDate='" + NewStartDate + '\'' +
                ", NewEndDate='" + NewEndDate + '\'' +
                ", LastEndDate='" + LastEndDate + '\'' +
                ", CardType='" + CardType + '\'' +
                ", CarCardType='" + CarCardType + '\'' +
                ", CardState='" + CardState + '\'' +
                ", CardYJ=" + CardYJ +
                ", SubSystem='" + SubSystem + '\'' +
                ", CarIssueDate='" + CarIssueDate + '\'' +
                ", CarIssueUserCard='" + CarIssueUserCard + '\'' +
                ", CarValidStartDate参考卡片发行Model结构同名字段='" + CarValidStartDate参考卡片发行Model结构同名字段 + '\'' +
                ", CarValidEndDate='" + CarValidEndDate + '\'' +
                ", CarColor='" + CarColor + '\'' +
                ", CarType='" + CarType + '\'' +
                ", CarPlace='" + CarPlace + '\'' +
                ", CarWithdrawCardDa参考卡片发行Model结构同名字段te='" + CarWithdrawCardDa参考卡片发行Model结构同名字段te + '\'' +
                ", CarWithdrawOptCar参考卡片发行Model结构同名字段d='" + CarWithdrawOptCar参考卡片发行Model结构同名字段d + '\'' +
                ", CarValidMachine='" + CarValidMachine + '\'' +
                ", CarValidZone='" + CarValidZone + '\'' +
                ", CarMemo='" + CarMemo + '\'' +
                ", IssueDate='" + IssueDate + '\'' +
                ", WithdrawDate='" + WithdrawDate + '\'' +
                ", IssueUserCard='" + IssueUserCard + '\'' +
                ", WithdrawUserCard='" + WithdrawUserCard + '\'' +
                ", LossregDate='" + LossregDate + '\'' +
                ", LossregUserCard='" + LossregUserCard + '\'' +
                ", CardIDNO='" + CardIDNO + '\'' +
                ", Tempnumber=" + Tempnumber +
                ", TimeTeam='" + TimeTeam + '\'' +
                ", HolidayLimited='" + HolidayLimited + '\'' +
                ", UserInfo='" + UserInfo + '\'' +
                ", BackCardNum='" + BackCardNum + '\'' +
                ", CardIdLossState='" + CardIdLossState + '\'' +
                ", CardIdUnLossState参考卡片发行Model结构同名字段='" + CardIdUnLossState参考卡片发行Model结构同名字段 + '\'' +
                ", UnLossDate='" + UnLossDate + '\'' +
                ", UnLossUer='" + UnLossUer + '\'' +
                ", CarFailID='" + CarFailID + '\'' +
                ", CaRFailOKNO='" + CaRFailOKNO + '\'' +
                ", CardLossMachine='" + CardLossMachine + '\'' +
                ", DownLoadState='" + DownLoadState + '\'' +
                ", DownloadSignal='" + DownloadSignal + '\'' +
                ", CPHDownloadSignal参考卡片发行Model结构同名字段='" + CPHDownloadSignal参考卡片发行Model结构同名字段 + '\'' +
                ", Res1='" + Res1 + '\'' +
                ", Res2='" + Res2 + '\'' +
                ", MonthType=" + MonthType +
                ", UserName='" + UserName + '\'' +
                ", Sex='" + Sex + '\'' +
                ", HomeAddress=" + HomeAddress +
                ", DeptName='" + DeptName + '\'' +
                ", Job='" + Job + '\'' +
                ", WorkTime='" + WorkTime + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", IDCard='" + IDCard + '\'' +
                ", MaritalStatus='" + MaritalStatus + '\'' +
                ", HighestDegree='" + HighestDegree + '\'' +
                ", PoliticalStatus='" + PoliticalStatus + '\'' +
                ", School='" + School + '\'' +
                ", Speciality='" + Speciality + '\'' +
                ", ForeignLanguage='" + ForeignLanguage + '\'' +
                ", Skill='" + Skill + '\'' +
                ", TelNumber='" + TelNumber + '\'' +
                ", MobNumber='" + MobNumber + '\'' +
                ", ZipCode='" + ZipCode + '\'' +
                ", NativePlace='" + NativePlace + '\'' +
                ", CarPlaceNo=" + CarPlaceNo +
                '}';
    }
}
