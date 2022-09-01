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
     * ��ѯ
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
                    //��ѯ����
                    //�ж�������ѯ����ͬʱ����
                    if(!"".equals(lend.getBook().getBookName())&&!"".equals(lend.getBook().getIsbn())){
                        conditionList=list.stream().filter(l->l.getBook().getBookName().equals(lend.getBook().getBookName())).collect(Collectors.toList());
                        //���ڵ�һ����ѯ�����Ļ����Ͻ��в�ѯ
                        conditionList=conditionList.stream().filter(l->l.getBook().getIsbn().equals(lend.getBook().getIsbn())).collect(Collectors.toList());
                    }else{
                        if(!"".equals(lend.getBook().getBookName())){
                            //����ͼ�����Ʋ�ѯ
                            conditionList=list.stream().filter(l->l.getBook().getBookName().equals(lend.getBook().getBookName())).collect(Collectors.toList());
                        }
                        if (!"".equals(lend.getBook().getIsbn())){
                            //����Isbn���в�ѯ
                            conditionList=list.stream().filter(l->l.getBook().getIsbn().equals(lend.getBook().getIsbn())).collect(Collectors.toList());
                        }
                    }
                    return conditionList;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("�����쳣������ϵ����Ա��");
        }
        return new ArrayList<>();
    }

    /**
     * ��ӽ�������
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
            //�ϴ���Ӳ��
            oos = new ObjectOutputStream(new FileOutputStream(PathConstant.LEND_PATH));
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
     * ���ݵ�ɾ��
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
            throw new RuntimeException("ɾ���������ݳ�������");
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
     * ���ݸ���
     * @param lend
     */
    @Override
    public void update(Lend lend) {
        //��list���ݴ��ļ��в����
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.LEND_PATH));
            List<Lend> list =(List<Lend>)ois.readObject();
            if(list!=null){
                //��list�в���Ҫ�޸ĵ�����
                Lend originLend=list.stream().filter(u->u.getId().equals(lend.getId())).findFirst().get();
                //�޸�����
                BeanUtil.populate(originLend,lend);
                //�����ݳ־û����ļ���
                oos=new ObjectOutputStream(new FileOutputStream(PathConstant.LEND_PATH));
                oos.writeObject(list);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("������������ϵ����Ա��");
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
