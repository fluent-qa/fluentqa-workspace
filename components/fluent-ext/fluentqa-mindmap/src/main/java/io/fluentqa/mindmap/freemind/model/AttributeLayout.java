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
 *       &lt;attribute name="NAME_WIDTH" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="VALUE_WIDTH" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "attribute_layout")
public class AttributeLayout {

    @XmlAttribute(name = "NAME_WIDTH", required = true)
    protected BigInteger namewidth;
    @XmlAttribute(name = "VALUE_WIDTH")
    protected BigInteger valuewidth;

    /**
     * 获取namewidth属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getNAMEWIDTH() {
        return namewidth;
    }

    /**
     * 设置namewidth属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNAMEWIDTH(BigInteger value) {
        this.namewidth = value;
    }

    /**
     * 获取valuewidth属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVALUEWIDTH() {
        return valuewidth;
    }

    /**
     * 设置valuewidth属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVALUEWIDTH(BigInteger value) {
        this.valuewidth = value;
    }

}
