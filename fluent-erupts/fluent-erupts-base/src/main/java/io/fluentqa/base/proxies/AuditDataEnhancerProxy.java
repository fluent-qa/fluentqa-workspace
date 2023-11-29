package io.fluentqa.base.proxies;

import io.fluent.builtin.StringUtils;
import org.springframework.stereotype.Component;
import xyz.erupt.core.context.MetaContext;
import xyz.erupt.jpa.model.MetaDataProxy;
import xyz.erupt.jpa.model.MetaModel;

import java.time.LocalDateTime;

@Component
public class AuditDataEnhancerProxy extends MetaDataProxy {

  public void enhanceTimeAndUserAuditData(MetaModel metaModel) {
    if (metaModel.getCreateTime()!=null){
      metaModel.setCreateTime(LocalDateTime.now());
    }
    if(StringUtils.isAllEmpty(metaModel.getCreateBy())){
      metaModel.setCreateBy(MetaContext.getUser().getName());
    }
    metaModel.setUpdateTime(metaModel.getCreateTime());
    metaModel.setUpdateBy(metaModel.getCreateBy());
  }
}
