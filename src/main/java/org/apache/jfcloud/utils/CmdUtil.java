package org.apache.jfcloud.utils;

import org.apache.jfcloud.configure.JfCloudException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fxj
 * @date 2019-8-21
 */
public class CmdUtil {

    private static Logger LOG = LoggerFactory.getLogger(CmdUtil.class);

    public static List<String> exec(String cmd) throws JfCloudException {
        List<String> result = new LinkedList<>();
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd, null, null);
            InputStream stderr = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line = "";
            // 打印出命令执行的结果
            while ((line = br.readLine()) != null) {
                result.add(line);
                System.out.println(line);
            }
            LOG.debug(cmd+"执行结束,code="+proc.exitValue());
        } catch (Exception e) {
            throw new JfCloudException("执行"+cmd+"异常"+e.getMessage());
        }
        return result;
    }
}
