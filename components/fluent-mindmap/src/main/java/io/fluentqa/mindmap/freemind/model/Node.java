//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2022.09.23 时间 08:46:06 PM CST
//


package io.fluentqa.mindmap.freemind.model;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}arrowlink"/>
 *         &lt;element ref="{}attribute"/>
 *         &lt;element ref="{}attribute_layout"/>
 *         &lt;element ref="{}linktarget"/>
 *         &lt;element ref="{}cloud"/>
 *         &lt;element ref="{}edge"/>
 *         &lt;element ref="{}font"/>
 *         &lt;element ref="{}hook"/>
 *         &lt;element ref="{}icon"/>
 *         &lt;element ref="{}node"/>
 *         &lt;element ref="{}richcontent"/>
 *       &lt;/choice>
 *       &lt;attribute name="BACKGROUND_COLOR" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="COLOR" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FOLDED">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="true"/>
 *             &lt;enumeration value="false"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="LINK" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="POSITION">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="left"/>
 *             &lt;enumeration value="right"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="STYLE" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TEXT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="CREATED" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="MODIFIED" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="HGAP" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="VGAP" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="VSHIFT" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="ENCRYPTED_CONTENT" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "arrowlinkOrAttributeOrAttributeLayout"
})
@XmlRootElement(name = "node")
public class Node {

    @XmlElements({
        @XmlElement(name = "arrowlink", type = Arrowlink.class),
        @XmlElement(name = "attribute", type = Attribute.class),
        @XmlElement(name = "attribute_layout", type = AttributeLayout.class),
        @XmlElement(name = "linktarget", type = Linktarget.class),
        @XmlElement(name = "cloud", type = Cloud.class),
        @XmlElement(name = "edge", type = Edge.class),
        @XmlElement(name = "font", type = Font.class),
        @XmlElement(name = "hook", type = Hook.class),
        @XmlElement(name = "icon", type = Icon.class),
        @XmlElement(name = "node", type = Node.class),
        @XmlElement(name = "richcontent", type = Richcontent.class)
    })
    protected List<Object> arrowlinkOrAttributeOrAttributeLayout;
    @XmlAttribute(name = "BACKGROUND_COLOR")
    protected String backgroundcolor;
    @XmlAttribute(name = "COLOR")
    protected String color;
    @XmlAttribute(name = "FOLDED")
    protected String folded;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "LINK")
    protected String link;
    @XmlAttribute(name = "POSITION")
    protected String position;
    @XmlAttribute(name = "STYLE")
    protected String style;
    @XmlAttribute(name = "TEXT")
    protected String text;
    @XmlAttribute(name = "CREATED")
    protected BigInteger created;
    @XmlAttribute(name = "MODIFIED")
    protected BigInteger modified;
    @XmlAttribute(name = "HGAP")
    protected BigInteger hgap;
    @XmlAttribute(name = "VGAP")
    protected BigInteger vgap;
    @XmlAttribute(name = "VSHIFT")
    protected BigInteger vshift;
    @XmlAttribute(name = "ENCRYPTED_CONTENT")
    protected String encryptedcontent;

    /**
     * Gets the value of the arrowlinkOrAttributeOrAttributeLayout property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrowlinkOrAttributeOrAttributeLayout property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrowlinkOrAttributeOrAttributeLayout().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Arrowlink }
     * {@link Attribute }
     * {@link AttributeLayout }
     * {@link Linktarget }
     * {@link Cloud }
     * {@link Edge }
     * {@link Font }
     * {@link Hook }
     * {@link Icon }
     * {@link Node }
     * {@link Richcontent }
     *
     *
     */
    public List<Object> getArrowlinkOrAttributeOrAttributeLayout() {
        if (arrowlinkOrAttributeOrAttributeLayout == null) {
            arrowlinkOrAttributeOrAttributeLayout = new ArrayList<Object>();
        }
        return this.arrowlinkOrAttributeOrAttributeLayout;
    }

    /**
     * 获取backgroundcolor属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBACKGROUNDCOLOR() {
        return backgroundcolor;
    }

    /**
     * 设置backgroundcolor属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBACKGROUNDCOLOR(String value) {
        this.backgroundcolor = value;
    }

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
     * 获取folded属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFOLDED() {
        return folded;
    }

    /**
     * 设置folded属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFOLDED(String value) {
        this.folded = value;
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
     * 获取link属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLINK() {
        return link;
    }

    /**
     * 设置link属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLINK(String value) {
        this.link = value;
    }

    /**
     * 获取position属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPOSITION() {
        return position;
    }

    /**
     * 设置position属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPOSITION(String value) {
        this.position = value;
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
     * 获取text属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTEXT() {
        return text;
    }

    /**
     * 设置text属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTEXT(String value) {
        this.text = value;
    }

    /**
     * 获取created属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getCREATED() {
        return created;
    }

    /**
     * 设置created属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setCREATED(BigInteger value) {
        this.created = value;
    }

    /**
     * 获取modified属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getMODIFIED() {
        return modified;
    }

    /**
     * 设置modified属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setMODIFIED(BigInteger value) {
        this.modified = value;
    }

    /**
     * 获取hgap属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getHGAP() {
        return hgap;
    }

    /**
     * 设置hgap属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setHGAP(BigInteger value) {
        this.hgap = value;
    }

    /**
     * 获取vgap属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVGAP() {
        return vgap;
    }

    /**
     * 设置vgap属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVGAP(BigInteger value) {
        this.vgap = value;
    }

    /**
     * 获取vshift属性的值。
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVSHIFT() {
        return vshift;
    }

    /**
     * 设置vshift属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVSHIFT(BigInteger value) {
        this.vshift = value;
    }

    /**
     * 获取encryptedcontent属性的值。
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getENCRYPTEDCONTENT() {
        return encryptedcontent;
    }

    /**
     * 设置encryptedcontent属性的值。
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setENCRYPTEDCONTENT(String value) {
        this.encryptedcontent = value;
    }

}
