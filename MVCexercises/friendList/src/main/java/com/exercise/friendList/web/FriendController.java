package com.exercise.friendList.web;

import com.exercise.friendList.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendController {
    private List<Friend> friends = new ArrayList<>();

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("friends", friends);
        return "index";
    }

    @PostMapping("/addFriend")
    public String addFriend(@RequestParam String friendName) {
        Friend friend = new Friend(friendName);
        friends.add(friend);
        return "redirect:/index";
    }
}