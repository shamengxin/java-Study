package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Constant;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.bean.User;
import com.bjpowernode.dao.UserDao;
import com.bjpowernode.util.BeanUtil;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * �û�Dao��
 */
public class UserDaoImpl implements UserDao {

    /**
     * ��Ӳ���ļ��ж�ȡ����
     * @return
     */
    @Override
    public List<User> select() {
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))){
            List<User> list = (List<User>) ois.readObject();
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }

        //����������쳣���򷵻�һ��List����
        return new ArrayList<>();
    }

    /**
     * ������ѯ
     * @param user
     * @return
     */
    @Override
    public List<User> select(User user) {
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list = (List<User>) ois.readObject();
            if(list!=null){
                List<User> conditionList=new ArrayList<>();
                if(!(0==user.getId())){
                    conditionList=list.stream().filter(u->u.getId()==user.getId()).collect(Collectors.toList());
                    return conditionList;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return new ArrayList<>();
    }

    /**
     * ��Ӳ���
     * @param user
     */
    @Override
    public void add(User user) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            //��ȡ�ļ���List����
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>)ois.readObject();
            if(list!=null){
                //��ȡlist������User����
                User lastUser=list.get(list.size()-1);
                //�����û����
                user.setId(lastUser.getId()+1);

                //��User������뵽List���У�Ȼ��listд�����ļ���
                list.add(user);

            }else{
                list=new ArrayList<>();
                user.setId(1001);
                list.add(user);
            }

            oos=new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            //����쳣���׸��������ģ��ÿ�����֪������Ĵ�����������⣬
            //������������Ĵ��������ĳ������в�׽��
            throw new RuntimeException("�����쳣������ϵ����Ա��");
        } finally {
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * �û��޸�
     * @param user
     */
    @Override
    public void update(User user) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            //��list���ݴ��ļ��в����
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>) ois.readObject();
            if(list!=null){
                //��list�в���Ҫ�޸ĵ�����
                User originUser=list.stream().filter(u->u.getId()==user.getId()).findFirst().get();
                //�޸�����
                BeanUtil.populate(originUser,user);

                //�����ݳ־û����ļ���
                oos=new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
                oos.writeObject(list);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //����쳣���׸��������ģ��ÿ�����֪������Ĵ�����������⣬
            //������������Ĵ��������ĳ������в�׽��
            throw new RuntimeException("�����쳣������ϵ����Ա��");
        } finally {
            try {
                if(ois!=null) {
                    ois.close();
                }
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *�û�ɾ��
     * @param id
     */
    @Override
    public void delete(int id) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            //��ȡ����
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>)ois.readObject();
            //����stream��������
            User user = list.stream().filter(u -> u.getId() == id).findFirst().get();
            //��list�н���userɾ��
            list.remove(user);

            //��listд�����ļ���
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            //����쳣���׸��������ģ��ÿ�����֪������Ĵ�����������⣬
            //������������Ĵ��������ĳ������в�׽��
            throw new RuntimeException("�����쳣������ϵ����Ա��");
        } finally {

            try {
                if (ois != null) {
                    ois.close();
                }
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ����
     * @param id
     */
    @Override
    public void frozen(int id) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>)ois.readObject();
            User user = list.stream().filter(u -> u.getId() == id).findFirst().get();
            //��״̬�޸�Ϊ����
            user.setStatus(Constant.USER_FROZEN);
            oos=new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("�����쳣������ϵ����Ա��");
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if(oos!=null){
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * ��ѯ�����Խ�����û�
     * @return
     */
    @Override
    public List<User> selectUserToLend() {
        try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
            List<User> list = (List<User>)ois.readObject();
            if(list!=null){
                //��ѯ���û�״̬��������isLend��false���û�
                List<User> collect = list.stream().filter(u->Constant.USER_OK.equals(u.getStatus())&&false==u.isLend()).collect(Collectors.toList());
                return collect;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
