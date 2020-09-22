package tamanna.challange.interviews.CandidateTests;

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
import org.springframework.test.context.junit4.SpringRunner;
import tamanna.challange.interviews.model.Person.Candidate;
import tamanna.challange.interviews.model.Person.Interviewer;
import tamanna.challange.interviews.repository.CandidateRepository;
import tamanna.challange.interviews.service.Candidate.CandidateService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCandidateService {
    @InjectMocks
    private CandidateService candidateService;
    @Mock
    private CandidateRepository candidateRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllCandidatesTest()
    {
        List<Candidate> list = new LinkedList<>();
        Candidate i1 = new Candidate(1L,"Name1");
        Candidate i2 = new Candidate(2L,"Name2");
        list.add(i1);
        list.add(i2);

        when(candidateRepository.findAll()).thenReturn(list);

        List<Candidate> canList = candidateService.getAll();
        assertEquals(2, canList.size());
        verify(candidateRepository,times(1)).findAll();
    }

    @Test
    public void getInterviewerByIdTest()
    {
        when(candidateRepository.findById(1L)).thenReturn(java.util.Optional.of(new Candidate(1L,"Francisco")));
        Candidate c = candidateService.getCandidateById(1L);

        assertEquals(1L, c.getId().longValue());
        assertEquals("Francisco", c.getName());
    }

    //Testing error 404 after request
    @Test
    public void givenCandidateDoesNotExists_then404IsReceived() throws IOException {
        HttpUriRequest request = new HttpGet( "http://localhost:8080/api/candidates/" + 50 );
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.NOT_FOUND.value());
    }

    //TODO : GET INTERVIEWERS BASED ON CANDIDATE ID
}
