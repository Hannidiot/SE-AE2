package team.se.ae2.ui;

import team.se.ae2.model.User;

public interface IPermissionControl {
    User.Role[] getPermittedRoles();
}
