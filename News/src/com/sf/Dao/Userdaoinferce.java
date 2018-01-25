package com.sf.Dao;

import java.util.List;

import com.sf.bean.PageBean;
import com.sf.bean.Userbean;

public interface Userdaoinferce {
	public int addUser(String name,String password,String userClass); //用户注册
	public Userbean findUser(String name,String password);//用户登录
	public int deleteUser(String name,String password);//用户删除
	public int updateUser(Userbean user); //用户名及密码修改
	public PageBean findByUserClass(PageBean pagebean,String userClass); //通过用户类别查询用户是否是普通用户还是管理员
	public PageBean findAllUser(PageBean pagebean); //查询所用用户
	public int deleteUser(int id);//删除用户
	public Userbean queryById(int id); //根据id查找内容
	public boolean findAdm(String name,String password,String userclass); //查找管理员或普通用户
	public List findByName(String name);//按名字搜索
	public int insertUser(Userbean userbean);//添加用户
}
