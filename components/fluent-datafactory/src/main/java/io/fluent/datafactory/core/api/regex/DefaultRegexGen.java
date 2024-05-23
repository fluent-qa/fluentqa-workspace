package io.fluent.datafactory.core.api.regex;

import com.mifmif.common.regex.Generex;
import io.fluent.datafactory.api.core.IRegexGen;

/**
 * 默认的 regex 生成方式
 *
 * @author binbin.hou
 * @date 2019/3/12
 * @since 0.0.3
 */
public class DefaultRegexGen implements IRegexGen {

  @Override
  public String generate(String regex) {
    Generex generex = new Generex(regex);
    return generex.random();
  }
}
