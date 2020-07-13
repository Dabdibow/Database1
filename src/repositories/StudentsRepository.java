package repositories;
import entities.*;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student>{

    List<Student> findAllByAge(int age);

}
