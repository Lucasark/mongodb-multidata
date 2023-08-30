package com.example.multi_mongo_proj.configurations;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@Configuration
public class MultipleMongoConfig {
    @Primary
    @Bean(name = "newdb1Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.newdb1")
    public MongoProperties getNewDb1Props() throws Exception {
        return new MongoProperties();
    }

    @Bean(name = "newdb2Properties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.newdb2")
    public MongoProperties getNewDb2Props() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "newdb1MongoTemplate")
    public MongoTemplate newdb1MongoTemplate(MappingMongoConverter converter) throws Exception {
        return new MongoTemplate(newdb1MongoDatabaseFactory(getNewDb1Props()), converter);
    }

    @Bean(name = "newdb2MongoTemplate")
    public MongoTemplate newdb2MongoTemplate(MappingMongoConverter converter) throws Exception {
        return new MongoTemplate(newdb2MongoDatabaseFactory(getNewDb2Props()), converter);
    }

    @Primary
    @Bean
    public MongoDatabaseFactory newdb1MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

    @Bean
    public MongoDatabaseFactory newdb2MongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(
                mongo.getUri()
        );
    }

}
