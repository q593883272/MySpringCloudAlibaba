package com.raven.cloud.common.service;

import java.util.List;

/**
 * 包含基本的增删改查的Service
 */
public interface CrudService<T, I> {


    ///////////////////////////////////////////////////////////////////////////
    // Read
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 获取总条目数
     */
    int findCount();

    /**
     * 根据[id]获取[T]
     */
    T findById(I id);

    /**
     * 分页查询((currentPage - 1) * pageSize)
     */
    List<T> findPage(int currentPage, int pageSize);


    ///////////////////////////////////////////////////////////////////////////
    // Write
    ///////////////////////////////////////////////////////////////////////////

    /**
     * 添加[T]
     */
    boolean add(T entity);

    /**
     * 根据[id]修改[T]
     */
    boolean modifyById(I id, T entity);

    /**
     * 保存[T](会根据id或其他字段判断, 存在会覆盖, 不存在即插入)
     */
    T save(T entity);
}
