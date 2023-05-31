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
//	private static final String REAL_PATH = "/greating/src/main/webapp/resources/images/uploaded";

	Logger log = LogManager.getLogger("case3");
	
	private final DiyDAO diyDAO;
	
	@Override
	public PostResponseDto getPostDetail(int postId) {
		return diyDAO.selectPostByPostId(postId);
	}

//	@Override
//	@Transactional
//	public Integer savePost(User loginUser, DiyRequestDto postRequest, String path) {
//		
//		// 1. 파일명 생성해서 받아오기 (tomcat서버에 저장된 경로 + UUID로 만든 파일명 + 확장자)
//		String fileName = "";
//		String imgUrl = "";
//		try {
////			fileName = uploadImage(postRequest.getImgFile(), path);
//			imgUrl = uploadImageToResources(postRequest.getImgFile(), path);
////			imgUrl = uploadFile(postRequest.getImgFile());
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//			throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		// 2. post 객체 생성하기
//		Post post = createPost(loginUser, postRequest, imgUrl);
//		
//		// 3. post DB에 저장하기
//		return diyDAO.savePost(post);
//	}
	
//	// 파일 업로드 메서드
//	public String uploadFile(MultipartFile multipartFile) {
//	    // 업로드할 디렉토리 경로 설정
//	    String uploadDirectory = "webapp/resources/images/uploaded";  // 예: "webapp/resources/images/uploaded"
//	    String contextRoot = "greating";  // 예: "greating"
//	    
//	    // 파일 저장 디렉토리 생성
//	    String saveDirectory = System.getProperty("catalina.base") + "/webapps/" + contextRoot + "/" + uploadDirectory;
//	    File directory = new File(saveDirectory);
//	    if (!directory.exists()) {
//	        directory.mkdirs();
//	    }
//	    
//	    // 파일명 설정
//	    String fileName = multipartFile.getOriginalFilename();
//	    
//	    // 파일 객체 생성
//	    File file = new File(directory.getAbsolutePath() + File.separator + fileName);
//	    
//	    try {
//	        // Multipart 파일을 지정된 파일로 복사
//	        multipartFile.transferTo(file);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        // 파일 업로드 실패 시 예외 처리
//	    }
//	    
//	    return fileName;
//	}
	
//	private String uploadImageToResources(MultipartFile multipartFile, String path) throws IllegalStateException, IOException {
//				
//		String originalFilename = multipartFile.getOriginalFilename();
//
//	    String fileType = "";
//	    int dotIndex = originalFilename.lastIndexOf(".");
//	    if (dotIndex >= 0) {
//	        fileType = originalFilename.substring(dotIndex);
//	    }
//	    String fileName = ImageUrlGenerator.generateUniqueUrl() + fileType;
//	    
//		File file = new File(path, fileName);
////		File file = new File("/greating/webapp/resources/images/uploaded", fileName);
//		multipartFile.transferTo(file);
//		
////		return file.getAbsolutePath();
//		log.info("absolutePath=" + file.getAbsolutePath());
//		return "/greating/images/uploaded/" + file.getName();
//	}
	
//	private String uploadImage(MultipartFile file, String tomcatPath) throws IllegalStateException, IOException {
//	    
//		String originalFilename = file.getOriginalFilename();
//
//	    String fileType = "";
//	    int dotIndex = originalFilename.lastIndexOf(".");
//	    if (dotIndex >= 0) {
//	        fileType = originalFilename.substring(dotIndex);
//	    }
//	    String fileName = ImageUrlGenerator.generateUniqueUrl() + fileType;
//
////	    // 경로 생성
////	    File directory = new File(tomcatPath);
////	    if (!directory.exists()) {
////	        directory.mkdirs(); // 경로가 없으면 생성
////	    }
//
////	    String savedPath = saveImage(file, tomcatPath, fileName);
//	    
//	    String savedPath = saveImage(file, fileName);
//	    log.info(savedPath);
//	    
//	    String uploadedPath = "/greating/resources/images/uploaded/" + fileName;
////	    return uploadedPath;
//	    
//	    return savedPath;
//	}
	
	// 톰캣에 저장된 경로 확인 용
//	private String saveImage(MultipartFile file, String path, String fileName) throws IllegalStateException, IOException {
//	    File newFile = new File(path, fileName);
//	    file.transferTo(newFile);
//	    
//	    String savedPath = newFile.getAbsolutePath(); // 저장된 경로를 가져옵니다.
//	    return savedPath;
//	}
	
	
	// 리소스에 저장하기
//	private String saveImage(MultipartFile file, String fileName) throws IllegalStateException, IOException {
//	    String webappPath = System.getProperty("catalina.base") + "/wtpwebapps/greating"; // 프로젝트명은 실제 프로젝트 이름으로 바꿔주세요.
//	    String imagePath = webappPath + "/resources/images/uploaded/";
//	    File directory = new File(imagePath);
//
//	    // 디렉토리 생성
//	    if (!directory.exists()) {
//	        directory.mkdirs();
//	    }
//	    
//	    File newFile = new File(imagePath + fileName);
//	    file.transferTo(newFile);
//
//	    String savedPath = newFile.getAbsolutePath(); // 저장된 경로를 가져옵니다.
//	    return savedPath;
//	}
	
	private Post createPost(User loginUser, DiyRequestDto postRequest, String imgUrl) {
		
		log.info("request -> post 매핑 전 =" + postRequest);
		
		Post newPost = Post.builder()
							.mainCategoryId(postRequest.getMainCategoryId())
							.subCategoryId(postRequest.getSubCategoryId())
							.foodCountryId(postRequest.getFoodCountryId())
							.userId(loginUser.getId())
							.title(postRequest.getDietName())
							.content(postRequest.getContent())
							.imgUrl(postRequest.getFileName())
							.riceFoodId(postRequest.getRiceFoodId())
							.soupFoodId(postRequest.getSoupFoodId())
							.mainFoodId(postRequest.getMainFoodId())
							.side1FoodId(postRequest.getSideFoodIds().size() >= 1 ? postRequest.getSideFoodIds().get(0) : null)
							.side2FoodId(postRequest.getSideFoodIds().size() >= 2 ? postRequest.getSideFoodIds().get(1) : null)
							.minCalorie(postRequest.getMinCalorie())
							.maxCalorie(postRequest.getMaxCalorie())
							.minPrice(postRequest.getMinPrice())
							.maxPrice(postRequest.getMaxPrice())
							.build();

		log.info("request -> post 매핑 후 =" + newPost);

		return newPost;
	}

	@Override
	public Integer savePost(User loginUser, DiyRequestDto newPost, String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int savePostAndImage(User loginUser, DiyRequestDto postRequest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int savePost(User loginUser, DiyRequestDto postRequest) {
		// 1. 파일명 생성해서 받아오기 (tomcat서버에 저장된 경로 + UUID로 만든 파일명 + 확장자)
		String fileName = "tmp";
		
		// 2. post 객체 생성하기
		Post post = createPost(loginUser, postRequest, fileName);
		
		// 3. post DB에 저장하기
		return diyDAO.savePost(post);
	}

//	@Override
//	public int savePostAndImage(User loginUser, DiyRequestDto postRequest) {
//		// 1. 파일명 생성해서 받아오기 (tomcat서버에 저장된 경로 + UUID로 만든 파일명 + 확장자)
////		String fileName = "";
////		String imgUrl = "";
////		try {
//////			fileName = uploadImage(postRequest.getImgFile(), path);
////			imgUrl = uploadImageToResources(postRequest.getImgFile(), path);
//////			imgUrl = uploadFile(postRequest.getImgFile());
////		} catch (IllegalStateException e) {
////			e.printStackTrace();
////			throw new BusinessException(ErrorCode.INTERNAL_SERVER_ERROR);
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		// 2. post 객체 생성하기
////		Post post = createPost(loginUser, postRequest, imgUrl);
////		
////		// 3. post DB에 저장하기
////		return diyDAO.savePost(post);
//		return 100;
//	}

//	@Override
//	public int savePostAndImage(User loginUser, DiyRequestDto postRequest) {
//		
//	}
	
//	private String sendImage() {
//		 
//	}
}
