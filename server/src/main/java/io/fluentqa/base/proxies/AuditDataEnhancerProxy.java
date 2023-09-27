package io.fluentqa.base.proxies;

import org.springframework.stereotype.Component;
import xyz.erupt.core.context.MetaContext;
import xyz.erupt.jpa.model.MetaDataProxy;
import xyz.erupt.jpa.model.MetaModel;

import java.time.LocalDateTime;

@Component
public class AuditDataEnhancerProxy extends MetaDataProxy {

  public void enhanceTimeAndUserAuditData(MetaModel metaModel) {
    metaModel.setCreateTime(LocalDateTime.now());
    metaModel.setCreateBy(MetaContext.getUser().getName());
    metaModel.setUpdateTime(metaModel.getCreateTime());
    metaModel.setUpdateBy(metaModel.getCreateBy());
  }
}
