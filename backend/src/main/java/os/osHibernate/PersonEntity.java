package os.osHibernate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity

@NamedNativeQuery(name = "StudentOnCourse",
        query = """
                SELECT  p.lastname, p.firstname,  COUNT(cws.course_with_student_id) AS courseTotalCount
                FROM person p  LEFT  JOIN course_with_student cws ON p.person_id = cws.person_id
                WHERE p.role = 'student'
                    GROUP BY p.person_id
                ORDER BY lastname;
                """,
        resultSetMapping = "StudentOnCourseMapping")
@SqlResultSetMapping(name = "StudentOnCourseMapping",
        classes = {
                @ConstructorResult(
                        columns = {
                                @ColumnResult(name = "lastname"),
                                @ColumnResult(name = "firstname"),
                                @ColumnResult(name = "courseTotalCount", type = int.class),
                        },
                        targetClass = StudentOnCourse.class
                )}
)


@Table(name = "person", schema = "online_school")
public class PersonEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id", nullable = false)
    private int personId;
    @Basic
    @NotNull
    @Column(name = "lastname", nullable = true, length = 100)
    private String lastname;
    @Basic
    @Column(name = "firstname", nullable = true, length = 50)
    private String firstname;
    @Basic
    @Column(name = "phone", nullable = true, length = 13)
    private String phone;
    @Basic
    @NotNull
    @Email()
    @Column(name = "email", nullable = true, length = 100)
    private String email;
    @Basic
    @NotNull
    @Column(name = "role", nullable = false)
    private Object role;
    @ManyToMany
    @JoinTable(name = "course_with_student",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<CourseEntity> course;
    @Transient
    private int courseTotal;

    public int getCourseTotal() {
        return courseTotal;
    }

    public void setCourseTotal(int courseTotal) {
        this.courseTotal = courseTotal;
    }

    public List<CourseEntity> getCourse() {
        return course;
    }

    public void setCourse(List<CourseEntity> course) {
        this.course = course;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEntity person = (PersonEntity) o;
        return personId == person.personId && courseTotal == person.courseTotal && Objects.equals(lastname, person.lastname) && Objects.equals(firstname, person.firstname) && Objects.equals(phone, person.phone) && Objects.equals(email, person.email) && Objects.equals(role, person.role) && Objects.equals(course, person.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, lastname, firstname, phone, email, role, course, courseTotal);
    }

    @Override
    public String toString() {
        return "PersonEntity{" +
                "personId=" + personId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +

                '}';
    }
}
