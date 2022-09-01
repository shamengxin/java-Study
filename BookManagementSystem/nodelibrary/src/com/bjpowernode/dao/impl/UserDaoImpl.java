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
 * 用户Dao层
 */
public class UserDaoImpl implements UserDao {

    /**
     * 从硬盘文件中读取数据
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

        //如上面出现异常，则返回一个List对象
        return new ArrayList<>();
    }

    /**
     * 条件查询
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
     * 添加操作
     * @param user
     */
    @Override
    public void add(User user) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            //读取文件中List对象
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>)ois.readObject();
            if(list!=null){
                //获取list中最后的User对象
                User lastUser=list.get(list.size()-1);
                //生成用户编号
                user.setId(lastUser.getId()+1);

                //将User对象放入到List当中，然后将list写出到文件中
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
            //这个异常是抛给控制器的，让控制器知道这里的代码出现了问题，
            //而不是让这里的代码对问题的出现自行捕捉。
            throw new RuntimeException("操作异常，请联系管理员。");
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
     * 用户修改
     * @param user
     */
    @Override
    public void update(User user) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            //将list数据从文件中查出来
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>) ois.readObject();
            if(list!=null){
                //从list中查找要修改的数据
                User originUser=list.stream().filter(u->u.getId()==user.getId()).findFirst().get();
                //修改数据
                BeanUtil.populate(originUser,user);

                //将数据持久化到文件中
                oos=new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
                oos.writeObject(list);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //这个异常是抛给控制器的，让控制器知道这里的代码出现了问题，
            //而不是让这里的代码对问题的出现自行捕捉。
            throw new RuntimeException("操作异常，请联系管理员。");
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
     *用户删除
     * @param id
     */
    @Override
    public void delete(int id) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            //读取数据
            ois=new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH));
            List<User> list=(List<User>)ois.readObject();
            //利用stream流来查找
            User user = list.stream().filter(u -> u.getId() == id).findFirst().get();
            //从list中将该user删除
            list.remove(user);

            //将list写出到文件中
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            //这个异常是抛给控制器的，让控制器知道这里的代码出现了问题，
            //而不是让这里的代码对问题的出现自行捕捉。
            throw new RuntimeException("操作异常，请联系管理员。");
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
     * 冻结
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
            //将状态修改为冻结
            user.setStatus(Constant.USER_FROZEN);
            oos=new ObjectOutputStream(new FileOutputStream(PathConstant.USER_PATH));
            oos.writeObject(list);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作异常，请联系管理员。");
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
     * 查询出可以借书的用户
     * @return
     */
    @Override
    public List<User> selectUserToLend() {
        try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(PathConstant.USER_PATH))) {
            List<User> list = (List<User>)ois.readObject();
            if(list!=null){
                //查询出用户状态是正常且isLend是false的用户
                List<User> collect = list.stream().filter(u->Constant.USER_OK.equals(u.getStatus())&&false==u.isLend()).collect(Collectors.toList());
                return collect;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
