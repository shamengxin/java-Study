package com.bjpowernode.dao.impl;

import com.bjpowernode.bean.Book;
import com.bjpowernode.bean.PathConstant;
import com.bjpowernode.dao.BookDao;
import com.bjpowernode.util.BeanUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {

    /**
     * 查询
     * @param book
     * @return
     */
    @Override
    public List<Book> select(Book book) {
        ObjectInputStream ois=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.BOOK_PATH));
            //读取list对象
            List<Book> list = (List<Book>) ois.readObject();
            if(list!=null){
                if(book==null||"".equals(book.getBookName())&&"".equals(book.getIsbn())){
                    //查询全部数据的操作
                    return list;
                }else{
                    List<Book> conditionList = new ArrayList<>();

                    //根据编号查询
                    if(!(0==book.getId())){
                        conditionList=list.stream().filter(b->b.getId()==book.getId()).collect(Collectors.toList());
                        return conditionList;
                    }
                    //条件查询
                    //判断两个查询条件同时输入
                    if(!"".equals(book.getBookName())&&!"".equals(book.getIsbn())){
                        conditionList = list.stream().filter(b -> b.getBookName().equals(book.getBookName())).collect(Collectors.toList());
                        //基于第一个查询条件的基础上进行查询
                        conditionList = conditionList.stream().filter(b -> b.getIsbn().equals(book.getIsbn())).collect(Collectors.toList());
                    }else {
                        if (!"".equals(book.getBookName())) {
                            //根据图书名称查询
                            conditionList = list.stream().filter(b -> b.getBookName().equals(book.getBookName())).collect(Collectors.toList());

                        }
                        if (!"".equals(book.getIsbn())) {
                            conditionList = list.stream().filter(b -> b.getIsbn().equals(book.getIsbn())).collect(Collectors.toList());
                        }
                    }
                    return conditionList;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
     * 图书添加
     * @param book
     */
    @Override
    public void add(Book book) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.BOOK_PATH));
            List<Book> list =(List<Book>) ois.readObject();
            if(list!=null){
                //生成图书id
                Book lastBook = list.get(list.size() - 1);
                book.setId(lastBook.getId()+1);
                list.add(book);
                //将图书数据写出到硬盘上
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.BOOK_PATH));
                oos.writeObject(list);
                oos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("操作异常，请联系管理员。");
        }  finally {
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
     * 图书删除
     * @param id
     */
    @Override
    public void delete(int id) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.BOOK_PATH));
            List<Book> list = (List<Book>) ois.readObject();
            if(list!=null) {
                //从集合中查找要删除的图书
                Book book = list.stream().filter(b -> b.getId() == id).findFirst().get();
                list.remove(book);
                //将图书数据写出到硬盘中
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.BOOK_PATH));
                oos.writeObject(list);
                oos.flush();
            }
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
     * 图书修改
     * @param book
     */
    @Override
    public void update(Book book) {
        ObjectInputStream ois=null;
        ObjectOutputStream oos=null;
        try {
            ois = new ObjectInputStream(new FileInputStream(PathConstant.BOOK_PATH));
            List<Book> list = (List<Book>) ois.readObject();
            if(list!=null) {
                //从集合中查找要修改的图书
                Book originBook = list.stream().filter(b -> b.getId() == book.getId()).findFirst().get();
                BeanUtil.populate(originBook,book);
                //这样写太繁琐了，可以写一个工具类实现此功能
                /*originBook.setIsbn(book.getIsbn());
                originBook.setBookName(book.getBookName());
                originBook.setAuthor(book.getAuthor());
                originBook.setPublisher(book.getPublisher());
                originBook.setStatus(book.getStatus());
                originBook.setType(book.getType());*/
                //将图书数据写出到硬盘中
                oos = new ObjectOutputStream(new FileOutputStream(PathConstant.BOOK_PATH));
                oos.writeObject(list);
                oos.flush();
            }
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
}
