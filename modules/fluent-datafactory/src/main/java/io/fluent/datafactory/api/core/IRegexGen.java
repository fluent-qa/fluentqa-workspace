package io.fluent.datafactory.api.core;

/**
 * 正则表达式生成
 *
 * <pre> Created: 2019/3/11 11:12 PM  </pre>
 *
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.3
 */
public interface IRegexGen {

  /**
   * 根据正则表达式生成随机的字符串 TODO:// 直接使用成熟框架，后期替换成为自己的实现。
   *
   * @param regex 正则表达式
   * @return 结果
   */
  String generate(final String regex);
}
