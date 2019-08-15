package com.aotain.nms.common.config.redis.connection;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

public class MyJedisConnectionFactory extends JedisConnectionFactory {
	
	public MyJedisConnectionFactory() {
		super();
	}

	public MyJedisConnectionFactory(JedisPoolConfig poolConfig) {
		super(poolConfig);
	}

	public MyJedisConnectionFactory(JedisShardInfo shardInfo) {
		super(shardInfo);
	}

	public MyJedisConnectionFactory(RedisClusterConfiguration clusterConfig, JedisPoolConfig poolConfig) {
		super(clusterConfig, poolConfig);
	}

	public MyJedisConnectionFactory(RedisClusterConfiguration clusterConfig) {
		super(clusterConfig);
	}

	public MyJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig, JedisPoolConfig poolConfig) {
		super(sentinelConfig, poolConfig);
	}

	public MyJedisConnectionFactory(RedisSentinelConfiguration sentinelConfig) {
		super(sentinelConfig);
	}

	@Override
	protected JedisCluster createCluster(RedisClusterConfiguration clusterConfig, GenericObjectPoolConfig poolConfig) {
		Assert.notNull(clusterConfig,"Cluster configuration must not be null!");

		Set<HostAndPort> hostAndPort = new HashSet<HostAndPort>();
		for (RedisNode node : clusterConfig.getClusterNodes()) {
			hostAndPort.add(new HostAndPort(node.getHost(), node.getPort().intValue()));
		}

		int redirects = clusterConfig.getMaxRedirects() != null ? clusterConfig.getMaxRedirects().intValue() : 5;

		return StringUtils.hasText(getPassword()) ? new JedisCluster(hostAndPort, getTimeout(), getTimeout(), redirects, getPassword(), poolConfig) : new JedisCluster(hostAndPort, getTimeout(), redirects, poolConfig);
	}
}
