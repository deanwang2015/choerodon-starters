package io.choerodon.mybatis.entity;

import tk.mybatis.mapper.MapperException;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedHashSet;
import java.util.Set;

public class UpdateExample extends Example {

    //查询字段
    protected Set<EntityColumn> updateColumns;

    public UpdateExample(Class<?> entityClass) {
        super(entityClass);
    }

    /**
     * 指定要查询的属性列 - 这里会自动映射到表字段
     *
     * @param properties
     * @return
     */
    public UpdateExample updateProperties(String... properties) {
        if (properties != null && properties.length > 0) {
            if (this.updateColumns == null) {
                this.updateColumns = new LinkedHashSet<>();
            }
            for (String property : properties) {
                if (propertyMap.containsKey(property)) {
                    this.updateColumns.add(propertyMap.get(property));
                } else {
                    throw new MapperException("类 " + entityClass.getSimpleName() + " 不包含属性 \'" + property + "\'，或该属性被@Transient注释！");
                }
            }
        }
        return this;
    }

    @Override
    public Example excludeProperties(String... properties) {
        throw new IllegalArgumentException("UpdateExample not supported this method");
    }

    @Override
    public Example selectProperties(String... properties) {
        throw new IllegalArgumentException("UpdateExample not supported this method");
    }

    @Override
    public Criteria createCriteria() {
        throw new IllegalArgumentException("UpdateExample not supported this method");
    }

    public Set<EntityColumn> getUpdateColumns() {
        return updateColumns;
    }

}
