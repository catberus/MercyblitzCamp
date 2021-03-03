package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collection;
import java.util.List;

@Path("/register")
public class UserListController implements PageController {

    private UserService userService = new UserServiceImpl();


    @GET
    @Path("/success")
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {

        Collection<User> userList = userService.getAll();
        request.setAttribute("userList",userList);
        return "success.jsp";
    }
}
