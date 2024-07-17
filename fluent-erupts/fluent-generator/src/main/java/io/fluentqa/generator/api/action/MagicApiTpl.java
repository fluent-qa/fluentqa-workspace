package io.fluentqa.generator.api.action;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.ssssssss.magicapi.core.config.MagicAPIProperties;
import xyz.erupt.core.util.EruptInformation;
import xyz.erupt.tpl.annotation.EruptTpl;
import xyz.erupt.tpl.annotation.TplAction;
import xyz.erupt.upms.service.EruptContextService;

@EruptTpl
@Component
public class MagicApiTpl {

  public static final String MAGIC_API_PERMISSION = "magic-api.ftl";

  @Resource private MagicAPIProperties magicAPIProperties;

  @Resource private EruptContextService eruptContextService;

  @TplAction(MAGIC_API_PERMISSION)
  public Map<String, Object> magicApiAction() {
    Map<String, Object> map = new HashMap<>();
    map.put("web", magicAPIProperties.getWeb());
    map.put("token", eruptContextService.getCurrentToken());
    map.put("v", EruptInformation.getEruptVersion());
    map.put("hash", this.hashCode());
    return map;
  }
}
