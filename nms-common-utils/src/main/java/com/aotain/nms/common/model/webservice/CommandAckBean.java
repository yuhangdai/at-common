//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2019.07.26 ʱ�� 03:14:51 PM CST 
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
 *         &lt;element name="resultList" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                   &lt;element name="msgInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "resultList",
    "timeStamp"
})
@XmlRootElement(name = "nmsCommandAck")
public class CommandAckBean {

    protected long commandId;
    @XmlElement(required = true)
    protected Integer type;
    @XmlElement(required = true)
    protected List<CommandAckBean.ResultList> resultList;
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
     * Gets the value of the resultList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resultList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResultList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommandAckBean.ResultList }
     * 
     * 
     */
    public List<CommandAckBean.ResultList> getResultList() {
        if (resultList == null) {
            resultList = new ArrayList<CommandAckBean.ResultList>();
        }
        return this.resultList;
    }
    

    public void setResultList(List<CommandAckBean.ResultList> resultList) {
		this.resultList = resultList;
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
     *         &lt;element name="resultCode" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *         &lt;element name="msgInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "ip",
        "resultCode",
        "msgInfo"
    })
    public static class ResultList {

        @XmlElement(required = true)
        protected String ip;
        @XmlElement(required = true)
        protected Integer resultCode;
        @XmlElement(required = true)
        protected String msgInfo;

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

        /**
         * ��ȡresultCode���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public Integer getResultCode() {
            return resultCode;
        }

        /**
         * ����resultCode���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setResultCode(Integer value) {
            this.resultCode = value;
        }

        /**
         * ��ȡmsgInfo���Ե�ֵ��
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMsgInfo() {
            return msgInfo;
        }

        /**
         * ����msgInfo���Ե�ֵ��
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMsgInfo(String value) {
            this.msgInfo = value;
        }

    }

}
