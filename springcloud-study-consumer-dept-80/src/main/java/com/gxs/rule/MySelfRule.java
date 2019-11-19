package com.gxs.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

/**
 * @Author: xuyaoyao
 * @Description:
 * @Date: Create in 16:04 2019/10/22
 */
@Configuration
@RibbonClient(name="microservicecloud-dept",configuration = MySelfRule.class)
public class MySelfRule extends AbstractLoadBalancerRule {
    int num = 0;
    int index = 0;
    Random rand;

    public MySelfRule() {
        rand = new Random();
    }

    /**
     * Randomly choose from all living servers
     */
    //@edu.umd.cs.findbugs.annotations.SuppressWarnings(value = "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE")
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = rand.nextInt(serverCount);
//            server = upList.get(index);
            System.out.println(num + "=" + index);
            if(index == allList.size()){
                index = 0;
            }
            if(num <5){
                server = allList.get(index);
                num++;
            }else{
                server = allList.get(index);
                index ++;
                num = 0;
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
