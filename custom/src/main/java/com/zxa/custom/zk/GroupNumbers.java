package com.zxa.custom.zk;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.List;

/**
 * @author zhangxinan
 * @Classname GroupNumbers
 * @Date 2021/5/11 8:29 下午
 */
public class GroupNumbers implements Watcher {

    ZooKeeper zooKeeper;

    private String groupPath;

    public GroupNumbers() {
    }

    public GroupNumbers(ZooKeeper zooKeeper, String groupPath) {
        this.zooKeeper = zooKeeper;
        this.groupPath = groupPath;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
            this.list();
        }
    }

    public void list(){
        try{
            List<String> members = zooKeeper.getChildren(groupPath, this);
            System.out.println(members + "changed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

}
