package com.raven.cloud.common.service;


import java.util.List;

/**
 * 特定字段查询
 */
public interface FieldService<T> {

    /**
     * 根据持有的信息[field]类型[F]获取总条目数
     */
    int findCountByField(String fieldName, Object fieldValue);

    /**
     * 根据持有的信息[field]类型[F]获取[T]
     */
    T findByField(String fieldName, Object fieldValue);

    /**
     * 根据持有的信息[field]修改[T]
     */
    boolean modifyByField(T entity, String fieldName, Object fieldValue);

    /**
     * 根据字段进行模块匹配后分页查询((currentPage - 1) * pageSize)
     */
    List<T> findPageByFieldLike(String fieldName, String fieldValue, int currentPage, int pageSize);
}
