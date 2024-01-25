package io.fluentqa.generator.model;

import io.fluentqa.base.handlers.SqlTagFetchHandler;
import io.fluentqa.base.model.ModelWithValidFlagVo;
import io.fluentqa.generator.handlers.DataSourceTableSyncHandler;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_erupt.RowOperation;
import xyz.erupt.annotation.sub_erupt.Tree;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.*;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Erupt(name = "数据源配置",
        power = @Power(importable = true, export = true),
        rowOperation = {
            @RowOperation(
                    title = "同步表信息",
                    mode=RowOperation.Mode.MULTI,
                    operationHandler = DataSourceTableSyncHandler.class
            )
        })
@Table(name = "data_sources")
@DynamicUpdate
@DynamicInsert
@Where(clause = "valid=true")
public class DataSourceModel extends ModelWithValidFlagVo {
    @ManyToOne
    @EruptField(
            edit = @Edit(
                    title = "上级数据源",
                    type = EditType.REFERENCE_TREE,
                    referenceTreeType = @ReferenceTreeType(pid = "parent.id")
            )
    )
    private DataSourceModel parent;
    /**
     * 数据库类型
     */
    @EruptField(
            views = @View(title = "数据库类型"),
            edit = @Edit(
                    search = @Search(vague = true),
                    title = "数据库类型",
                    type = EditType.TAGS,
                    desc = "动态获取可选种类",
                    tagsType = @TagsType(
                            fetchHandler = SqlTagFetchHandler.class,
                            fetchHandlerParams = "select distinct db_type from data_sources where valid=true"
                    ))
    )
    private String dbType;
    /**
     * 连接名
     */
    @EruptField(
            views = @View(
                    title = "数据源名称"
            ),
            edit = @Edit(
                    title = "数据源名称",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String name;
    /**
     * URL
     */



    @EruptField(
            views = @View(
                    title = "schema名称"
            ),
            edit = @Edit(
                    title = "schema名称",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String schemaName;

    @EruptField(
            views = @View(
                    title = "数据源连接配置"
            ),
            edit = @Edit(
                    title = "数据源连接配置",
                    type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "json")
            )
    )
    @org.hibernate.annotations.Type(type = "org.hibernate.type.TextType")
    private @Lob String connectionConfig;

    @EruptField(
            views = @View(
                    title = "数据源名称连接"
            ),
            edit = @Edit(
                    title = "数据源名称连接",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String connUrl;
    /**
     * 用户名
     */
    @EruptField(
            views = @View(
                    title = "用户名"
            ),
            edit = @Edit(
                    title = "用户名",
                    type = EditType.INPUT, search = @Search,
                    inputType = @InputType
            )
    )
    private String userName;
    /**
     * 密码
     */
    @EruptField(
            views = @View(
                    title = "密码"
            ),
            edit = @Edit(
                    title = "密码",
                    type = EditType.INPUT,
                    inputType = @InputType(type = "password")
            )
    )
    private String password;

    @EruptField(
            views = @View(
                    title = "驱动类"
            ),
            edit = @Edit(
                    title = "驱动类",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String driverClass;


    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConnUrl() {
        return connUrl;
    }

    public void setConnUrl(String connUrl) {
        this.connUrl = connUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public DataSourceModel getParent() {
        return parent;
    }

    public void setParent(DataSourceModel parent) {
        this.parent = parent;
    }

    public String getConnectionConfig() {
        return connectionConfig;
    }

    public void setConnectionConfig(String connectionConfig) {
        this.connectionConfig = connectionConfig;
    }
}
