package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity // JPA를 사용하는 클래스로 인식하기 위해서 꼭 입력해야 함
public class Member {
    public Member() {
    }

    @Id // JPA에게 PK가 뭔지 알려주어야 함, javax.persistence 밑에 있는 것을 선택
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;
}
