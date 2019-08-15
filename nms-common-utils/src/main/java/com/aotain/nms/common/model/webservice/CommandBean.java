//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.07.26 ʱ�� 03:14:45 PM CST 
//


package com.aotain.nms.common.model.webservice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commandId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="ipList" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="time">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="effectTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="expiredTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "commandId",
    "type",
    "ipList",
    "time",
    "timeStamp"
})
@XmlRootElement(name = "command")
public class CommandBean {

    protected long commandId;
    @XmlElement(required = true)
    protected Integer type;
    @XmlElement(required = true)
    protected List<CommandBean.IpList> ipList;
    @XmlElement(required = true)
    protected CommandBean.Time time;
    @XmlElement(required = true)
    protected String timeStamp;

    /**
     * ��ȡcommandId���Ե�ֵ��
     * 
     */
    public long getCommandId() {
        return commandId;
    }

    /**
     * ����commandId���Ե�ֵ��
     * 
     */
    public void setCommandId(long value) {
        this.commandId = value;
    }

    /**
     * ��ȡtype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public Integer getType() {
        return type;
    }

    /**
     * ����type���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setType(Integer value) {
        this.type = value;
    }

    /**
     * Gets the value of the ipList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ipList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIpList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandBean.IpList }
     * 
     * 
     */
    public List<CommandBean.IpList> getIpList() {
        if (ipList == null) {
            ipList = new ArrayList<CommandBean.IpList>();
        }
        return this.ipList;
    }
    

    public void setIpList(List<CommandBean.IpList> ipList) {
		this.ipList = ipList;
	}

	/**
     * ��ȡtime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link CommandBean.Time }
     *     
     */
    public CommandBean.Time getTime() {
        return time;
    }

    /**
     * ����time���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link CommandBean.Time }
     *     
     */
    public void setTime(CommandBean.Time value) {
        this.time = value;
    }

    /**
     * ��ȡtimeStamp���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * ����timeStamp���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStamp(String value) {
        this.timeStamp = value;
    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "ip"
    })
    public static class IpList {

        @XmlElement(required = true)
        protected String ip;

        /**
         * ��ȡip���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIp() {
            return ip;
        }

        /**
         * ����ip���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIp(String value) {
            this.ip = value;
        }

    }


    /**
     * <p>anonymous complex type�� Java �ࡣ
     * 
     * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="effectTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="expiredTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "effectTime",
        "expiredTime"
    })
    public static class Time {

        @XmlElement(required = true)
        protected String effectTime;
        @XmlElement(required = true)
        protected String expiredTime;

        /**
         * ��ȡeffectTime���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getEffectTime() {
            return effectTime;
        }

        /**
         * ����effectTime���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setEffectTime(String value) {
            this.effectTime = value;
        }

        /**
         * ��ȡexpiredTime���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getExpiredTime() {
            return expiredTime;
        }

        /**
         * ����expiredTime���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setExpiredTime(String value) {
            this.expiredTime = value;
        }

    }

}
