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
 *       &lt;attribute name="REMINDUSERAT" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="ORIGINAL_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_MAP_LAT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_MAP_LON" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_MAP_TOOLTIP_LOCATION" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_POS_LAT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_POS_LON" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_TILE_SOURCE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="XML_STORAGE_ZOOM" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CLONE_ID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CLONE_IDS" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CLONE_ITSELF" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Parameters")
public class Parameters {

    @XmlAttribute(name = "REMINDUSERAT")
    protected BigInteger reminduserat;
    @XmlAttribute(name = "ORIGINAL_ID")
    protected String originalid;
    @XmlAttribute(name = "XML_STORAGE_MAP_LAT")
    protected String xmlstoragemaplat;
    @XmlAttribute(name = "XML_STORAGE_MAP_LON")
    protected String xmlstoragemaplon;
    @XmlAttribute(name = "XML_STORAGE_MAP_TOOLTIP_LOCATION")
    protected String xmlstoragemaptooltiplocation;
    @XmlAttribute(name = "XML_STORAGE_POS_LAT")
    protected String xmlstorageposlat;
    @XmlAttribute(name = "XML_STORAGE_POS_LON")
    protected String xmlstorageposlon;
    @XmlAttribute(name = "XML_STORAGE_TILE_SOURCE")
    protected String xmlstoragetilesource;
    @XmlAttribute(name = "XML_STORAGE_ZOOM")
    protected String xmlstoragezoom;
    @XmlAttribute(name = "CLONE_ID")
    protected String cloneid;
    @XmlAttribute(name = "CLONE_IDS")
    protected String cloneids;
    @XmlAttribute(name = "CLONE_ITSELF")
    protected String cloneitself;

    /**
     * 获取reminduserat属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getREMINDUSERAT() {
        return reminduserat;
    }

    /**
     * 设置reminduserat属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setREMINDUSERAT(BigInteger value) {
        this.reminduserat = value;
    }

    /**
     * 获取originalid属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getORIGINALID() {
        return originalid;
    }

    /**
     * 设置originalid属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setORIGINALID(String value) {
        this.originalid = value;
    }

    /**
     * 获取xmlstoragemaplat属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGEMAPLAT() {
        return xmlstoragemaplat;
    }

    /**
     * 设置xmlstoragemaplat属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGEMAPLAT(String value) {
        this.xmlstoragemaplat = value;
    }

    /**
     * 获取xmlstoragemaplon属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGEMAPLON() {
        return xmlstoragemaplon;
    }

    /**
     * 设置xmlstoragemaplon属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGEMAPLON(String value) {
        this.xmlstoragemaplon = value;
    }

    /**
     * 获取xmlstoragemaptooltiplocation属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGEMAPTOOLTIPLOCATION() {
        return xmlstoragemaptooltiplocation;
    }

    /**
     * 设置xmlstoragemaptooltiplocation属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGEMAPTOOLTIPLOCATION(String value) {
        this.xmlstoragemaptooltiplocation = value;
    }

    /**
     * 获取xmlstorageposlat属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGEPOSLAT() {
        return xmlstorageposlat;
    }

    /**
     * 设置xmlstorageposlat属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGEPOSLAT(String value) {
        this.xmlstorageposlat = value;
    }

    /**
     * 获取xmlstorageposlon属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGEPOSLON() {
        return xmlstorageposlon;
    }

    /**
     * 设置xmlstorageposlon属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGEPOSLON(String value) {
        this.xmlstorageposlon = value;
    }

    /**
     * 获取xmlstoragetilesource属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGETILESOURCE() {
        return xmlstoragetilesource;
    }

    /**
     * 设置xmlstoragetilesource属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGETILESOURCE(String value) {
        this.xmlstoragetilesource = value;
    }

    /**
     * 获取xmlstoragezoom属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getXMLSTORAGEZOOM() {
        return xmlstoragezoom;
    }

    /**
     * 设置xmlstoragezoom属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setXMLSTORAGEZOOM(String value) {
        this.xmlstoragezoom = value;
    }

    /**
     * 获取cloneid属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCLONEID() {
        return cloneid;
    }

    /**
     * 设置cloneid属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCLONEID(String value) {
        this.cloneid = value;
    }

    /**
     * 获取cloneids属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCLONEIDS() {
        return cloneids;
    }

    /**
     * 设置cloneids属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCLONEIDS(String value) {
        this.cloneids = value;
    }

    /**
     * 获取cloneitself属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCLONEITSELF() {
        return cloneitself;
    }

    /**
     * 设置cloneitself属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCLONEITSELF(String value) {
        this.cloneitself = value;
    }

}
