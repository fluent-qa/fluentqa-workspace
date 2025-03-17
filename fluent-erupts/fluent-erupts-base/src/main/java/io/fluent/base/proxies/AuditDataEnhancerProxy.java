package io.fluent.base.proxies;

import java.time.LocalDateTime;
import org.springframework.stereotype.Component;
import xyz.erupt.jpa.model.MetaDataProxy;
import xyz.erupt.jpa.model.MetaModel;

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
