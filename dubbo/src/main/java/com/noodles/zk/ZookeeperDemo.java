package com.noodles.zk;

import java.util.List;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

/**
 * @Description: zookeeper 示例
 *      参考连接: https://www.bilibili.com/video/BV1VE411q7dX?p=23
 * @Author: noodles
 * @create: 2021-05-13 13:32
 */
public class ZookeeperDemo {

    @Test
    public void testApi() throws Exception {
        // 1, 创建 zookeeper 连接
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181", 2000, new Watcher() {
            @Override
            public void process(WatchedEvent event) {
                System.out.println("触发了 " + event.getType() + " 的事件");
            }
        });

        // 2, 创建父节点
//        String path = zookeeper.create("/zk-book", "java guide".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(path);

        // 3, 创建子节点
//        String children = zookeeper.create("/zk-book/chapter1", "java tutorial".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        System.out.println(children);

        // 4, 获取节点中的值(父节点和子节点)
        byte[] data = zookeeper.getData("/zk-book", false, null);
        System.out.println("父节点数据为: " + new String(data));

        List<String> children = zookeeper.getChildren("/zk-book", false);
        for (String child : children) {
            System.out.println(child);
        }

        // 5, 修改节点的值
        Stat stat = zookeeper.setData("/zk-book", "effective java".getBytes(), -1);
        System.out.println("修改后的结果为: " + stat);

        // 6, 判断某个节点是否存在
        Stat exists = zookeeper.exists("/zk-book/chapter1", false);
        System.out.println(exists);

        // 7, 删除节点
        zookeeper.delete("/zk-book/chapter1", -1);
    }
}
