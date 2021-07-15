package final_project;

import java.io.*;

public class Save_Data
{
  private static ObjectOutputStream dos = null;
  private static File tempFile;

  public static void save(Record[] record, String directory, String file_name)
  { tempFile = new File(directory, file_name);

  //This function will write in object stream

  try
    {  dos = new ObjectOutputStream(new FileOutputStream(tempFile));
       Record length= new Record(record.length); //it will write the first Record with year
       dos.writeObject( (Record)length );        //as a count for how many records in the collection
       for (int i = 0; i < record.length; i++)
           { dos.writeObject( (Record)record[i] );
           }
    }
              catch (NotSerializableException se)
              { System.err.println(se);
               }
              catch (FileNotFoundException fe)
              { System.err.println(fe);
               }
              catch (IOException se)
              { System.err.println(se);
              }

    finally
    {  try
       { if (dos != null) dos.close();
       }
       catch(IOException ex)
       {  System.out.println(ex);
       }
    }
  }
}