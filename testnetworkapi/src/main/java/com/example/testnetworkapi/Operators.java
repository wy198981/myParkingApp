package com.example.testnetworkapi;

/**
 * Created by Administrator on 2017-02-17.
 * 表示操作员，其人员姓名在登录界面会使用到；
 */
public class Operators
{
    public Operators()
    {

    }

    /**
     * 1), ID (疑问，大致有哪些用途?)
     */
    private int _id;

    /**
     * 2), 卡号
     */
    private String _cardno;

    /**
     * 3), 卡类
     */
    private String _cardtype;

    /**
     * 4)，人员编号
     */
    private String _userno;

    /**
     * 5)，人员姓名
     */
    private String _username;

    /**
     * 6),部门
     */
    private String _deptname;

    /**
     *  7),密码
     */
    private String _pwd;

    /**
     * 8), 卡状态
     */
    private int _cardstate;

    /**
     * 9), 权限组
     */
    private int _userlevel;

    public int get_id()
    {
        return _id;
    }

    public void set_id(int _id)
    {
        this._id = _id;
    }

    public String get_cardno()
    {
        return _cardno;
    }

    public void set_cardno(String _cardno)
    {
        this._cardno = _cardno;
    }

    public String get_cardtype()
    {
        return _cardtype;
    }

    public void set_cardtype(String _cardtype)
    {
        this._cardtype = _cardtype;
    }

    public String get_userno()
    {
        return _userno;
    }

    public void set_userno(String _userno)
    {
        this._userno = _userno;
    }

    public String get_username()
    {
        return _username;
    }

    public void set_username(String _username)
    {
        this._username = _username;
    }

    public String get_deptname()
    {
        return _deptname;
    }

    public void set_deptname(String _deptname)
    {
        this._deptname = _deptname;
    }

    public String get_pwd()
    {
        return _pwd;
    }

    public void set_pwd(String _pwd)
    {
        this._pwd = _pwd;
    }

    public int get_cardstate()
    {
        return _cardstate;
    }

    public void set_cardstate(int _cardstate)
    {
        this._cardstate = _cardstate;
    }

    public int get_userlevel()
    {
        return _userlevel;
    }

    public void set_userlevel(int _userlevel)
    {
        this._userlevel = _userlevel;
    }

    @Override
    public String toString()
    {
        return "Operators{" +
                "_id=" + _id +
                ", _cardno='" + _cardno + '\'' +
                ", _cardtype='" + _cardtype + '\'' +
                ", _userno='" + _userno + '\'' +
                ", _username='" + _username + '\'' +
                ", _deptname='" + _deptname + '\'' +
                ", _pwd='" + _pwd + '\'' +
                ", _cardstate=" + _cardstate +
                ", _userlevel=" + _userlevel +
                '}';
    }
}
