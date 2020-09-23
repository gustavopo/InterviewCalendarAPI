package tamanna.challange.interviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.model.Slot;
import tamanna.challange.interviews.service.Candidate.ICandidateService;

import java.time.LocalDateTime;
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

    @PostMapping("/api/candidates/{candidateId}/requestDates")
    public void setCandidateRequestDates(@PathVariable(name="candidateId") Integer candidateId,
                                        @RequestParam("requestDate")
                                        @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") List<LocalDateTime> requestDates){
        iCandidateService.setCandidateRequestDates(candidateId , requestDates);
    }

    @GetMapping("/api/candidates/{candidateId}/requestedDates")
    public List<RequestedInterviewDates> getRequestedInterviewDatesByCandidate (@PathVariable(name="candidateId") Integer candidateId){
        return iCandidateService.getRequestedDatesByCandidate(candidateId);
    }

    @PostMapping("/api/candidates/{candidateId}/scheduleInterview")
    public void scheduleInterviewForCandidate (@PathVariable(name="candidateId") Integer candidateId){
        iCandidateService.scheduleInterviewForCandidate(candidateId);
    }

    @PutMapping("/api/candidates/{candidateId}/updateInterview")
    public void rescheduleInterviewForCandidate (@PathVariable(name="candidateId") Integer candidateId, @RequestBody Slot slot){
        iCandidateService.rescheduleInterviewForCandidate(candidateId,slot);
    }
}
