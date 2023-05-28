package com.codals.greating.mypage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

    @GetMapping
    public String loadMain() {
        /**
         * my-main.jsp 예정
         */
        return "mypage/mypage-main";
    }

    @GetMapping("/diets")
    public String loadMyDietPage() {
        return "user/mypage-mydiy";
    }

    @GetMapping("/scrap")
    public String loadMyScrapPage() {
        return "user/mypage-myscrap"; // mypage/my-scrap
    }

    @GetMapping("/voted")
    public String loadMyVotedPage() {
        /**
         * my-voted.jsp 예정
         */
        return "mypage/my-voted";
    }

    @GetMapping("/profile")
    public String loadProfilePage() {
        /**
         * my-profile.jsp 예정
         */
        return "mypage/my-profile";
    }
}
