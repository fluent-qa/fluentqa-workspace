package io.fluentqa.base.model;

import javax.persistence.MappedSuperclass;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.MetaModel;

@MappedSuperclass
/** Do not display Creator/Updater */
public class ModelWithValidFlag extends MetaModel {

  @EruptField(
      views = @View(title = "是否有效"),
      edit =
          @Edit(
              title = "是否有效",
              type = EditType.BOOLEAN,
              search = @Search,
              notNull = true,
              boolType = @BoolType))
  private final Boolean valid = true;
}
