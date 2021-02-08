package com.example.feedback.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback.model.Feedback;
import com.example.feedback.repository.FeedbackRepository;

@RestController
public class FeedbackController {


    @Autowired
    private FeedbackRepository repo;


    @GetMapping("/")
    public String showServiceName()
    {
		return "Feedback";
    }

    @GetMapping("/feedback/{id}")
    public Feedback showFeedbackById(@PathVariable Integer id)
    {


        return repo.findById(id).get();

    }


    @PostMapping("/submitfeedback")
    public Feedback addFeedback(@RequestBody Feedback newFeedback) {



        return repo.save(newFeedback);

    }


}
