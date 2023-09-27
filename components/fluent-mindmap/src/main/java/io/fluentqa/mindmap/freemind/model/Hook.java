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
 *       &lt;sequence>
 *         &lt;element ref="{}Parameters" minOccurs="0"/>
 *         &lt;element ref="{}text" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="NAME" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "parameters",
    "text"
})
@XmlRootElement(name = "hook")
public class Hook {

    @XmlElement(name = "Parameters")
    protected Parameters parameters;
    protected Text text;
    @XmlAttribute(name = "NAME", required = true)
    protected String name;

    /**
     * 获取parameters属性的值。
     *
     * @return
     *     possible object is
     *     {@link Parameters }
     *
     */
    public Parameters getParameters() {
        return parameters;
    }

    /**
     * 设置parameters属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Parameters }
     *
     */
    public void setParameters(Parameters value) {
        this.parameters = value;
    }

    /**
     * 获取text属性的值。
     *
     * @return
     *     possible object is
     *     {@link Text }
     *
     */
    public Text getText() {
        return text;
    }

    /**
     * 设置text属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link Text }
     *
     */
    public void setText(Text value) {
        this.text = value;
    }

    /**
     * 获取name属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNAME() {
        return name;
    }

    /**
     * 设置name属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNAME(String value) {
        this.name = value;
    }

}
