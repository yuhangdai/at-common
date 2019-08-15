package com.aotain.nms.common.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.lf5.util.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件基础操作工具
 *
 * @author liuz@aotian.com
 * @date 2017年11月10日 上午11:05:43
 */
public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /*
     * 将文件读取成为数据流
     */
    public static InputStream read2Stream(String path) throws FileNotFoundException {
        if (StringUtils.isBlank(path)) {
            return null;
        }

        File f = new File(path);
        if (!f.exists()) {
            return null;
        }

        return new FileInputStream(f);
    }

    /**
     * 将文件读取成为byte[]
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static byte[] read2Bytes(String path) throws IOException {
    	byte[] result = null;
    	InputStream is = null;
        try {
			is = read2Stream(path);
			if (is == null) {
			    return null;
			}
			result = StreamUtils.getBytes(is);
			if (is != null) {
				is.close();
			}
		} catch (Exception e) {
		} finally {
			if (is != null) {
				is.close();
			}
		}
        return result;
    }

    /**
     * 文件重命名
     *
     * @param path1
     * @param path2
     */
    public static boolean renameFile(String path1, String path2) throws Exception {
        File oldFile = new File(path1);
        File newFile = new File(path2);
        if (oldFile.exists() && !newFile.exists()) {
            return oldFile.renameTo(newFile);
        }
        return false;
    }

    /**
     * 将数据流写入文件
     *
     * @param data
     * @param path
     * @throws Exception
     */
    public static void writeToFile(byte[] data, String path) throws Exception {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            fos.write(data);
            fos.flush();
        } finally {
            org.springframework.util.StreamUtils.nonClosing(fos);
        }

    }

    /**
     * 安静的删除指定的文件路径列表指向的文件
     *
     * @param copiedTmpFilePaths
     */
    public static void deleteFilesQuietly(List<String> copiedTmpFilePaths) {
        if (copiedTmpFilePaths == null || copiedTmpFilePaths.size() == 0) {
            return;
        }
        try {
            for (String path : copiedTmpFilePaths) {
                File file = new File(path);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * 从环境中加载配置文件
     *
     * @param dir
     * @param name
     */
    public static Properties loadPropertiesFromConfig(String dir, String name) {
        return loadPropertiesFromConfig(dir, name, null);
    }

    /**
     * 将Properteis对象转成Map<String,String>对象
     *
     * @param properties
     * @return
     */
    public static Map<String, String> propertiesToMap(Properties properties) {
        Map<String, String> map = new HashMap<String, String>();
        for (Object key : properties.keySet()) {
            map.put((String) key, (String) properties.get(key));
        }
        return map;
    }

    /**
     * 从环境中加载配置文件
     *
     * @param dir
     * @param name
     */
    public static Properties loadPropertiesFromConfig(String dir, String name, String charset) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        name = name.trim();
        if (!name.endsWith(".properties")) {
            name += ".properties";
        }
        String path = null;
        path = name;
        if (!StringUtils.isBlank(dir)) {
            path = dir.trim() + File.separator + path;
        }
        System.out.println("try to load properties from path : " + new File(path).getAbsolutePath());
        Properties p = new Properties();
        File file = new File(path);
        if (file.exists()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                if (!StringUtils.isBlank(charset)) {
                    p.load(new InputStreamReader(fis, charset));
                } else {
                    p.load(fis);
                }
                return p;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 从class path中加载使用绝对路径加载
        path = name;
        if (path.contains("\\")) {
            path = path.replace("\\", "/");
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        System.out.println("try to load properties from classpath : " + path);
        try {
            InputStream is = FileUtils.class.getResourceAsStream(path);
            if (is != null) {
                if (!StringUtils.isBlank(charset)) {
                    p.load(new InputStreamReader(is, charset));
                } else {
                    p.load(is);
                }
                return p;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fail to load properties: " + path);
        return null;
    }

    public static void main(String[] args) {
        loadPropertiesFromConfig("config", "ai\\push.properties");
    }

    /**
     * @return
     */
    public static List<String> readFileByLine(File file) {
        BufferedReader reader = null;
        String temp = null;
        List<String> fileContexts = new ArrayList<>();
        try {
            // reader = new BufferedReader(new FileReader(file));
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));//转成gbk就不乱码了
            while ((temp = reader.readLine()) != null) {
                fileContexts.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContexts;
    }

    /**
     * 将文件内容加密成密文。
     *
     * @param fileAbsoultePath 文件绝对路径
     * @param sKey
     * @param slv
     * @return
     */
    public static String aesFile4String(String fileAbsoultePath, String sKey, String slv) {
        byte[] data = new byte[0];
        try {
            data = FileUtils.read2Bytes(fileAbsoultePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return AES.Encrypt(data, sKey, slv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将文件内容的密文解密。
     *
     * @param fileAbsoultePath 文件绝对路径
     * @param sKey
     * @param slv
     * @return
     */
    public static String aesFileToDecrypt(String fileAbsoultePath, String sKey, String slv) {
        byte[] data = new byte[0];
        try {
            data = FileUtils.read2Bytes(fileAbsoultePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return AES.Decrypt(new String(data), sKey, slv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 压缩单个文件
     *
     * @param srcfile
     */
    public static void zipFile(File srcfile, ZipOutputStream out, String basedir) {
        if (!srcfile.exists())
            return;

        byte[] buf = new byte[1024];
        FileInputStream in = null;

        try {
            int len;
            in = new FileInputStream(srcfile);
            out.putNextEntry(new ZipEntry(basedir + srcfile.getName()));

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.closeEntry();
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 压缩文件
     *
     * @param srcfile
     */
    public static void zipFiles(File srcfile, File targetFile) {
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(targetFile))) {
            if (srcfile.isFile()) {
                zipFile(srcfile, out, "");
            } else {
                File[] list = srcfile.listFiles();
                for (int i = 0; i < list.length; i++) {
                    compress(list[i], out, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 压缩文件夹里的文件 起初不知道是文件还是文件夹--- 统一调用该方法
     *
     * @param file
     * @param out
     * @param basedir
     */
    private static void compress(File file, ZipOutputStream out, String basedir) {
        /* 判断是目录还是文件 */
        if (file.isDirectory()) {
            zipDirectory(file, out, basedir);
        } else {
            zipFile(file, out, basedir);
        }
    }

    /**
     * 压缩文件夹
     *
     * @param dir
     * @param out
     * @param basedir
     */
    public static void zipDirectory(File dir, ZipOutputStream out, String basedir) {
        if (!dir.exists())
            return;

        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            /* 递归 */
            compress(files[i], out, basedir + dir.getName() + "/");
        }
    }

    /**
     * 根据指定路径创建文件夹
     *
     * @param path
     */
    public static void createFolderIfNotExists(String path) {
        File file = new File(path);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    /**
     * 根据指定路径创建文件
     * if parentFolder is not exist it will throw exception
     *
     * @param path
     */
    public static void createFileIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                logger.error("create file failed", e);
            }

        }
    }

    public static boolean removeFile(String fileName, String destinationFloderUrl) {
        File file = new File(fileName);
        File destFloder = new File(destinationFloderUrl);
        //检查目标路径是否合法
        if (destFloder.exists()) {
            if (destFloder.isFile()) {
                logger.error("目标路径是个文件，请检查目标路径！");
                return false;
            }
        } else {
            if (!destFloder.mkdirs()) {
                logger.error("目标文件夹不存在，创建失败！");
                return false;
            }
        }
        //检查源文件是否合法
        if (file.isFile() && file.exists()) {
            String destinationFile = destinationFloderUrl + "/" + file.getName();
            if (!file.renameTo(new File(destinationFile))) {
                logger.error("移动文件失败！");
                return false;
            }
        } else {
            logger.error("要备份的文件路径不正确，移动失败！");
            return false;
        }
        logger.info("已成功移动文件" + file.getName() + "到" + destinationFloderUrl);
        return true;
    }

}
