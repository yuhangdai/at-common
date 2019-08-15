package com.aotain.nms.common.tools;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/07/25
 */
public class XmlUtils {
    public XmlUtils() {
    }

    public static String getRootName(InputStream istream) throws Exception {
        if (istream == null) {
            return null;
        } else {
            String ret = "";
            SAXReader reader = new SAXReader();

            try {
                Document doc = reader.read(istream);
                Element root = doc.getRootElement();
                ret = StringUtils.trim(root.getName());
            } finally {
                istream.reset();
            }

            return ret;
        }
    }

    public static String parseXmlStr(InputStream istream) throws Exception {
        if (istream == null) {
            return null;
        } else {
            SAXReader reader = new SAXReader();
            StringWriter sw = new StringWriter();
            XMLWriter writer = new XMLWriter(sw, OutputFormat.createPrettyPrint());

            String var5;
            try {
                Document doc = reader.read(new InputStreamReader(istream), "UTF-8");
                writer.write(doc);
                writer.close();
                var5 = sw.toString();
            } finally {
                istream.reset();
            }

            return var5;
        }
    }

    public static <T> T createBean(InputStream istream, Class<T> cls) throws Exception {
        T ret = null;
        JAXBContext context = JAXBContext.newInstance(cls);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        BufferedReader reader = new BufferedReader(new InputStreamReader(istream, "UTF-8"));
        ret = (T)unmarshaller.unmarshal(reader);
        return ret;
    }

    public static <T> String toXmlString(T data) throws JAXBException, UnsupportedEncodingException {
        if (data == null) {
            return null;
        } else {
            String tmp = "";
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            String var5;
            try {
                JAXBContext context = JAXBContext.newInstance(data.getClass());
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty("jaxb.encoding", "UTF-8");
                marshaller.marshal(data, buffer);
                tmp = buffer.toString("UTF-8");
                var5 = tmp;
            } finally {
                if (buffer != null) {
                    try {
                        buffer.close();
                    } catch (IOException var12) {
                        ;
                    }
                }

            }

            return var5;
        }
    }
}
