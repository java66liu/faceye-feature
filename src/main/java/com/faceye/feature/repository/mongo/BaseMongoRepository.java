package com.faceye.feature.repository.mongo;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BaseMongoRepository<T,ID extends Serializable> extends MongoRepository<T, ID>,QueryDslPredicateExecutor<T>{

}
