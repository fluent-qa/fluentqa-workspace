package io.fluent.qtm.upload.model;

import io.fluent.base.product.model.ProductModuleModel;
import io.fluent.qtm.upload.proxy.UploadFileDataProxy;
import lombok.Data;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.PreDataProxy;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.AttachmentType;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.InputType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.toolkit.handler.SqlChoiceFetchHandler;

import javax.persistence.Entity;
import javax.persistence.Table;

@Erupt(name = "测试相关文件上传同步", orderBy = "UploadFileModel.createTime desc")
@Table(name = "uploaded_files")
@Entity
@Data
@PreDataProxy(value = UploadFileDataProxy.class)
public class UploadFileModel extends ProductModuleModel {

    @EruptField(
            views = @View(title = "用途"),
            edit = @Edit(
                    search = @Search,
                    title = "获取可选类型",
                    type = EditType.CHOICE,
                    desc = "动态获取可选类型",
                    notNull = true,
                    choiceType = @ChoiceType(
                            fetchHandler = SqlChoiceFetchHandler.class,
                            fetchHandlerParams = "select distinct code,name from master_data where category='UPLOAD_FILE_USAGE' and valid=true"
                    ))
    )
    private String usage;


    @EruptField(
            views = @View(title = "文件上传"),
            edit = @Edit(title = "文件上传", type = EditType.ATTACHMENT,
                    attachmentType = @AttachmentType(size = 100000))
    )
    private String attachment;

    @EruptField(
            views = @View(
                    title = "用途描述"
            ),
            edit = @Edit(
                    title = "用途描述",
                    type = EditType.TEXTAREA, notNull = true,
                    inputType = @InputType
            )
    )
    private String comments;
}