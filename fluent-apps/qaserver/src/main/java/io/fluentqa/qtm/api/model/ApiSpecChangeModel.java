package io.fluentqa.qtm.api.model;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Layout;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "api_spec_change")
@Erupt(
        layout = @Layout(
                tableLeftFixed = 3,
                pageSize = 30),
        name = "api spec 变化记录", power = @Power(export = true)
)
@Data
public class ApiSpecChangeModel extends BaseModel {
    @EruptField(
            views = @View(title = "应用名-appName")
    )
    private String name;
    @EruptField(
            views = @View(title = "GIT URL")
    )
    private String gitUrl;
    @EruptField(
            views = @View(title = "GIT分支")
    )
    private String branch;

    @EruptField(
            views = @View(title = "创建时间")
    )
    private LocalDateTime createdTime;

    @EruptField(
            views = @View(title = "appVersion")
    )
    private String appVersion;

}
