package com.codals.greating.diy.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.codals.greating.diy.dao.DiyDAO;
import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.dto.PostResponseDto;
import com.codals.greating.diy.dto.ScrapRequestDto;
import com.codals.greating.diy.entity.Post;
import com.codals.greating.exception.BusinessException;
import com.codals.greating.exception.ErrorCode;
import com.codals.greating.user.entity.User;
import com.codals.greating.util.ImageUrlGenerator;
import com.codals.greating.diy.dto.VoteRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
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
	public Integer savePost(User loginUser, DiyRequestDto postRequest, String path) {
		
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
		return diyDAO.savePost(post);
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

//	    String savedPath = saveImage(file, tomcatPath, fileName);
	    
	    String savedPath = saveImage(file, fileName);
	    log.info(savedPath);
	    
	    String uploadedPath = "/greating/resources/images/uploaded/" + fileName;
//	    return uploadedPath;
	    
	    return savedPath;
	}
	
	// 톰캣에 저장된 경로 확인 용
//	private String saveImage(MultipartFile file, String path, String fileName) throws IllegalStateException, IOException {
//	    File newFile = new File(path, fileName);
//	    file.transferTo(newFile);
//	    
//	    String savedPath = newFile.getAbsolutePath(); // 저장된 경로를 가져옵니다.
//	    return savedPath;
//	}
	
	
	// 리소스에 저장하기
	private String saveImage(MultipartFile file, String fileName) throws IllegalStateException, IOException {
	    String webappPath = System.getProperty("catalina.base") + "/wtpwebapps/greating"; // 프로젝트명은 실제 프로젝트 이름으로 바꿔주세요.
	    String imagePath = webappPath + "/resources/images/uploaded/";
	    File directory = new File(imagePath);

	    // 디렉토리 생성
	    if (!directory.exists()) {
	        directory.mkdirs();
	    }
	    
	    File newFile = new File(imagePath + fileName);
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

  @Override
	@Transactional
	public boolean vote(VoteRequestDto requestDto) {
		try {
			if(diyDAO.insertVote(requestDto)==1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

  @Override
  @Transactional
  public boolean cancelVote(VoteRequestDto requestDto) {
    try {
      if(diyDAO.deleteVote(requestDto)==1) {
        return true;
      }
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
  
  @Override
	@Transactional
	public boolean scrap(ScrapRequestDto requestDto) {
		try {
			if(diyDAO.insertScrap(requestDto)==1) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cancelScrap(ScrapRequestDto requestDto) {
		try {
			if(diyDAO.deleteScrap(requestDto)==1) {
				return true;
			}
			log.warn("해당 scrap 데이터가 없습니다.");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Post> loadPostsByCategoryType(int mainCategoryId) {
		return diyDAO.selectPostsByMainCategory(mainCategoryId);
	}
      
}
