package tamanna.challange.interviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tamanna.challange.interviews.service.Candidate.ICandidateService;
import tamanna.challange.interviews.service.Interviewer.IInterviewerService;

@RestController
public class CandidateController {
    @Autowired
    ICandidateService iCandidateService;
}
