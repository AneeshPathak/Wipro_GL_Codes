package com.contactmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactmanager.dao.ContactDao;
import com.contactmanager.model.Contact;

/**
 * Handles modifying an existing contact.
 */
public class EditContactServlet extends HttpServlet {

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
            // ignore, will be treated as invalid index
        }

        Contact contact = dao.getContact(index);
        if (contact == null) {
            response.sendRedirect(request.getContextPath() + "/viewContacts?message=Contact+not+found");
            return;
        }

        request.setAttribute("id", index);
        request.setAttribute("contact", contact);
        request.getRequestDispatcher("/editContact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        int index = -1;
        try {
            index = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            // invalid id
        }

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        if (name != null) name = name.trim();
        if (phone != null) phone = phone.trim();
        if (email != null) email = email.trim();

        if (name == null || name.isEmpty()
                || phone == null || phone.isEmpty()
                || email == null || email.isEmpty()) {

            request.setAttribute("errorMessage", "All fields (name, phone, email) are mandatory.");
            request.setAttribute("id", index);
            request.setAttribute("contact", new Contact(name, phone, email));
            request.getRequestDispatcher("/editContact.jsp").forward(request, response);
            return;
        }

        Contact updated = new Contact(name, phone, email);
        boolean updatedOk = dao.updateContact(index, updated);

        if (!updatedOk) {
            response.sendRedirect(request.getContextPath() + "/viewContacts?message=Unable+to+update+contact");
        } else {
            response.sendRedirect(request.getContextPath() + "/viewContacts?message=Contact+updated+successfully");
        }
    }
}
