package io.fluentqa.generator.handlers;

import cn.hutool.core.bean.BeanUtil;
import io.fluent.quickdao.QuickDao;
import io.fluent.quickdao.datasource.model.DataSourceSetting;
import io.fluent.quickdao.datasource.model.TableColumn;
import io.fluent.quickdao.datasource.model.TableInfoQueryFinder;
import io.fluentqa.generator.model.DataSourceModel;
import io.fluentqa.generator.model.DataSourceTableColumModel;
import io.fluentqa.generator.repo.DataSourceTableColumRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import xyz.erupt.annotation.fun.OperationHandler;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class DataSourceTableSyncHandler implements OperationHandler<DataSourceModel, Void> {

    @Resource
    private DataSourceTableColumRepo repo;

    @Override
    @Async
    public String exec(List<DataSourceModel> data, Void unused, String[] param) {
        for (DataSourceModel dataSourceModel : data) {
            DataSourceSetting setting = DataSourceSetting.builder().
                    url(dataSourceModel.getConnUrl())
                    .dbType(dataSourceModel.getDbType())
                    .username(dataSourceModel.getUserName()).password(dataSourceModel.getPassword())
                    .build();
            QuickDao dao = QuickDao.createDao(setting);
            TableInfoQueryFinder finder = new TableInfoQueryFinder();
            var tableInfoQuery = finder.find(setting.getDbType());
            tableInfoQuery.addQueryParameterValue("schema", dataSourceModel.getSchemaName());

            var results = dao.queryForObjects(tableInfoQuery.getTableInfoQuery(),
                    tableInfoQuery.getParameters(), TableColumn.class);
            for (TableColumn result : results) {
                DataSourceTableColumModel model = BeanUtil.copyProperties(result, DataSourceTableColumModel.class);
                model.setDs(dataSourceModel);
                model.setDataType(setting.getDbType());
                repo.save(model);
            }

        }
        return "SYNC SUCCESSFULLY";
    }
}
