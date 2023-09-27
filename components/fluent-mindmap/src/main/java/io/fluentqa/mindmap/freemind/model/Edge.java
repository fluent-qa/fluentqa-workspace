//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.09.23 时间 08:46:06 PM CST
//


package io.fluentqa.mindmap.freemind.model;

import jakarta.xml.bind.annotation.*;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="COLOR" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="STYLE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="WIDTH" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "edge")
public class Edge {

    @XmlAttribute(name = "COLOR")
    protected String color;
    @XmlAttribute(name = "STYLE")
    protected String style;
    @XmlAttribute(name = "WIDTH")
    protected String width;

    /**
     * 获取color属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCOLOR() {
        return color;
    }

    /**
     * 设置color属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCOLOR(String value) {
        this.color = value;
    }

    /**
     * 获取style属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSTYLE() {
        return style;
    }

    /**
     * 设置style属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSTYLE(String value) {
        this.style = value;
    }

    /**
     * 获取width属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getWIDTH() {
        return width;
    }

    /**
     * 设置width属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setWIDTH(String value) {
        this.width = value;
    }

}
