package tamanna.challange.interviews.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Interview;
import tamanna.challange.interviews.service.Candidate.ICandidateService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Api(description = "Candidate Endpoint", value = "CandidateController" , produces = MediaType.APPLICATION_JSON_VALUE)
public class CandidateController {
    @Autowired
    ICandidateService iCandidateService;

    @GetMapping("/api/candidates")
    @ApiOperation(value = "Get all Candidates")
    public ResponseEntity<Object> getCandidates(){
        return new ResponseEntity<>(iCandidateService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/candidates/{candidateId}")
    @ApiOperation(value = "Get a Candidate by Id")
    public ResponseEntity<Object> getCandidateById(@PathVariable(name="candidateId") Long candidateId){
        return new ResponseEntity<>(iCandidateService.getCandidateById(candidateId), HttpStatus.OK);
    }

    @PostMapping("/api/candidates")
    @ApiOperation(value = "Insert a new Candidate")
    public ResponseEntity<Object> insertCandidate(Candidate candidates){
        iCandidateService.insertCandidates(candidates);
        return new ResponseEntity<>("A new Candidate is created successfully!", HttpStatus.CREATED);

    }

    @PostMapping("/api/candidates/{candidateId}/requestDates")
    @ApiOperation(value = "Set Candidate Request Interview Dates")
    public ResponseEntity<Object> setCandidateRequestDates(@PathVariable(name="candidateId") Long candidateId,
                                        @RequestParam("requestDate")
                                        @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") List<LocalDateTime> requestDates){
        iCandidateService.setCandidateRequestDates(candidateId , requestDates);
        return new ResponseEntity<>("Interview Date requested successsfully for candidate with Id "+candidateId,HttpStatus.CREATED);
    }

    @GetMapping("/api/candidates/{candidateId}/requestedDates")
    @ApiOperation(value = "Get requested Interviews by Candidate ID")
    public ResponseEntity<Object>  getRequestedInterviewDatesByCandidate (@PathVariable(name="candidateId") Long candidateId){
        return new ResponseEntity<>(iCandidateService.getRequestedDatesByCandidate(candidateId),HttpStatus.OK);
    }

    @PostMapping("/api/candidates/{candidateId}/scheduleInterview")
    @ApiOperation(value = "Schedule Interview by Candidate ID")
    public ResponseEntity<Object> scheduleInterviewForCandidate (@PathVariable(name="candidateId") Long candidateId){
        iCandidateService.scheduleInterviewForCandidate(candidateId);
        return new ResponseEntity<>("Interview Slot is created successsfully for candidate with Id "+candidateId, HttpStatus.OK);
    }

    @PutMapping("/api/candidates/{candidateId}/updateInterview")
    @ApiOperation(value = "ReSchedule Interview by Candidate ID")
    public ResponseEntity<Object> rescheduleInterviewForCandidate (@PathVariable(name="candidateId") Long candidateId, @RequestBody Interview interview){
        iCandidateService.rescheduleInterviewForCandidate(candidateId, interview);
        return new ResponseEntity<>("Interview Slot is updated successsfully for candidate with Id "+candidateId, HttpStatus.OK);
    }
}
