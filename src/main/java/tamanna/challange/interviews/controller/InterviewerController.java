package tamanna.challange.interviews.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tamanna.challange.interviews.model.Person.Interviewer;
import tamanna.challange.interviews.service.Interviewer.IInterviewerService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Api(description = "Interviewer Endpoint", value = "InterviewerController" , produces = MediaType.APPLICATION_JSON_VALUE)
public class InterviewerController {
    @Autowired
    IInterviewerService iInterviewerService;

    @GetMapping("/api/interviewers")
    @ApiOperation(value = "Get all Interviewers")
    public ResponseEntity<Object> getInterviewers(){
        return new ResponseEntity<>(iInterviewerService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/interviewers/{interviewerId}")
    @ApiOperation(value = "Get an Interviewer by Id")
    public ResponseEntity<Object> getInterviewerById(@PathVariable(name="interviewerId") Long interviewerId){
        return new ResponseEntity<>( iInterviewerService.getInterviewerById(interviewerId),HttpStatus.OK);
    }

    @PostMapping("/api/interviewers")
    @ApiOperation(value = "Insert new Interviewer")
    public ResponseEntity<Object> insertInterviewer(Interviewer interviewers){
        iInterviewerService.insertInterviewer(interviewers);
        return new ResponseEntity<>("A new Interviewer is created successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/api/interviewers/{interviewerId}/setAvailableDates")
    @ApiOperation(value = "Set Interviewer Available Interview Dates")
    public ResponseEntity<Object> setInterviewerAvailableDates(@PathVariable(name="interviewerId") Long interviewerId,
                                   @RequestParam("availableDates")
                                   @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") List<LocalDateTime> availableDates){
        iInterviewerService.setInterviewerAvailableDates(interviewerId,availableDates);
        return new ResponseEntity<>("Available Date registered successsfully for interviewer with Id "+interviewerId,HttpStatus.CREATED);
    }

    @GetMapping("/api/interviewers/{interviewerId}/availableDates")
    @ApiOperation(value = "Get available Interviews by Interviewer ID")
    public ResponseEntity<Object> getAvailableDatesByInterviewer (@PathVariable(name="interviewerId") Long interviewerId){
        return new ResponseEntity<>(iInterviewerService.getAvailableDatesByInterviewer(interviewerId), HttpStatus.OK);
    }

}
