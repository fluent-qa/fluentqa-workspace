package io.fluentqa.generator.model;

import io.fluent.base.model.NamedModelVO;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.CodeEditorType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.toolkit.handler.SqlChoiceFetchHandler;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Erupt(name = "数据SQL配置管理")
@Table(name = "sql_configurations")
@Entity
@Data
@Where(clause = "valid=true")
@DynamicUpdate
@DynamicInsert
public class SqlConfigEntity extends NamedModelVO {
    @EruptField(
            views = @View(
                    title = "数据代号"
            ),
            edit = @Edit(
                    title = "数据代号",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    inputType = @InputType
            )
    )
    private String code;

    @EruptField(
            views = @View(
                    title = "获取数据SQL"
            ),
            edit = @Edit(
                    title = "获取数据SQL",
                    type = EditType.CODE_EDITOR, notNull = true,
                    codeEditType = @CodeEditorType(language = "sql")
            )
    )
    @org.hibernate.annotations.Type(type = "org.hibernate.type.TextType")
    private @Lob String sqlConfig;

    @EruptField(
            views = @View(
                    title = "SQL参数配置"
            ),
            edit = @Edit(
                    title = "SQL参数配置",
                    type = EditType.CODE_EDITOR,
                    codeEditType = @CodeEditorType(language = "json")
            )
    )
    @org.hibernate.annotations.Type(type = "org.hibernate.type.TextType")
    private @Lob String sqlParameters;

    @EruptField(
            views = @View(title = "数据源", column = "name"),
            edit = @Edit(
                    search = @Search,
                    title = "数据源选择",
                    type = EditType.CHOICE,
                    desc = "数据源选择",
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            fetchHandlerParams = {"select id,name from data_sources where valid=true"}
                    ))
    )
    private String dataSourceName;
}
