package com.faceye.feature.repository.impl;

import static org.springframework.data.querydsl.QueryDslUtils.QUERY_DSL_PRESENT;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.LockModeRepositoryPostProcessor;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import com.faceye.feature.repository.BaseRepository;

public class BaseRepositoryFactoryBean<R extends JpaRepository<T, ID>, T, ID extends Serializable> extends
		JpaRepositoryFactoryBean<R, T, ID> {
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		return new BaseRepositoryFactory(entityManager);
	}

	private static  class BaseRepositoryFactory extends JpaRepositoryFactory {
		private EntityManager entityManager=null;
		private  LockModeRepositoryPostProcessor lockModePostProcessor=null;
		public BaseRepositoryFactory(EntityManager entityManager) {
			super(entityManager);
			this.entityManager=entityManager;
			this.lockModePostProcessor = LockModeRepositoryPostProcessor.INSTANCE;
			addRepositoryProxyPostProcessor(lockModePostProcessor);
		}

		@SuppressWarnings("unchecked")
		protected Object  getTargetRepository(RepositoryMetadata metadata) {
			Class<?> repositoryInterface = metadata.getRepositoryInterface();
			JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
		    SimpleJpaRepository<?, ?> repo=null;
			Boolean isQueryDslExecutor=isQueryDslExecutor(repositoryInterface);
			if(isQueryDslExecutor){
				repo= new QueryDslJpaRepository(entityInformation, entityManager);
			}else{
				repo=new BaseRepositoryImpl(entityInformation, entityManager);
			}
			repo.setLockMetadataProvider(lockModePostProcessor.getLockMetadataProvider());
			return repo;
		}

		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			if (isQueryDslExecutor(metadata.getRepositoryInterface())) {
				return QueryDslJpaRepository.class;
			} else {
				return BaseRepository.class;
			}
		}
		private boolean isQueryDslExecutor(Class<?> repositoryInterface) {

			return QUERY_DSL_PRESENT && QueryDslPredicateExecutor.class.isAssignableFrom(repositoryInterface);
		}
	}
}
