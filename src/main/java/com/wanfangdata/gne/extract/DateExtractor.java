package com.wanfangdata.gne.extract;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Element;


public class DateExtractor{

	private static final String[] patterns = {
			"(\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9])",
			"(\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9])",
			"(\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[1-24]\\d时[0-60]\\d分)([1-24]\\d时)",
			"(\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[0-1]?[0-9]:[0-5]?[0-9])",
			"(\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[2][0-3]:[0-5]?[0-9])",
			"(\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2}\\s*?[1-24]\\d时[0-60]\\d分)([1-24]\\d时)",
			"(\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9])",
			"(\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9])",
			"(\\d{4}年\\d{1,2}月\\d{1,2}日\\s*?[1-24]\\d时[0-60]\\d分)([1-24]\\d时)",
			"(\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9])",
			"(\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9])",
			"(\\d{2}年\\d{1,2}月\\d{1,2}日\\s*?[1-24]\\d时[0-60]\\d分)([1-24]\\d时)",
			"(\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9]:[0-5]?[0-9])",
			"(\\d{1,2}月\\d{1,2}日\\s*?[0-1]?[0-9]:[0-5]?[0-9])", "(\\d{1,2}月\\d{1,2}日\\s*?[2][0-3]:[0-5]?[0-9])",
			"(\\d{1,2}月\\d{1,2}日\\s*?[1-24]\\d时[0-60]\\d分)([1-24]\\d时)", "(\\d{4}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2})",
			"(\\d{2}[-|/|.]\\d{1,2}[-|/|.]\\d{1,2})", "(\\d{4}年\\d{1,2}月\\d{1,2}日)", "(\\d{2}年\\d{1,2}月\\d{1,2}日)",
			"(\\d{1,2}月\\d{1,2}日)" };

	public String extract(Element ele) {
		String data = null;
		String content = ele.text();
		for (int i=0;i<patterns.length;i++) {
			Pattern compile = Pattern.compile(patterns[i]);
			Matcher matcher = compile.matcher(content);
			if(matcher.find()) {
				data = matcher.group(1);
//				System.out.println("data: "+ data);
				return data;
			}
		}
		return data;
	}
}