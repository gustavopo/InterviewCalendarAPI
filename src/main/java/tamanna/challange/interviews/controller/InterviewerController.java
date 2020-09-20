package tamanna.challange.interviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tamanna.challange.interviews.model.Interviewer;
import tamanna.challange.interviews.service.Interviewer.IInterviewerService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/interviewers/{id}")
    public Optional<Interviewer> getInterviewerById(@PathVariable(name="interviewerId") Integer interviewerId){
        return iInterviewerService.getInterviewerById(interviewerId);
    }

    @PostMapping("/api/interviewers")
    public void insertInterviewer(Interviewer interviewers){
        iInterviewerService.insertInterviewer(interviewers);
        System.out.println("Interviewer Saved Successfully");
    }

    @PostMapping("/api/interviewers/{id}/setSlot")
    public void setInterviewerSlot(@PathVariable(name="interviewerId") Integer interviewerId){
        iInterviewerService.getAvailableSlots(interviewerId);
        System.out.println("Set slot Ok");
    }

}
