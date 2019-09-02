package org.apache.jfcloud.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fxj
 * @date 2019/8/30 0030
 */
public class JfCloudException extends Exception{
    private static final Logger LOG = LoggerFactory.getLogger(JfCloudException.class);

    public JfCloudException(String s) {
        super(s);
    }

    public JfCloudException(String s, Exception e) {
        this(s);
        LOG.error(s,e);
    }
}
