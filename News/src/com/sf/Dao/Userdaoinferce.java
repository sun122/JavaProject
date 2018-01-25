package com.sf.Dao;

import java.util.List;

import com.sf.bean.PageBean;
import com.sf.bean.Userbean;

public interface Userdaoinferce {
	public int addUser(String name,String password,String userClass); //�û�ע��
	public Userbean findUser(String name,String password);//�û���¼
	public int deleteUser(String name,String password);//�û�ɾ��
	public int updateUser(Userbean user); //�û����������޸�
	public PageBean findByUserClass(PageBean pagebean,String userClass); //ͨ���û�����ѯ�û��Ƿ�����ͨ�û����ǹ���Ա
	public PageBean findAllUser(PageBean pagebean); //��ѯ�����û�
	public int deleteUser(int id);//ɾ���û�
	public Userbean queryById(int id); //����id��������
	public boolean findAdm(String name,String password,String userclass); //���ҹ���Ա����ͨ�û�
	public List findByName(String name);//����������
	public int insertUser(Userbean userbean);//����û�
}
