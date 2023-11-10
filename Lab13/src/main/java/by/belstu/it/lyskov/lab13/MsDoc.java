package by.belstu.it.lyskov.lab13;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.*;

public class MsDoc extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String docDir = getServletContext().getInitParameter("doc-dir");
        String filename = req.getParameter("file");
        File doc = new File(docDir + "\\" + filename);
        if (doc.exists())
            outputDoc(doc, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String docDir = req.getServletContext().getInitParameter("doc-dir");
        for (Part part : req.getParts()) {
            part.write(docDir + "\\" + fileName);
        }
        writer.print("The file uploaded sucessfully");
    }

    private void outputDoc(File doc, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/msword");
        resp.addHeader("Content-Disposition", "attachment; filename=" + doc.getName());
        resp.setContentLength((int) doc.length());
        FileInputStream in = new FileInputStream(doc);
        BufferedInputStream buf = new BufferedInputStream(in);
        ServletOutputStream out = resp.getOutputStream();
        int readBytes;
        while ((readBytes = buf.read()) != -1)
            out.write(readBytes);
    }
}