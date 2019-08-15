package com.aotain.nms.common.tools;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class FileLoadEncode {
	private static LocalConfig cfg;

	static {
		cfg = new LocalConfig();
	}

	public static void main(String[] args) throws IOException {
		String path = ".";
		if (args != null && args.length > 0) {
			path = args[0];
		}

		File f = new File(path);
		List<File> files = new ArrayList<File>();
		if (f.isDirectory()) {
			File[] list = f.listFiles(new FileFilter() {

				public boolean accept(File pathname) {
					if (pathname.isDirectory()) {
						return false;
					}
					return pathname.getAbsolutePath().endsWith(".txt") && !pathname.getAbsolutePath().endsWith("_data.txt");
				}
			});
			files.addAll(Arrays.asList(list));
		} else {
			files.add(f);
		}

		for (File file : files) {
			try {
				byte[] data = FileUtils.read2Bytes(file.getAbsolutePath());
				String encryptStr = AES.Encrypt(data, cfg.aesKey, cfg.aesIv);
				String resultFileName = file.getAbsolutePath().replace(".txt", "_data.txt");
				String resultZipFileName = file.getAbsolutePath().replace(".txt", "_data.zip");
				FileUtils.writeToFile(encryptStr.getBytes("UTF-8"), resultFileName);
				FileUtils.zipFiles(new File(resultFileName), new File(resultZipFileName));
				System.out.println("加密成功：" + file.getAbsolutePath().replace(".xml", "_data.xml"));
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("加密失败" + path);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("加密失败" + path);
			}
		}
	}

	private static class LocalConfig {
		private String aesKey;
		private String aesIv;

		public LocalConfig() {
			Properties p = new Properties();
			try {
				p.load(new FileInputStream("config/config.properties"));
				aesKey = (String) p.get("aes.key");
				aesIv = (String) p.get("aes.iv");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
}
