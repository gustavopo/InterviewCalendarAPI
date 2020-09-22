package tamanna.challange.interviews.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
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
    public List<Interviewer> getInterviewers(){
        return iInterviewerService.getAll();
    }

    @GetMapping("/api/interviewers/{interviewerId}")
    @ApiOperation(value = "Get an Interviewer by Id")
    public Interviewer getInterviewerById(@PathVariable(name="interviewerId") Integer interviewerId){
        return iInterviewerService.getInterviewerById(interviewerId).get();
    }

    @PostMapping("/api/interviewers")
    @ApiOperation(value = "Insert new Interviewer")
    public void insertInterviewer(Interviewer interviewers){
        iInterviewerService.insertInterviewer(interviewers);
        System.out.println("Interviewer Saved Successfully");
    }

    @PostMapping("/api/interviewers/{interviewerId}/setAvailableDates")
    @ApiOperation(value = "Set Interviewer Available Interview Dates")
    public void setInterviewerAvailableDates(@PathVariable(name="interviewerId") Integer interviewerId,
                                   @RequestParam("availableDates")
                                   @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") List<LocalDateTime> availableDates){
        iInterviewerService.setInterviewerAvailableDates(interviewerId,availableDates);
        System.out.println("Set slot Ok");
    }

    @GetMapping("/api/interviewers/{interviewerId}/availableDates")
    @ApiOperation(value = "Get available Interviews by Interviewer ID")
    public List<AvailableInterviewDates> getAvailableDatesByInterviewer (@PathVariable(name="interviewerId") Integer interviewerId){
        return iInterviewerService.getAvailableDatesByInterviewer(interviewerId);
    }

}
