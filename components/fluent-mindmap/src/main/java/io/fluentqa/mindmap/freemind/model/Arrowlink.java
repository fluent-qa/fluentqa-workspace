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
 *       &lt;attribute name="DESTINATION" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ENDARROW" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ENDINCLINATION" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="STARTARROW" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="STARTINCLINATION" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "arrowlink")
public class Arrowlink {

    @XmlAttribute(name = "COLOR")
    protected String color;
    @XmlAttribute(name = "DESTINATION", required = true)
    protected String destination;
    @XmlAttribute(name = "ENDARROW")
    protected String endarrow;
    @XmlAttribute(name = "ENDINCLINATION")
    protected String endinclination;
    @XmlAttribute(name = "ID")
    protected String id;
    @XmlAttribute(name = "STARTARROW")
    protected String startarrow;
    @XmlAttribute(name = "STARTINCLINATION")
    protected String startinclination;

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
     * 获取destination属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDESTINATION() {
        return destination;
    }

    /**
     * 设置destination属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDESTINATION(String value) {
        this.destination = value;
    }

    /**
     * 获取endarrow属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getENDARROW() {
        return endarrow;
    }

    /**
     * 设置endarrow属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setENDARROW(String value) {
        this.endarrow = value;
    }

    /**
     * 获取endinclination属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getENDINCLINATION() {
        return endinclination;
    }

    /**
     * 设置endinclination属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setENDINCLINATION(String value) {
        this.endinclination = value;
    }

    /**
     * 获取id属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getID() {
        return id;
    }

    /**
     * 设置id属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * 获取startarrow属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSTARTARROW() {
        return startarrow;
    }

    /**
     * 设置startarrow属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSTARTARROW(String value) {
        this.startarrow = value;
    }

    /**
     * 获取startinclination属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSTARTINCLINATION() {
        return startinclination;
    }

    /**
     * 设置startinclination属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSTARTINCLINATION(String value) {
        this.startinclination = value;
    }

}
