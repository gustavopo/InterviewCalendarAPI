package tamanna.challange.interviews.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
}
