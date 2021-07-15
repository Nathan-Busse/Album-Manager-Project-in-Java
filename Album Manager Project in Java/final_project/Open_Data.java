package final_project;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class Open_Data {

  private ObjectInputStream dis = null;
  private ObjectOutputStream dos = null;
  private TwoWayList list = new TwoWayList();
  private static int x;
  private int y = 10;
  private static File tempFile;

  public Open_Data(String directory, String file_name)
  { tempFile = new File(directory, file_name);
  }

  public TwoWayList get_List()
  {

    try
    {  dis = new ObjectInputStream(new FileInputStream(tempFile));
       Record length = (Record)dis.readObject();
       x = length.getYear();  //the first Record in the file is the count record
       list.first();
       for (int i = 0; i < x; i++)
           { list.insert( (Record)dis.readObject() );
             list.next();
           }
    }
              catch (NotSerializableException se)
              { System.err.println(se); x = -1;
               }
              catch (FileNotFoundException fe)
              { System.err.println(fe); x = -1;
               }
              catch (IOException se)
              { System.err.println(se); x = -1;
              }
              catch (ClassNotFoundException ce)
              { System.err.println(ce);  x = -1;
              }
              catch (ClassCastException de)
              { System.err.println(de);  x = -1;
              }


    finally
    {  try
       { if (dis != null) dis.close();
       }
       catch(IOException ex)
       {  System.out.println(ex);
       }
    }
  return list;
  }

  public int get_int()
  { return this.x;
  }

}