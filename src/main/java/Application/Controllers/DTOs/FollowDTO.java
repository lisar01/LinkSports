package Application.Controllers.DTOs;

import Application.Model.User;

public class FollowDTO {
    public String loggedUsername;
    public User toFollow;

    public FollowDTO(String loggedUsername, User toFollow) {
        this.loggedUsername = loggedUsername;
        this.toFollow = toFollow;
    }

    public FollowDTO() { }

    public String getFollower() { return loggedUsername; }
    public User getToFollow() { return toFollow; }
}
