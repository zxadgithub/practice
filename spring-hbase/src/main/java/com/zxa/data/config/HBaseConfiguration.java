package com.zxa.data.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;

/**
 * @Classname HBaseConfiguration
 * @Description HBaseConfiguration
 * @Date 2020/1/17 5:49 下午
 * @Created by zhangxinan
 */
@Configuration
public class HBaseConfiguration {

	@Value("${hbase.zookeeper.quorum}")
	private String zookeeperQuorum;

	@Value("${hbase.zookeeper.property.clientPort}")
	private String clientPort;

	@Value("${zookeeper.znode.parent}")
	private String znodeParent;

	@Bean
	public HbaseTemplate hbaseTemplate() {
		org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
		conf.set("hbase.zookeeper.quorum", zookeeperQuorum);
		conf.set("hbase.zookeeper.property.clientPort", clientPort);
		conf.set("zookeeper.znode.parent", znodeParent);
		return new HbaseTemplate(conf);
	}
}