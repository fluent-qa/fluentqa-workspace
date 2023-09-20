package io.fluent.builtin;

import cn.hutool.core.util.XmlUtil;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathConstants;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

@Slf4j
public class XmlUtils extends XmlUtil {

  public static Document getDocument(String xmlFilePath) {
    return XmlUtil.readXML(xmlFilePath);
  }

  public static Object getValueByXpath(String xmlFilePath,
                                       String xpathExpr) {
    Document doc = getDocument(xmlFilePath);
    return XmlUtil.getByXPath(xpathExpr, doc, XPathConstants.STRING);
  }

  public static Object getValueByXpath(Document doc,
                                       String xpathExpr) {
    return XmlUtil.getByXPath(xpathExpr, doc, XPathConstants.STRING);
  }

  /**
   * JAXB Read Xml file
   *
   * @param xmlFilePath
   * @param clazz
   * @return
   */
  public static <T> T readXmlToObject(String xmlFilePath, Class<T> clazz) {

    try {
      JAXBContext context = JAXBContext.newInstance(clazz);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      return (T) unmarshaller.unmarshal(new BufferedInputStream(new FileInputStream(xmlFilePath)));
    } catch (Exception e) {
      log.error("parse xml failed,", e);
      throw new RuntimeException(e);
    }
  }

  public static <T> T readXmlToObject(Document doc, Class<T> clazz) {

    try {
      JAXBContext context = JAXBContext.newInstance(clazz);
      Unmarshaller unmarshaller = context.createUnmarshaller();
      return (T) unmarshaller.unmarshal(doc);
    } catch (Exception e) {
      log.error("parse xml failed,", e);
      throw new RuntimeException(e);
    }
  }
}
