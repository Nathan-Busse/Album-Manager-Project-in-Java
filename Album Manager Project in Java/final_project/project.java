package final_project;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;

public class project extends JFrame implements ActionListener, ItemListener, MouseListener
{
  //Declaration of J component

  private JTextField text_title, text_artist, text_company, text_genre, text_year, text_search, text_replace, text_total, text_current;
  private JLabel label_title, label_artist, label_company, label_genre, label_year, label_total, label_current;

  private JToolBar tool_bar = new JToolBar();
  private JToolBar tool_bar_bottom = new JToolBar();

  private JButton button_save = new JButton();
  private JButton button_open = new JButton();
  private JButton button_new = new JButton();
  private JButton button_close = new JButton();
  private JButton button_export = new JButton();
  private JButton button_next = new JButton();
  private JButton button_previous = new JButton();
  private JButton button_sort_year = new JButton();
  private JButton button_search = new JButton("Search");
  private JButton button_replace = new JButton("Replace");
  private JButton button_delete = new JButton();
  private JButton button_add = new JButton();
  private JButton button_saveas = new JButton();

  private JComboBox drop_down;
  private JComboBox drop_search;
  private JComboBox drop_replace;

  private static JMenuBar jmb = new JMenuBar();
  private static JMenu file_menu = new JMenu("File");
  private static JMenu file_action = new JMenu("Action");
  private static JMenuItem file_exit = new JMenuItem("Exit");
  private static JMenuItem file_new = new JMenuItem("New Collection");
  private static JMenuItem file_save = new JMenuItem("Save");
  private static JMenuItem file_open = new JMenuItem("Open");
  private static JMenuItem file_close = new JMenuItem("Close");
  private static JMenuItem file_export = new JMenuItem("Export to HTML");
  private static JMenuItem file_delete = new JMenuItem("Delete");
  private static JMenuItem file_add = new JMenuItem("Add");
  private static JMenuItem file_saveas = new JMenuItem("Save as");
  private static JMenu help_menu = new JMenu("Help");
  private static JMenuItem help_about = new JMenuItem("About");

  private String filee = null;
  private String directory = null;
  private FileDialog file_dialog_open, file_dialog_close;

  private TwoWayList list = new TwoWayList();
  private Open_Data open_file;

  private int count = -1;
  private int count_search;
  private int count_replace = 5;

  private Record[] list_rec;

  private JPanel panel_replace = new JPanel();
  private JPanel panel_search_drop = new JPanel();
  private JPanel panel_bottom = new JPanel();
  private JPanel panel_search = new JPanel();
  private JPanel panel_drop_replace = new JPanel();
  private JPanel panel_tool = new JPanel();
  private JPanel top_tool_bar = new JPanel();
  private JPanel panel_status = new JPanel();
  private JPanel panel_label = new JPanel();
  private JPanel panel_text = new JPanel();
  private JPanel panel_label_text = new JPanel();

  private int x, y;
  private boolean check_sort = false;



  public static void main(String[] args)
  { project frame = new project();
    frame.pack();
    frame.setJMenuBar(jmb);
    frame.setResizable(false);
    jmb.setBackground(Color.black);
    //add a menu file to a frame
                jmb.add(file_menu); file_menu.setBackground(Color.black); file_menu.setForeground(Color.orange); file_menu.setFont(new Font("Arial", 0, 12));
                file_menu.setBorderPainted(false);
                file_menu.add(file_new); file_new.setBackground(Color.black); file_new.setForeground(Color.orange); file_new.setFont(new Font("Arial", 0, 12));
                file_menu.add(file_open); file_open.setBackground(Color.black); file_open.setForeground(Color.orange); file_open.setFont(new Font("Arial", 0, 12));
                file_menu.add(file_save); file_save.setBackground(Color.black); file_save.setForeground(Color.orange); file_save.setFont(new Font("Arial", 0, 12));
                file_menu.add(file_saveas); file_saveas.setBackground(Color.black); file_saveas.setForeground(Color.orange); file_saveas.setFont(new Font("Arial", 0, 12));
                file_menu.add(file_export); file_export.setBackground(Color.black); file_export.setForeground(Color.orange); file_export.setFont(new Font("Arial", 0, 12));
                file_menu.add(file_close); file_close.setBackground(Color.black); file_close.setForeground(Color.orange); file_close.setFont(new Font("Arial", 0, 12));
                file_menu.add(file_exit); file_exit.setBackground(Color.black); file_exit.setForeground(Color.orange); file_exit.setFont(new Font("Arial", 0, 12));
                file_exit.setBorderPainted(false); file_menu.setFocusPainted(false);
                jmb.add(file_action); file_action.setBackground(Color.black);  file_action.setForeground(Color.orange); file_action.setFont(new Font("Arial", 0, 12));
                file_action.add(file_add); file_add.setBackground(Color.black);  file_add.setForeground(Color.orange); file_add.setFont(new Font("Arial", 0, 12));
                file_action.add(file_delete); file_delete.setBackground(Color.black);  file_delete.setForeground(Color.orange); file_add.setFont(new Font("Arial", 0, 12));

    file_menu.setBackground(Color.black);
    frame.setSize(550, 400);
    frame.setBackground(Color.black);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public project()
  { setTitle("Album Collector");
    setBackground(Color.black);

    set_panel_bottom();  //create all the bottom panel
    set_panel_search();  //create the search panel
    set_panel_top();  //create the panel on top, including tool bar
    set_label_text(); //create label and text field
    set_icon();  //load images into icon

    //add these Panel into the main frame
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(panel_label_text, BorderLayout.CENTER);
    getContentPane().add(panel_bottom, BorderLayout.SOUTH);
    getContentPane().add(top_tool_bar, BorderLayout.NORTH);

    //add responses to these buttons and combobox
    button_open.addActionListener(this);
    button_save.addActionListener(this);
    button_close.addActionListener(this);
    button_new.addActionListener(this);
    button_next.addActionListener(this);
    button_previous.addActionListener(this);
    button_sort_year.addActionListener(this);
    button_search.addActionListener(this);
    button_replace.addActionListener(this);
    button_add.addActionListener(this);
    button_delete.addActionListener(this);
    drop_down.addItemListener(this);
    drop_search.addItemListener(this);
    drop_replace.addItemListener(this);
    button_new.addMouseListener(this);
    button_open.addMouseListener(this);
    button_save.addMouseListener(this);
    button_saveas.addMouseListener(this);
    button_close.addMouseListener(this);
    button_add.addMouseListener(this);
    button_delete.addMouseListener(this);
    button_export.addMouseListener(this);
    button_saveas.addActionListener(this);
    button_previous.addMouseListener(this);
    button_next.addMouseListener(this);
    file_open.addActionListener(this);
    file_save.addActionListener(this);
    file_close.addActionListener(this);
    file_new.addActionListener(this);
    file_export.addActionListener(this);
    file_delete.addActionListener(this);
    file_add.addActionListener(this);
    file_exit.addActionListener(this);

    reset();
    }




   // when mouse is moved over a button
   public void mouseEntered(MouseEvent e)
   { if (e.getSource() == button_new)
        { button_new.setBorderPainted(true);
        }
     if (e.getSource() == button_open)
        { button_open.setBorderPainted(true);
        }
     if (e.getSource() == button_save)
        { button_save.setBorderPainted(true);
        }
     if (e.getSource() == button_saveas)
        { button_saveas.setBorderPainted(true);
        }
     if (e.getSource() == button_close)
        { button_close.setBorderPainted(true);
        }
     if (e.getSource() == button_add)
        { button_add.setBorderPainted(true);
        }
     if (e.getSource() == button_delete)
        { button_delete.setBorderPainted(true);
        }
     if (e.getSource() == button_export)
        { button_export.setBorderPainted(true);
        }
     if (e.getSource() == button_previous)
        { button_previous.setBorderPainted(true);
        }
     if (e.getSource() == button_next)
        { button_next.setBorderPainted(true);
        }
   }
   // when mouse exitted a button
   public void mouseExited(MouseEvent e)
   { if (e.getSource() == button_new)
        { button_new.setBorderPainted(false);
        }
     if (e.getSource() == button_open)
        { button_open.setBorderPainted(false);
        }
     if (e.getSource() == button_save)
        { button_save.setBorderPainted(false);
        }
     if (e.getSource() == button_saveas)
        { button_saveas.setBorderPainted(false);
        }
     if (e.getSource() == button_close)
        { button_close.setBorderPainted(false);
        }
     if (e.getSource() == button_add)
        { button_add.setBorderPainted(false);
        }
     if (e.getSource() == button_delete)
        { button_delete.setBorderPainted(false);
        }
     if (e.getSource() == button_export)
        { button_export.setBorderPainted(false);
        }
     if (e.getSource() == button_previous)
        { button_previous.setBorderPainted(false);
        }
     if (e.getSource() == button_next)
        { button_next.setBorderPainted(false);
        }
   }

   public void mouseReleased(MouseEvent e)
   {
   }

   public void mousePressed(MouseEvent e)
   {
   }

   public void mouseClicked(MouseEvent e)
   {
   }


   //Action Responses for Comboboxes
   public void itemStateChanged (ItemEvent e)
    {
       if ( e.getSource() == drop_search)
       {  if (drop_search.getSelectedIndex() == 1)
             { count_search = 0;
              }
          else if (drop_search.getSelectedIndex() == 2)
                  { count_search = 1;
                  }
               else if (drop_search.getSelectedIndex() == 3)
                       { count_search = 2;
                       }
                    else if (drop_search.getSelectedIndex() == 4)
                             { count_search = 3;
                             }
                          else if (drop_search.getSelectedIndex() == 5)
                          { count_search = 4;
                          }
        }

   if (e.getSource() == drop_replace)
    { if (drop_replace.getSelectedIndex() == 1)
          { count_replace = 0;
          }
       else if (drop_replace.getSelectedIndex() == 2)
                { count_replace = 1;
                }
            else if (drop_replace.getSelectedIndex() == 3)
                    { count_replace = 2;
                    }
                 else if (drop_replace.getSelectedIndex() == 4)
                         { count_replace = 3;
                         }
                      else if (drop_replace.getSelectedIndex() == 5)
                              { count_replace = 4;
                              }
                            else count_replace = 5;
     }

 //if item in sort combo box are selected, it will sort by item that is selected
 if (e.getSource() == drop_down)
   {   if (drop_down.getSelectedIndex() == 1)
          {   Sort.insertionSort(list_rec,
              new Comparator()
               {
              public int compare(Object obj1, Object obj2) {
              return Record.compare_title((Record) obj1, (Record) obj2);   } });
              count = 0;
              set_text();
          }
        if (drop_down.getSelectedIndex() == 2)
          {   Sort.insertionSort(list_rec,
              new Comparator() {
              public int compare(Object obj1, Object obj2) {
              return Record.compare_artist((Record) obj1, (Record) obj2);   } });
              count = 0;
             set_text();
          }
        if (drop_down.getSelectedIndex() == 3)
          {
              Sort.insertionSort(list_rec,
              new Comparator() {
              public int compare(Object obj1, Object obj2) {
              return Record.compare_company((Record) obj1, (Record) obj2);   } });
              count = 0;
              set_text();
          }
        if (drop_down.getSelectedIndex() == 4)
          {
              Sort.insertionSort(list_rec,
              new Comparator() {
              public int compare(Object obj1, Object obj2) {
              return Record.compare_genre((Record) obj1, (Record) obj2);   } });
              count = 0;
              set_text();
          }
        if (drop_down.getSelectedIndex() == 5)
          {
              Sort.insertionSort(list_rec,
              new Comparator() {
              public int compare(Object obj1, Object obj2) {
              return Record.compare_year((Record) obj1, (Record) obj2);   } });
              count = 0;
              set_text();
          }
     }
}


    //Action Response for all buttons and file menus
    public void actionPerformed(ActionEvent e)
       {  //if the user click exit menu, the system if will check if the user need to save data
          if (e.getSource() == file_exit)
             {  if (count >= 0)  //if there's currently data in the collection
                 {  int x;
                   x = JOptionPane.showConfirmDialog(this, "    Save Before Exit ?");
                   if ( (x == 0) && (directory == null) )
                       { file_dialog_close = new FileDialog(this,"Save",FileDialog.SAVE);
                         file_dialog_close.setVisible(true);
                         filee = file_dialog_close.getFile();
                         directory = file_dialog_close.getDirectory();
                         System.out.println(directory + filee);

                         Save_Data.save(list_rec, directory, filee);
                         directory = "";  filee = "";
                         System.exit(0);
                       }
                    else if ( (x == 0) && (directory != null) )
                             { Save_Data.save(list_rec, directory, filee);
                               System.exit(0);
                             }
                         else if (x == 1) System.exit(0);
                   }
                  //if there's no currently data in the collection
                  else System.exit(0);
             }

          //if user click on button Save As or File Save As
          if ( (e.getSource() == button_saveas) || (e.getSource() == file_saveas))
               {    file_dialog_close = new FileDialog(this,"Save",FileDialog.SAVE);
                    file_dialog_close.setVisible(true);
                    filee = file_dialog_close.getFile();
                    directory = file_dialog_close.getDirectory();
                    if (directory != null)
                        Save_Data.save(list_rec, directory, filee);
               }
          //if user click on button Export to HTML or File Export
          if ( (e.getSource() == button_export) || (e.getSource() == file_export))
             {
                    file_dialog_close = new FileDialog(this,"Export",FileDialog.SAVE);
                    file_dialog_close.setVisible(true);
                    filee = file_dialog_close.getFile();
                    directory = file_dialog_close.getDirectory();

                    Export_HTML.Export_HTML(list_rec, directory, filee);
               }
         //if user click on close, the system will check if the user need to save data
          if ( (e.getSource() == button_close) || (e.getSource() == file_close))
            { int x;
              x = JOptionPane.showConfirmDialog(this, "    Save Before Close ?"); //ask the user
              if ( (x == 0) && (directory == null) )
                 { file_dialog_close = new FileDialog(this,"Save",FileDialog.SAVE);
                   file_dialog_close.setVisible(true);
                   filee = file_dialog_close.getFile();
                   directory = file_dialog_close.getDirectory();
                   Save_Data.save(list_rec, directory, filee);
                   reset();
                   directory = "";  filee = "";
                 }
              else if ( (x == 0) && (directory != null) )
                        { Save_Data.save(list_rec, directory, filee);
                          reset();   directory = "";  filee = "";
                        }
                   else if (x == 1)
                           reset();
                }
         //if user click on New
         if ( (e.getSource() == button_new) || (e.getSource() == file_new))
            {   String year = null;

                list_rec = new Record[1];
                String new_title = JOptionPane.showInputDialog(this, "Enter new Title");
                String new_artist = JOptionPane.showInputDialog(this, "Enter new Artist");
                String new_company = JOptionPane.showInputDialog(this, "Enter new Company");
                String new_genre = JOptionPane.showInputDialog(this, "Enter Genre");
                year = (JOptionPane.showInputDialog(this, "Enter Year"));
              try
               {
                int new_year = Integer.parseInt(year);

                 list_rec[list_rec.length-1] = new Record(new_title, new_artist, new_genre, new_company, new_year);
                 count = list_rec.length - 1;     set_text();
                 button_new.setEnabled(false);
                 set();
               }
               catch (NumberFormatException ce)
               { JOptionPane.showMessageDialog(this, "Wrong Input for Year: " + year);
               }

            }
          //if the user has clicked on save
          if ( (e.getSource() == button_save) || (e.getSource() == file_save))
             { if (directory == null)
                  {
                    file_dialog_close = new FileDialog(this,"Save",FileDialog.SAVE);
                    file_dialog_close.setVisible(true);
                    filee = file_dialog_close.getFile();
                    directory = file_dialog_close.getDirectory();
                    Save_Data.save(list_rec, directory, filee);
                   }
              else if (directory != null)
                      Save_Data.save(list_rec, directory, filee);
             }
          //if the user click on delete
          //check if there's only one record in the collection
          if ( (e.getSource() == button_delete) || (e.getSource() == file_delete))
             {
                if ( (list_rec.length - 1 > 0) && (count > 0) )
                    {
                          if (JOptionPane.showConfirmDialog(this, "You're Sure You Wanna Do This") == 0)
                             {     Record[] temp_list = new Record[list_rec.length];
                                   for (int i = 0; i < temp_list.length - 1; i++)
                                      { temp_list[i] = list_rec[i];
                                      }
                                   list_rec = new Record[temp_list.length - 1];

                                   for (int i = 0 ; i < count; i++)
                                       { list_rec[i] = temp_list[i];
                                       }
                                   for (int i = count + 1; i < temp_list.length; i++)
                                       { list_rec[i] = temp_list[i];
                                       }
                                   if (count > 0)
                                      { count--;   set_text();
                                      }
                                   else { count = 0; set_text();  }

                        }
                    }
                 else if (list_rec.length - 1 > 0)
                         {  if (count == 0)
                              {  if (JOptionPane.showConfirmDialog(this, "You're Sure You Wanna Do This") == 0)
                                   {  Record[] temp_list = new Record[list_rec.length-1];

                                     for (int i = 0; i < temp_list.length; i++)
                                          { temp_list[i] = list_rec[i+1];
                                          }
                                     list_rec = new Record[temp_list.length];
                                     for (int i = 0; i < temp_list.length; i++)
                                         { list_rec[i] = temp_list[i];
                                         }
                                     count = 0; set_text();
                                   }
                                }
                         }
                       else if (list_rec.length - 1 == 0)
                               { if (JOptionPane.showConfirmDialog(this, "You're Sure You Wanna Do This") == 0)
                                     list_rec[0] = new Record("","","","",0); set_text();
                               }
              }
          //if the user click on add and check if the user has only one record in the collection
          if ((e.getSource() == button_add) || (e.getSource() == file_add))
             {  String year;
                if ( (list_rec.length == 1) && (list_rec[0].getYear() == 0) )
                    {
                        String new_title = JOptionPane.showInputDialog(this, "Enter new Title");
                        String new_artist = JOptionPane.showInputDialog(this, "Enter new Artist");
                        String new_company = JOptionPane.showInputDialog(this, "Enter new Company");
                        String new_genre = JOptionPane.showInputDialog(this, "Enter Genre");
                        year = JOptionPane.showInputDialog(this, "Enter Year");
                     try
                       {    int new_year = Integer.parseInt(year);

                            list_rec[list_rec.length-1] = new Record(new_title, new_artist, new_genre, new_company, new_year);
                            count = 0;     set_text();
                        }
                     catch (NumberFormatException ce)
                           { JOptionPane.showMessageDialog(this, "Wrong Input for Year: " + year);
                           }
                    }
                 else
                    {
                        String new_title = JOptionPane.showInputDialog(this, "Enter new Title");
                        String new_artist = JOptionPane.showInputDialog(this, "Enter new Artist");
                        String new_company = JOptionPane.showInputDialog(this, "Enter new Company");
                        String new_genre = JOptionPane.showInputDialog(this, "Enter Genre");
                        year = JOptionPane.showInputDialog(this, "Enter Year");
                     try
                       {    int new_year = Integer.parseInt(year);
                            Record[] temp_list = new Record[list_rec.length];

                            for (int i = 0; i < temp_list.length; i++)
                                { temp_list[i] = list_rec[i];
                                }
                            list_rec = new Record[temp_list.length + 1];
                            for (int i = 0; i < temp_list.length; i++)
                                { list_rec[i] = temp_list[i];
                                }
                            list_rec[list_rec.length-1] = new Record(new_title, new_artist, new_genre, new_company, new_year);
                            count = list_rec.length - 1;     set_text();
                        }
                     catch (NumberFormatException ce)
                           { JOptionPane.showMessageDialog(this, "Wrong Input for Year: " + year);
                           }
                 }
             }
          //if user click replace, will get the index selection from the combo box and replace with
          // and new string which the user enter
          if (e.getSource() == button_replace)
             { String parse_string = "";
               if (count_replace < 5)
               { try
                  {
                    parse_string = text_replace.getText();
                    list_rec[count].replace_info(parse_string, count_replace);
                    set_text();
                   }
                 catch (NumberFormatException ce)
                     { JOptionPane.showMessageDialog(this, "Wrong Input for Year: " + parse_string);
                     }
                }
             }
          //if the user click on search, system will get index selection from combo box
          //selection and search within that selection
          if (e.getSource() == button_search)
             {  String parse_string;
                int[] position;
                parse_string = (text_search.getText());
                position = (search.get_location(parse_string, list_rec, count_search));
                System.out.println(position[0] + " " + position[1]);

                if ( position[0] == (-1) )
                     JOptionPane.showMessageDialog(this, "The String You Entered Can't Be Found");
                else { count = position[0];
                       set_text();
                     }
             }
          //If user click the next button, count will increase and reset the text_field
          if (e.getSource() == button_next)
            {  if (list_rec.length > 1)
                   if ((count+1) < list_rec.length)
                        {  count++;
                           set_text();
                        }
             }
          //If user click the previous button, count will decrease unless it is 0
          //and reset the text_field
          if (e.getSource() == button_previous)
            { if ( list_rec.length > 1)
                 if (count != 0)
                     { count--;
                       set_text();
                     }
             }
         //if the user click open button
         if ((e.getSource() == button_open) || (e.getSource() == file_open))
             {
               file_dialog_open = new FileDialog(this,"Open",FileDialog.LOAD);
               file_dialog_open.setVisible(true);
               filee = file_dialog_open.getFile();
               directory = file_dialog_open.getDirectory();

               if ((directory != null) && (filee != null))
                   {
                        open_file = new Open_Data(directory, filee);
                        list = open_file.get_List();
                        list.first();
                        if (open_file.get_int() != (-1))
                           {  count = open_file.get_int() - 1;
                              list_rec = new Record[open_file.get_int()];
                              for (int i = 0; i < list_rec.length; i++)
                                  { list_rec[i] = (Record)list.access();
                                    list.next();
                                  }
                              count = 0;
                              set();
                              set_text();
                            }
                         else
                             {  JOptionPane.showMessageDialog(this, "Invalid Data Format");
                                directory = null;
                                filee = null;
                             }
                    }

             }
       }

   public void set_label_text()
   {
   //Create the panel that hold labels
    panel_label.setLayout(new GridLayout(5,1, 20, 20));
    panel_label.add(label_title = new JLabel("Title")); label_title.setFont(new Font("Arial", 1, 14));
    label_title.setForeground(Color.orange);
    panel_label.add(label_artist = new JLabel("Artist")); label_artist.setFont(new Font("Arial", 1, 14));
    label_artist.setForeground(Color.orange);
    panel_label.add(label_company = new JLabel("Company")); label_company.setFont(new Font("Arial", 1, 14));
    label_company.setForeground(Color.orange);
    panel_label.add(label_genre = new JLabel("Genre"));  label_genre.setFont(new Font("Arial", 1, 14));
    label_genre.setForeground(Color.orange);
    panel_label.add(label_year = new JLabel("Year"));  label_year.setFont(new Font("Arial", 1, 14));
    label_year.setForeground(Color.orange);
    panel_label.setBorder(new TitledBorder(""));
    panel_label.setBackground(Color.black);

    //Create a panel that hold text field
    panel_text.setLayout(new GridLayout(5,1, 20, 20));
    panel_text.add(text_title = new JTextField(""));  text_title.setEditable(false);  text_title.setBackground(Color.black);
    text_title.setForeground(Color.orange); text_title.setFont(new Font("Times", 1, 12));
    panel_text.add(text_artist = new JTextField(""));  text_artist.setEditable(false);  text_artist.setBackground(Color.black);
    text_artist.setForeground(Color.orange); text_artist.setFont(new Font("Times", 1, 12));
    panel_text.add(text_company = new JTextField(""));  text_company.setEditable(false);  text_company.setBackground(Color.black);
    text_company.setForeground(Color.orange); text_company.setFont(new Font("Times", 1, 12));
    panel_text.add(text_genre = new JTextField(""));  text_genre.setEditable(false);  text_genre.setBackground(Color.black);
    text_genre.setForeground(Color.orange); text_genre.setFont(new Font("Times", 1, 12));
    panel_text.add(text_year = new JTextField(""));  text_year.setEditable(false);  text_year.setBackground(Color.black);
    text_year.setForeground(Color.orange); text_year.setFont(new Font("Times", 1, 12));
    panel_text.setBorder(new TitledBorder(""));
    panel_text.setBackground(Color.black);

    //Create a panel that hold text field panel and label panel
    panel_label_text.setLayout(new BorderLayout());
    panel_label_text.add(panel_label, BorderLayout.WEST);
    panel_label_text.add(panel_text, BorderLayout.CENTER);
 }
   //Create a Tool Bar
   public void set_panel_top()
      {  //create panel, tool bar and add button into the panel and tool bar
        drop_down = new JComboBox();
        drop_down.setBackground(Color.black);
        drop_down.setFont(new Font("Arial", 0, 12));
        drop_down.setForeground(Color.orange);
        drop_down.setToolTipText("Sort by ...");
        drop_down.addItem(new String("Sort by ..."));
        drop_down.addItem(new String("Title"));
        drop_down.addItem(new String("Artist"));
        drop_down.addItem(new String("Company"));
        drop_down.addItem(new String("Genre"));
        drop_down.addItem(new String("Year"));
        drop_down.setEnabled(false);
        drop_replace = new JComboBox();
        drop_replace.setBackground(Color.black);
        drop_replace.setFont(new Font("Arial", 0, 12));
        drop_replace.setBackground(Color.black);
        drop_replace.setForeground(Color.orange);
        drop_replace.setToolTipText("Replace ...");
        drop_replace.addItem(new String("Replace ..."));
        drop_replace.addItem(new String("Title"));
        drop_replace.addItem(new String("Artist"));
        drop_replace.addItem(new String("Company"));
        drop_replace.addItem(new String("Genre"));
        drop_replace.addItem(new String("Year"));
        drop_replace.setEnabled(false);
        panel_replace.setLayout(new BorderLayout());
        panel_replace.setBackground(Color.black);
        panel_replace.add(drop_replace, BorderLayout.CENTER);
        panel_replace.add(button_replace, BorderLayout.EAST);  button_replace.setBackground(Color.darkGray); button_replace.setForeground(Color.orange);  button_replace.setBorder(new TitledBorder(""));
        panel_drop_replace.setLayout(new BorderLayout());
        panel_drop_replace.setBackground(Color.black);
        panel_drop_replace.add(text_replace = new JTextField(8), BorderLayout.CENTER);
        text_replace.setBorder(new TitledBorder(""));  text_replace.setBackground(Color.black);
        text_replace.setForeground(Color.white);
        panel_drop_replace.add(panel_replace, BorderLayout.EAST);
        panel_tool.setLayout(new BorderLayout(10, 0));
        panel_tool.add(tool_bar, BorderLayout.CENTER);
        panel_tool.add(drop_down, BorderLayout.EAST);
        panel_tool.setBackground(Color.black);
        panel_tool.setBorder(new TitledBorder(""));
        tool_bar.setBackground(Color.black);
        tool_bar.setPreferredSize(new Dimension(500, 30));
        tool_bar.setFloatable(false);

        tool_bar.add(panel_drop_replace);
        top_tool_bar.setLayout(new BorderLayout());
        top_tool_bar.add(panel_tool, BorderLayout.SOUTH);
        top_tool_bar.add(tool_bar_bottom, BorderLayout.NORTH);
        tool_bar_bottom.setFloatable(false);
        tool_bar_bottom.setBackground(Color.black);
        tool_bar_bottom.add(button_new);  tool_bar_bottom.add(button_open);
        tool_bar_bottom.add(button_save);  tool_bar_bottom.add(button_saveas);
        tool_bar_bottom.add(button_close);  tool_bar_bottom.addSeparator(); tool_bar_bottom.add(button_add);
        tool_bar_bottom.add(button_delete); tool_bar_bottom.add(button_export);

       }
   //Create Panel for the Search Area
   //Add an combo box and a button
   public void set_panel_search()
       {  drop_search = new JComboBox();
          drop_search.setFont(new Font("Times", 0, 12));
          drop_search.setBackground(Color.black);
          drop_search.setForeground(Color.orange);
          drop_search.setBorder(new TitledBorder(""));
          drop_search.addItem(new String("Search by"));
          drop_search.addItem(new String("Title"));
          drop_search.addItem(new String("Artist"));
          drop_search.addItem(new String("Company"));
          drop_search.addItem(new String("Genre"));
          drop_search.addItem(new String("Year"));
          panel_search_drop.setLayout(new BorderLayout());
          panel_search_drop.add(drop_search, BorderLayout.EAST);
          panel_search_drop.add(text_search = new JTextField(), BorderLayout.CENTER);
          text_search.setBorder(new TitledBorder(""));
          text_search.setBackground(Color.black);  text_search.setForeground(Color.orange);
          panel_search.setLayout(new BorderLayout(10, 10));
          panel_search.setBackground(Color.black);
          panel_search.setBorder(new TitledBorder(""));
          panel_search.add(panel_search_drop, BorderLayout.CENTER);
          panel_search.add(button_search, BorderLayout.EAST); button_search.setBackground(Color.darkGray); button_search.setForeground(Color.orange); button_search.setBorder(new TitledBorder(""));
       }
  //Create a panel for the bottom of the pane
   public void set_panel_bottom()
       {    panel_bottom.setLayout(new BorderLayout(20, 20));
            panel_bottom.setBorder(new TitledBorder(""));
            panel_bottom.setBackground(Color.black);
            panel_bottom.add(button_next, BorderLayout.EAST);
            panel_bottom.add(button_previous, BorderLayout.WEST);
            panel_bottom.add(panel_search, BorderLayout.CENTER);
       }

    //Function that set text in the text field
    public void set_text()
        {   text_title.setText("    " + list_rec[count].getTitle());
            text_artist.setText("    " + list_rec[count].getArtist());
            text_company.setText("    " + list_rec[count].getCompany());
            text_genre.setText("    " + list_rec[count].getGenre());
            text_year.setText("    " + String.valueOf(list_rec[count].getYear()));
         }

    public void set_icon()
        { //load all images into buttons and file menus
          button_open.setIcon(new ImageIcon("open_file.gif"));
          button_open.setBackground(Color.black);    button_open.setBorderPainted(false);  button_open.setToolTipText("Open");
          button_save.setIcon(new ImageIcon("save_file.gif"));
          button_save.setBackground(Color.black);    button_save.setBorderPainted(false);;  button_save.setToolTipText("Save");
          button_new.setIcon(new ImageIcon("newFile.gif"));
          button_new.setBackground(Color.black);    button_new.setBorderPainted(false);  button_new.setToolTipText("New Collection");
          button_close.setIcon(new ImageIcon("close_file.gif"));
          button_close.setBackground(Color.black);  button_close.setBorderPainted(false);; button_close.setToolTipText("Close");
          button_delete.setIcon(new ImageIcon("delete_file.gif"));
          button_delete.setBackground(Color.black);  button_delete.setBorderPainted(false);;  button_delete.setToolTipText("Delete Record");
          button_add.setIcon(new ImageIcon("add_file.gif"));
          button_add.setBackground(Color.black);  button_add.setBorderPainted(false); button_add.setToolTipText("Add new Record");
          button_export.setIcon(new ImageIcon("export_file.gif"));
          button_export.setBackground(Color.black);  button_export.setBorderPainted(false);; button_export.setToolTipText("Export to HTML file");
          button_saveas.setIcon(new ImageIcon("saveas_file.gif"));
          button_saveas.setBackground(Color.black);  button_saveas.setBorderPainted(false); button_saveas.setToolTipText("Save as");
          button_previous.setIcon(new ImageIcon("previous_file.gif"));
          button_previous.setBackground(Color.black); button_previous.setBorderPainted(false);  button_previous.setToolTipText("Previous");
          button_next.setIcon(new ImageIcon("next_file.gif"));
          button_next.setBackground(Color.black); button_next.setBorderPainted(false);  button_next.setToolTipText("Next");
          //load images into file menu
          file_open.setIcon(new ImageIcon("open_file.gif"));
          file_save.setIcon(new ImageIcon("save_file.gif"));
          file_saveas.setIcon(new ImageIcon("saveas_file.gif"));
          file_new.setIcon(new ImageIcon("newFile.gif"));
          file_close.setIcon(new ImageIcon("close_file.gif"));
          file_export.setIcon(new ImageIcon("export_file.gif"));
        }
    //to disable buttons and menus to prevent the user from clicking it
    public void reset()
        {          button_close.setEnabled(false);
                   button_delete.setEnabled(false);
                   button_add.setEnabled(false);
                   button_save.setEnabled(false);
                   button_saveas.setEnabled(false);
                   file_save.setEnabled(false);
                   button_open.setEnabled(true);
                   button_new.setEnabled(true);
                   button_search.setEnabled(false);
                   button_replace.setEnabled(false);
                   button_previous.setEnabled(false);
                   button_next.setEnabled(false);
                   button_export.setEnabled(false);
                   file_new.setEnabled(true);
                   file_open.setEnabled(true);
                   file_close.setEnabled(false);
                   file_export.setEnabled(false);
                   file_exit.setEnabled(true);
                   file_save.setEnabled(false);
                   file_delete.setEnabled(false);
                   file_add.setEnabled(false);
                   file_saveas.setEnabled(false);
                   drop_down.disable();
                   drop_replace.disable();
                   drop_search.disable();
                   text_title.setText("");
                   text_artist.setText("");
                   text_company.setText("");
                   text_genre.setText("");
                   text_year.setText("");
        }

     //enable buttons and file menus when user open or create a new collection
      public void set()
        {          button_close.setEnabled(true);
                   button_delete.setEnabled(true);
                   button_add.setEnabled(true);
                   button_save.setEnabled(true);
                   button_saveas.setEnabled(true);
                   button_open.setEnabled(false);
                   button_new.setEnabled(false);
                   button_search.setEnabled(true);
                   button_replace.setEnabled(true);
                   button_previous.setEnabled(true);
                   button_next.setEnabled(true);
                   button_export.setEnabled(true);
                   file_new.setEnabled(false);
                   file_open.setEnabled(false);
                   file_close.setEnabled(true);
                   file_export.setEnabled(true);
                   file_exit.setEnabled(true);
                   file_save.setEnabled(true);
                   file_saveas.setEnabled(true);
                   file_delete.setEnabled(true);
                   file_add.setEnabled(true);
                   drop_down.enable();
                   drop_replace.enable();
                   drop_search.enable();
        }

}



