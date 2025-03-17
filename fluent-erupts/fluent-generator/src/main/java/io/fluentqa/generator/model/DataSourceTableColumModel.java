package io.fluentqa.generator.model;

import io.fluent.base.handlers.SqlTagFetchHandler;
import io.fluent.base.model.ModelWithValidFlag;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.LinkTree;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.ReferenceTreeType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.TagsType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Erupt(name = "数据源表数据",
        power = @Power(importable = true, export = true),
        linkTree = @LinkTree(field = "ds"))
@Table(name = "ds_tables")
@DynamicUpdate
@DynamicInsert
@Where(clause = "valid=true")
public class DataSourceTableColumModel extends ModelWithValidFlag {
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
    @ManyToOne
    @JoinColumn(name = "data_source_id")
    @EruptField(
            views = @View(title = "所属数据源", column = "name"),
            edit = @Edit(
                    notNull = true,
                    search = @Search,
                    title = "数据源选择",
                    type = EditType.REFERENCE_TREE,
                    desc = "动态数据源",
                    referenceTreeType = @ReferenceTreeType(id = "id", label = "name",
                            pid = "parent.id"))
    )
    private DataSourceModel ds;
    @EruptField(
            views = @View(
                    title = "字段名"
            ),
            edit = @Edit(
                    title = "字段名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String columnName;
    @EruptField(
            views = @View(
                    title = "表名"
            ),
            edit = @Edit(
                    title = "表名",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String tableName;
    @EruptField(
            views = @View(
                    title = "表备注说明"
            ),
            edit = @Edit(
                    title = "表备注说明",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String tableComment;
    private String dataType;

    @EruptField(
            views = @View(
                    title = "表类型"
            ),
            edit = @Edit(
                    title = "表类型",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String tableType;
    @EruptField(
            views = @View(
                    title = "是否主键"
            ),
            edit = @Edit(
                    title = "是否主键",
                    type = EditType.BOOLEAN,
                    inputType = @InputType
            )
    )
    private boolean isPk;
    @EruptField(
            views = @View(
                    title = "字段备注说明"
            ),
            edit = @Edit(
                    title = "字段备注说明",
                    type = EditType.INPUT,
                    inputType = @InputType
            )
    )
    private String  comments;

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public DataSourceModel getDs() {
        return ds;
    }

    public void setDs(DataSourceModel ds) {
        this.ds = ds;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public boolean isPk() {
        return isPk;
    }

    public void setPk(boolean pk) {
        isPk = pk;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
