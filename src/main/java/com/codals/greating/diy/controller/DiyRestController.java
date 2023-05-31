package com.codals.greating.diy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.MultiValueMap;

import com.codals.greating.diy.dto.DiyRequestDto;
import com.codals.greating.diy.service.DiyService;
import com.codals.greating.global.ResponseDTO;
import com.codals.greating.user.entity.User;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/mealdiy")
public class DiyRestController {
	
	private final DiyService diyService;

    @PostMapping
    public String search(@RequestParam(required = false) String category,
                         @RequestParam(required = false) String classification,
                         @RequestParam(required = false) boolean includeRice,
                         @RequestParam(required = false) boolean includeSoup) {
        /**
         * diy 메인 > 돋보기, 선택완료 버튼 (Ajax)
         */
        return "diy/diy-main";
    }
    
    @PostMapping("/new")
	public ResponseEntity<?> savePost(@SessionAttribute("loginUser") User loginUser,
									  @ModelAttribute DiyRequestDto postRequest,
							          HttpSession session) {

		/* log.info(loginUser); */
		log.info(postRequest);
		log.info("soupId=" + postRequest.getSoupFoodId());

		// 톰캣 아래 바로 이미지 넣는 경로
//		String tomcatPath = session.getServletContext().getRealPath("/") + "resources/images/uploaded";
//		String tomcatPath = session.getServletContext().getRealPath("/uploaded");
//		String tomcatPath = session.getServletContext().getRealPath("/resources/upload");
//		log.info("path=" + tomcatPath);

//		int postId = diyService.savePost(loginUser, postRequest, tomcatPath);
		
		int postId = diyService.savePost(loginUser, postRequest);
				
//		int postId = diyService.savePostAndImage(loginUser, postRequest);
		
	    return new ResponseEntity<>(postId, HttpStatus.OK);
	}

//    private void sendFile() {
//    	webClient webClient = WebClient.create();
//
//    	// API 요청을 보낼 URL
//    	String apiUrl = "http://example.com/upload";
//
//    	// 파일 경로
//    	String filePath = "/path/to/your/file";
//
//    	// Multipart 요청 본문 생성
//    	MultiValueMap<String, Object> body = new MultipartBodyBuilder()
//    	        .part("files", new FileSystemResource(filePath))
//    	        .build();
//
//    	// API 요청 보내고 응답 받기
//    	String responseBody = webClient.post()
//    	        .uri(apiUrl)
//    	        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
//    	        .contentType(MediaType.MULTIPART_FORM_DATA)
//    	        .bodyValue(body)
//    	        .retrieve()
//    	        .bodyToMono(String.class)
//    	        .block();
//    	// 원하는 처리 수행
//    }
    
}
