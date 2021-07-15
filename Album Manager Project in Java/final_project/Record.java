package final_project;

import java.io.Serializable;
import java.util.*;


public class Record implements java.io.Serializable, Comparable
{
  private String title = "";
  private String artist = "";
  private String genre = "";
  private String company = "";
  private int year;

  //Default Constructor
  public Record()
  {
  }
  //Constructor to count records in the collection
  //to be the first record write into the output file
  public Record(int year)
  {this.year = year;
  }

  public Record(String title, int year)
  { this.title = title;
    this.year = year;
   }
  //Constructor with title, artist, genre, company and year
 public Record(String title, String artist, String genre, String company, int year)
  { this.title = title;
    this.artist = artist;
    this.genre = genre;
    this.company = company;
    this.year = year;
  }

 public String get_info(int selection)
      {   if (selection == 0)
             return this.title;
          if (selection == 1)
             return this.artist;
          if (selection == 2)
             return this.company;
          if (selection == 3)
             return this.genre;
          return String.valueOf(this.year);
      }

  public void replace_info(String string, int selection)
      {   if (selection == 0)
             this.title = string;
          if (selection == 1)
             this.artist = string;
          if (selection == 2)
             this.company = string;
          if (selection == 3)
             this.genre = string;
          if (selection == 4)
             this.year = Integer.parseInt(string);
       }

 public String getTitle()
  {  return this.title;
  }
 public String getArtist()
  {  return this.artist;
  }
 public String getGenre()
  {  return this.genre;
  }
 public String getCompany()
  {  return this.company;
  }
 public int getYear()
  {  return this.year;
  }
 public void replaceTitle(String title)
  {  this.title = title;
  }
 public void replaceArtist(String artist)
  {  this.artist = artist;
  }
 public void replaceGenre(String genre)
  {  this.genre = genre;
  }
 public void replaceCompany(String company)
  {  this.company = company;
  }
 public void replaceYear(int year)
  {  this.year = year;
  }
 public String toString()
 { return this.title;
  }

  //implementation of Compare for sorting

  public static int compare_year(Record rec1, Record rec2) {
    return (rec1.year - rec2.year);
  }

  public static int compare_artist(Record rec1, Record rec2)
  {  int lastComp = rec1.artist.compareTo(rec2.artist);
     return lastComp;
  }

  public static int compare_company(Record rec1, Record rec2) {
    int lastComp = rec1.company.compareTo(rec2.company);
    return lastComp;
  }

  public static int compare_genre(Record rec1, Record rec2)
  {
     int lastComp = rec1.genre.compareTo(rec2.genre);
     return lastComp;
  }

  public static int compare_title(Record rec1, Record rec2) {
    int lastComp = rec1.title.compareTo(rec2.title);
     return lastComp;
  }

  public int compareTo(Object other)
  {
    return compare_title(this, (Record) other);
  }


}