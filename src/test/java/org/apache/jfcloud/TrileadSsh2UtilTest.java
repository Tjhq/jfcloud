package org.apache.jfcloud;

import org.apache.jfcloud.configure.JfCloudException;
import org.apache.jfcloud.utils.TrileadSsh2Util;
import org.junit.Test;

/**
 * @author fxj
 * @date 2019/8/30 0030
 */
public class TrileadSsh2UtilTest {
    @Test
    public void exec(){
        try {
            TrileadSsh2Util.exec("192.168.100.40","root","root40","date");
        } catch (JfCloudException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void scp(){
        try {
            TrileadSsh2Util.scp("192.168.100.40","root","root40","E:\\tess4j\\1.jpg","/home/fams/");
        } catch (JfCloudException e) {
            e.printStackTrace();
        }
    }
}
