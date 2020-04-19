package com.raven.cloud.uaa.service.user;

import com.raven.cloud.common.service.BaseService;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;
import java.util.Map;

public abstract class AbstractService<DAO extends Mapper<T>, T, I> implements BaseService<T, I> {

    protected final DAO dao;
    protected final Example example;

    protected AbstractService(DAO dao, Class<T> clazz) {
        this(dao, new Weekend<>(clazz));
    }

    protected AbstractService(DAO dao, Example example) {
        this.dao = dao;
        this.example = example;
    }

    protected Example getExample() {
        example.clear();
        return example;
    }

    @Override
    public int findCount() {
        return dao.selectCount(null);
    }

    @Override
    public T findById(I id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findPage(int currentPage, int pageSize) {
        return dao.selectByRowBounds(null, new RowBounds(((currentPage - 1) * pageSize), pageSize));
    }

    @Override
    public boolean add(T entity) {
        return dao.insertSelective(entity) == 1;
    }

    @Override
    public boolean modifyById(I id, T entity) {
        return dao.updateByPrimaryKeySelective(entity) == 1;
    }

    @Override
    public T save(T entity) {
//        Example example = getExample();
//        if (dao.selectOneByExample(example) == null) {
//            dao.insertSelective(entity);
//        } else {
//            dao.updateByExampleSelective(entity, example);
//        }
//        return dao.selectOneByExample(example);
        add(entity);
        return entity;
    }

    @Override
    public int findCountByField(String fieldName, Object fieldValue) {
        return dao.selectCountByExample(getEqualFieldExample(fieldName, fieldValue));
    }

    @Override
    public T findByField(String fieldName, Object fieldValue) {
        return dao.selectOneByExample(getEqualFieldExample(fieldName, fieldValue));
    }

    @Override
    public boolean modifyByField(T entity, String fieldName, Object fieldValue) {
        return dao.updateByExampleSelective(entity, getEqualFieldExample(fieldName, fieldValue)) == 1;
    }

    @Override
    public List<T> findPageByFieldLike(String fieldType, String fieldValue, int currentPage, int pageSize) {
        return dao.selectByExampleAndRowBounds(getLikeFieldExample(fieldType, fieldValue), new RowBounds(((currentPage - 1) * pageSize), pageSize));
    }

    private Example getEqualFieldExample(String fieldName, Object fieldValue) {
        Example example = getExample();
        example.createCriteria().andEqualTo(fieldName, fieldValue);
        return example;
    }

    private Example getLikeFieldExample(String fieldName, String fieldValue) {
        Example example = getExample();
        example.createCriteria().andLike(fieldName, fieldValue);
        return example;
    }

    /**
     * 根据[Entity] 所存在读字段进行 and 拼接
     */
    private Example getEqualEntityExample(Map<String, Object> entity) {
        Example example = getExample();
        if (entity == null) {
            return example;
        }
        for (Map.Entry<String, Object> entry : entity.entrySet()) {
            example.and().andEqualTo(entry.getKey(), entry.getValue());
        }
        return example;
    }

    /**
     * 根据[Entity] 所存在读字段进行 or 拼接
     */
    private Example getOrEntityExample(Map<String, Object> entity) {
        Example example = getExample();
        if (entity == null) {
            return example;
        }
        for (Map.Entry<String, Object> entry : entity.entrySet()) {
            example.or().andEqualTo(entry.getKey(), entry.getValue());
        }
        return example;
    }
}
