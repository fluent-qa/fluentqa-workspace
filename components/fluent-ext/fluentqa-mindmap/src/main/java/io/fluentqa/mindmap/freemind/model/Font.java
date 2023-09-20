//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.09.23 时间 08:46:06 PM CST
//


package io.fluentqa.mindmap.freemind.model;

import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="BOLD">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="true"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ITALIC">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="true"/>
 *             &lt;enumeration value="false"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="NAME" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SIZE" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "font")
public class Font {

    @XmlAttribute(name = "BOLD")
    protected String bold;
    @XmlAttribute(name = "ITALIC")
    protected String italic;
    @XmlAttribute(name = "NAME", required = true)
    protected String name;
    @XmlAttribute(name = "SIZE", required = true)
    protected BigInteger size;

    /**
     * 获取bold属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBOLD() {
        return bold;
    }

    /**
     * 设置bold属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBOLD(String value) {
        this.bold = value;
    }

    /**
     * 获取italic属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getITALIC() {
        return italic;
    }

    /**
     * 设置italic属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setITALIC(String value) {
        this.italic = value;
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

    /**
     * 获取size属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getSIZE() {
        return size;
    }

    /**
     * 设置size属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setSIZE(BigInteger value) {
        this.size = value;
    }

}
