package com.polixis.kafka.kafkapolixis.controller;

import com.polixis.kafka.kafkapolixis.service.MessagesService;
import com.polixis.kafka.kafkapolixis.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final MessagesService messagesService;
    private final ProducerService producerService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("inputData", "");
        log.info("Main page");
        return "send-message";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam("inputData") String inputData, Model model) {
        log.info("Input data: " + inputData);
        producerService.save(inputData);
        return mainPage(model);
    }

    @GetMapping("/list")
    public String listMessages(Model model) {
        model.addAttribute("messagesList", messagesService.getAllMessages());
        log.info("List Messages");
        return "messages-list";
    }


}
