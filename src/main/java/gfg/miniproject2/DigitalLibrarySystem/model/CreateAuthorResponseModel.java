package gfg.miniproject2.DigitalLibrarySystem.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateAuthorResponseModel {
    private UUID authorId;
    private String authorName;
    private String authorEmail;
    private int authorAge;
    private String authorCountry;
/*
    public CreateAuthorResponseModel() {
        super();
    }

    public CreateAuthorResponseModel(String authorId, String authorName, String authorEmail, int authorAge, String authorCountry) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorAge = authorAge;
        this.authorCountry = authorCountry;
    }

    public String getAuthorId() {
        return authorId.toString();
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
        return "CreateAuthorResponseModel{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorAge=" + authorAge +
                ", authorCountry='" + authorCountry + '\'' +
                '}';
    }*/
}
