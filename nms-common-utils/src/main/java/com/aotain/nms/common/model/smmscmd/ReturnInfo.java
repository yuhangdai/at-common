//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.14 at 02:35:40 下午 CST 
//


package com.aotain.nms.common.model.smmscmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idcId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="returnCode" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="returnMsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="returnData" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="house" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="gatewayId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="ipSegId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="frameInfoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="user" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                             &lt;element name="service" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *                                       &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
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
    "idcId",
    "returnCode",
    "returnMsg",
    "returnData",
    "timeStamp"
})
@XmlRootElement(name = "returnInfo")
public class ReturnInfo extends CommandBaseVo{
	private static final long serialVersionUID = 4936281990845436619L;
	@XmlElement(required = true)
    protected String idcId;
    protected long returnCode;
    protected String returnMsg;
    protected ReturnInfo.ReturnData returnData;
    @XmlElement(required = true)
    protected String timeStamp;

    /**
     * Gets the value of the idcId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdcId() {
        return idcId;
    }

    /**
     * Sets the value of the idcId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdcId(String value) {
        this.idcId = value;
    }

    /**
     * Gets the value of the returnCode property.
     * 
     */
    public long getReturnCode() {
        return returnCode;
    }

    /**
     * Sets the value of the returnCode property.
     * 
     */
    public void setReturnCode(long value) {
        this.returnCode = value;
    }

    /**
     * Gets the value of the returnMsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * Sets the value of the returnMsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReturnMsg(String value) {
        this.returnMsg = value;
    }

    /**
     * Gets the value of the returnData property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnInfo.ReturnData }
     *     
     */
    public ReturnInfo.ReturnData getReturnData() {
        return returnData;
    }

    /**
     * Sets the value of the returnData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnInfo.ReturnData }
     *     
     */
    public void setReturnData(ReturnInfo.ReturnData value) {
        this.returnData = value;
    }

    /**
     * Gets the value of the timeStamp property.
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
     * Sets the value of the timeStamp property.
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice>
     *         &lt;element name="house" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="gatewayId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="ipSegId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="frameInfoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="user" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                   &lt;element name="service" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
     *                             &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                             &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "house",
        "user"
    })
    public static class ReturnData {

        protected List<ReturnInfo.ReturnData.House> house;
        protected List<ReturnInfo.ReturnData.User> user;

        /**
         * Gets the value of the house property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the house property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getHouse().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReturnInfo.ReturnData.House }
         * 
         * 
         */
        public List<ReturnInfo.ReturnData.House> getHouse() {
            if (house == null) {
                house = new ArrayList<ReturnInfo.ReturnData.House>();
            }
            return this.house;
        }

        /**
         * Gets the value of the user property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the user property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUser().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ReturnInfo.ReturnData.User }
         * 
         * 
         */
        public List<ReturnInfo.ReturnData.User> getUser() {
            if (user == null) {
                user = new ArrayList<ReturnInfo.ReturnData.User>();
            }
            return this.user;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="houseId" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="gatewayId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="ipSegId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="frameInfoId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
            "houseId",
            "gatewayId",
            "ipSegId",
            "frameInfoId"
        })
        public static class House {

            protected long houseId;
            protected Long gatewayId;
            protected Long ipSegId;
            protected Long frameInfoId;

            /**
             * Gets the value of the houseId property.
             * 
             */
            public long getHouseId() {
                return houseId;
            }

            /**
             * Sets the value of the houseId property.
             * 
             */
            public void setHouseId(long value) {
                this.houseId = value;
            }

            /**
             * Gets the value of the gatewayId property.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getGatewayId() {
                return gatewayId;
            }

            /**
             * Sets the value of the gatewayId property.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setGatewayId(Long value) {
                this.gatewayId = value;
            }

            /**
             * Gets the value of the ipSegId property.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getIpSegId() {
                return ipSegId;
            }

            /**
             * Sets the value of the ipSegId property.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setIpSegId(Long value) {
                this.ipSegId = value;
            }

            /**
             * Gets the value of the frameInfoId property.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getFrameInfoId() {
                return frameInfoId;
            }

            /**
             * Sets the value of the frameInfoId property.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setFrameInfoId(Long value) {
                this.frameInfoId = value;
            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *         &lt;element name="service" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
         *                   &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                   &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
            "userId",
            "service",
            "hhId"
        })
        public static class User {

            protected long userId;
            protected ReturnInfo.ReturnData.User.Service service;
            protected Long hhId;

            /**
             * Gets the value of the userId property.
             * 
             */
            public long getUserId() {
                return userId;
            }

            /**
             * Sets the value of the userId property.
             * 
             */
            public void setUserId(long value) {
                this.userId = value;
            }

            /**
             * Gets the value of the service property.
             * 
             * @return
             *     possible object is
             *     {@link ReturnInfo.ReturnData.User.Service }
             *     
             */
            public ReturnInfo.ReturnData.User.Service getService() {
                return service;
            }

            /**
             * Sets the value of the service property.
             * 
             * @param value
             *     allowed object is
             *     {@link ReturnInfo.ReturnData.User.Service }
             *     
             */
            public void setService(ReturnInfo.ReturnData.User.Service value) {
                this.service = value;
            }

            /**
             * Gets the value of the hhId property.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getHhId() {
                return hhId;
            }

            /**
             * Sets the value of the hhId property.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setHhId(Long value) {
                this.hhId = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="serviceId" type="{http://www.w3.org/2001/XMLSchema}long"/>
             *         &lt;element name="domainId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
             *         &lt;element name="hhId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
                "serviceId",
                "domainId",
                "hhId"
            })
            public static class Service {

                protected long serviceId;
                protected Long domainId;
                protected Long hhId;

                /**
                 * Gets the value of the serviceId property.
                 * 
                 */
                public long getServiceId() {
                    return serviceId;
                }

                /**
                 * Sets the value of the serviceId property.
                 * 
                 */
                public void setServiceId(long value) {
                    this.serviceId = value;
                }

                /**
                 * Gets the value of the domainId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                public Long getDomainId() {
                    return domainId;
                }

                /**
                 * Sets the value of the domainId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                public void setDomainId(Long value) {
                    this.domainId = value;
                }

                /**
                 * Gets the value of the hhId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                public Long getHhId() {
                    return hhId;
                }

                /**
                 * Sets the value of the hhId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                public void setHhId(Long value) {
                    this.hhId = value;
                }

            }

        }

    }

}
