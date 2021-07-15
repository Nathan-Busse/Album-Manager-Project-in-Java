package final_project;

import java.lang.String;
import java.util.StringTokenizer;

public class search
{


       public static int[] get_location(String key, Record[] list_rec, int selection)
       {   int k = 0;
           int z = 0;

           int x = -1;
           int y = -1;
           int[] return_array= new int[2];
           boolean negative = true;
           int count = 0;
           int count_2 = 0;
           int count_token = 0;

           String target_part;

           //if selection is 0, will the first token from that field and search character by character
           //til the end of the collection in that field

           if (selection == 0)
              {
                  do
                     {
                         {   StringTokenizer target = new StringTokenizer(list_rec[k].get_info(selection));

                                  while (target.hasMoreTokens())
                                        {  negative = true;
                                           StringBuffer temp_string_key = new StringBuffer("");
                                           target_part = target.nextToken();
                                           StringBuffer temp_string_target = new StringBuffer(target_part);

                                           System.out.println(target_part);

                                           temp_string_key = new StringBuffer(key);


                                           if (temp_string_key.length() > target_part.length() == true)
                                              {  temp_string_key.delete(temp_string_target.length(),  temp_string_key.length() );
                                              }
                                           else if (temp_string_key.length() < target_part.length() == true)
                                              { temp_string_target.delete(temp_string_key.length() , temp_string_target.length() );
                                              }

                                           for (int i = 0; i < temp_string_target.length(); i++)
                                               {  System.out.println(temp_string_key.charAt(i) + " " + temp_string_target.charAt(i));
                                                   if ( temp_string_key.charAt(i) != temp_string_target.charAt(i))
                                                     {
                                                       negative = false; break;
                                                     }

                                             }

                                           if ( negative == true)
                                               {  System.out.println("It's Found");
                                                  x = k;
                                                  y = z;
                                                  break;

                                                }
                                           else System.out.println("It's not found");
                                       }
                             z++;

                              }
                         z = 0;
                         k++;
                        } while (k < list_rec.length);

                 return_array[0] = x;
                 return_array[1] = y;

                 return return_array;
               }

         if (selection == 1)
              {
                  do
                     {
                         {   StringTokenizer target = new StringTokenizer(list_rec[k].get_info(selection));

                                  while (target.hasMoreTokens())
                                        {  negative = true;
                                           StringBuffer temp_string_key = new StringBuffer("");
                                           target_part = target.nextToken();
                                           StringBuffer temp_string_target = new StringBuffer(target_part);

                                           System.out.println(target_part);

                                           temp_string_key = new StringBuffer(key);


                                           if (temp_string_key.length() > target_part.length() == true)
                                              {  temp_string_key.delete(temp_string_target.length(),  temp_string_key.length() );
                                              }
                                           else if (temp_string_key.length() < target_part.length() == true)
                                              { temp_string_target.delete(temp_string_key.length() , temp_string_target.length() );
                                              }

                                           for (int i = 0; i < temp_string_target.length(); i++)
                                               {  System.out.println(temp_string_key.charAt(i) + " " + temp_string_target.charAt(i));
                                                   if ( temp_string_key.charAt(i) != temp_string_target.charAt(i))
                                                     {
                                                       negative = false; break;
                                                     }

                                             }

                                           if ( negative == true)
                                               {  System.out.println("It's Found");
                                                  x = k;
                                                  y = z;
                                                  break;
                                                }
                                           else System.out.println("It's not found");
                                       }
                             z++;
                              }
                         z = 0;
                         k++;
                        } while (k < list_rec.length - 1);

                 return_array[0] = x;
                 return_array[1] = y;

                 return return_array;
               }

      if (selection == 2)
              {
                  do
                     {
                         {   StringTokenizer target = new StringTokenizer(list_rec[k].get_info(selection));

                                  while (target.hasMoreTokens())
                                        {  negative = true;
                                           StringBuffer temp_string_key = new StringBuffer("");
                                           target_part = target.nextToken();
                                           StringBuffer temp_string_target = new StringBuffer(target_part);

                                           System.out.println(target_part);

                                           temp_string_key = new StringBuffer(key);


                                           if (temp_string_key.length() > target_part.length() == true)
                                              {  temp_string_key.delete(temp_string_target.length(),  temp_string_key.length() );
                                              }
                                           else if (temp_string_key.length() < target_part.length() == true)
                                              { temp_string_target.delete(temp_string_key.length() , temp_string_target.length() );
                                              }

                                           for (int i = 0; i < temp_string_target.length(); i++)
                                               {  System.out.println(temp_string_key.charAt(i) + " " + temp_string_target.charAt(i));
                                                   if ( temp_string_key.charAt(i) != temp_string_target.charAt(i))
                                                     {
                                                       negative = false; break;
                                                     }

                                             }

                                           if ( negative == true)
                                               {  System.out.println("It's Found");
                                                  x = k;
                                                  y = z;
                                                  break;

                                                }
                                           else System.out.println("It's not found");
                                       }
                             z++;

                              }
                         z = 0;
                         k++;
                        } while (k < list_rec.length);

                 return_array[0] = x;
                 return_array[1] = y;

                 return return_array;
               }

        if (selection == 3)
              {
                  do
                     {
                         {   StringTokenizer target = new StringTokenizer(list_rec[k].get_info(selection));

                                  while (target.hasMoreTokens())
                                        {  negative = true;
                                           StringBuffer temp_string_key = new StringBuffer("");
                                           target_part = target.nextToken();
                                           StringBuffer temp_string_target = new StringBuffer(target_part);

                                           System.out.println(target_part);

                                           temp_string_key = new StringBuffer(key);


                                           if (temp_string_key.length() > target_part.length() == true)
                                              {  temp_string_key.delete(temp_string_target.length(),  temp_string_key.length() );
                                              }
                                           else if (temp_string_key.length() < target_part.length() == true)
                                              { temp_string_target.delete(temp_string_key.length() , temp_string_target.length() );
                                              }

                                           for (int i = 0; i < temp_string_target.length(); i++)
                                               {  System.out.println(temp_string_key.charAt(i) + " " + temp_string_target.charAt(i));
                                                   if ( temp_string_key.charAt(i) != temp_string_target.charAt(i))
                                                     {
                                                       negative = false; break;
                                                     }

                                             }

                                           if ( negative == true)
                                               {  System.out.println("It's Found");
                                                  x = k;
                                                  y = z;
                                                  break;

                                                }
                                           else System.out.println("It's not found");
                                       }
                             z++;

                              }
                         z = 0;
                         k++;
                        } while (k < list_rec.length);

                 return_array[0] = x;
                 return_array[1] = y;

                 return return_array;
               }

       if (selection == 4)
              {
                  do
                     {
                         {   StringTokenizer target = new StringTokenizer(list_rec[k].get_info(selection));

                                  while (target.hasMoreTokens())
                                        {  negative = true;
                                           StringBuffer temp_string_key = new StringBuffer("");
                                           target_part = target.nextToken();
                                           StringBuffer temp_string_target = new StringBuffer(target_part);

                                           System.out.println(target_part);

                                           temp_string_key = new StringBuffer(key);


                                           if (temp_string_key.length() > target_part.length() == true)
                                              {  temp_string_key.delete(temp_string_target.length(),  temp_string_key.length() );
                                              }
                                           else if (temp_string_key.length() < target_part.length() == true)
                                              { temp_string_target.delete(temp_string_key.length() , temp_string_target.length() );
                                              }

                                           for (int i = 0; i < temp_string_target.length(); i++)
                                               {  System.out.println(temp_string_key.charAt(i) + " " + temp_string_target.charAt(i));
                                                   if ( temp_string_key.charAt(i) != temp_string_target.charAt(i))
                                                     {
                                                       negative = false; break;
                                                     }

                                             }

                                           if ( negative == true)
                                               {  System.out.println("It's Found");
                                                  x = k;
                                                  y = z;
                                                  break;

                                                }
                                           else System.out.println("It's not found");
                                       }
                             z++;

                              }
                         z = 0;
                         k++;
                        } while (k < list_rec.length);

                 return_array[0] = x;
                 return_array[1] = y;

                 return return_array;
               }

       return return_array;
       }

}