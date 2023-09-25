package io.fluentqa.erupts.base.model;


import lombok.Data;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;


@MappedSuperclass
@Data
public class NamedTimeStatusModel extends ModelWithValidFlagVo {
    @EruptField(
            views = @View(
                    title = "名称"
            ),
            edit = @Edit(
                    title = "名称",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String name;
    @EruptField(
            views = @View(
                    title = "详细"
            ),
            edit = @Edit(
                    title = "详细",
                    type = EditType.INPUT, search = @Search, notNull = true
            )
    )
    private String detail;
    @EruptField(
            views = @View(
                    title = "开始时间"
            ),
            edit = @Edit(
                    title = "开始时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private LocalDate startDate;
    @EruptField(
            views = @View(
                    title = "预计完成时间"
            ),
            edit = @Edit(
                    title = "预计完成时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private LocalDate estimatedCompletedDate;
    @EruptField(
            views = @View(
                    title = "完成时间"
            ),
            edit = @Edit(
                    title = "完成时间",
                    type = EditType.DATE, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private LocalDate completedDate;
    @EruptField(
            views = @View(
                    title = "当前状态"
            ),
            edit = @Edit(
                    title = "当前状态",
                    type = EditType.INPUT, search = @Search, notNull = true,
                    boolType = @BoolType
            )
    )
    private String status;
}
