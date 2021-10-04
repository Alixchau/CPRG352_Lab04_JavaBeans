
package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Alix
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //to read note.txt
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        String title = br.readLine();

        String content = br.readLine();
        br.close();
        //create a note object
        Note n1 = new Note(title, content);

        //create an attribute that contains the note object
        request.setAttribute("note", n1);

        String editPara = request.getParameter("edit");
        //edit parameter's value is NULL initially
        if (editPara == null) {

            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

            return;
        //parameter is "" for edit ( there's no assigned value after edit 
        } else if (editPara == "") {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }

        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //retrieve parameters from the edit content
        String editTitle = request.getParameter("edit_title");
        String editContent = request.getParameter("edit_contents");

        //write edit info to file
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        pw.println(editTitle);

        pw.println(editContent);

        pw.close();
        Note n2 = new Note(editTitle, editContent);

        request.setAttribute("note", n2);
        //have the servlet to call upon viewnote.jsp after saved the edit notes       
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    }

}
