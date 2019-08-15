package com.aotain.nms.common.tools;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Demo class
 *
 * @author bang
 * @date 2019/07/25
 */
public class Tools {
    private static Logger logger = Logger.getLogger(Tools.class);

    public Tools() {
    }

    public static String getHostAddress() {
        String ip = "";

        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.getHostAddress();
        } catch (Exception var2) {
            logger.error("get host address error!", var2);
        }

        return ip;
    }

    public static String getHostAddressAndIp() {
        String ip = "";

        try {
            InetAddress addr = InetAddress.getLocalHost();
            ip = addr.toString();
        } catch (Exception var2) {
            logger.error("get host address error!", var2);
        }

        return ip;
    }

    public static String getHostName() {
        String hostname = "";

        try {
            InetAddress addr = InetAddress.getLocalHost();
            hostname = addr.getHostName();
        } catch (Exception var2) {
            logger.error("get host name error!", var2);
        }

        return hostname;
    }

    public static String getSystemWorkPath(Class<?> cls) {
        String path = System.getProperty("work.dir");
        if (path == null || path.length() == 0) {
            path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                path = path.replaceFirst("/", "");
            }

            System.setProperty("work.dir", path);
        }

        return path;
    }

    public static boolean isEmpty(String s) {
        return s == null || s.length() <= 0;
    }

    public static String format2Two(String num) {
        return num.length() < 2 ? "0" + num : num;
    }

    public static String getBatchId() {
        String mBatchId = "";
        Calendar cal = Calendar.getInstance();
        mBatchId = "" + cal.get(1);
        mBatchId = mBatchId + format2Two(cal.get(2) + 1 + "");
        mBatchId = mBatchId + format2Two(cal.get(5) + "");
        mBatchId = mBatchId + format2Two(cal.get(11) + "");
        mBatchId = mBatchId + format2Two(cal.get(12) + "");
        mBatchId = mBatchId + format2Two(cal.get(13) + "");
        mBatchId = mBatchId + format2Two(cal.get(14) + "");
        mBatchId = mBatchId + getUUIDPrefix();
        return mBatchId;
    }

    public static String getUUIDPrefix() {
        String result = "";
        UUID uuid = UUID.randomUUID();
        String temp = uuid.toString();
        if (temp.contains("-")) {
            result = temp.substring(0, 8);
        }

        return result;
    }

    public static byte[] joinBytes(byte[] srcByte1, byte[] srcByte2) {
        int byte1Length = srcByte1.length;
        int byte2Length = srcByte2.length;
        byte[] retByte = new byte[byte1Length + byte2Length];
        System.arraycopy(srcByte1, 0, retByte, 0, byte1Length);
        System.arraycopy(srcByte2, 0, retByte, byte1Length, byte2Length);
        return retByte;
    }

    public static String getDateStr(long timestamp) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(timestamp);
        return dateFormater.format(date);
    }

    public static String getDatetimeStr(long timestamp) {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(timestamp);
        return dateFormater.format(date);
    }

    public static String getDatetimeStr(long timestamp, String format) {
        SimpleDateFormat dateFormater = new SimpleDateFormat(format);
        Date date = new Date(timestamp);
        return dateFormater.format(date);
    }

    public static List<BigInteger> str2List(String mStr, String separator) {
        List<BigInteger> list = new ArrayList();
        if (mStr != null) {
            String[] strs = mStr.split(separator);

            for(int i = 0; i < strs.length; ++i) {
                list.add(new BigInteger(strs[i]));
            }
        }

        return list;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("-?[0-9]+");
            Matcher isNum = pattern.matcher(str);
            return isNum.matches();
        }
    }

    public static boolean isIpAddress(String s) {
        if (s == null) {
            return false;
        } else {
            String regex = "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(s);
            return m.matches();
        }
    }

    public static boolean isIpV6Address(String s) {
        if (s == null) {
            return false;
        } else {
            boolean result = false;
            String regex = "^(^((\\p{XDigit}{1,4}):){7}(\\p{XDigit}{1,4})$)|(^(::((\\p{XDigit}{1,4}):){0,5}(\\p{XDigit}{1,4}))$)|(^((\\p{XDigit}{1,4})(:|::)){0,6}(\\p{XDigit}{1,4})$)$";
            if (s.indexOf(":") != -1 && s.length() <= 39) {
                String addressTemp = s;
                int doubleColon = 0;
                if (s.equals("::")) {
                    return true;
                }

                while(addressTemp.indexOf("::") != -1) {
                    addressTemp = addressTemp.substring(addressTemp.indexOf("::") + 2, addressTemp.length());
                    ++doubleColon;
                }

                if (doubleColon <= 1) {
                    result = s.matches(regex);
                }
            }

            return result;
        }
    }

    public static BigInteger ipv6toInt(String ipv6) {
        int compressIndex = ipv6.indexOf("::");
        if (compressIndex != -1) {
            String part1s = ipv6.substring(0, compressIndex);
            String part2s = ipv6.substring(compressIndex + 1);
            BigInteger part1 = ipv6toInt(part1s);
            BigInteger part2 = ipv6toInt(part2s);
            int part1hasDot = 0;
            char[] ch = part1s.toCharArray();
            char[] var8 = ch;
            int var9 = ch.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                char c = var8[var10];
                if (c == ':') {
                    ++part1hasDot;
                }
            }

            return part1.shiftLeft(16 * (7 - part1hasDot)).add(part2);
        } else {
            String[] str = ipv6.split(":");
            BigInteger big = BigInteger.ZERO;

            for(int i = 0; i < str.length; ++i) {
                if (str[i].isEmpty()) {
                    str[i] = "0";
                }

                big = big.add(BigInteger.valueOf(Long.valueOf(str[i], 16)).shiftLeft(16 * (str.length - i - 1)));
            }

            return big;
        }
    }

    public static String int2ipv6(BigInteger big) {
        String str = "";
        BigInteger ff = BigInteger.valueOf(65535L);

        for(int i = 0; i < 8; ++i) {
            str = big.and(ff).toString(16) + ":" + str;
            big = big.shiftRight(16);
        }

        str = str.substring(0, str.length() - 1);
        return str.replaceFirst("(^|:)(0+(:|$)){2,8}", "::");
    }

    public static long ip2long(String ip) {
        if (!isIpAddress(ip)) {
            return -1L;
        } else {
            String[] ips = ip.split("[.]");
            long num = 16777216L * Long.parseLong(ips[0]) + 65536L * Long.parseLong(ips[1]) + 256L * Long.parseLong(ips[2]) + Long.parseLong(ips[3]);
            return num;
        }
    }

    public static String long2ip(long ipLong) {
        long[] mask = new long[]{255L, 65280L, 16711680L, -16777216L};
        long num = 0L;
        StringBuffer ipInfo = new StringBuffer();

        for(int i = 0; i < 4; ++i) {
            num = (ipLong & mask[i]) >> i * 8;
            if (i > 0) {
                ipInfo.insert(0, ".");
            }

            ipInfo.insert(0, Long.toString(num, 10));
        }

        return ipInfo.toString();
    }

    public static String formatStorageUnit(BigDecimal size) {
        BigDecimal bd1024 = new BigDecimal(1024);
        BigDecimal unit_k = size.divide(bd1024);
        int rsize = 3;
        if (unit_k.compareTo(BigDecimal.ONE) == -1) {
            return size.setScale(1, 5) + "(Byte)";
        } else {
            BigDecimal unit_m = unit_k.divide(bd1024);
            if (unit_m.compareTo(BigDecimal.ONE) == -1) {
                return unit_k.setScale(rsize, 5) + "(KB)";
            } else {
                BigDecimal unit_g = unit_m.divide(bd1024);
                if (unit_g.compareTo(BigDecimal.ONE) == -1) {
                    return unit_m.setScale(rsize, 5) + "(MB)";
                } else {
                    BigDecimal unit_t = unit_g.divide(bd1024);
                    return unit_t.compareTo(BigDecimal.ONE) == -1 ? unit_g.setScale(rsize, 5) + "(GB)" : unit_t.setScale(6, 5) + "(TB)";
                }
            }
        }
    }

    public static String parseDataJson(List<Map<String, String>> dataJsonList) {
        StringBuffer result = new StringBuffer();
        if (dataJsonList == null) {
            return "";
        } else {
            Iterator var2 = dataJsonList.iterator();

            while(var2.hasNext()) {
                Map<String, String> dataJsonMap = (Map)var2.next();
                StringBuffer buffer = new StringBuffer();
                Iterator it = dataJsonMap.keySet().iterator();

                while(it.hasNext()) {
                    String key = (String)it.next();
                    String value = (String)dataJsonMap.get(key);
                    buffer.append(value).append("-");
                }

                buffer.replace(buffer.lastIndexOf("-"), buffer.length(), "");
                result.append("[").append(buffer.toString()).append("]");
            }

            return result.toString();
        }
    }

    public static int getValueCharLength(String value) {
        if (value == null) {
            return 0;
        } else {
            char[] chars = value.toCharArray();
            int length = 0;

            for(int index = 0; index < chars.length; ++index) {
                if (isUnicode(chars[index])) {
                    length += 3;
                } else {
                    ++length;
                }
            }

            return length;
        }
    }

    private static boolean isUnicode(char c) {
        return c >= 19968 && c <= '龻';
    }
    
    // 当前时间，格式yyyy-MM-dd HH:mm:ss
 	public static String getTimeStamp() {
 		String ret = "";
 		Calendar cal = Calendar.getInstance();
 		ret = "" + cal.get(Calendar.YEAR);
 		ret += "-" + format2Two(cal.get(Calendar.MONTH) + 1 + "");
 		ret += "-" + format2Two(cal.get(Calendar.DAY_OF_MONTH) + "");
 		ret += " " + format2Two(cal.get(Calendar.HOUR_OF_DAY) + "");
 		ret += ":" + format2Two(cal.get(Calendar.MINUTE) + "");
 		ret += ":" + format2Two(cal.get(Calendar.SECOND) + "");
 		return ret;
 	}

    public static void main(String[] args) {
        List<Map<String, String>> dataJsonList = new ArrayList();
        Map<String, String> valueMap = new HashMap();
        valueMap.put("frameId", "111");
        valueMap.put("frameName", "aaaa");
        dataJsonList.add(valueMap);
        Map<String, String> valueMap1 = new HashMap();
        valueMap1.put("frameId", "222");
        valueMap1.put("frameName", "bbb");
        dataJsonList.add(valueMap1);
        Map<String, String> valueMap2 = new HashMap();
        valueMap2.put("frameId", "333");
        valueMap2.put("frameName", "ccc");
        dataJsonList.add(valueMap2);
        System.out.println(parseDataJson(dataJsonList));
        System.out.println("----------------------");
        System.out.println(getValueCharLength("A我"));
    }
}
