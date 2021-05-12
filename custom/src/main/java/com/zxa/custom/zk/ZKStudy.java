package com.zxa.custom.zk;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.Random;

/**
 * @author zhangxinan
 * @Classname ZKStudy
 * @Date 2021/5/11 8:23 下午
 */
public class ZKStudy {
    private static  String group = "/zxa";
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZKStudy zkStudy = new ZKStudy();
        ZooKeeper zooKeeper = null;

        zooKeeper = new ZooKeeper("139.199.30.155:2181", 30000, null);

        GroupNumbers groupNumbers = new GroupNumbers(zooKeeper, group);
        groupNumbers.list();
        zkStudy.join("members" + new Random().nextInt(1000), zooKeeper);
        Thread.sleep(Long.MAX_VALUE);

    }

    private void join(String s,ZooKeeper zooKeeper ) throws KeeperException, InterruptedException {
        String path = zooKeeper.create(group + "/" + s, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println("Created" + path);
    }

}


