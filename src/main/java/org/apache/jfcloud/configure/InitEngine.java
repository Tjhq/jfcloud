package org.apache.jfcloud.configure;

import org.apache.jfcloud.engine.ContainerEngine;
import org.apache.jfcloud.engine.impl.K8sEngine;
import org.apache.jfcloud.engine.impl.SwarmEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fxj
 * @date 2019/8/30 0030
 */
@Configuration
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class InitEngine implements InitializingBean {
    @Autowired
    private SwarmEngine swarmEngine;

    @Autowired
    private K8sEngine k8sEngine;

    interface ENGINE {
        String SWARM = "swarm";
        String K8S = "k8s";
    }

    public static Map<String, ContainerEngine> getEngineMap() {
        return engineMap;
    }

    private static Map<String, ContainerEngine> engineMap = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        engineMap.put(ENGINE.SWARM,swarmEngine);
        engineMap.put(ENGINE.K8S, k8sEngine);
    }
    public static ContainerEngine getContainerEngine(String engineType){
        Map<String, ContainerEngine> engineMap = getEngineMap();
        return engineMap.get(engineType);
    }

}
