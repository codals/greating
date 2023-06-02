package com.codals.greating.admin.dao;

import java.util.List;

import com.codals.greating.admin.dto.AdminDto;

public interface AdminDao {

	List<AdminDto> topList();

	boolean approveCheck(long postId);

}
