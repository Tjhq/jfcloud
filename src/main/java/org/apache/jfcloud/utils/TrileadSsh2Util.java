package org.apache.jfcloud.utils;

import com.trilead.ssh2.*;
import org.apache.jfcloud.configure.JfCloudException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Vector;

/**
 * @author fxj
 * @date 2019/8/30 0030
 */
public class TrileadSsh2Util {

    private static Logger LOG = LoggerFactory.getLogger(TrileadSsh2Util.class);

    public static void exec(String ip,String user,String pwd,String cmd) throws JfCloudException {
        Connection conn = new Connection(ip);
        Session session = null;
        try {
            conn.connect();
            conn.authenticateWithPassword(user, pwd);
            session = conn.openSession();
        } catch (IOException e) {
            throw new JfCloudException("连接服务器"+ip+"异常"+e.getMessage());
        }
        try {
            session.execCommand(cmd);
        } catch (IOException e) {
            throw new JfCloudException(ip+"执行命令"+cmd+"异常"+e.getMessage());
        }
        InputStream inp = session.getStdout();
        InputStreamReader reader = new InputStreamReader(inp);
        BufferedReader br = new BufferedReader(reader);
        try {
            String line = br.readLine();
            LOG.debug(line);
        } catch (IOException e) {
            throw new JfCloudException(ip+"执行"+cmd+"获取返回异常"+e.getMessage());
        }
    }

    /**
     * 通过SFTPv3Client来进行传输，可以控制到字节力度，但是传输速度太慢；在网络不好的情况下，想要使用断点续传等机制可以采用.
     * @param ip
     * @param user
     * @param pwd
     * @param local
     * @param remote
     * @throws JfCloudException
     */
    public static void scp(String ip,String user,String pwd,String local,String remote) throws JfCloudException {
        Connection conn = new Connection(ip);
        SCPClient scpClient = null;
        try {
            conn.connect();
            conn.authenticateWithPassword(user, pwd);
            scpClient = conn.createSCPClient();
        } catch (IOException e) {
            throw new JfCloudException("连接服务器"+ip+"异常"+e.getMessage());
        }
        try {
            scpClient.put(local, remote);
        } catch (IOException e) {
            throw new JfCloudException(ip+"传输文件异常"+local+e.getMessage());
        }
    }
    public static void sftp(String ip,String user,String pwd,String local,String remote) throws JfCloudException {
        Connection conn = new Connection(ip);
        SFTPv3Client sftPv3Client = null;
        try {
            conn.connect();
            conn.authenticateWithPassword(user, pwd);
            sftPv3Client = new SFTPv3Client(conn);
        } catch (IOException e) {
            throw new JfCloudException("连接服务器"+ip+"异常"+e.getMessage());
        }
        try {
            SFTPv3FileHandle handle = sftPv3Client.createFile(remote);
            File localFile = new File(local);
            FileInputStream fis = new FileInputStream(localFile);
            byte[] arr = new byte[(int) localFile.length()];
            fis.read(arr);
            fis.close();
            sftPv3Client.write(handle, 0, arr, 0, arr.length);
            sftPv3Client.closeFile(handle);
            Vector<SFTPv3DirectoryEntry> files = sftPv3Client.ls(remote);
            for(SFTPv3DirectoryEntry item : files){
                System.out.println("文件名称: " + item.filename);
            }
        } catch (IOException e) {
            throw new JfCloudException(ip+"传输文件异常"+local+e.getMessage());
        }
    }
}
