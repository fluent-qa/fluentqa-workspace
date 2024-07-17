package io.fluentqa.generator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.EruptI18n;
import xyz.erupt.annotation.fun.ChoiceFetchHandler;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.annotation.fun.VLModel;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.ShowBy;
import xyz.erupt.core.exception.EruptWebApiRuntimeException;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@EruptI18n
@Erupt(name = "字段信息", dataProxy = GeneratorField.class)
@Table(name = "generator_field")
@Entity
@Getter
@Setter
public class GeneratorField extends BaseModel implements DataProxy<GeneratorField>, ChoiceFetchHandler {

    @EruptField(
            views = @View(title = "字段名"),
            edit = @Edit(title = "字段名", notNull = true,
                    desc = "驼峰命名法，字母以小写开头，其后每个单词首字母大写")
    )
    private String fieldName;

    @EruptField(
            views = @View(title = "显示名称"),
            edit = @Edit(title = "显示名称", notNull = true)
    )
    private String showName;

    @EruptField(
            views = @View(title = "显示顺序", sortable = true),
            edit = @Edit(title = "显示顺序", notNull = true)
    )
    private Integer sort;

    @EruptField(
            views = @View(title = "编辑类型"),
            edit = @Edit(title = "编辑类型",
                    notNull = true, type = EditType.CHOICE,
                    choiceType = @ChoiceType(type = ChoiceType.Type.RADIO, fetchHandler = GeneratorField.class))
    )
    private String type;

    @EruptField(
            views = @View(title = "关联实体类"),
            edit = @Edit(title = "关联实体类", showBy = @ShowBy(dependField = "type",
                    expr = "value == 'REFERENCE_TREE'||value == 'REFERENCE_TABLE'||value == 'CHECKBOX'||" +
                            "value == 'TAB_TREE'||value == 'TAB_TABLE_REFER'||value == 'TAB_TABLE_ADD'"))
    )
    private String linkClass;

    @EruptField(
            views = @View(title = "查询项"),
            edit = @Edit(title = "查询项", notNull = true)
    )
    private Boolean query = true;

    @EruptField(
            views = @View(title = "字段排序"),
            edit = @Edit(title = "字段排序", notNull = true)
    )
    private Boolean sortable = false;

    @EruptField(
            views = @View(title = "是否必填"),
            edit = @Edit(title = "是否必填", notNull = true)
    )
    private Boolean notNull = true;

    @EruptField(
            views = @View(title = "是否显示"),
            edit = @Edit(title = "是否显示", notNull = true)
    )
    private Boolean isShow = true;


    @Override
    public List<VLModel> fetch(String[] params) {
        List<VLModel> list = new ArrayList<>();
        for (GeneratorType value : GeneratorType.values()) {
            list.add(new VLModel(value.name(), value.getName()));
        }
        return list;
    }

    @SneakyThrows
    @Override
    public void beforeAdd(GeneratorField generatorField) {
        if (null != GeneratorType.class.getDeclaredField(generatorField.getType()).getAnnotation(Ref.class)) {
            if (StringUtils.isBlank(generatorField.getLinkClass())) {
                throw new EruptWebApiRuntimeException("关联实体类必填！");
            }
        }
    }

    @Override
    public void beforeUpdate(GeneratorField generatorField) {
        this.beforeAdd(generatorField);
    }
}
