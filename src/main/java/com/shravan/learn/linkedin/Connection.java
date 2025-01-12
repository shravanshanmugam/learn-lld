package com.shravan.learn.linkedin;

import java.util.Objects;

public class Connection {
    private final User user;
    private final long connectionDate;

    public Connection(User user, long connectionDate) {
        this.user = user;
        this.connectionDate = connectionDate;
    }

    public User getUser() {
        return user;
    }

    public long getConnectionDate() {
        return connectionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Connection)) return false;
        Connection that = (Connection) o;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user);
    }
}
