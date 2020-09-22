package tamanna.challange.interviews.InterviewerTest;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import tamanna.challange.interviews.model.Person.Interviewer;
import tamanna.challange.interviews.repository.InterviewerRepository;
import tamanna.challange.interviews.service.Interviewer.InterviewerService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestInterviewerService {

    @InjectMocks
    InterviewerService interviewerService;

    @Mock
    InterviewerRepository interviewerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllInterviewersTest()
    {
        List<Interviewer> list = new LinkedList<>();
        Interviewer i1 = new Interviewer(1L,"Name1");
        Interviewer i2 = new Interviewer(2L,"Name2");
        list.add(i1);
        list.add(i2);

        when(interviewerRepository.findAll()).thenReturn(list);

        List<Interviewer> intList = interviewerService.getAll();
        assertEquals(2, intList.size());
        verify(interviewerRepository,times(1)).findAll();
    }

    @Test
    public void getInterviewerByIdTest()
    {
        when(interviewerRepository.findById(1L)).thenReturn(java.util.Optional.of(new Interviewer(1L,"Francisco")));
        Interviewer i = interviewerService.getInterviewerById(1L);

        assertEquals(1L, i.getId().longValue());
        assertEquals("Francisco", i.getName());
    }

    @Test
    public void givenInterviewerDoesNotExists_then404IsReceived() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/api/interviewers/" + 50 );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.NOT_FOUND.value());
    }

    //TODO : GET CANDIDATES BASED ON INTERVIEWER ID
}
