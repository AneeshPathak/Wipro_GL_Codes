package com.contactmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmanager.dao.ContactDao;

/**
 * Handles deletion of a contact.
 */
public class DeleteContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final ContactDao dao = new ContactDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        int index = -1;
        try {
            index = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            // invalid id
        }

        boolean deleted = dao.deleteContact(index);

        if (deleted) {
            response.sendRedirect(request.getContextPath() + "/viewContacts?message=Contact+deleted+successfully");
        } else {
            response.sendRedirect(request.getContextPath() + "/viewContacts?message=Unable+to+delete+contact");
        }
    }
}
