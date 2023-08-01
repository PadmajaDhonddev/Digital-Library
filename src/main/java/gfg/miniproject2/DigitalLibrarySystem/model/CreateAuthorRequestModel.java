package gfg.miniproject2.DigitalLibrarySystem.model;

import jakarta.persistence.Column;

public class CreateAuthorRequestModel {

    private String authorId;
    private String authorName;
    private String authorEmail;
    private int authorAge;
    private String authorCountry;

    public CreateAuthorRequestModel() {
        super();
    }

    public CreateAuthorRequestModel(String authorId, String authorName, String authorEmail, int authorAge, String authorCountry) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorAge = authorAge;
        this.authorCountry = authorCountry;
    }

    public CreateAuthorRequestModel(String authorName, String authorEmail, int authorAge, String authorCountry) {
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authorAge = authorAge;
        this.authorCountry = authorCountry;
    }

    public String getAuthorId() {
        return authorId;
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
        return "CreateAuthorRequestModel{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authorEmail='" + authorEmail + '\'' +
                ", authorAge=" + authorAge +
                ", authorCountry='" + authorCountry + '\'' +
                '}';
    }
}
