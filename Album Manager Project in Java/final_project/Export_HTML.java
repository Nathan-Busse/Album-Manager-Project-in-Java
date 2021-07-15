package final_project;

import java.io.*;

public class Export_HTML
{

  private static PrintWriter dos = null;
  private static File tempFile = null;

  //it will use printwriter stream to write output for HTML

  public static void Export_HTML(Record[] record, String directory, String file_name)
  {
     tempFile = new File(directory, file_name + ".html"); //add an html extension to all the file name

     try
        {    //write a header and a table for the HTML file
             dos = new PrintWriter(new FileOutputStream(tempFile), true);
             dos.println("<HTML>");
             dos.println("<TITLE> Album Collector </TITLE> ");
             dos.println("<CENTER><h1><font size =25 color=BLACK>Album List</h1><CENTER>");
             dos.println("<BODY>");
             dos.println("<table border=0 width=80%><tr>");
             dos.println("<td width=20%> <b> <font size=3 color=BLACK>Title</b><br></td>");
             dos.println("<td width=20%> <b> <font size=3 color=BLACK>Artist</b><br></td>");
             dos.println("<td width=20%> <b> <font size=3 color=BLACK>Company</b><br></td>");
             dos.println("<td width=20%> <b> <font size=3 color=BLACK>Genre</b><br></td>");
             dos.println("<td width=20%> <b> <font size=3 color=BLACK>Year</b><br></td>");
             //write all title, artist, company, genre and year in the collection in a table
             for (int i=0; i < record.length; i++)
                 { dos.println("<table border=0 width=80%><tr>");
                   dos.println("<td width=20%> <b> <font size=2 color=BLACK>" + record[i].getTitle() + "</b><br></td>");
                   dos.println("<td width=20%> <b> <font size=2 color=BLACK>" + record[i].getArtist() + "</b><br></td>");
                   dos.println("<td width=20%> <b> <font size=2 color=BLACK>" + record[i].getCompany() + "</b><br></td>");
                   dos.println("<td width=20%> <b> <font size=2 color=BLACK>" + record[i].getGenre() + "</b><br></td>");
                   dos.println("<td width=20%> <b> <font size=2 color=BLACK>" + record[i].getYear() + "</b><br></td>");
                 }
              dos.println("</BODY>");
              dos.println("</HTML>");

        }
      catch (FileNotFoundException fe)
           { System.err.println(fe);
           }
      catch (IOException se)
            { System.err.println(se);
            }

  }
}