package com.codals.greating.admin.service;

import java.util.List;

import com.codals.greating.admin.dto.AdminDto;

public interface AdminService {

	List<AdminDto> topList();

	boolean approveCheck(long postId);

}
