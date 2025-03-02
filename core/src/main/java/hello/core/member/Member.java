package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade Grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.Grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return Grade;
    }

    public void setGrade(Grade grade) {
        this.Grade = grade;
    }
}
