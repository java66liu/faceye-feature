package com.faceye.feature.service;


/**
 * 序列服务，当前为mogo提供序列服务
 * @author @haipenge 
 * haipenge@gmail.com
*  Create Date:2014年8月10日
 */
public interface SequenceService {
  public Long getNextSequence(String name);
}
