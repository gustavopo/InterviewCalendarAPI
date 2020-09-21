package tamanna.challange.interviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tamanna.challange.interviews.model.Schedule.AvailableInterviewDates;
import tamanna.challange.interviews.model.Person.Interviewer;
import tamanna.challange.interviews.service.Interviewer.IInterviewerService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class InterviewerController {
    @Autowired
    IInterviewerService iInterviewerService;

    public void setiInterviewerService(IInterviewerService iInterviewerService) {
        this.iInterviewerService = iInterviewerService;
    }
    @GetMapping("/api/interviewers")
    public List<Interviewer> getInterviewers(){
        return iInterviewerService.getAll();
    }

    @GetMapping("/api/interviewers/{interviewerId}")
    public Interviewer getInterviewerById(@PathVariable(name="interviewerId") Integer interviewerId){
        return iInterviewerService.getInterviewerById(interviewerId).get();
    }

    @PostMapping("/api/interviewers")
    public void insertInterviewer(Interviewer interviewers){
        iInterviewerService.insertInterviewer(interviewers);
        System.out.println("Interviewer Saved Successfully");
    }

    @PostMapping("/api/interviewers/{interviewerId}/setAvailableDates")
    public void setInterviewerAvailableDates(@PathVariable(name="interviewerId") Integer interviewerId,
                                   @RequestParam("availableDates")
                                   @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") List<LocalDateTime> availableDates){
        iInterviewerService.setInterviewerAvailableDates(interviewerId,availableDates);
        System.out.println("Set slot Ok");
    }

    @GetMapping("/api/interviewers/{interviewerId}/availableDates")
    public List<AvailableInterviewDates> getAvailableDatesByInterviewer (@PathVariable(name="interviewerId") Integer interviewerId){
        return iInterviewerService.getAvailableDatesByInterviewer(interviewerId);
    }

}
