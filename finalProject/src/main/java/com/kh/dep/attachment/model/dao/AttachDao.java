package com.kh.dep.attachment.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.dep.attachment.model.vo.Attachment;

public interface AttachDao {

	int insertAttachment(SqlSessionTemplate sqlSession, Attachment file);

}
