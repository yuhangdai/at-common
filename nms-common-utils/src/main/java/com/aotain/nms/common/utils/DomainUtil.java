package com.aotain.nms.common.utils;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 域名或url处理
 * @author silence
 * @time 2019年8月1日
 */
public class DomainUtil {
	
	private final static Set<String> PublicSuffixSet = new HashSet<String>(
			Arrays.asList(new String(
					"com|cn|org|net|edu|com.cn|xyz|xin|club|shop|site|wang|top|win|online|tech|store|bid|cc|ren|lol|pro|red|kim|space|link|click|news|news|ltd|website" +
							"|biz|help|mom|work|date|loan|mobi|live|studio|info|pics|photo|trade|vc|party|game|rocks|band)" +
							"|gift|wiki|design|software|social|lawyer|engineer|org|net.cn|org.cn|gov.cn|name|tv|me|asia|co|press|video|market)" +
							"|games|science|中国|公司|网络|pub" +
							"|la|auction|email|sex|sexy|one|host|rent|fans|cn.com|life|cool|run|gold|rip|ceo|sale|hk|io|gg|tm|com.hk|gs|us")
					.split("\\|")));
 
	private static Pattern IP_PATTERN = Pattern
			.compile("(\\d{1,3}\\.){3}(\\d{1,3})");
	
	/**
	 * 通过URL获取顶级域名
	 * 
	 * @author : songl
	 * @since:2019年8月1日 下午4:58:30
	 */
	public static String getTopDomainName(URL url) {
		String host = url.getHost().toLowerCase();//转为小写
		if (host.endsWith("."))
			host = host.substring(0, host.length() - 1);
		if (IP_PATTERN.matcher(host).matches())
			return host;
 
		return getTopDomainName(host);
	}
	
	/**
	 * 通过域名获取顶级域名
	 * 
	 * @author : songl
	 * @since:2019年8月1日 下午5:07:17
	 */
	public static String getTopDomainName(String domainName) {
		domainName = domainName.toLowerCase();//转为小写
		if (IP_PATTERN.matcher(domainName).matches())
			return domainName;
 
		int index = 0;
		String candidate = domainName;
		for (; index >= 0;) {
			index = candidate.indexOf('.');
			String subCandidate = candidate.substring(index + 1);
			if (PublicSuffixSet.contains(subCandidate)) {
				return candidate;
			}
			candidate = subCandidate;
		}
		return candidate;
	}
	
	/**
	 * 比较两个域名是否含有相同的顶级域名
	 * 
	 * @author : songl
	 * @since:2019年8月1日 下午5:09:19
	 */
	public static Boolean ifSameTopDomainName(String domain1,String domain2){
		if(domain1==null||domain1==""||domain2==null||domain2==""){
			return false;
		}
		return getTopDomainName(domain1).equals(getTopDomainName(domain2));
	}
	
	/**
	 * 比较两个URL是否含有相同的顶级域名
	 * 
	 * @author : songl
	 * @since:2019年8月1日 下午5:09:19
	 */
	public static Boolean ifSameTopDomainName(URL url1,URL url2){
		if(url1==null||url2==null){
			return false;
		}
		return getTopDomainName(url1).equals(getTopDomainName(url2));
	}
	
	/**
	 * 比较URL和域名是否含有相同的顶级域名
	 * 
	 * @author : songl
	 * @since:2019年8月1日 下午5:09:19
	 */
	public static Boolean ifSameTopDomainName(URL url,String domain){
		if(url==null||domain==null||domain==""){
			return false;
		}
		return getTopDomainName(url).equals(getTopDomainName(domain));
	}
	
	
	public static void main(String[] args) {
		try {
			System.out.println(getTopDomainName(new URL("http://www.baidu.cns//")));
			System.out.println(getTopDomainName(new URL("http://360.com//")));
			System.out.println(getTopDomainName(new URL("http://360.coms.baidu.baidu.com.cn//")));
			System.out.println(getTopDomainName(new URL("http://360.coms.baidu.baidu.com.cn.com.cn//")));
			System.out.println(getTopDomainName(new URL("http://360.coms.baidu.baidu.com.cn.com.中国//")));
			System.out.println(getTopDomainName(new URL("http://360.coms.baidu.baidu.com.cn.com.中国人//")));
			
			System.out.println(ifSameTopDomainName("www.baidu.com", "sport.baidu.com"));
			System.out.println(ifSameTopDomainName("www.baidu.com", "sport.baidu.com.cn"));
		} catch (MalformedURLException e) {
		}
	}

}
