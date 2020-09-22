package tamanna.challange.interviews.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Schedule.RequestedInterviewDates;
import tamanna.challange.interviews.service.Candidate.ICandidateService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@Api(description = "Candidate Endpoint", value = "CandidateController" , produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateController {
    @Autowired
    ICandidateService iCandidateService;

    @GetMapping("/api/candidates")
    @ApiOperation(value = "Get all Candidates")
    public List<Candidate> getCandidates(){
        return iCandidateService.getAll();
    }

    @GetMapping("/api/candidates/{candidateId}")
    @ApiOperation(value = "Get a Candidate by Id")
    public Candidate getCandidateById(@PathVariable(name="candidateId") Long candidateId){
        return iCandidateService.getCandidateById(candidateId);
    }

    @PostMapping("/api/candidates")
    @ApiOperation(value = "Insert a new Candidate")
    public void insertCandidate(Candidate candidates){
        iCandidateService.insertCandidates(candidates);
        System.out.println("Candidate Saved Successfully");
    }

    @PostMapping("/api/candidates/{candidateId}/requestDates")
    @ApiOperation(value = "Set Candidate Request Interview Dates")
    public void setCandidateRequestDates(@PathVariable(name="candidateId") Long candidateId,
                                        @RequestParam("requestDate")
                                        @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") List<LocalDateTime> requestDates){
        iCandidateService.setCandidateRequestDates(candidateId , requestDates);
    }

    @GetMapping("/api/candidates/{candidateId}/requestedDates")
    @ApiOperation(value = "Get requested Interviews by Candidate ID")
    public List<RequestedInterviewDates> getRequestedInterviewDatesByCandidate (@PathVariable(name="candidateId") Long candidateId){
        return iCandidateService.getRequestedDatesByCandidate(candidateId);
    }


}
