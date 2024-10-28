package com.simplilearn.zumbamanagement.Admins.servlets;

import com.simplilearn.zumbamanagement.Admins.models.Participant;
import com.simplilearn.zumbamanagement.Admins.service.ParticipantService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/participants")
public class ParticipantController extends HttpServlet {
    private ParticipantService participantService;

    @Override
    public void init() throws ServletException {
        participantService = new ParticipantService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action == null ? "list" : action) {
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                participantService.deleteParticipant(deleteId);
                response.sendRedirect("participants?action=list");
                break;

            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                Participant participant = participantService.getParticipantById(editId);
                request.setAttribute("participant", participant);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Participants.jsp");
                dispatcher.forward(request, response);
                break;

            case "list":
            default:
                List<Participant> participants = participantService.getAllParticipants();
                request.setAttribute("participants", participants);
                RequestDispatcher listDispatcher = request.getRequestDispatcher("Participants.jsp");
                listDispatcher.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int batchId = Integer.parseInt(request.getParameter("batchId"));
            participantService.addParticipant(name, email, phone, batchId);
            response.sendRedirect("participants?action=list");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int batchId = Integer.parseInt(request.getParameter("batchId"));
            participantService.updateParticipant(id, name, email, phone, batchId);
            response.sendRedirect("participants?action=list");
        }
    }
}
