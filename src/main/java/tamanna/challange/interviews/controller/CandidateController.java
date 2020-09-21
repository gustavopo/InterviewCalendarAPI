package tamanna.challange.interviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tamanna.challange.interviews.model.Candidate;
import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.service.Candidate.ICandidateService;
import tamanna.challange.interviews.service.Interviewer.IInterviewerService;

import java.util.List;
import java.util.Optional;

@RestController
public class CandidateController {
    @Autowired
    ICandidateService iCandidateService;

    public void setiCandidateService(ICandidateService iCandidateService) {
        this.iCandidateService = iCandidateService;
    }

    @GetMapping("/api/candidates")
    public List<Candidate> getCandidates(){
        return iCandidateService.getAll();
    }

    @GetMapping("/api/candidates/{candidateId}")
    public Optional<Candidate> getCandidateById(@PathVariable(name="candidateId") Integer candidateId){
        return iCandidateService.getCandidateById(candidateId);
    }

    @PostMapping("/api/candidates")
    public void insertCandidate(Candidate candidates){
        iCandidateService.insertCandidates(candidates);
        System.out.println("Candidate Saved Successfully");
    }

    /*@PostMapping("/api/interviewers/{id}/requestSlot")
    public void setCandidateRequestSlot(@PathVariable(name="candidateId") Integer candidateId){
        iCandidateService.getCandidateRequestSlot(candidateId);
    }*/

}
