package com.contactmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmanager.dao.ContactDao;
import com.contactmanager.model.Contact;

/**
 * Handles creation of new contacts.
 */
public class AddContactServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final ContactDao dao = new ContactDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        if (name != null) name = name.trim();
        if (phone != null) phone = phone.trim();
        if (email != null) email = email.trim();

        // Basic validation
        if (name == null || name.isEmpty()
                || phone == null || phone.isEmpty()
                || email == null || email.isEmpty()) {

            request.setAttribute("errorMessage", "All fields (name, phone, email) are mandatory.");
            request.setAttribute("name", name);
            request.setAttribute("phone", phone);
            request.setAttribute("email", email);
            request.getRequestDispatcher("/addContact.jsp").forward(request, response);
            return;
        }

        Contact contact = new Contact(name, phone, email);
        dao.addContact(contact);

        // Add success message and redirect to list page
        response.sendRedirect(request.getContextPath() + "/viewContacts?message=Contact+added+successfully");
    }
}
