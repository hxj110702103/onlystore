package com.han.onlystore.biz.mapper;

import com.han.onlystore.base.model.common.BaseCondition;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2017/2/18.
 */
public interface BaseMapper<T> {
    int create(T obj);

    List<T> findByForeignKey(Serializable pk);

    int update(T obj);

    int delete(T obj);

    T findById(Serializable id);

    T findOne(T obj);

    List<T> find(T obj);

    List<T> findAll();

    List searchList(BaseCondition conditions);

    int searchCount(BaseCondition conditions);

}
