package io.fluentqa.md.parsers;

import cn.hutool.json.JSONUtil;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.BulletListItem;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import io.fluent.builtin.JavaProjectFileUtils;
import io.fluentqa.md.parser.awesome.AwesomeModel;
import io.fluentqa.md.parser.awesome.MarkdownAwesomeListParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class MarkdownAwesomeListParserTest {
    MarkdownAwesomeListParser parser = new MarkdownAwesomeListParser();
    private Node parseMarkdownDoc(String fileName){
        String filePath = JavaProjectFileUtils.getFilePath(fileName);
        String mdStr = JavaProjectFileUtils.readString(new File(filePath), Charset.defaultCharset());
        Parser parser = Parser.builder().build();
        return parser.parse(mdStr);
    }

    private String renderToHtml(Node doc){
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(doc);
    }
    @Test
    void testTransformByMarkdownNodes() {
       Node document = parseMarkdownDoc("low-code-1.md");
        if(document.getFirstChild()==null) return;
        Node nextNode = document.getFirstChild().getNext();
        while(nextNode!=null){
            if(nextNode instanceof Heading){
                if(((Heading) nextNode).getLevel()==3){
                    System.out.println(((Heading) nextNode).getText());
                }
            }
            if(nextNode instanceof BulletList){
                System.out.println(nextNode.getChars());
            }
            if(nextNode instanceof BulletListItem){
                System.out.println(nextNode.getChars());
            }
            nextNode = nextNode.getNext();
        }
        System.out.println(document);
    }
    //next sibling element: list
    @Test
    public void testTransformByXmlPath(){
        Node document = parseMarkdownDoc("low-code-1.md");
        String htmlStr = renderToHtml(document);
        JavaProjectFileUtils.writeToFile("low-code.html",htmlStr);
        Document htmlDocs = Jsoup.parse(htmlStr);
        List<Element> elementList= htmlDocs.select("ul>li");
        for (Element element : elementList) {
            System.out.println("category:"+element.parent().previousSibling().previousSibling().childNode(0).toString());
            System.out.println("url:"+element.selectFirst("a").attr("href"));
            System.out.println("name:"+element.selectFirst("a").text());
            System.out.println("desc:"+element.text());
        }
    }
  @Test
  public void testToHtml(){
    Node document = parseMarkdownDoc("test-resources.md");
    String htmlStr = renderToHtml(document);
      JavaProjectFileUtils.writeToFile("test-resources.html",htmlStr);
  }

//    @Test
    public void testTransform(){
        for (int i = 3; i < 7 ; i++) {
            List<AwesomeModel> repos = parser.transform("low-code-%d.md".formatted(i));
            System.out.println(repos);
            JavaProjectFileUtils.writeToFile("low-code-%d.json".formatted(i),JSONUtil.toJsonPrettyStr(repos));
        }

    }
}