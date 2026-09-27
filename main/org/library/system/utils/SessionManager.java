package org.library.system.utils;

import org.library.system.enums.Role;
import org.library.system.model.User;

public class SessionManager {
    private static SessionManager instance;
    private User currentUser;
    private SessionManager() {}

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public boolean login(User user, String passwordInput) {
        if (user != null && user.getActive() && user.getPassword_hash().equals(passwordInput)) {
            this.currentUser = user;
            return true;
        }
        return false;
    }

    public void logout() {
        if (currentUser != null) {
            this.currentUser = null;
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean hasRole(Role requiredRole) {
        if (!isLoggedIn()) {
            return false;
        }
        return currentUser.getUser_role() == requiredRole;
    }
}
