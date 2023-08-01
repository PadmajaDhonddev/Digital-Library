package gfg.miniproject2.DigitalLibrarySystem.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.UUID;

@Entity(name = "Table")
@Table(name = "`Proj2Author`")
public class Author {
    @Id
    @GeneratedValue
    @Column(name = "`id`", columnDefinition = "BINARY(16)")
    private UUID authorId;
    @Column(name = "`name`")
    private String authorName;
    @Column(name = "`email`")
    private String authorEmail;
    @Column(name = "`age`")
    private int authorAge;
    @Column(name = "`country`")
    private String authorCountry;

    public Author(UUID authorId, String authorName, String authorEmail, int authorAge, String authorCountry) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorAge = authorAge;
        this.authorCountry = authorCountry;
    }

    public Author() {
        super();
    }

    public Author(String authorName, String authorEmail, int authorAge, String authorCountry) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorAge = authorAge;
        this.authorCountry = authorCountry;
    }

    public String getAuthorId() {
        return authorId.toString();
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorAge=" + authorAge +
                ", authorCountry='" + authorCountry + '\'' +
                '}';
    }
}
