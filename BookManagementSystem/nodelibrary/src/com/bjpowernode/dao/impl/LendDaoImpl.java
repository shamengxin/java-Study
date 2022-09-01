package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Lend;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.dao.LendDao;
import com.bjpowernode.util.BeanUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LendDaoImpl implements LendDao {
    /**
     * 查询
     * @param lend
     * @return
     */
    @Override
    public List<Lend> select(Lend lend) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PathConstant.LEND_PATH))){
            List<Lend> list =(List<Lend>) ois.readObject();
            if(list!=null){
                if(lend==null||" ".equals(lend.getId())){
                    return list;
                }else{
                    List<Lend> conditionList=new ArrayList<>();
                    //查询条件
                    //判断两个查询条件同时输入
                    if(!"".equals(lend.getBook().getBookName())&&!"".equals(lend.getBook().getIsbn())){
                        conditionList=list.stream().filter(l->l.getBook().getBookName().equals(lend.getBook().getBookName())).collect(Collectors.toList());
                        //基于第一个查询条件的基础上进行查询
                        conditionList=conditionList.stream().filter(l->l.getBook().getIsbn().equals(lend.getBook().getIsbn())).collect(Collectors.toList());
                    }else{
                        if(!"".equals(lend.getBook().getBookName())){
                            //根据图书名称查询
                            conditionList=list.stream().filter(l->l.getBook().getBookName().equals(lend.getBook().getBookName())).collect(Collectors.toList());
                        }
                        if (!"".equals(lend.getBook().getIsbn())){
                            //根据Isbn进行查询
                            conditionList=list.stream().filter(l->l.getBook().getIsbn().equals(lend.getBook().getIsbn())).collect(Collectors.toList());
                        }
                    }
                    return conditionList;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作异常，请联系管理员。");
        }
        return new ArrayList<>();
    }

    /**
     * 添加借阅数据
     * @param lend
     */
    @Override
    public void add(Lend lend) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.LEND_PATH));
            List<Lend> list =(List<Lend>) ois.readObject();
            list.add(lend);
            //上传到硬盘
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.LEND_PATH));
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
     * 数据的删除
     * @param id
     */
    @Override
    public void delete(String id) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.LEND_PATH));
            List<Lend> list = (List<Lend>) ois.readObject();
            if(list!=null){
                Lend originLend=list.stream().filter(r-> Objects.equals(id,r.getId())).findFirst().get();
                list.remove(originLend);
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.LEND_PATH));
                oos.writeObject(list);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除借阅数据出问题了");
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
     * 数据更新
     * @param lend
     */
    @Override
    public void update(Lend lend) {
        //将list数据从文件中查出来
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.LEND_PATH));
            List<Lend> list =(List<Lend>)ois.readObject();
            if(list!=null){
                //从list中查找要修改的数据
                Lend originLend=list.stream().filter(u->u.getId().equals(lend.getId())).findFirst().get();
                //修改数据
                BeanUtil.populate(originLend,lend);
                //将数据持久化到文件中
                oos=new ObjectOutputStream(new FileOutputStream(PathConstant.LEND_PATH));
                oos.writeObject(list);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作有误，请联系管理员。");
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
}
