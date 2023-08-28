package org.example.domain;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.ebean.config.DatabaseConfig;
import io.ebean.test.config.AutoConfigureForTesting;

public class DbConfig extends AutoConfigureForTesting {

  @Override
  public void postConfigure(DatabaseConfig config) {
    final HikariConfig hikariConfig = new HikariConfig();
    hikariConfig.setMaximumPoolSize(1);
    hikariConfig.setJdbcUrl(config.getDataSourceConfig().getUrl());
    hikariConfig.setPassword(config.getDataSourceConfig().getPassword());
    config.setDataSource(new HikariDataSource(hikariConfig));
    super.preConfigure(config);
  }
}
