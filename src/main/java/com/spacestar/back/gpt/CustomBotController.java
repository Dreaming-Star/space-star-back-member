package com.spacestar.back.gpt;

import com.spacestar.back.profile.domain.Profile;
import com.spacestar.back.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bot")
public class CustomBotController {


    @Autowired
    private RestTemplate template;
    private final ProfileRepository profileRepository;
    @GetMapping("/chat/{profileId}")
    public String chat(@PathVariable Long profileId){
        List<Profile> profleList = profileRepository.findAll();
        Profile profile = profileRepository.findById(profileId).orElseThrow();
        String profileListStr = profleList.stream()
                .map(Profile::toString)
                .collect(Collectors.joining(", "));
        System.out.println("프로필 전체 목록 = " + profileListStr);
        String prompt = String.format("이 사람들을 [%s] 이 사람과 성향이 잘 맞는 순서대로 이 사람을 제외하고 10명까지 출력해줘. 출력 형식은 각 유저의 uuid를 리스트로 반환해줘 [8bf8c52e-91d8-40cb-af8c-ee87600bc0b5,a79baf4a-7696-459a-8d65-54a9cb71e39e,38f8d9fa-13d7-478b-aa25-e0db4a8e6af4] 이런식으로 반환해줘", profile.toString());
        System.out.println("prompt = " + prompt);
        ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo", profileListStr + prompt);
        ChatGPTResponse chatGPTResponse =  template.postForObject("https://api.openai.com/v1/chat/completions", request, ChatGPTResponse.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

}