package com.codals.greating.diy.service;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.exception.BusinessException;
import com.codals.greating.exception.ErrorCode;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.ImageUrlGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiyServiceImpl implements DiyService{
	private static final String REAL_PATH = "/greating/src/main/webapp/resources/images/uploaded";

	Logger log = LogManager.getLogger("case3");
	
	private final DiyDAO diyDAO;
	
	@Override
	public PostResponseDto getPostDetail(int postId) {

		return diyDAO.selectPostByPostId(postId);
	}

	@Override
	@Transactional
	public void savePost(User loginUser, DiyRequestDto postRequest, String path) {
		
		// 1. 파일명 생성해서 받아오기 (tomcat서버에 저장된 경로 + UUID로 만든 파일명 + 확장자)
		String imgUrl;
		try {
			imgUrl = uploadImage(postRequest.getImgFile(), path);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
		
		// 2. post 객체 생성하기
		Post post = createPost(loginUser, postRequest, imgUrl);
		
		// 3. post DB에 저장하기
		int result = diyDAO.savePost(post);
		if (result == 0) {
			throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
		}
	}
	
	private String uploadImage(MultipartFile file, String tomcatPath) throws IllegalStateException, IOException {
	    String originalFilename = file.getOriginalFilename();

	    String fileType = "";
	    int dotIndex = originalFilename.lastIndexOf(".");
	    if (dotIndex >= 0) {
	        fileType = originalFilename.substring(dotIndex);
	    }
	    String fileName = ImageUrlGenerator.generateUniqueUrl() + fileType;

//	    // 경로 생성
//	    File directory = new File(tomcatPath);
//	    if (!directory.exists()) {
//	        directory.mkdirs(); // 경로가 없으면 생성
//	    }

	    String savedPath = saveImage(file, tomcatPath, fileName);
	    log.info(savedPath);
	    
	    String uploadedPath = tomcatPath + "/" + fileName;
	    return uploadedPath;
	}
	
	private String saveImage(MultipartFile file, String path, String fileName) throws IllegalStateException, IOException {
	    File newFile = new File(path, fileName);
	    file.transferTo(newFile);
	    
	    String savedPath = newFile.getAbsolutePath(); // 저장된 경로를 가져옵니다.
	    return savedPath;
	}
	
	private Post createPost(User loginUser, DiyRequestDto postRequest, String imgUrl) {
		Post newPost = Post.builder()
							.mainCategoryId(postRequest.getMainCategoryId())
							.subCategoryId(postRequest.getSubCategoryId())
							.foodCountryId(postRequest.getFoodCountryId())
							.userId(loginUser.getId())
							.title(postRequest.getDietName())
							.content(postRequest.getContent())
							.imgUrl(imgUrl)
							.riceFoodId(postRequest.getRiceFoodId())
							.soupFoodId(postRequest.getSoupFoodId())
							.mainFoodId(postRequest.getMainFoodId())
							.side1FoodId(postRequest.getSideFoodIds().size() >= 1 ? postRequest.getSideFoodIds().get(0) : null)
							.side1FoodId(postRequest.getSideFoodIds().size() >= 2 ? postRequest.getSideFoodIds().get(1) : null)
							.minCalorie(postRequest.getMinCalorie())
							.maxCalorie(postRequest.getMaxCalorie())
							.minPrice(postRequest.getMinPrice())
							.maxPrice(postRequest.getMaxPrice())
							.build();
		return newPost;
	}
}
