package io.fluentqa.base.proxies;

import io.fluent.builtin.StringUtils;
import org.springframework.stereotype.Component;
import xyz.erupt.core.context.MetaContext;
import xyz.erupt.jpa.model.MetaDataProxy;
import xyz.erupt.jpa.model.MetaModel;

import java.time.LocalDateTime;

@Component
public class AuditDataEnhancerProxy extends MetaDataProxy {

  public void enhanceTimeAndUserAuditData(MetaModel metaModel, String userName) {
    if (metaModel.getCreateTime() == null) {
      metaModel.setCreateTime(LocalDateTime.now());
    }
    metaModel.setUpdateBy(userName);
    if (metaModel.getCreateBy() != null) metaModel.setCreateBy(userName);
    metaModel.setUpdateTime(LocalDateTime.now());
  }
}
