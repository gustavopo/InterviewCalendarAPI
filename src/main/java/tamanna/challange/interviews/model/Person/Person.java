package tamanna.challange.interviews.model.Person;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
