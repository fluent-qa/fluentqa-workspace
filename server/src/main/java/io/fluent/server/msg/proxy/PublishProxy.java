package io.fluent.server.msg.proxy;

import io.fluent.server.msg.model.PublishMsg;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.model.Row;
import xyz.erupt.annotation.query.Condition;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PublishProxy implements DataProxy<PublishMsg> {
    @Override
    public void beforeAdd(PublishMsg publishMsg) {
        DataProxy.super.beforeAdd(publishMsg);
    }

    @Override
    public void afterAdd(PublishMsg publishMsg) {
        DataProxy.super.afterAdd(publishMsg);
    }

    @Override
    public void beforeUpdate(PublishMsg publishMsg) {
        DataProxy.super.beforeUpdate(publishMsg);
    }

    @Override
    public void afterUpdate(PublishMsg publishMsg) {
        DataProxy.super.afterUpdate(publishMsg);
    }

    @Override
    public void beforeDelete(PublishMsg publishMsg) {
        DataProxy.super.beforeDelete(publishMsg);
    }

    @Override
    public void afterDelete(PublishMsg publishMsg) {
        DataProxy.super.afterDelete(publishMsg);
    }

    @Override
    public String beforeFetch(List<Condition> conditions) {
        return DataProxy.super.beforeFetch(conditions);
    }

    @Override
    public void afterFetch(Collection<Map<String, Object>> list) {
        DataProxy.super.afterFetch(list);
    }

    @Override
    public void addBehavior(PublishMsg publishMsg) {
        DataProxy.super.addBehavior(publishMsg);
    }

    @Override
    public void editBehavior(PublishMsg publishMsg) {
        DataProxy.super.editBehavior(publishMsg);
    }

    @Override
    public void searchCondition(Map<String, Object> condition) {
        DataProxy.super.searchCondition(condition);
    }

    @Override
    public void excelExport(Object workbook) {
        DataProxy.super.excelExport(workbook);
    }

    @Override
    public void excelImport(Object workbook) {
        DataProxy.super.excelImport(workbook);
    }

    @Override
    public List<Row> extraRow(List<Condition> conditions) {
        return DataProxy.super.extraRow(conditions);
    }
}
