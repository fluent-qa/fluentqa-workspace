package io.fluentqa.md.parser.awesome;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import io.fluent.builtin.JavaProjectFileUtils;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class MarkdownAwesomeListParser {

  private Node parseMarkdownDoc(String mdFilePath) {
    String filePath = JavaProjectFileUtils.getFilePath(mdFilePath);
    String mdStr = JavaProjectFileUtils.readString(new File(filePath), Charset.defaultCharset());
    Parser parser = Parser.builder().build();
    return parser.parse(mdStr);
  }

  private String renderToHtml(Node doc) {
    HtmlRenderer renderer = HtmlRenderer.builder().build();
    return renderer.render(doc);
  }

  private String toHtml(String mdFilePath) {
    return renderToHtml(parseMarkdownDoc(mdFilePath));
  }

  public List<AwesomeModel> transform(String path) {
    String htmlStr = toHtml(path);
    Document htmlDocs = Jsoup.parse(htmlStr);
    List<Element> elementList = htmlDocs.select("ul>li");
    return elementList.stream()
        .map(
            element -> {
              AwesomeModel awesome = new AwesomeModel();
              awesome.setCategory(
                  element.parent().previousSibling().previousSibling().childNode(0).toString());
              awesome.setName(element.selectFirst("a").text());
              awesome.setDesc(element.text());
              awesome.setUrl(element.selectFirst("a").attr("href"));
              return awesome;
            })
        .collect(Collectors.toList());
  }
}
